package com.kh.erp.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.kh.erp.employee.model.service.PmanagementService;
import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.employee.model.vo.Pmanagement;




@Controller
public class PmanagementController {

	@Autowired
	PmanagementService pmanageService;

	
	@RequestMapping("/employee/pmanageList.do")
	public String pmanagementList(Model model
			) {
	
		
		List<Pmanagement> list = pmanageService.selectPmanageList(); 
		List<Employee> clist = pmanageService.selectChar();
		
		System.out.println("++++++++++"+clist+"+++++++++++++++");
		model.addAttribute("list", list);
		model.addAttribute("clist",clist);
		
		return "employee/pmanageList";
		
		
	}
	
		@RequestMapping(value="/pmanagement/updatePmanage.do",
		method=RequestMethod.GET)
		public String updatePmanagement(Pmanagement pmanage,Model model) {

			
			int result = pmanageService.updatePmanage(pmanage);
			
			
			String msg="";
			if( result > 0 ) {
				msg="근태 수정 성공!";
			} else {
				msg="근태 수정 실패!";
			}
			
			String loc="/employee/pmanageList.do";
			model.addAttribute("loc", loc);
			model.addAttribute("msg", msg);
			
			
			
			
			
			
			
			return "common/msg";
		}

	
}
