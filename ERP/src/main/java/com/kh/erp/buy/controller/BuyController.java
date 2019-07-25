package com.kh.erp.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyController {
	
	@RequestMapping("/buy/buy_lookup.do")
	public String buy_lookup() {
		
		
		return "buy/buy_lookup";
	}
	
	@RequestMapping("/buy/buy_insert.do")
	public String buy_insert() {
		
		
		return "buy/buy_insert";
	}
	
	@RequestMapping("/buy/buy_status.do")
	public String buy_status() {
		
		
		return "buy/buy_status";
	}

}
