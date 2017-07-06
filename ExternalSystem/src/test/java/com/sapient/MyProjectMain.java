package com.sapient;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.dao.FillsDAO;
import com.sapient.entity.Blocks;
import com.sapient.entity.Fills;
import com.sapient.entity.Securities;
import com.sapient.service.BlockExecutorEngine;
import com.sapient.service.FillService;
import com.sapient.service.RandomNumberGenerator;
import com.sapient.service.SecuritiesService;

public class MyProjectMain {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-fakebook-jpa.xml");
		BlockExecutorEngine bee = (BlockExecutorEngine) context.getBean("blockExecutorEngine");
		FillService fs = (FillService)context.getBean("fillService");
		RandomNumberGenerator rng = new RandomNumberGenerator();
		int a = rng.getNoOfExecution(20);
		System.out.println("No. of execution  " + a);
		System.out.println(rng.getNoOfSecurities(700));
		System.out.println(rng.getRandomPriceSpread(50));
		Blocks block = new Blocks(1, "buy", "SBI", "limit", 120, "Open", 600, 0, 0);
		Blocks block1 = new Blocks(2, "sell", "HDFC", "market", 110, "Open", 500, 0, 0);
		/*bee.addBlocks(block);
		bee.addBlocks(block1);*/
		Securities securities = new Securities(50, 10, 3, 30, "SBI", 200.0);
		Securities securities1 = new Securities(50, 10, 4, 30, "HDFC", 250.0);
		Securities securities2 = new Securities(10, 10, 5, 12, "MRF", 100.0);
		System.out.println(" open Quantity   " + block.getOpenQuantity());
	
		bee.getTradedQuantity(block, securities);
		System.out.println("Block 2 executed Quantity"+bee.getTradedQuantity(block1, securities));
		/*
		 * while (a > 0 && block.getOpenQuantity() > 0) { System.out.println(
		 * " open Quantity   " + block.getOpenQuantity());
		 * block.setExecutedQuantity(bee.getTradedQuantity(block, securities));
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } a--; }
		 */
		System.out.println(bee.getBlocks(2));
		System.out.println(block.getId());
		System.out.println("Traded price   " + bee.calculateTradePrice(block, securities));
		/*
		 * System.out.println("Traded Quantity  " + bee.getTradedQuantity(block,
		 * securities));
		 */
		System.out.println(block.getStatus());
		bee.updateBlocks(block);
		bee.updateBlocks(block1);
		SecuritiesService secser = (SecuritiesService) context.getBean("securitiesService");
		secser.updateSecurities(block, securities);
		/*secser.addSecurity(securities);
		secser.addSecurity(securities1);
		secser.addSecurity(securities2);*/
		List<Blocks> list=bee.fetchBlocks();
		for(Blocks blocknew:list)
			System.out.println(blocknew);
		
		fs.generateFills(block);
		//fdao.generateFills(block1);
		//fdao.createFills(bid, symbol, side, exeQuantity, d, transactionTime);
		/*System.out.println("fills creating...");
		Fills f = new Fills(1, "HDFC", "Sell", 2, block.getTradedPrice(), "asd");
		fdao.addFills(f);
		System.out.println("fills created");*/
		
	}
}
