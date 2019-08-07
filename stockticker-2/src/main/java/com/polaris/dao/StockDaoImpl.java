package com.polaris.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session ;

//import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendbox.dto.StockDto;
import com.lendbox.model.files.FetchStock;
import com.lendbox.utilities.FileReadUtility;

@Repository
public class StockDaoImpl implements StockDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Configuration cfg;
	@Override
	public List<StockDto> process(List<String> filesPath) {
		List<StockDto> list = new ArrayList<StockDto>();
		for( String filePath: filesPath)
		{
				list.addAll(FileReadUtility.readCsv(filePath));						
		}
		System.out.println("Calling createStockTicker");
		createStockTicker(list);
		return list;
	}
	
	public void createStockTicker(List<StockDto> stocksDto)
	{			
		try {
			
			cfg=new Configuration();
			cfg.configure("/com/lendox/hibernate.cfg.xml").addAnnotatedClass(StockDto.class);    
			sessionFactory =cfg.buildSessionFactory();		
			Session session = sessionFactory.openSession();  
  			session.beginTransaction();
  			Query query = session.createQuery("delete StockDto");
  			query.executeUpdate();
  			session.getTransaction().commit();
  			
  			session.beginTransaction();
			for(StockDto stockDto:stocksDto)
			{
				session.save(stockDto);
			}
			session.getTransaction().commit();
			session.close();  
		}catch(Exception e) {
			System.out.println("Exception occured:- ");
			System.out.println(e.getMessage());}
	}

	public List<StockDto> fetchStockTicker()
	{			
		System.out.println("Insid fetchStockTicker function ");
		Session session =null;
//		List<StockDto> stocksDto= new ArrayList<StockDto>();
		List<StockDto> list = new ArrayList<StockDto>();
		List<StockDto> listUpdate = new ArrayList<StockDto>();
		try {			 
			cfg=new Configuration();
			cfg.configure("/com/lendox/hibernate.cfg.xml").addAnnotatedClass(StockDto.class);    
			sessionFactory =cfg.buildSessionFactory();		
			session = sessionFactory.openSession();		
			System.out.println("Before Iteration fetch");
			list =  session.createQuery("from StockDto").list();
			System.out.println("After Iteration fetch " + list.size());
//			 while ( iter.hasNext() ) {
//				 StockDto stockDto = (StockDto) iter.next();  // fetch the object		            
//				 System.out.println( "\n "+ stockDto.getSymbol() + " And " + stockDto.getPrice() );
//				 list.add(stockDto);
//				}
			 System.out.println("After fetching fom DB");
			 FetchStock fetchStock =new FetchStock();
			 for(StockDto stockDto:list)
				{				 
					//System.out.println( "\n "+ stockDto.getSymbol() + " And " + stockDto.getPrice() );
					stockDto.setPrice(fetchStock.getstockprice(stockDto.getSymbol()));
					listUpdate.add(stockDto);
				}
		}catch(Exception e) {
			System.out.println("Exception occured:- ");
			System.out.println(e.getMessage());
			}
		finally {
			session.close();
		}
		return listUpdate;
	}

}
