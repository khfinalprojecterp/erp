package com.kh.erp.quality_r.model.service;

import java.util.List; 
import java.util.Map;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.quality_r.model.vo.Quality_r;


public interface Quality_rService {

	int insert(Quality_r quality_r);
List<Quality_r> selectQuality_rList();
	
Quality_r selectQuality_r(int QRCODE);
	
	int updateQuality_r(Quality_r quality_r);
	
	int deleteQuality_r(int QRCODE);
	
	List<Map<String, String>> quality_rDetailList();
	List<Map<String, String>> productDetailList();
	List<Map<String, String>> enterpriseDetailList();
}
	
	
	
	
	

