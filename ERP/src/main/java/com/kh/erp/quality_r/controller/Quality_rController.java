package com.kh.erp.quality_r.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.quality_r.model.service.Quality_rService;
import com.kh.erp.quality_r.model.vo.Quality_r;

@Controller
public class Quality_rController {
@Autowired 

Quality_rService quality_rservice;


	/*
	 * @RequestMapping(value="/quality_r/insertQuality_r.do",
	 * method=RequestMethod.GET) public String insertQuality_rView(Quality_r
	 * quality_r) {
	 * 
	 * System.out.println("insertquality_r 화면 메소드 확인");
	 * 
	 * 
	 * return "quality_r/quality_r"; }
	 */
//발주요청 기능수행메소드
@RequestMapping(value="/quality_r/insertQuality_r.do",
method=RequestMethod.GET)
public String insertQuality_r(
		/*M_storage m_storage*/
			/*
			 * private int QRCODE; //품질관리 코드 private int IDCODE; //사원 코드 private int SCODE;
			 * //창고 코드 private int PCODE;//물품코드 private int IN_CODE;//생산 입고 코드 private
			 * String QRCHECK;//검사구분 private String QRNOTE;//적요 private int QRSTOCK;// 수량
			 * private String QRSTATUS;// 진행 사항
			 */
		
	
		@RequestParam int IDCODE,
		@RequestParam int SCODE,
		@RequestParam int PCODE,
		
		@RequestParam String QRCHECK,
		@RequestParam String QRNOTE,
		@RequestParam int  ECODE,
		@RequestParam int QRSTOCK,
		@RequestParam String QRSTATUS
		
		) {

	Quality_r quality_r = new Quality_r(IDCODE, SCODE, PCODE, ECODE,QRNOTE,QRCHECK, QRSTOCK,QRSTATUS);
	System.out.println(quality_r);
System.out.println("insertm_storage 화면 메소드 확인");

//여기까진 되는데 

		  int result = quality_rservice.insert(quality_r);
		 
		  System.out.println("insert 결과 : " + result);
		 

return "redirect:/quality_r/Quality_rList.do";
}




@RequestMapping("/quality_r/Quality_rList.do")
public String selectQuality_rList(String selectScode, Model model ,HttpSession session) {
	List<Quality_r> list=quality_rservice.selectQuality_rList();
	
	System.out.println("list 확인"+list);
	model.addAttribute("list",list);
	
	Employee employee = (Employee) session.getAttribute("employee"); 
	
	ArrayList<Map<String, String>> slist = new ArrayList<>(quality_rservice.quality_rDetailList());
	System.out.println(slist);
	model.addAttribute("slist", slist);
	
	ArrayList<Map<String, String>> plist = new ArrayList<>(quality_rservice.productDetailList());
	System.out.println(plist);
	model.addAttribute("plist", plist);
	
	ArrayList<Map<String, String>> elist = new ArrayList<>(quality_rservice.enterpriseDetailList());
	System.out.println(elist);
	model.addAttribute("elist", elist);
	return"quality_r/Quality_rList";
	
	
	}
	
	/*
	 * private int QRCODE; //품질관리 코드 private int IDCODE; //사원 코드 private int SCODE;
	 * //창고 코드 private int PCODE;//물품코드 private int IN_CODE;//생산 입고 코드 private
	 * String QRCHECK;//검사구분 private String QRNOTE;//적요 private int QRSTOCK;// 수량
	 * private String QRSTATUS;// 진행 사항
	 */
@RequestMapping("/quality_r/updateQuality_r.do")
public String updateQuality_r(@RequestParam int QRCODE ,
		//
	
		@RequestParam int IDCODE,
	
		@RequestParam int SCODE,
		@RequestParam int PCODE,
		
		@RequestParam String QRCHECK,
		@RequestParam String QRNOTE,
		@RequestParam int ECODE,
		@RequestParam int QRSTOCK,
		@RequestParam String QRSTAUS,
		
		 Model model) {
	
	Quality_r quality_r = new Quality_r(QRCODE, IDCODE, 
			SCODE,PCODE,ECODE,QRCHECK,QRNOTE,QRSTOCK,QRSTAUS);
	
	
	int result = quality_rservice.updateQuality_r(quality_r);
	String msg="";
	if( result > 0 ) {
		msg="수정 성공";
	} else {
		msg="수정 실패!";
	}
	String loc="/quality_r/Quality_rList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}




@RequestMapping("/quality_r/deleteQuality_r.do")
public String deleteM_storage(@RequestParam int QRCODE, Model model) {
	
	int result = quality_rservice.deleteQuality_r(QRCODE);
	String msg="";
	if( result > 0 ) {
		msg="삭제 성공!";
	} else {
		msg="삭제 실패!";
	}
	String loc="/quality_r/Quality_rList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}






}
