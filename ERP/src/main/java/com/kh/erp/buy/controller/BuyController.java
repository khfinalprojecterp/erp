package com.kh.erp.buy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.erp.buy.model.service.BuyService;
import com.kh.erp.buy.model.vo.Purchase;



@Controller
public class BuyController {
	
	@Autowired
	BuyService buyService;
	

	
	
	
	@RequestMapping("/buy/buy_lookup.do")
	public String buy_lookup(Model model) {
		
		ArrayList<Map<String, String>> list = new ArrayList<>(buyService.purchaseList()); // 구매 목록 조회
		
		model.addAttribute("list", list);

		
		ArrayList<Map<String, String>> mlist = new ArrayList<>(buyService.mList()); // 자재 리스트
		
		model.addAttribute("mlist", mlist);
		
		
		ArrayList<Map<String, String>> plist = new ArrayList<>(buyService.pList()); // 물품 리스트
		
		model.addAttribute("plist", plist);
		
		
		ArrayList<Map<String, String>> slist = new ArrayList<>(buyService.sList()); // 창고 리스트
		
		model.addAttribute("slist", slist);
		
		ArrayList<Map<String, String>> elist = new ArrayList<>(buyService.eList()); // 창고 리스트
		
		model.addAttribute("elist", elist);	
		
		return "buy/buy_lookup";
	}
	
	@RequestMapping("/buy/buy_insert.do")
	public String buy_insert(Purchase purchase, Model model) {
		
		int result = buyService.insertPurchase(purchase);
		
		String msg = "";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_insertS.do")
	public String buy_insertS(Purchase purchase, Model model) {
		
		int result = buyService.insertPurchaseS(purchase);
		
		String msg = "";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_update.do")
	public String buy_update(Purchase purchase,Model model) {
		
		
		int result = buyService.updatePurchase(purchase);
		// 2. 처리 결과에 따른 화면 설정

		String msg = "";
		
		if(result > 0) {
			msg="수정 성공!!";
		} else {
			msg = "수정 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_updateS.do")
	public String buy_updateS(Purchase purchase,Model model) {
		
		
		int result = buyService.updatePurchaseS(purchase);
		// 2. 처리 결과에 따른 화면 설정

		String msg = "";
		
		if(result > 0) {
			msg="구매 완료";
		} else {
			msg = "구매 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_delete.do")
	public String buy_delete(@RequestParam int buy_code, Model model) {
		
		int result = buyService.deletePurchase(buy_code);
		String msg="";
		if( result > 0 ) {
			msg="삭제 성공!";
		} else {
			msg="삭제 실패!";
		}
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}

}
