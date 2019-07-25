package com.kh.erp.storage.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.materials.model.vo.MaterialsCategory;
import com.kh.erp.storage.model.service.StorageService;
import com.kh.erp.storage.model.vo.Storage;

@Controller
public class StorageController {

	@Autowired
	StorageService storageService;

	// 창고 리스트 전체를 조회하는 메소드
	@RequestMapping("/storage/storageList.do")
	public String selectStorageList(Model model) {
		
		
		ArrayList<Map<String, String>> list = new ArrayList<>(storageService.storageList());
		
		model.addAttribute("list", list);
		
		/*
		 * ArrayList<Map<String, String>> calist = new
		 * ArrayList<>(materialsCategoryService.materialsCategoryList());
		 * 
		 * model.addAttribute("calist", calist);
		 */
		
		return "storage/storageList";
		
	}
	
	// 창고 추가 메소드
	@RequestMapping("/storage/storageInsert.do")
	public String insertStorage(Model model,
			@RequestParam int eCode, @RequestParam int idCode, @RequestParam String sCate,
			@RequestParam String sPhone, @RequestParam String sAddr) {
		
		Storage storage = new Storage(eCode, idCode, sCate, sPhone, sAddr);
		int result = storageService.insertStorage(storage);
		
		String msg="";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/storage/storageList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	// 창고 수정 메소드
	@RequestMapping("/storage/storageUpdate.do")
	public String updateStorage(Model model,
			@RequestParam int eCode, @RequestParam int idCode, @RequestParam int sCode,
			@RequestParam String sCate, @RequestParam String sPhone, @RequestParam String sAddr, @RequestParam String sStatus
			) {
		
		Storage storage = new Storage(sCode, eCode, idCode, sCate, sPhone, sAddr, sStatus);
		int result = storageService.updateStorage(storage);
		String msg="";
		if( result > 0 ) {
			msg ="수정 성공!";
		} else {
			msg ="수정 실패!";
		}
		String loc="/storage/storageList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	// 창고 삭제 메소드
	@RequestMapping("/storage/storageDelete.do")
	public String deleteMaterialCategory(@RequestParam int sCode, Model model) {
		
		int result = storageService.deleteStorage(sCode);
		String msg="";
		if( result > 0 ) {
			msg="삭제 성공!";
		} else {
			msg="삭제 실패!";
		}
		String loc="/storage/storageList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	
	
}
