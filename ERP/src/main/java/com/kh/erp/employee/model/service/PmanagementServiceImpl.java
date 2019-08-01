package com.kh.erp.employee.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.employee.model.dao.PmanagementDao;
import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.employee.model.vo.Pmanagement;


@Service
public class PmanagementServiceImpl implements PmanagementService {

	@Autowired
	PmanagementDao pmanageDao;
	
	@Override
	public List<Pmanagement> selectPmanageList() {
		
		return pmanageDao.selectPmanageList();
	}

	@Override
	public int updatePmanage(Pmanagement pmanage) {
		
		return pmanageDao.updatePmanage(pmanage);
	}

	@Override
	public List<Employee> selectChar() {
		// TODO Auto-generated method stub
		return pmanageDao.selectChar();
	}

}
