package com.lendbox.model.files;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import com.lendbox.dto.HistoricalStockDto;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import com.lendbox.utilities.CalendarConvert;

public class FetchHistoricalStock {

	public void getHistoricalQuote(String stockName) throws IOException
	{
		//Stock stock=YahooFinance.get(stockName);
		Stock stock= YahooFinance.get(stockName);
		List<HistoricalQuote> history= stock.getHistory();
		for(HistoricalQuote quote : history)
		{
			System.out.println("========Start========");
			HistoricalStockDto historicalStockDto =new HistoricalStockDto(quote.getSymbol(),convertDate(quote.getDate()),quote.getHigh(),quote.getLow(),quote.getClose());
			historicalStockDto.toString();
			System.out.println("========End==========");
		}
	}

	private String convertDate(Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}
}
