package com.sapient.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.sapient.entity.BrokerLogin;
import com.sapient.service.LoginService;

@Controller
@SessionAttributes("userObject")
public class LoginController {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView loginPage(Model model) throws Exception {
		return new ModelAndView("Login", "command", new BrokerLogin());
	}

	@RequestMapping(value = { "/ForgotPassword" }, method = RequestMethod.GET)
	public ModelAndView forgotPassword(Model model) throws Exception {
		return new ModelAndView("ForgotPassword", "command", new BrokerLogin());
	}

	@RequestMapping(value = { "/Login" }, method = RequestMethod.POST)
	public ModelAndView changePassword(@ModelAttribute("user") BrokerLogin user,
			@RequestParam("cPassword") String cPassword ,HttpSession session) throws Exception{
		session.getId();
		boolean isUserNameValid = loginService.validateUserName(user.getUserName());
		if (isUserNameValid) {
			boolean ispwdmatches = loginService.checkPassword(user.getUserName(), user.getUserPassword(), cPassword);
			if (ispwdmatches) {
				ModelAndView model = new ModelAndView("ForgotPassword", "command", new BrokerLogin());
				model.addObject("success", "Password changed successfully");
				return model;
			} else {
				ModelAndView model = new ModelAndView("ForgotPassword", "command", new BrokerLogin());
				model.addObject("err", "Password not match");
				return model;
			}
		} else {
			ModelAndView model = new ModelAndView("ForgotPassword", "command", new BrokerLogin());
			model.addObject("error", "Invalid UserName");
			return model;
		}
	}

	@RequestMapping(value = { "/NewBlocks" }, method = RequestMethod.POST)
	public ModelAndView displayDetails( @ModelAttribute("user") BrokerLogin user) throws Exception {
		boolean isUserValid = loginService.validateUser(user.getUserName(), user.getUserPassword());
		if (isUserValid) {
			ModelAndView model = new ModelAndView("redirect:/NewBlocks");
			model.addObject("userObject",user);
			return model;
		} else {
			ModelAndView model = new ModelAndView("Login", "command", new BrokerLogin());
			model.addObject("error", "Invalid Login Details");
			return model;
		}
	}
}
