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
	
	
	
	@RequestMapping(value="/department/insertField.do",
	        method=RequestMethod.GET)
		public String insertDepart(Field field, Model model) {


				int result = fieldService.insertField(field);

				String msg="";
				if( result > 0 ) {
					msg="상세 정보 등록 성공!";
				} else {
					msg="상세 정보 등록 실패!";
				}
				
				String loc="/department/departmentList.do";
				model.addAttribute("loc", loc);
				model.addAttribute("msg", msg);
				


				return "common/msg";


}
	
	
	@RequestMapping(value="/field/deleteField.do")
	public String deleteField(@RequestParam int fCode,Model model) {
		
	
		
		int result = fieldService.deleteField(fCode);
		
		String msg="";
		if( result > 0 ) {
			msg="상세 정보 삭제 성공!";
		} else {
			msg="상세 정보 삭제 실패!";
		}
		
		String loc="/department/departmentList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		


		return "common/msg";
		
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
