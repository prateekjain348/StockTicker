package com.lendbox.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;

import com.lendbox.dto.StockDto;
//import com.lendbox.model.files.FetchStock;


public class FileReadUtility {

	public static List<StockDto> readCsv(String filePath)
	{
		List<StockDto> dtoList =new ArrayList<StockDto>() ;
		BufferedReader buff = null;
		String line="";
		String splitBy=",";
		int i=0;
		//FetchStock fetchStock =new FetchStock();
		try {
			buff=new BufferedReader(new FileReader(filePath));
			try {
				while((line =buff.readLine())!=null)
				{
					if(i==0)
					{
						i++; continue;						
					}
					
					String[] data =line.split(splitBy);
					StockDto dto =new StockDto() ;
					dto.setSymbol(data[0]);					
					if(data.length == 1)
						dto.setPrice(new BigDecimal(0));
					else
						dto.setPrice(new BigDecimal(data[1]));
					
					//dto.setPrice(fetchStock.getstockprice(data[0]));
					
					
					
					dtoList.add(dto);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(buff!=null)
					try {
						buff.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}			
		}catch(FileNotFoundException e)	{
			e.printStackTrace();
		}
		return dtoList;		
	}
	public static String getFileExtension(String name) {
		if(name.lastIndexOf(",")!= -1 && name.lastIndexOf(".") != 0)
		{
			return name.substring(name.lastIndexOf(".")+1);
		}
		else
		{
			return "";
		}		
	}
}
