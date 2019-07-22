package com.kh.erp.employee.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.employee.model.dao.EmployeeDao;
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

}
