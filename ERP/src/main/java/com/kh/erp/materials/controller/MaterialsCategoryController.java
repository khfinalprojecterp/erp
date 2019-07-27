package com.kh.erp.materials.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.materials.model.service.MaterialsCategoryService;
import com.kh.erp.materials.model.vo.MaterialsCategory;

@Controller
public class MaterialsCategoryController {

	@Autowired
	MaterialsCategoryService materialsCategoryService;
	
	// 기자재 카테고리 리스트 전체를 조회하는 메소드
	@RequestMapping("/materialscate/mateCateList.do")
	public String selectMaterialCategoryList(Model model) {
		
		ArrayList<Map<String, String>> list
		 = new ArrayList<>(materialsCategoryService.materialsCategoryList());
		
		model.addAttribute("list", list);
		
		return "materials/materialsCateList";
	}
	
	// 기자재 카테고리 하나를 선택 조회하는 메소드
	@RequestMapping("/materialscate/mateCateView.do")
	public String selectOneMaterialCategory(@RequestParam int mCate, Model model) {
		
		model
			.addAttribute("materialsCategory",materialsCategoryService.selectOneMaterialsCategory(mCate));
		
		return "materials/materialsCateView";
	}
	
	// 기자재 추가 메소드
	@RequestMapping("/materialscate/mateCateInsert.do")
	public String insertMaterialCategory(@RequestParam String mcName, Model model) {
		
		int result = materialsCategoryService.insertMaterialsCategory(mcName);
		
		String msg="";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/materialscate/mateCateList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	// 기자재 수정 메소드
	@RequestMapping("/materialscate/mateCateUpdate.do")
	public String updateMaterialCategory(@RequestParam int mCate,@RequestParam String mcName, Model model) {
		
		MaterialsCategory mc = new MaterialsCategory(mCate, mcName);
		int result = materialsCategoryService.updateMaterialsCategory(mc);
		String msg="";
		if( result > 0 ) {
			msg ="수정 성공!";
		} else {
			msg ="수정 실패!";
		}
		String loc="/materialscate/mateCateList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	// 기자재 삭제 메소드
	@RequestMapping("/materialscate/mateCateDelete.do")
	public String deleteMaterialCategory(@RequestParam int mCate, Model model) {
		
		int result = materialsCategoryService.deleteMaterialsCategory(mCate);
		String msg="";
		if( result > 0 ) {
			msg="삭제 성공!";
		} else {
			msg="삭제 실패!";
		}
		String loc="/materialscate/mateCateList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
}
