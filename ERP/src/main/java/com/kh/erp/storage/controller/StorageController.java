package com.kh.erp.storage.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.erp.storage.model.service.StorageService;

@Controller
public class StorageController {
	
	@Autowired
	StorageService storageService;
	
	// 창고  리스트 전체를 조회하는 메소드
	@RequestMapping("/storage/storageList.do")
	public String selectStorageList(Model model) {
		return null;
	
		/*
		 * ArrayList<Map<String, String>> list = new
		 * ArrayList<>(storageService.storageList());
		 * 
		 * model.addAttribute("list", list);
		 * 
		 * ArrayList<Map<String, String>> calist = new
		 * ArrayList<>(materialsCategoryService.materialsCategoryList());
		 * 
		 * model.addAttribute("calist", calist);
		 * 
		 * return "materials/materialsList";
		 */
	}
}
