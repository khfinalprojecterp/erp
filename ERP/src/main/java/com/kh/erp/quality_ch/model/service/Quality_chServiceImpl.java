package com.kh.erp.quality_ch.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.m_storage.model.dao.M_storageDao;
import com.kh.erp.quality_ch.model.dao.Quality_chDao;
import com.kh.erp.quality_ch.model.vo.Quality_ch;
@Service
public class Quality_chServiceImpl implements Quality_chService {
	@Autowired
	private Quality_chDao quality_chDao;
	@Override
	public int insert(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return quality_chDao.insert(quality_ch);
	}

	@Override
	public List<Quality_ch> selectQuality_chList() {
		// TODO Auto-generated method stub
		return quality_chDao.selectQuality_chList();
	}

	@Override
	public Quality_ch selectQuality_ch(int QRCODE) {
		// TODO Auto-generated method stub
		return (Quality_ch) quality_chDao.selectQuality_chList();
	}

	@Override
	public int updateQuality_ch(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return quality_chDao.updateQuality_ch(quality_ch);
	}

	@Override
	public int deleteQuality_ch(int QRCODE) {
		// TODO Auto-generated method stub
		return quality_chDao.deleteQuality_ch(QRCODE);
	}

}
