package com.sapient.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.dao.BlockDAO;
import com.sapient.entity.Blocks;
import com.sapient.entity.Securities;

@Component
public class BlockExecutorEngine {
	double randomPriceSpread;
	int maxPercentageSpread;
	double lastTradedPrice;
	int percentageOfExecution;
	String status;

	public BlockExecutorEngine() {
	}

	RandomNumberGenerator rng = new RandomNumberGenerator();
	@Autowired
	BlockDAO bdao;

	public void addBlocks(Blocks block) {
		bdao.addBlocks(block);
	}

	public Blocks getBlocks(int id) {
		return bdao.getBlocks(id);

	}
	public List<Blocks> fetchBlocks() {
				return bdao.fetchBlocks();
	}

	/*
	 * public void updateBlocks(Blocks block) { bdao.updateBlocks(block); }
	 */
	public void updateBlocks(Blocks block) {
		bdao.updateBlocks(block);
	}

	public double calculateTradePrice(Blocks block, Securities securities) {

		String blockType = block.getBlockType();
		lastTradedPrice = securities.getLastTradedPrice();
		maxPercentageSpread = securities.getMaxSpread();
		randomPriceSpread = rng.getRandomPriceSpread(maxPercentageSpread);
		System.out.println("Random price spread"+randomPriceSpread);
		/* Securities securities=new Securities(); */
		if (blockType.equalsIgnoreCase("market")) {
			lastTradedPrice = rng.getRandomNumberInRange(lastTradedPrice - randomPriceSpread,
					lastTradedPrice + randomPriceSpread);
		} else if (blockType.equalsIgnoreCase("limit") && block.getSide().equalsIgnoreCase("buy")) {
			lastTradedPrice = rng.getRandomNumberInRange(lastTradedPrice - randomPriceSpread, lastTradedPrice);
		} else if (blockType.equalsIgnoreCase("limit") && block.getSide().equalsIgnoreCase("sell")) {
			lastTradedPrice = rng.getRandomNumberInRange(lastTradedPrice, lastTradedPrice + randomPriceSpread);
		}
		securities.setLastTradedPrice(lastTradedPrice);
		block.setTradedPrice(lastTradedPrice);
		return lastTradedPrice;
	}

	public int getTradedQuantity(Blocks block, Securities securities) {
		int a = (int) rng.getRandomNumberInRange(0, 100);
		percentageOfExecution = securities.getPercentageOfExecution();
		if (a > (100 - percentageOfExecution)) {
			block.setExecutedQuantity(block.getTotalQuantity());
			System.out.println("Executed Quantity " + block.getExecutedQuantity());
			block.setOpenQuantity(0);
			block.setStatus("Executed");
			System.out.println("All executed");
			return block.getExecutedQuantity();
		} else {
			int wait = rng.getNoOfExecution(securities.getMaxInterval());
			for (int i = 0; i < wait; i++) {
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//int executedQuantity=0;
			System.out.println("Wait over");
			int executedQuantity = (securities.getPercentageOfExecution() * block.getOpenQuantity()) / 100;
			System.out.println("check check "+block.getExecutedQuantity());
			int b=block.getExecutedQuantity()+
					executedQuantity;
			System.out.println("2nd check"+b);
			block.setExecutedQuantity(b);
			/* System.out.println("Executed Quantity " + executedQuantity); */
			int openQuantity = block.getOpenQuantity() - executedQuantity;
			block.setOpenQuantity(openQuantity);
			block.setStatus("Partially Executed");
			System.out.println(block.getOpenQuantity());
			return block.getExecutedQuantity();
			/* getTradedQuantity(block, securities); */
		}

	}
}
