package com.kh.erp.employee.model.service;

import java.util.List;

import com.kh.erp.employee.model.vo.Attendance;
import com.kh.erp.employee.model.vo.Employee;



public interface EmployeeService {

	
	int insertEmployee(Employee member);
	
	/**
	 * 회원 정보 조회용 메소드
	 * @param userId
	 * @return
	 */
	Employee selectEmployee(String idCode);
	
	List<Employee> selectEmpList();
	
	int updateEmployee(Employee emp);
	
	int deleteEmployee(int idCode);
	
	int checkIdDuplicate(int idCode);
	
	int checkDepart(int dCode);

	void insertSub(Employee emp);

	List<Attendance> selectAttendnaceList();

	int updateAttendance(Attendance attendance);

	int employeeUpdate(Employee employee);
	
}
