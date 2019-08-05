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

// 발주요청 화면 전환 매소드 
@RequestMapping(value="/m_storage/insertM_storage.do",
method=RequestMethod.GET)
public String insertM_storageView(M_storage m_storage) {

System.out.println("insertm_storage 화면 메소드 확인");

//여기까진 되는데 

		/* int result = m_storageService.insert(m_storage); */
		 
		/* System.out.println("insert 결과 : " + result); */
		 

return "m_storage/m_storage";
}

//발주요청 기능수행메소드
@RequestMapping(value="/m_storage/insertM_storage.do",
method=RequestMethod.POST)
public String insertM_storage(
		/*M_storage m_storage*/
		
		@RequestParam int IDCODE,
		@RequestParam int MCODE,
		@RequestParam int SCODE,
		@RequestParam int MSMSTOCK,
		@RequestParam Date MSDATE,
		@RequestParam int MSPRICE,
		@RequestParam String MSSTATUS) {

	M_storage m_storage = new M_storage(IDCODE, MCODE, SCODE, MSMSTOCK, MSDATE, MSPRICE, MSSTATUS);
	System.out.println(m_storage);
System.out.println("insertm_storage 화면 메소드 확인");

//여기까진 되는데 

		  int result = m_storageService.insert(m_storage);
		 
		   System.out.println("insert 결과 : " + result);
		 

return "redirect:/m_storage/M_storageList.do";
}




@RequestMapping("/m_storage/M_storageList.do")
public String selectM_storageList(Model model) {
	List<M_storage> list=m_storageService.selectM_storageList();
	
	System.out.println("list 확인"+list);
	model.addAttribute("list",list);
	
	return"m_storage/M_storageList";
	
	
	}
	
		
	/*
	 * @RequestMapping("/m_storage/updateM_storage.do") public String
	 * updateDev(Model model, @RequestParam int MSNO
	 * 
	 * ) {
	 * 
	 * 
	 * 
	 * M_storage m_storage = new M_storage(MSNO );
	 * 
	 * 
	 * 
	 * model.addAttribute("m_storage", m_storageService.selectM_storage(MSNO));
	 * 
	 * 
	 * 
	 * 
	 * return "m_storage/m_storageList";
	 * 
	 * 
	 * 
	 * }
	 */



@RequestMapping("/m_storage/updateM_storage.do")
public String updateM_storage(@RequestParam int MSNO ,
		//
	
		@RequestParam int MSMSTOCK,
	
		@RequestParam int MSPRICE,
		 Model model) {
	
	M_storage m_storage = new M_storage(MSMSTOCK, MSPRICE);
	
	
	int result = m_storageService.updateM_storage(m_storage);
	String msg="";
	if( result > 0 ) {
		msg="수정 성공";
	} else {
		msg="수정 실패!";
	}
	String loc="/m_storage/M_storageList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}




@RequestMapping("/m_storage/deleteM_storage.do")
public String deleteM_storage(@RequestParam int MSNO, Model model) {
	
	int result = m_storageService.deleteM_storage(MSNO);
	String msg="";
	if( result > 0 ) {
		msg="삭제 성공!";
	} else {
		msg="삭제 실패!";
	}
	String loc="/m_storage/M_storageList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}






}
