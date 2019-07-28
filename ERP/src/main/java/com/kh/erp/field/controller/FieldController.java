package com.kh.erp.field.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.field.model.service.FieldService;
import com.kh.erp.field.model.vo.Field;

@Controller
public class FieldController {

	
	@Autowired
	FieldService fieldService;
	
	

//	
//	@RequestMapping("/department/departmentList.do")
//	public String fieldList(Model model
//			) {
//	
//		List<Field> list = fieldService.selectFieldList();
//		
//		model.addAttribute("list", list);
//	
//		return "department/departmentList";
//	}
//	

	
	@RequestMapping(value="/department/insertField.do",
	        method=RequestMethod.GET)
		public String insertDepart(Field field) {


				int result = fieldService.insertField(field);

	
// 서블릿에서 sendRedirect() 했던 코드를
// 스프링에서 구현하려면 'redirect:'을 작성하고
// 뒤에 보내고자 하는 url을 적는다.
// '/'는 절대 경로인 index.jsp로 보내는 역할을 한다.

			 return "redirect:/department/departmentList.do";
}
	
	
	@RequestMapping(value="/field/deleteField.do")
	public String deleteField(@RequestParam int fCode) {
		
	
		
		System.out.println(fCode);
		
		int result = fieldService.deleteField(fCode);
		
		return "redirect:/department/departmentList.do";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
