package com.kh.erp.m_storage.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.erp.m_storage.model.vo.M_storage;
@Repository
public interface M_storageDao {

int insert(M_storage m_storage);
	
	List<M_storage> selectM_storageList();
	
	M_storage selectDev(int IDCODE);
	
	int updateM_storage(M_storage m_storage);
	
	int deleteM_storage(int IDCDOE);
	}
