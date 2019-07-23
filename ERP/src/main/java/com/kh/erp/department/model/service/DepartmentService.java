package com.kh.erp.department.model.service;

import java.util.List;

import com.kh.erp.department.model.vo.Department;


public interface DepartmentService {

	int insertDepart(Department depart);
	
	List<Department> selectDepartList();
	
	
	
	
	
	
}
