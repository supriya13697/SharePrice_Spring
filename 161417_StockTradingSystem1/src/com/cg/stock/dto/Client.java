package com.cg.stock.dto;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="stock_master")
public class Client
{
	@Id
	@Column(name="stock_code")
	private int stockCode;
	private String stock;
	private double quote;
	public int getStockCode() {
		return stockCode;
	}
	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public double getQuote() {
		return quote;
	}
	public void setQuote(double quote) {
		this.quote = quote;
	}
	@Override
	public String toString() {
		return "Client [stockCode=" + stockCode + ", stock=" + stock
				+ ", quote=" + quote + "]";
	}
	

}
