package com.kh.erp.quality_ch.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.quality_ch.model.vo.Quality_ch;
import com.kh.erp.quality_r.model.vo.Quality_r;
@Repository
public class Quality_chDaoImpl implements Quality_chDao {
@Autowired
	SqlSessionTemplate SqlSession;
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
