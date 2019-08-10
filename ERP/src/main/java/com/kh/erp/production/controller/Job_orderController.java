package com.kh.erp.production.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.enterprise.model.vo.Enterprise;
import com.kh.erp.production.model.service.Job_orderService;
import com.kh.erp.production.model.vo.Job_order;
import com.kh.erp.storage.model.vo.StorageDetail;

@Controller
public class Job_orderController {

	@Autowired
	Job_orderService job_orderService;

	// 작업지시서 리스트 전체 조회 메소드
	@RequestMapping("/production/job_orderList.do")
	public String selectJob_orderList(Model model) {

		ArrayList<Map<String, String>> list = new ArrayList<>(job_orderService.jobOrderList());
		model.addAttribute("list", list);
		System.out.println(list);
		ArrayList<Map<String, String>> elist = new ArrayList<>(job_orderService.elist());
		model.addAttribute("elist", elist);

		ArrayList<Map<String, String>> plist = new ArrayList<>(job_orderService.plist());
		model.addAttribute("plist", plist);
		
		ArrayList<Map<String, String>> slist = new ArrayList<>(job_orderService.slist());
		model.addAttribute("slist", slist);
		return "production/job_orderList";

	}

	@RequestMapping("/production/job_orderInsert.do")
	public String insertJob_order(@RequestParam(value = "idcode", required = false) String idcode,
								  @RequestParam(value = "pcode", required = false) String pcode,
								  @RequestParam(value = "productea", required = false) String productea,
								  @RequestParam(value = "sCode", required = false) String sCode,
								  Model model) {

		/*
		 * System.out.println(idcode); System.out.println(pcode);
		 * System.out.println(productea);
		 */

		
		 Job_order job_order = new Job_order(idcode, pcode, productea, sCode);
		 
		 int result = job_orderService.insertJobOrder(job_order);
		 
		 String msg=""; if( result > 0) { msg="등록 성공!"; } else { msg="등록 실패!"; }
		 
		 String loc="/production/job_orderList.do"; model.addAttribute("loc", loc);
		 model.addAttribute("msg", msg);
		 
		 System.out.println(result);
		 

		return "common/msg";
	}

	@RequestMapping("/production/job_orderupdate.do")
	public String updateJob_order(Model model,
								  @RequestParam(value = "workcode", required = false) int workcode,
								  @RequestParam(value = "idcode", required = false) String idcode,
								  @RequestParam(value = "pCode", required = false) String pCode,
								  @RequestParam(value = "productea", required = false) String productea,
								  @RequestParam(value = "sCode", required = false) String sCode,
								  @RequestParam(value = "jostatus", required = false) String jostatus,
								  @RequestParam(value = "beforeprice", required = false) String beforeprice,
								  @RequestParam(value = "afterprice", required = false) String afterprice,
								  HttpSession session) {
		
		/*
		 * System.out.println(workcode); System.out.println(idcode);
		 * System.out.println(pCode); System.out.println(jostatus);
		 */
		
		System.out.println(sCode);
		 Job_order job_order = new Job_order(workcode, idcode, pCode, productea, sCode,jostatus);
		
		  int result = job_orderService.updateJobOrder(job_order);
		  
		  String msg = ""; if (result > 0) { 
			  msg = "등록 성공!";
		  } else { 
			  msg = "등록 실패!";
		  }
		  
		  String loc = "/production/job_orderList.do"; model.addAttribute("loc", loc);
		  model.addAttribute("msg", msg);
		  
		  if(jostatus.equals("Y")) {
			  Employee employee = (Employee) session.getAttribute("employee");
			  System.out.println(employee);
			  int eCode = employee.geteCode();
//			  System.out.println(eCode);
//			  int sCode, int eCode, int idCode, String mCode, String pCode, int sdStock, int sdCost, int sdPrice,in_code
//			  System.out.println(Integer.parseInt(idcode));
//			  System.out.println(pCode);
//			  System.out.println(Integer.parseInt(productea));
//			  System.out.println(Integer.parseInt(beforeprice));
//			  System.out.println(Integer.parseInt(afterprice));
//			  System.out.println(workcode);
			  
			  StorageDetail sd = new StorageDetail(Integer.parseInt(sCode), eCode, Integer.parseInt(idcode)
					  , "asd", pCode, Integer.parseInt(productea), Integer.parseInt(beforeprice), Integer.parseInt(afterprice), workcode);
			  job_orderService.insertStorageDetail(sd);
		  }
		  
		return "common/msg";
	}

	@RequestMapping("/production/job_orderdelete.do")
	public String deleteJob_order(@RequestParam int workcode, Model model) {
//		System.out.println(workcode);
		int result = job_orderService.deleteJobOrder(workcode);
		String msg = "";
		if (result > 0) {
			msg = "삭제 성공!";
		} else {
			msg = "삭제 실패!";
		}
		String loc = "/production/job_orderList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);

		return "common/msg";
	}

}
