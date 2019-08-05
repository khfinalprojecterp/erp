package com.kh.erp.employee.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.employee.model.dao.EmployeeDao;
import com.kh.erp.employee.model.vo.Attendance;
import com.kh.erp.employee.model.vo.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	
	@Override
	public int insertEmployee(Employee emp) {
		
		return empDao.insertEmployee(emp);
	}

	@Override
	public Employee selectEmployee(String idCode) {
		
		return empDao.selectEmployee(idCode);
		
	}

	@Override
	public List<Employee> selectEmpList() {
		
		return empDao.selectEmpList();
	}

	@Override
	public int updateEmployee(Employee emp) {
		System.out.println(emp+"1");
		return empDao.updateEmployee(emp);
	}
	
	
	@Override
	public int deleteEmployee(int idCode) {
		
		return empDao.deleteEmployee(idCode);
	}

	@Override
	public void insertSub(Employee emp) {
		
		empDao.insertSub(emp);
		
		
		
	}

	@Override
	public List<Attendance> selectAttendnaceList() {
		
		return empDao.selectAttendnaceList();
	}

	@Override
	public int updateAttendance(Attendance attendance) {
	
		return empDao.updateAttendance(attendance);
	}

	
	
	@Override
	public int checkIdDuplicate(int idCode) {
		// TODO Auto-generated method stub
		return empDao.checkIdDuplicate(idCode);
	}

	@Override
	public int employeeUpdate(Employee employee) {
		
		return empDao.employeeUpdate(employee);
	}

	
	

}
