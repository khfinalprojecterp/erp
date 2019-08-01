package com.kh.erp.department.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.department.model.dao.DepartmentDao;
import com.kh.erp.department.model.vo.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	DepartmentDao departDao;
	
	@Override
	public int insertDepart(Department depart) {
	
		return departDao.insertDepart(depart);
	}

	@Override
	public List<Department> selectDepartList() {
		
		return departDao.selectDepartList();
	}
	
	
	@Override
	public int updateDepart(Department depart) {
		
		return departDao.updateDepart(depart);
	}

	@Override
	public int deleteDepart(int dCode) {
		
		return departDao.deleteDepart(dCode);
	}
	
	
	
	
	
	

}
