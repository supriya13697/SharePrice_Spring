package com.cg.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import com.cg.stock.dto.Client;

@Repository("dao")
public class StockDAOImpl  implements StockDAO
{
	@PersistenceContext
	EntityManager entitymanager;
	
	/*
	 * Using createQuery method the entire list has been retrieved from the database and stored in a list.
	 * Further it will be returned to the service layer
	 */
	@Override
	public List<Client> getAllStocks() {
		String string ="select stock from Client stock";
		TypedQuery<Client> queryOne=(TypedQuery<Client>) entitymanager.createQuery(string,Client.class);
		List<Client> list=queryOne.getResultList();
		return list;
	}

	@Override
	public Client getStock(int stid) {
		
		Client obj= entitymanager.find(Client.class,stid);
	
		return obj;
	}

}
