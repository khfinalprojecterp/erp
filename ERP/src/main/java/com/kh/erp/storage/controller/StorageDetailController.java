package com.kh.erp.storage.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.materials.model.service.MaterialsService;
import com.kh.erp.storage.model.service.StorageDetailService;
import com.kh.erp.storage.model.service.StorageService;
import com.kh.erp.storage.model.vo.StorageDetail;

@Controller
public class StorageDetailController {

	@Autowired
	StorageDetailService storageDetailService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	MaterialsService materialsService;
	
	/* 
	 * detail 을 하나 혹은 여러개를 수정해야 할 수 있으니(인서트도?) 객체로 받아온다.
	 * 이를 controller 에서 for 문을 통해 여러번 처리하거나 , (next()) 사용
	 * 객체 덩어리로 넘겨준후 , dao 혹은 service에서 처리하게 구현 한다.
	 */
	
	@RequestMapping("/storage/storageDetailList.do")
	public String selectStorageDetailList(Model model) {
		
		
		ArrayList<Map<String, String>> list = new ArrayList<>(storageDetailService.storageDetailList());
		
		model.addAttribute("list", list);
		
		ArrayList<Map<String, String>> slist = new ArrayList<>(storageService.storageList());
		
		model.addAttribute("slist", slist);
		
		ArrayList<Map<String, String>> mlist = new ArrayList<>(materialsService.materialsList());
	
		model.addAttribute("mlist", mlist);
		
		//임시 프로덕트
		ArrayList<Map<String, String>> plist = new ArrayList<>(storageDetailService.loadProductList());
		
		model.addAttribute("plist", plist);
		/*
		 * ArrayList<Map<String, String>> calist = new
		 * ArrayList<>(materialsCategoryService.materialsCategoryList());
		 * 
		 * model.addAttribute("calist", calist);
		 */
		
		return "storage/storageDetailList";
		
	}
	
		
	@RequestMapping("/storage/storageDetailInsert.do")
	public String insertStorageDetail(Model model, @RequestParam int sCode, @RequestParam int eCode,
			@RequestParam int idCode, @RequestParam(value = "mCode", required=false) String mCode, 
			@RequestParam(value = "pCode", required=false) String pCode, @RequestParam int sdStock, @RequestParam int sdCost, @RequestParam int sdPrice) {
		
		StorageDetail storageDetail = new StorageDetail(sCode,eCode,idCode,mCode,pCode,sdStock,sdCost,sdPrice);		
	
		int result = storageDetailService.insertStorageDetail(storageDetail);
		
		
		
		String msg="";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/storage/storageDetailList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/storage/storageDetailUpdate.do")
	public String updateStorageDetail(Model model,@RequestParam int sdCode, @RequestParam int sCode, @RequestParam int eCode,
			@RequestParam int idCode, @RequestParam(value = "mCode", required=false) String mCode, 
			@RequestParam(value = "pCode", required=false) String pCode, @RequestParam int sdStock, @RequestParam int sdCost, @RequestParam int sdPrice) {
		StorageDetail storageDetail = new StorageDetail(sdCode,sCode,eCode,idCode,mCode,pCode,sdStock,sdCost,sdPrice);		
	
		int result = storageDetailService.updateStorageDetail(storageDetail);
		
		
		
		String msg="";
		if( result > 0) {
			msg="수정 성공!";
			
		} else {
			msg="수정 실패!";
		}
		
		String loc="/storage/storageDetailList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/storage/storageDetailDelete.do")
	public String updateStorageDetail(Model model,@RequestParam int sdCode) {
		
		int result = storageDetailService.deleteStorageDetail(sdCode);
		
		
		
		String msg="";
		if( result > 0) {
			msg="삭제 성공!";
			
		} else {
			msg="삭제 실패!";
		}
		
		String loc="/storage/storageDetailList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
}
