package com.lendbox.model.files;

import java.io.IOException;
import java.math.BigDecimal;

import com.lendbox.dto.StockDto;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class FetchStock {
	
	public StockDto getstock(String stockName)
	{
		StockDto dto;
		Stock stock=null;
		
		try {
			stock=YahooFinance.get(stockName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//System.exit(0);
		}
		finally
		{
			System.out.println("zscss");
			
		}
		//dto=  new StockDto(stock.getName(), stock.getCurrency(), stock.getQuote().getPrice(), stock.getQuote().getChange(), stock.getQuote().getBid());		
		dto=  new StockDto(stock.getName(), stock.getQuote().getPrice());
		return dto ;
	}
	public BigDecimal getstockprice(String stockName)
	{		
		Stock stock=null;
		
		try {
			stock=YahooFinance.get(stockName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//System.exit(0);
		}			
		
		
		return stock.getQuote().getPrice() ;
	}
	public void getStock(String[] stockNames) throws IOException
	{
		for(String stockName : stockNames)
		{
			getstock(stockName);
		}		
	}
}
