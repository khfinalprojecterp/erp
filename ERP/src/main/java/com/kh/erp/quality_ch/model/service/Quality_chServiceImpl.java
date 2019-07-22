package com.kh.erp.quality_ch.model.service;

import org.springframework.stereotype.Service;

import com.kh.erp.quality_ch.model.dao.Quality_chDao;
import com.kh.erp.quality_ch.model.vo.Quality_ch;
import com.kh.erp.quality_r.model.vo.Quality_r;
@Service
public class Quality_chServiceImpl implements Quality_chService {
private Quality_chDao quality_chdao;
	@Override
	public int selectQuality_ch(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertQuality_ch(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Quality_r selectOneQuality_ch(int QRCODE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateQuality_ch(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQuality_ch(int QRCODE) {
		// TODO Auto-generated method stub
		return 0;
	}

}
