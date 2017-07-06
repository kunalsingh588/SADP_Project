package com.sapient.service;

import java.util.Random;

import com.sapient.entity.Blocks;


public class RandomNumberGenerator {
	int maxNoOfExecution;
	Blocks blocks = new Blocks();
	Random r = new Random();

	public int getNoOfExecution(int maxNoOfExecution) {
		if (1 >= maxNoOfExecution) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return r.nextInt((maxNoOfExecution - 1) + 1) + 1;
	}

	public int getNoOfSecurities(int remainingOrderQuantity) {
		// remainingOrderQuantity=blocks.getOpenQuantity();
		if (1 >= remainingOrderQuantity) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return r.nextInt((remainingOrderQuantity - 1) + 1) + 1;

	}

	public double getRandomPriceSpread(int maxPercentageSpread) {
		// remainingOrderQuantity=blocks.getOpenQuantity();
		if (0 >= maxPercentageSpread) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		return (r.nextDouble() * maxPercentageSpread);

	}

	public double getRandomNumberInRange(double min, double max) {
		double range = max - min;
		double scaled = r.nextDouble() * range;
		double shifted = scaled + min;
		return shifted;
	}

}
