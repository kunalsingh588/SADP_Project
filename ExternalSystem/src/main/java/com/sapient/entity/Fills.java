package com.sapient.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "retrieveAllFills", query = "SELECT f FROM Fills f"),
		@NamedQuery(name = "Fillsbybid", query = "SELECT f FROM Fills f WHERE f.bid = :bid"),
	 })

public class Fills implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fill_id;
	private int bid;
	private String symbol;
	private String side;
	private int  exeQuantity;
	private double transactionPrice;
	private String transactionTime;

	public Fills() {}

	public int getFill_id() {
		return fill_id;
	}

	public void setFill_id(int fill_id) {
		this.fill_id = fill_id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getExeQuantity() {
		return exeQuantity;
	}

	public void setExeQuantity(int exeQuantity) {
		this.exeQuantity = exeQuantity;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Fills( int bid, String symbol, String side, int exeQuantity,
			double transactionPrice, String transactionTime) {
		super();
		
		this.bid = bid;
		this.symbol = symbol;
		this.side = side;
		this.exeQuantity = exeQuantity;
		this.transactionPrice = transactionPrice;
		this.transactionTime = transactionTime;
	}

	@Override
	public String toString() {
		return "Fills [fill_id=" + fill_id + ", bid=" + bid + ", symbol=" + symbol + ", side=" + side + ", exeQuantity="
				+ exeQuantity + ", transactionPrice=" + transactionPrice + ", transactionTime=" + transactionTime + "]";
	}
}
