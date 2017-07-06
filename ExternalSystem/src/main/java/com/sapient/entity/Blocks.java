package com.sapient.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "getExecutedQuantity", query = "update Blocks b set b.executedQuantity=:executedQuantity where b.id=:id")
public class Blocks implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String side;
	private String symbol;
	private String blockType;
    private double tradedPrice;
	private String status;
	private int totalQuantity;
	public int getTotalQuantity() {
		return totalQuantity;
	}



	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	private int openQuantity;
	private int executedQuantity;
	//private double price;

	/*public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}*/



	public Blocks() {
	}



	public double getTradedPrice() {
		return tradedPrice;
	}



	public void setTradedPrice(double tradedPrice) {
		this.tradedPrice = tradedPrice;
	}



	
	public Blocks(int id, String side, String symbol, String blockType, double tradedPrice, String status,
			int totalQuantity, int openQuantity, int executedQuantity) {
		super();
		this.id = id;
		this.side = side;
		this.symbol = symbol;
		this.blockType = blockType;
		this.tradedPrice = tradedPrice;
		this.status = status;
		this.totalQuantity = totalQuantity;
		this.openQuantity = openQuantity;
		this.executedQuantity = executedQuantity;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSide() {
		return side;
	}

	public String getBlockType() {
		return blockType;
	}

	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOpenQuantity() {
		return openQuantity;
	}

	public void setOpenQuantity(int openQuantity) {
		this.openQuantity = openQuantity;
	}

	public int getExecutedQuantity() {
		return executedQuantity;
	}

	public void setExecutedQuantity(int executedQuantity) {
		this.executedQuantity = executedQuantity;
	}

	@Override
	public String toString() {
		return "Blocks [id=" + id + ", side=" + side + ", symbol=" + symbol + ", blockType=" + blockType
				+ ", tradedPrice=" + tradedPrice + ", status=" + status + ", totalQuantity=" + totalQuantity
				+ ", openQuantity=" + openQuantity + ", executedQuantity=" + executedQuantity + "]";
	}

}
