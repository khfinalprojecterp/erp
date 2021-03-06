package com.kh.erp.employee.model.dao;

import java.util.List;

import com.kh.erp.employee.model.vo.Attendance;
import com.kh.erp.employee.model.vo.Employee;

public interface EmployeeDao {

	
	int insertEmployee(Employee member);
	
	/**
	 * 회원 정보 조회용 메소드
	 * @param userId
	 * @return
	 */
	Employee selectEmployee(String idCode);
	
	int checkDepart(int dCode);
	List<Employee> selectEmpList();
	
	int updateEmployee(Employee emp);
	int deleteEmployee(int idCode);
	int checkIdDuplicate(int idCode);
	void insertSub(Employee emp);

	List<Attendance> selectAttendnaceList();
	
	int updateAttendance(Attendance attendance);
	
	int employeeUpdate(Employee employee);
}
