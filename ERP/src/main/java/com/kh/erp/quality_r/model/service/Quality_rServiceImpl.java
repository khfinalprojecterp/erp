package com.kh.erp.quality_r.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.m_storage.model.dao.M_storageDao;
import com.kh.erp.quality_r.model.dao.Quality_rDao;
import com.kh.erp.quality_r.model.vo.Quality_r;
@Service
public class Quality_rServiceImpl implements Quality_rService {
	@Autowired
	private Quality_rDao quality_rDao;
	@Override
	public int insert(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return quality_rDao.insert(quality_r);
	}

	@Override
	public List<Quality_r> selectQuality_rList() {
		// TODO Auto-generated method stub
		return quality_rDao.selectQuality_rList();
	}

	@Override
	public Quality_r selectQuality_r(int QRCODE) {
		// TODO Auto-generated method stub
		return (Quality_r) quality_rDao.selectQuality_rList();
	}

	@Override
	public int updateQuality_r(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return quality_rDao.updateQuality_r(quality_r);
	}

	@Override
	public int deleteQuality_r(int QRCODE) {
		// TODO Auto-generated method stub
		return quality_rDao.deleteQuality_r(QRCODE);
	}

}
