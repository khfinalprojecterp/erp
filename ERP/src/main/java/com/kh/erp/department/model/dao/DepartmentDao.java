package com.kh.erp.department.model.dao;

import java.util.List;

import com.kh.erp.department.model.vo.Department;

public interface DepartmentDao {

	
	int insertDepart(Department depart);
	
	List<Department> selectDepartList();
	
	
	
	
	
	
	
}
