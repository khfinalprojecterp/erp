package com.kh.erp.mail_check.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.erp.mail_check.model.service.MailCheckService;
import com.kh.erp.mail_check.model.vo.MailCheck;

@Controller
public class MailCheckController {
	
	@Autowired
	MailCheckService mailCheckService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping("/mail/mailInsert.do")
	public String insertMailCheck(MailCheck mailCheck, Model model) {

		String rePass = mailCheck.getUserPass();

		mailCheck.setUserPass(bcryptPasswordEncoder.encode(rePass));

		int result = mailCheckService.insertMailCheck(mailCheck);

		String msg = "";
		if( result > 0) {
			msg="메일등록 성공!";
			
		} else {
			msg="메일등록 실패!";
		}
		
		String loc="/mail/mailList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	
}
