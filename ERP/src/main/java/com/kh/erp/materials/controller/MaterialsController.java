package com.kh.erp.materials.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.materials.model.service.MaterialsCategoryService;
import com.kh.erp.materials.model.service.MaterialsService;
import com.kh.erp.materials.model.vo.Materials;
import com.kh.erp.materials.model.vo.MaterialsCategory;

@Controller
public class MaterialsController {

	@Autowired
	MaterialsService materialsService;
	
	@Autowired
	MaterialsCategoryService materialsCategoryService;
	
	// 기자재  리스트 전체를 조회하는 메소드
	@RequestMapping("/materialscate/mateList.do")
	public String selectMaterialCategoryList(Model model) {
	
		ArrayList<Map<String, String>> list
		 = new ArrayList<>(materialsService.materialsList());
	
		model.addAttribute("list", list);
		
		ArrayList<Map<String, String>> calist
		 = new ArrayList<>(materialsCategoryService.materialsCategoryList());
		
		model.addAttribute("calist", calist);
		
		return "materials/materialsList";
	}
		
	// 기자재 추가 메소드
	@RequestMapping("/materialscate/mateInsert.do")
	public String insertMaterialCategory(@RequestParam String mName,
			@RequestParam int mCate, Model model) {
		
		Materials materials = new Materials(mCate, mName);
		int result = materialsService.insertMaterials(materials);
		
		String msg="";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/materialscate/mateList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	// 기자재 수정 메소드
	@RequestMapping("/materialscate/mateUpdate.do")
	public String updateMaterialCategory(@RequestParam int mCode,@RequestParam int mCate,@RequestParam String mName, Model model) {
		
		Materials materials = new Materials(mCode, mCate, mName);
		int result = materialsService.updateMaterials(materials);
		String msg="";
		if( result > 0 ) {
			msg ="수정 성공!";
		} else {
			msg ="수정 실패!";
		}
		String loc="/materialscate/mateList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	// 기자재 삭제 메소드
	@RequestMapping("/materialscate/mateDelete.do")
	public String deleteMaterialCategory(@RequestParam int mCode, Model model) {
		
		int result = materialsService.deleteMaterials(mCode);
		String msg="";
		if( result > 0 ) {
			msg="삭제 성공!";
		} else {
			msg="삭제 실패!";
		}
		String loc="/materialscate/mateList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
}
