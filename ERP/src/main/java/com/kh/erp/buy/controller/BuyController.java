package com.kh.erp.buy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.erp.buy.model.service.BuyService;
import com.kh.erp.buy.model.vo.Purchase;



@Controller
public class BuyController {
	
	@Autowired
	BuyService buyService;
	

	
	
	
	@RequestMapping("/buy/buy_lookup.do")
	public String buy_lookup(Model model) {
		List<Purchase> list = buyService.purchaseList();

		model.addAttribute("list", list);
		
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
