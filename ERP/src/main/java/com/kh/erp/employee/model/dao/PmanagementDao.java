package com.kh.erp.employee.model.dao;

import java.util.List;

import com.kh.erp.employee.model.vo.Pmanagement;

public interface PmanagementDao {

	
	
	List<Pmanagement> selectPmanageList();
	
	int updatePmanage(Pmanagement pmanage);
	
	
	
	
	
	
}
