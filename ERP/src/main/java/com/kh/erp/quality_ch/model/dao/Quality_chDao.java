package com.kh.erp.quality_ch.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.erp.quality_ch.model.vo.Quality_ch;
import com.kh.erp.quality_r.model.vo.Quality_r;

public interface Quality_chDao {
int insert(Quality_ch quality_ch);
	
	List<Quality_ch> selectQuality_chList();
	
	Quality_ch selectQuality_ch(int QRCODE);
	
	int updateQuality_ch(Quality_ch quality_ch);
	
	int deleteQuality_ch(int QRCODE);
	List<Map<String, String>> enterpriseDetailList();
	List<Map<String, String>> quality_chDetailList();
	
	}
