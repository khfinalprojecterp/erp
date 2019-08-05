package com.kh.erp.quality_ch.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.quality_ch.model.service.Quality_chService;
import com.kh.erp.quality_ch.model.vo.Quality_ch;

@Controller
public class Quality_chController {
@Autowired
Quality_chService quality_chService;

//발주요청 화면 전환 매소드 
@RequestMapping(value="/quality_ch/insertQuality_ch.do",
method=RequestMethod.GET)
public String insertQuality_chView(Quality_ch quality_ch) {

System.out.println("insertm_storage 화면 메소드 확인");



return "quality_ch/quality_ch";
}

//발주요청 기능수행메소드
@RequestMapping(value="/quality_ch/insertQuality_ch.do",
method=RequestMethod.POST)
public String insertQuality_ch(
	
		@RequestParam int QRCODE,
		
		@RequestParam int IDCODE,
		@RequestParam int ECODE,
		@RequestParam int QCHT,
		@RequestParam int QCHF,
		@RequestParam String QCHCHECK,
		@RequestParam String QCHSTATUS
		) {

	Quality_ch quality_ch = new Quality_ch(QRCODE,IDCODE,ECODE, QCHT, QCHF, QCHCHECK, QCHSTATUS);
	
	System.out.println(quality_ch);
System.out.println("insertquality_ch 화면 메소드 확인");

//여기까진 되는데 

		  int result = quality_chService.insert(quality_ch);
		 
		   System.out.println("insert 결과 : " + result);
		 

return "redirect:/quality_ch/Quality_chList.do";
}




@RequestMapping("/quality_ch/Quality_chList.do")
public String selectM_storageList(Model model) {
	List<Quality_ch> list=quality_chService.selectQuality_chList();
	
	System.out.println("list 확인"+list);
	model.addAttribute("list",list);
	
	return"quality_ch/Quality_chList";
	
	
	}
/*private int QRCODE;// 품질관리코드
private int IN_CODE;// 생산 입고 코드
private int QCHT;// 적격
private int QCHF;//부적격
private String QCHCHECK;//불/합격
private String QCHSTATUS;
		*/
	


@RequestMapping("/quality_ch/updateQuality_ch.do")
public String updateQuality_ch(@RequestParam int QRCODE,
		
	
		
		@RequestParam int IDCODE,
		@RequestParam int ECODE,
		@RequestParam int QCHT,
		@RequestParam int QCHF,
		@RequestParam String QCHCHECK,
		@RequestParam String QCHSTATUS,
		
		 Model model) {
	
	Quality_ch quality_ch = new Quality_ch(QRCODE,IDCODE,ECODE,QCHT,QCHF,
			QCHCHECK,QCHSTATUS
			);
	
	
	int result = quality_chService.updateQuality_ch(quality_ch);
	String msg="";
	if( result > 0 ) {
		msg="수정 성공";
	} else {
		msg="수정 실패!";
	}
	String loc="/quality_ch/Quality_chList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}




@RequestMapping("/quality_ch/deleteQuality_ch.do")
public String deleteM_storage(@RequestParam int QRCODE, Model model) {
	
	int result = quality_chService.deleteQuality_ch(QRCODE);
	String msg="";
	if( result > 0 ) {
		msg="삭제 성공!";
	} else {
		msg="삭제 실패!";
	}
	String loc="/quality_ch/Quality_chList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}






}


