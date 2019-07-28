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
		public String insertDepart(Department depart) {


				int result = departService.insertDepart(depart);

	
// 서블릿에서 sendRedirect() 했던 코드를
// 스프링에서 구현하려면 'redirect:'을 작성하고
// 뒤에 보내고자 하는 url을 적는다.
// '/'는 절대 경로인 index.jsp로 보내는 역할을 한다.

				return "redirect:/department/departmentList.do";
}

	
	

	@RequestMapping("/department/updateDepartment.do")
	public String updateDepart(Department depart) {
		
		System.out.println("update 전 확인 : " + depart);
		
		int result = departService.updateDepart(depart);
		
		return "redirect:/department/departmentList.do";
	}
	
	
	@RequestMapping("/department/deleteDepartment.do")
	public String deleteDepart(Department depart) {
		
			int dCode =depart.getdCode();
		
		int result = departService.deleteDepart(dCode);
		
		return "redirect:/department/departmentList.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
