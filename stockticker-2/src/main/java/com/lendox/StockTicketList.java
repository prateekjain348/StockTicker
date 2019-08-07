package com.lendox;

import java.util.List;

import com.lendbox.dto.StockDto;

public interface StockTicketList {
	public List <StockDto> process(List <StockDto> stockDto);
}
