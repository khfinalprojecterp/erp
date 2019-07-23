package com.kh.erp.enterprise.model.service;

import com.kh.erp.enterprise.model.vo.Enterprise;

public interface EnterpriseService {

	int insertEnterprise(Enterprise enterprise);
	
	
	Enterprise selectEnterprise(String eId);
	
	int updateEnterprise(Enterprise enterprise);

	int deleteEnterprise(String eId);

	int checkIdDuplicate(String eId);

	
}
