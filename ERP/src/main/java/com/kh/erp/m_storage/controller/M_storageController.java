package com.kh.erp.m_storage.controller ;

import java.sql.Date;  
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.m_storage.model.service.M_storageService;
import com.kh.erp.m_storage.model.service.M_storageServiceImpl;
import com.kh.erp.m_storage.model.vo.M_storage;



@Controller
public class M_storageController {
@Autowired
M_storageService m_storageService; 

	/*
	 * private int IDCODE;// 사원코드 private int MCOE; // 기자재 코드 private int SCODE;//반출
	 * 창고 코드 private int MSMSTOCK;// 수량 private Date MSDATE;//신청일 private int
	 * MSPRICE;//납품원가 private String MSSTATUS;//(신청 거절,완료)
	 */

@RequestMapping(value="/m_storage/insertM_storage.do",
method=RequestMethod.GET)
public String insertM_storage(M_storage m_storage) {

System.out.println("insertm_storage 화면 메소드 확인");

	
		  int result = m_storageService.insert(m_storage);
		 
		  System.out.println("insert 결과 : " + result);
		 

return "m_storage/m_storagelist";
}

@RequestMapping("/m_storage/M_storageList.do")
public String selectM_storageList(Model model) {
	List<M_storage> list=m_storageService.selectM_storageList();
	
	System.out.println("list 확인"+list);
	model.addAttribute("list",list);
	
	return"m_storage/m_storagelist";
	
	
	}
	
		
@RequestMapping("/m_storage/m_storageDev.do")
public String updateDev(Model model, @RequestParam int MCODE) {
	model.addAttribute("m_storage", m_storageService.selectM_storageList());
	
	return "m_storage/m_storageForm";



	}



@RequestMapping("/demo/updatem_storag.do")
public String updateM_storageEnd(M_storage m_storage) {
	
	System.out.println("update 전 확인 : " + m_storage);
	
	int result = m_storageService.updateM_storage(m_storage);
	
	return "redirect:/m_storage/selectM_storageList.do";






}
}
