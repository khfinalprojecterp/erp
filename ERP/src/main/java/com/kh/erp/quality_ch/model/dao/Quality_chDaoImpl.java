package com.kh.erp.quality_ch.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.quality_ch.model.vo.Quality_ch;
import com.kh.erp.quality_ch.model.dao.Quality_chDao;
import com.kh.erp.quality_ch.model.vo.Quality_ch;
@Repository
public class Quality_chDaoImpl implements Quality_chDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public int insert(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return sqlSession.insert("quality_ch.insertQuality_ch",quality_ch);
	}

	@Override
	public List<Quality_ch> selectQuality_chList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("quality_ch.selectQuality_chList");
	}

	@Override
	public Quality_ch selectQuality_ch(int QRCODE) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("quality_.selectQuality_ch",QRCODE) ;
	}

	@Override
	public int updateQuality_ch(Quality_ch quality_ch) {
		// TODO Auto-generated method stub
		return sqlSession.update("quality_ch.updateQuality_ch",quality_ch);
	}

	@Override
	public int deleteQuality_ch(int QRCODE) {
		// TODO Auto-generated method stub
		return sqlSession.delete("quality_ch.deleteQuality_ch",QRCODE);
	}

	@Override
	public List<Map<String, String>> enterpriseDetailList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("quality_ch.enterpriseDetailList");
	}

	@Override
	public List<Map<String, String>> quality_chDetailList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("quality_ch.quality_chDetailList");
	}

}
