package com.sapient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.dao.FillsDAO;
import com.sapient.entity.Blocks;
import com.sapient.entity.Fills;
import com.sapient.entity.Securities;
import com.sapient.service.BlockExecutorEngine;
import com.sapient.service.FillService;
import com.sapient.service.RandomNumberGenerator;
import com.sapient.service.SecuritiesService;

@Controller
public class BlockController {

	@Autowired
	private BlockExecutorEngine mgr;

	@Autowired
	private SecuritiesService secser;

	@Autowired
	private FillService fs;

	@RequestMapping("/NewBlocks")
	public ModelAndView viewBlocks() {
		List<Blocks> list = mgr.fetchBlocks();

		/* return new ModelAndView("details", "list", list); */

		ModelAndView model = new ModelAndView("NewBlocks");
		model.addObject("list", list);

		return model;
	}

	@RequestMapping("/ViewSecurity")
	public ModelAndView viewSecurities() {
		List<Securities> list = secser.fetchSecurities();
		ModelAndView model = new ModelAndView("ViewSecurity");
		model.addObject("SecurityList", list);

		return model;
	}

	@RequestMapping("/ViewFills")
	public ModelAndView viewFills() {
		ArrayList<Fills> list = fs.displayFills();
		System.out.println("fills");
		ModelAndView model = new ModelAndView("ViewFills");
		model.addObject("list", list);
		System.out.println("fills2");
		return model;
	}

	/*
	 * @RequestMapping("/ConfigureSecurity") public ModelAndView
	 * configureSecurity() { ModelAndView model = new
	 * ModelAndView("ConfigureSecurity"); return model; }
	 */
	@RequestMapping(value = "/ConfigureSecurity", method = RequestMethod.GET)
	public String setupForm(Model model) {
		Securities Securities = new Securities();
		model.addAttribute("securityNew", Securities);
		return "ConfigureSecurity";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("securityNew") Securities securities, BindingResult result,
			SessionStatus status) {
		secser.addSecurity(securities);
		// Mark Session Complete
		status.setComplete();
		return "redirect:/ViewSecurity";
	}

	@RequestMapping(value = "/ConfigureSecurity/edit/{symbol}")
	public ModelAndView edit(@PathVariable String symbol) {
		Securities security = secser.getSecurityBySymbol(symbol);
		return new ModelAndView("ConfigureSecurityEdit", "securityEdit", security);
	}

	/*
	 * @RequestMapping(value = "/editSave",method = RequestMethod.GET) public
	 * String Form(Model model) { Securities Securities = new Securities();
	 * model.addAttribute("securityEdit", Securities); return "ViewSecurity"; }
	 */
	/* It updates model object. */
	@RequestMapping(value = "/ConfigureSecurity/edit/{symbol}", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("securityEdit") Securities sec) {
		System.out.println("inside edit and save");
		secser.updateSecurity(sec);
		return new ModelAndView("redirect:/ViewSecurity");
	}

	// It deletes record for the given id in URL and redirects to /viewemp
	/*
	 * @RequestMapping(value="/deleteSecurity/{symbol}") public ModelAndView
	 * delete(@PathVariable String symbol){ Securities
	 * security=secser.getSecurityBySymbol(symbol); return new
	 * ModelAndView("ConfigureSecurityEdit","securityEdit",security); }
	 */
	@RequestMapping(value = "/ConfigureSecurity/deleteSecurity/{symbol}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String symbol) {
		System.out.println("Inside deletion");
		secser.delete(symbol);
		return new ModelAndView("redirect:/ViewSecurity");
	}
	RandomNumberGenerator rng = new RandomNumberGenerator();
	
	
	@RequestMapping(value="/start")
	public ModelAndView startExchange() {
		System.out.println("Exchange started");
		List<Blocks> blocks=mgr.fetchBlocks();
		for(Blocks b:blocks)
		{
			System.out.println(b);
			Securities sec=secser.getSecurityBySymbol(b.getSymbol());
			int a = rng.getNoOfExecution(sec.getMaxExecution());
			System.out.println(a);
			//for(int i=0;i<a;i++)
			//{
			if(b.getOpenQuantity()!=0)
			{
			System.out.println("   "+mgr.getTradedQuantity(b, sec));
			System.out.println("   "+mgr.calculateTradePrice(b, sec));
			mgr.updateBlocks(b);
			secser.updateSecurities(b, sec);
			fs.generateFills(b);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			}
			
		}	
		
		//}
		return new ModelAndView("redirect:/NewBlocks");
	}
	@RequestMapping(value="/stop")
	public ModelAndView stopExchange() {
		System.out.println("Exchange stopped");
				
		return new ModelAndView("redirect:/NewBlocks");
	}
	
}
