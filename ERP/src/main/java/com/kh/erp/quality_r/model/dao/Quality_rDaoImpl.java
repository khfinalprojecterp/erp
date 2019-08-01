package com.kh.erp.quality_r.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.quality_r.model.vo.Quality_r;
@Repository
public class Quality_rDaoImpl implements Quality_rDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public int insert(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return sqlSession.insert("quality_r.insertQuality_r",quality_r);
	}

	@Override
	public List<Quality_r> selectQuality_rList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("quality_r.selectQuality_rList");
	}

	@Override
	public Quality_r selectQuality_r(int QRCODE) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("quality_r.selectQuality_r",QRCODE);
	}

	@Override
	public int updateQuality_r(Quality_r quality_r) {
		// TODO Auto-generated method stub
		return sqlSession.update("quality_r.selectQuality_r",quality_r);
	}

	@Override
	public int deleteQuality_r(int QRCODE) {
		// TODO Auto-generated method stub
		return sqlSession.delete("quality_r.deleteQuality_r",QRCODE);
	}

}
