package com.kh.erp.m_storage.model.service;

import java.util.List; 
import java.util.Map;

import com.kh.erp.m_storage.model.vo.M_storage;




public interface M_storageService {
	
int insert(M_storage m_storage);
	
	List<M_storage> selectM_storageList();
	
	M_storage selectM_storage(int MSNO);
	
	int updateM_storage(M_storage m_storage);
	
	int deleteM_storage(int MSNO);

	
	}
