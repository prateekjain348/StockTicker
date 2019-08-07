package com.lendbox.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockTicker")
public class StockDto {
	@Id
	private String symbol;
	private BigDecimal price;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockDto [symbol=" + symbol + ", price=" + price + "]";
	}

	public StockDto(String symbol, BigDecimal price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}

	public StockDto() {

	}

}
