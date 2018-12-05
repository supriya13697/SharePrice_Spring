package com.cg.stock.dao;

import java.util.List;

import com.cg.stock.dto.Client;

public interface StockDAO {
	public List<Client> getAllStocks();
	public Client getStock(int stid);
}
