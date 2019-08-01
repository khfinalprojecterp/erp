package com.kh.erp.quality_r.model.dao;

import java.util.List;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product_category.model.vo.Product_Category;
import com.kh.erp.quality_r.model.vo.Quality_r;

public interface Quality_rDao {

	int insert(Quality_r quality_r);
	List<Quality_r> selectQuality_rList();
		
	Quality_r selectQuality_r(int QRCODE);
		
		int updateQuality_r(Quality_r quality_r);
		
		int deleteQuality_r(int QRCODE);

			
			
	}


