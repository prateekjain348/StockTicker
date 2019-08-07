package com.lendbox.dto;

import java.math.BigDecimal;

public class HistoricalStockDto {
	private String symbol;	
	private String date;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	private BigDecimal closedPrice;
	
	public HistoricalStockDto(String symbol, String date, BigDecimal highPrice, BigDecimal lowPrice,
			BigDecimal closedPrice) {
		super();
		this.symbol = symbol;
		this.date = date;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closedPrice = closedPrice;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}

	public BigDecimal getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}

	public BigDecimal getClosedPrice() {
		return closedPrice;
	}

	public void setClosedPrice(BigDecimal closedPrice) {
		this.closedPrice = closedPrice;
	}

	@Override
	public String toString() {
		return (" Symbol : " + symbol + "\n Date : " + date + "\n High Price : "
				+ highPrice + "\n Low Price : " + lowPrice + "\n Closed Price : " + closedPrice);
	}
	
	
}
