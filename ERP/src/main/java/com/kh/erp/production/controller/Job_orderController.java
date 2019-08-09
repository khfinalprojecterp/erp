package com.kh.erp.production.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.production.model.service.Job_orderService;
import com.kh.erp.production.model.vo.Job_order;

@Controller
public class Job_orderController {

	@Autowired
	Job_orderService job_orderService;

	// 작업지시서 리스트 전체 조회 메소드
	@RequestMapping("/production/job_orderList.do")
	public String selectJob_orderList(Model model) {

		ArrayList<Map<String, String>> list = new ArrayList<>(job_orderService.jobOrderList());
		model.addAttribute("list", list);

		ArrayList<Map<String, String>> elist = new ArrayList<>(job_orderService.elist());
		model.addAttribute("elist", elist);

		ArrayList<Map<String, String>> plist = new ArrayList<>(job_orderService.plist());
		model.addAttribute("plist", plist);

		return "production/job_orderList";

	}

	@RequestMapping("/production/job_orderInsert.do")
	public String insertJob_order(@RequestParam(value = "idcode", required = false) String idcode,
			@RequestParam(value = "pcode", required = false) String pcode, Model model) {

		System.out.println(idcode);
		System.out.println(pcode);

		
		 Job_order job_order = new Job_order(idcode, pcode);
		 
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
								  @RequestParam(value = "jostatus", required = false) String jostatus) {
		
		System.out.println(workcode);
		System.out.println(idcode);
		System.out.println(pCode);
		System.out.println(jostatus);
		
		 Job_order job_order = new Job_order(workcode, idcode, pCode, jostatus);
		
		  int result = job_orderService.updateJobOrder(job_order);
		  
		  String msg = ""; if (result > 0) { 
			  msg = "등록 성공!";
		  } else { 
			  msg = "등록 실패!";
		  }
		  
		  String loc = "/production/job_orderList.do"; model.addAttribute("loc", loc);
		  model.addAttribute("msg", msg);
		
		return "common/msg";
	}

	@RequestMapping("/production/job_orderdelete.do")
	public String deleteJob_order(@RequestParam int workcode, Model model) {
		System.out.println(workcode);
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
