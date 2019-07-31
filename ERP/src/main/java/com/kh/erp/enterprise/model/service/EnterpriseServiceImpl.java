package com.kh.erp.enterprise.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.enterprise.model.dao.EnterpriseDao;
import com.kh.erp.enterprise.model.vo.Enterprise;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	
	@Autowired
	EnterpriseDao enterpriseDao;
	
	
	@Override
	public int insertEnterprise(Enterprise enterprise) {
		
		return enterpriseDao.insertEnterprise(enterprise);
	}

	@Override
	public Enterprise selectEnterprise(String eId) {
		
		return enterpriseDao.selectEnterprise(eId);
	}

	@Override
	public int updateEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEnterprise(String eId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkIdDuplicate(String eId) {
		
		return enterpriseDao.checkIdDuplicate(eId);
	}

}
