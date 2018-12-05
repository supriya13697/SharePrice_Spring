package com.cg.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.stock.dao.StockDAO;
import com.cg.stock.dto.Client;

@Service("servObj")
@Transactional
public class StockServiceImpl implements StockService 
{
	//Making a link between service and the DAO layer using Autowired annotation
	@Autowired
	StockDAO dao;
	
	/*
	 * This method retrieves the entire list of available sessions from the database from the dao layer
	 * and return the list to the controller class
	 */
	@Override
	public List<Client> getAllStocks() {
		return dao.getAllStocks();
	}
	@Override
	public Client getStock(int stid) {
		
		return dao.getStock(stid);
	}

}
