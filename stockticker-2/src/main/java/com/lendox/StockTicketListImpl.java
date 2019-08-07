package com.lendox;

import java.util.ArrayList;
import java.util.List;

import com.lendbox.dto.StockDto;
//import com.lendbox.dto.StockDto;
//import com.lendbox.model.files.FetchStock;

public class StockTicketListImpl  implements StockTicketList{

	@Override
	public List <StockDto> process(List <StockDto> stocksDto){
		List<StockDto> returnstocks=new ArrayList<StockDto>();
//		FetchStock fetchStock=new FetchStock();
		for(StockDto stockDto: stocksDto)
		{			
			//returnstocks.add(fetchStock.getstock(stockDto.getSymbol()));
			returnstocks.add(stockDto);
		}
		return returnstocks;
	}

}

