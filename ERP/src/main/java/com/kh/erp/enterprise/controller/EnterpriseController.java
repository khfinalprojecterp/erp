package com.kh.erp.enterprise.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.erp.employee.model.service.EmployeeService;
import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.enterprise.model.exception.EnterpriseException;
import com.kh.erp.enterprise.model.service.EnterpriseService;
import com.kh.erp.enterprise.model.service.EnterpriseServiceImpl;
import com.kh.erp.enterprise.model.vo.Enterprise;



//@SessionAttributes(value= {"enterprise"})
@Controller
public class EnterpriseController {

	@Autowired
	EmployeeService empService;

	
	@Autowired
	EnterpriseService enterpriseService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@RequestMapping("/goMain.do")
	public String goMain() {
		
		
		
		return "index1";
	}
	
	
	
	@RequestMapping("/enterprise/enterpriseEnroll.do")
	public String memberEnroll() {
		
		
		return "enterprise/enterpriseEnroll";
		
		
	}
	
	
	
	
	
	
	@RequestMapping("/enterprise/enterpriseEnrollEnd.do")
	public String memberEnrollEnd(Enterprise enterprise, Model model) {
			
		//System.out.println("member 확인 : " + member);
		
		/********************/
		// 이전 비밀번호
		String rawPassword = enterprise.getePwd();
		
		
		enterprise.setePwd(
				bcryptPasswordEncoder.encode(rawPassword));
		
		int result = enterpriseService.insertEnterprise(enterprise);
		
		// 2. 실행 결과에 따른 화면 처리
		String loc="/";
		String msg = "";
		
		if(result > 0) msg = "회원가입 성공!";
		else msg = "회원가입 실패!";
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	
	
	
	
//	@RequestMapping("/enterprise/enterpriseLogin.do")
//	public String enterpriseLogin() {
//		
//		
//		return "enterprise/enterpriseLogin";
//	}
	
	@RequestMapping("/enterprise/enterpriseEmployeeUpdate.do")
	public String enterpriseEmployeeUpdate() {
		
		
		
		
		return "enterprise/enterpriseEmployeeUpdate";
	}
	@RequestMapping("/enterprise/enterpriseUpdate.do")
	public String enterpriseUpdate(
			@RequestParam String eName,
			@RequestParam String ePwd,
			@RequestParam String eEmail,
			@RequestParam String eAddress,
			@RequestParam String ePhone
			,Model model,
			HttpSession session) {
		Enterprise enterprise =(Enterprise)session.getAttribute("enterprise");
		
		
		
		
		enterprise.setePwd(bcryptPasswordEncoder.encode(ePwd));
		enterprise.seteName(eName);
		enterprise.seteEmail(eEmail);
		enterprise.seteAddress(eAddress);
		enterprise.setePhone(ePhone);

		
		int result = enterpriseService.updateEnterprise(enterprise);
		
		String msg="/enterprise/enterpriseEmployeeUpdate.do";
		if( result > 0 ) {
			msg="수정 성공";

		} else {
			msg="수정 실패!";
		}
		String loc="/";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return  "common/msg";		
		
		
			}
	
	
	
	
	
	
	
	@RequestMapping(value="/enterprise/enterpriseLoginEnd.do"
		       , method=RequestMethod.POST)
public String memberLogin (
			@RequestParam String userId,
			@RequestParam String userPwd,
			Model model, HttpSession session
		) throws EnterpriseException {
	
	try {
		// 1. 업무 로직 구현
		Enterprise enterprise = enterpriseService.selectEnterprise(userId);
		
		// 2. 반환할 화면 url 처리
		String loc = "";
		String msg = "";
		
		if(enterprise == null) {
			msg = "존재하지 않는 회원입니다.";
			loc ="/";
		} else {
			// 3. 로그인에 사용한 비밀번호와
			//    원래 저장되어 있던 비밀번호 확인
			
			if(bcryptPasswordEncoder.matches(userPwd, enterprise.getePwd())) {
				msg = "로그인 성공!";
				
				session.setAttribute("enterprise", enterprise);
				
				
				loc= "/goMain.do";
			} else {
				msg = "비밀번호가 일치하지 않습니다!";
			
				
			}
			
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
	} catch(Exception e) {
		
		throw new EnterpriseException("로그인 에러 : " + e.getMessage());
		
		// 그냥 실행하면 기본 에러페이지로 이동할 수 있기 때문에
		// 우리가 만든 error 페이지를 web.xml에 등록하여
		// 에러 발생 시 해당 에러 페이지로 이동하도록 
		// 공용 에러 페이지 등록 처리를 한다.
	}
	
	return "common/msg";
	
}
	
	
	

	@RequestMapping("/enterprise/enterpriseLogout.do")
	public String memberLogout(HttpSession session) {
	
		
		
		if(session != null) {
		
		session.invalidate();
		
		}
		
		

		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/enterprise/checkIdDuplicate.do")

	public void checkIdDuplicate(
			@RequestParam String eId,
			HttpServletResponse resp
			) throws IOException {
		
		System.out.println(eId);
		
		resp.getWriter().print((enterpriseService.checkIdDuplicate(eId))>0? "no" : "ok");
		
		
	}
	
	
	

	
}
