package com.kh.erp.enterprise.model.dao;

import java.util.HashMap;

import com.kh.erp.enterprise.model.vo.Enterprise;


public interface EnterpriseDao {

	int insertEnterprise(Enterprise enterprise);
	
	Enterprise selectEnterprise(String eId);
	
	int updateEnterprise(Enterprise enterprise);

	int deleteEnterprise(String eId);

	int checkIdDuplicate(HashMap<String, Object> hmap);

	
	
	
	
}
