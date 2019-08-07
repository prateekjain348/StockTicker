package com.lendbox.utilities;

import java.util.List;

import com.lendbox.dto.StockDto;

public class StockRefreshUtility {
	public void refreshStock(List<StockDto> stocksDto)
	{
		for(StockDto stockDao:stocksDto) 
		{
			System.out.println("Symbol = "+ stockDao.getSymbol());
		}		
	}
	public void refreshStock(StockDto stockDto)
	{
		
			System.out.println("Symbol = "+ stockDto.getSymbol());
				
	}

}
