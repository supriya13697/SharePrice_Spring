package com.cg.stock.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cg.stock.dto.Client;
import com.cg.stock.service.StockService;

@Controller
public class StockController
{
	
	//Autowired is used to create make a connection with proceeding layers
	@Autowired
	StockService service;
	
	/*
	 * This method will be called when the index.jsp redirects to home.
	 * It is used to get the entire list from the database and further redirects it to the Home.jsp page.
	 * Also it calls the getAllStocks method which exists in service layer.
	 */
	@RequestMapping("run")
	public String getAll(Model model)
	{
		
		List<Client> list = null;
		try {
			list = service.getAllStocks();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		model.addAttribute("list",list);
		return "index";
	}
	
	@RequestMapping("selectOrder")
	public String setOrder(@RequestParam("stockId") int stock,Model model)
	{
		Client client= service.getStock(stock);
		model.addAttribute("data",client);
		return "order";
	}
	
	@RequestMapping("placeOrder")
	public String placeOrder(@ModelAttribute("data") Client client, 
			@RequestParam("quantity") int quantity,Model model)
	{
		double finalPrice = client.getQuote()*quantity;
		model.addAttribute("price",finalPrice);
		model.addAttribute("stock",client.getStock());
		return "result";
	}
}
