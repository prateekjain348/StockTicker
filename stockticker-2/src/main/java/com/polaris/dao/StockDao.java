package com.polaris.dao;

import java.util.List;

import com.lendbox.dto.StockDto;

public interface StockDao {
	public List<StockDto> process(List <String> filePath);
	public List<StockDto> fetchStockTicker();
}
