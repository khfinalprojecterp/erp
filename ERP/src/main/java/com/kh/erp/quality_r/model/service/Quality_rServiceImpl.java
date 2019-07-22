package com.kh.erp.quality_r.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.quality_r.model.dao.Quality_rDao;
import com.kh.erp.quality_r.model.vo.Quality_r;
@Service
public class Quality_rServiceImpl implements Quality_rService {
	@Autowired 
	Quality_rDao quality_rdao;
	@Override
	public int selectQuality_r(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertQulity_r(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Quality_r selectOneQuality_r(int QRCODE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateQuality_r(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int QRCODE) {
		// TODO Auto-generated method stub
		return 0;
	}

}
