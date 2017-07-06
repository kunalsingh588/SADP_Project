package com.sapient.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Securities implements Serializable {
	@Override
	public String toString() {
		return "Securities [symbol=" + symbol + ", name=" + name + ", maxSpread=" + maxSpread + ", maxExecution="
				+ maxExecution + ", maxInterval=" + maxInterval + ", percentageOfExecution=" + percentageOfExecution
				+ ", lastTradedPrice=" + lastTradedPrice + "]";
	}

	@Id
	private String symbol;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private int maxSpread;
	private int maxExecution;
	private int maxInterval;
	private int percentageOfExecution;
	
	private double lastTradedPrice;
public Securities(){}
	public Securities(int maxSpread, int maxExecution, int maxInterval, int percentageOfExecution, String symbol,
			double lastTradedPrice) {
		super();
		this.maxSpread = maxSpread;
		this.maxExecution = maxExecution;
		this.maxInterval = maxInterval;
		this.percentageOfExecution = percentageOfExecution;
		this.symbol = symbol;
		this.lastTradedPrice = lastTradedPrice;
	}

	public int getMaxSpread() {
		return maxSpread;
	}

	public void setMaxSpread(int maxSpread) {
		this.maxSpread = maxSpread;
	}

	public int getMaxExecution() {
		return maxExecution;
	}

	public void setMaxExecution(int maxExecution) {
		this.maxExecution = maxExecution;
	}

	public int getMaxInterval() {
		return maxInterval;
	}

	public void setMaxInterval(int maxInterval) {
		this.maxInterval = maxInterval;
	}

	public int getPercentageOfExecution() {
		return percentageOfExecution;
	}

	public void setPercentageOfExecution(int percentageOfExecution) {
		this.percentageOfExecution = percentageOfExecution;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getLastTradedPrice() {
		return lastTradedPrice;
	}

	public void setLastTradedPrice(double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}

}
