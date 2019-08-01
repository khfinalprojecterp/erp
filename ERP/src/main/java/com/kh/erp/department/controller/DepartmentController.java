package com.kh.erp.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.erp.department.model.service.DepartmentService;
import com.kh.erp.department.model.vo.Department;
import com.kh.erp.field.model.service.FieldService;
import com.kh.erp.field.model.vo.Field;


@Controller
public class DepartmentController {
	
	
	
	
	@Autowired
	DepartmentService departService;
	@Autowired
	FieldService fieldService;
	
	
	@RequestMapping("/department/departmentList.do")
	public String departmentList(Model model
			) {
	
		List<Department> list = departService.selectDepartList();
		
		List<Field> flist = fieldService.selectFieldList();

		model.addAttribute("list", list);
		model.addAttribute("flist",flist);
		
	
		return "department/departmentList";
	}
	

	
	@RequestMapping(value="/department/insertDepart.do",
	        method=RequestMethod.GET)
		public String insertDepart(Department depart, Model model) {


				int result = departService.insertDepart(depart);
				
				String msg="";
				if( result > 0 ) {
					msg="등록 성공!";
				} else {
					msg="등록 실패!";
				}
				
				String loc="/department/departmentList.do";
				model.addAttribute("loc", loc);
				model.addAttribute("msg", msg);
				


				return "common/msg";
}

	
	

	@RequestMapping("/department/updateDepartment.do")
	public String updateDepart(Department depart ,Model model) {
		
		
		int result = departService.updateDepart(depart);
		
		
		String msg="";
		if( result > 0 ) {
			msg="수정 성공!";
		} else {
			msg="수정 실패!";
		}
		
		String loc="/department/departmentList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		


		return "common/msg";
	}
	
	
	@RequestMapping("/department/deleteDepartment.do")
	public String deleteDepart(Department depart, Model model) {
		
		int dCode =depart.getdCode();
		
		int result = departService.deleteDepart(dCode);
		String msg="";
		if( result > 0 ) {
			msg="삭제 성공!";
		} else {
			msg="삭제 실패!";
		}
		
		String loc="/department/departmentList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		


		return "common/msg";	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
