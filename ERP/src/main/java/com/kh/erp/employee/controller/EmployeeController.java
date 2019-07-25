package com.kh.erp.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.erp.department.model.service.DepartmentService;
import com.kh.erp.department.model.vo.Department;
import com.kh.erp.employee.model.service.EmployeeService;
import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.enterprise.model.exception.EnterpriseException;
import com.kh.erp.enterprise.model.vo.Enterprise;



@Controller
public class EmployeeController {

	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService departService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	

	@RequestMapping("/employee/employeeList.do")
	public String departmentList(Model model
			) {
	
		List<Department> Dlist =  departService.selectDepartList();
		List<Employee> list = empService.selectEmpList();

		model.addAttribute("list", list);
		model.addAttribute("Dlist",Dlist);

		return "employee/employeeList";
		
		
	}
	
	
	@RequestMapping(value="/employee/insertEmployee.do",
	        method=RequestMethod.POST)
	public String insertEmployee(Employee emp) {

		String rawPassword = emp.getwPwd();
	
		emp.setwPwd(bcryptPasswordEncoder.encode(rawPassword));
		
	

		int result = empService.insertEmployee(emp);


		return "redirect:/";
}

	
	
	
	@RequestMapping(value="/employee/updateEmployee.do",
					method=RequestMethod.POST)
	public ModelAndView memberUpdate(Employee emp) {
		
	
		ModelAndView mv = new ModelAndView();
		int result = empService.updateEmployee(emp);
		
		
		// 2. 처리 결과에 따른 화면 설정
		String loc = "/";
		String msg = "";
		
		if(result > 0) {
			msg="회원 정보 수정 성공!!";
			mv.addObject("employee", emp);
		} else {
			msg = "회원 정보 수정 실패!";
		}
		
		mv.addObject("loc", loc);
		mv.addObject("msg", msg);
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/employee/employeeLoginEnd.do"
		       , method=RequestMethod.POST)
public String employeeLogin (
			@RequestParam String userId,
			@RequestParam String userPwd,
			Model model, HttpSession session
		) throws EnterpriseException {
	
	try {
		// 1. 업무 로직 구현
		Employee employee = empService.selectEmployee(userId);
		
		// 2. 반환할 화면 url 처리
		String loc = "/";
		String msg = "";
		
		if(employee == null) {
			msg = "존재하지 않는 회원입니다.";
		} else {
			// 3. 로그인에 사용한 비밀번호와
			//    원래 저장되어 있던 비밀번호 확인
			
			if(bcryptPasswordEncoder.matches(userPwd, employee.getwPwd())) {
				msg = "로그인 성공!";
				
				
				session.setAttribute("employee", employee);
			
				System.out.println(employee);
				
				
				
				
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
	
	
	@RequestMapping("/employee/employeeLogout.do")
	public String employeeLogout(HttpSession session) {
	
		
		
		if(session != null) {
		
		session.invalidate();
		
		}
		
		

		return "redirect:/";
	}
	
	
	
}
