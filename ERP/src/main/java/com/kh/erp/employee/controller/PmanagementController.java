package com.kh.erp.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.kh.erp.employee.model.service.PmanagementService;

import com.kh.erp.employee.model.vo.Pmanagement;




@Controller
public class PmanagementController {

	@Autowired
	PmanagementService pmanageService;

	
	@RequestMapping("/employee/pmanageList.do")
	public String pmanagementList(Model model
			) {
	
		
		List<Pmanagement> list = pmanageService.selectPmanageList(); 
		
		
		model.addAttribute("list", list);
		
		
		return "employee/pmanageList";
		
		
	}
	
		@RequestMapping(value="/pmanagement/updatePmanage.do",
		method=RequestMethod.GET)
		public String updatePmanagement(Pmanagement pmanage) {

			
			int result = pmanageService.updatePmanage(pmanage);
			
			return "redirect:/employee/pmanageList.do";
		}

	
}
