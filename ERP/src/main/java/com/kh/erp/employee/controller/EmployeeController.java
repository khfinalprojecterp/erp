package com.kh.erp.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import com.kh.erp.employee.model.exception.EmployeeException;
import com.kh.erp.employee.model.service.EmployeeService;
import com.kh.erp.employee.model.service.PmanagementService;
import com.kh.erp.employee.model.vo.Attendance;
import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.employee.model.vo.Pmanagement;
import com.kh.erp.enterprise.model.exception.EnterpriseException;
import com.kh.erp.enterprise.model.vo.Enterprise;



@Controller
public class EmployeeController {
	@Autowired
	PmanagementService pmanageService;
	
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
	public String insertEmployee(Employee emp, Model model) {

		String rawPassword = emp.getwPwd();
	
		emp.setwPwd(bcryptPasswordEncoder.encode(rawPassword));
		
		int result = empService.insertEmployee(emp);
		empService.insertSub(emp);
		
		String msg="";
		if( result > 0 ) {
			msg="사원 등록 성공!";
		} else {
			msg="사원 등록 실패!";
		}
		
		String loc="/employee/employeeList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		


		return "common/msg";
		
}
	@RequestMapping("/enterprise/employeeUpdate.do")
	public String enterpriseUpdate(
			@RequestParam String wName,
			@RequestParam String wPwd
			,Model model,
			HttpSession session) {
		Employee employee =(Employee)session.getAttribute("employee");
		
		
		
		
		employee.setwPwd(bcryptPasswordEncoder.encode(wPwd));
		employee.setwName(wName);
		
		int result = empService.employeeUpdate(employee);
		
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
	
	
	
	// 기업 수정용
	@RequestMapping(value="/employee/updateEmployee.do",
			method=RequestMethod.GET)
	public String updateEmployee(Employee emp,Model model) {

		int result = empService.updateEmployee(emp);
		String msg="";
		if( result > 0 ) {
			msg="사원 수정 성공!";
		} else {
			msg="사원 수정 실패!";
		}
		
		String loc="/employee/employeeList.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		


		return "common/msg";
		
			}



@RequestMapping("/employee/deleteEmployee.do")
public String deleteEmployee(Employee emp, Model model) {

try {
	int idCode =emp.getIdCode();
	// 1. 업무 로직
	int result = empService.deleteEmployee(idCode);

	// 2. 처리 결과에 따른 페이지 설정
	String loc = "/";
	String msg = "";
	
	if(result > 0 ) msg = "사원 삭제 성공!";
	else msg = "사원 삭제 실패!";
	
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
} catch (Exception e) {
	// logger 파일에 에러 기록하기
	
	// 에러 페이지로 이동시키기
	throw new EmployeeException("사원 삭제 에러 : " + e.getMessage());
}

return "redirect:/employee/employeeList.do";

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
			loc="/";
		} else {
			// 3. 로그인에 사용한 비밀번호와
			//    원래 저장되어 있던 비밀번호 확인
			
			if(bcryptPasswordEncoder.matches(userPwd, employee.getwPwd())) {
				msg = "로그인 성공!";
				
				
				session.setAttribute("employee", employee);
			
				loc= "/goMain.do";
				
				
				
				
			} else {
				msg = "비밀번호가 일치하지 않습니다!";
				loc="/";
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
	
	
	@RequestMapping("/employee/attendanceList.do")
	public String attendanceList(Model model
			) {
	
		
		List<Attendance> list = empService.selectAttendnaceList();
		
		
		List<Employee> clist = pmanageService.selectChar();
		
		
		model.addAttribute("clist",clist);
		
		
		
		
		model.addAttribute("list", list);
		
		
		return "employee/attendanceList";
		
		
	}
	
	
	
	
		@RequestMapping(value="/employee/updateAttendance.do",
		method=RequestMethod.GET)
		public String updateAttendance(Attendance attendance,Model model) {

			
			int result = empService.updateAttendance(attendance);

			
			
			String msg="";
			if( result > 0 ) {
				msg="근태 수정 성공!";
			} else {
				msg="근태 수정 실패!";
			}
			
			String loc="/employee/attendanceList.do";
			model.addAttribute("loc", loc);
			model.addAttribute("msg", msg);
			


			return "common/msg";
			
		}
	
		
		@RequestMapping(value="/employee/checkIdDuplicate.do")

		public void checkIdDuplicate(
				@RequestParam int idCode,
				HttpServletResponse resp
				) throws IOException {
			
			System.out.println(idCode);
			
			resp.getWriter().print((empService.checkIdDuplicate(idCode))>0? "no" : "ok");
			
			
		}
		
		
		
		@RequestMapping(value="/employee/departCheck.do")

		public void employeeDepartCheck(
				@RequestParam int dCode,
				HttpServletResponse resp
				) throws IOException {
			
			resp.getWriter().print((empService.checkDepart(dCode))>0? "no" : "ok");
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
}
