package com.kh.erp.m_storage.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.m_storage.model.vo.M_storage;
@Repository
public class M_storageDaoImpl implements M_storageDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public int insert(M_storage m_storage) {
		// TODO Auto-generated method stub
		return sqlSession.insert("m_storage.insertM_storage",m_storage);
	}

	@Override
	public List<M_storage> selectM_storageList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("m_storage.selectM_storageList");
	}

	@Override
	public M_storage selectM_storage(int MSNO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("m_storage.selectM_storage",MSNO);
	}

	@Override
	public int updateM_storage(M_storage m_storage) {
		// TODO Auto-generated method stub
		return sqlSession.update("m_storage.updateM_storage",m_storage);
	}

	@Override
	public int deleteM_storage(int MSNO) {
		// TODO Auto-generated method stub
		return sqlSession.delete("m_storage.deleteM_storage",MSNO);
	}

	@Override
	public List<Map<String, String>> storageDetailList(int eCode) {
		
		return sqlSession.selectList("m_storage.storageList");
	}

	@Override
	public List<Map<String, String>> materialsDetailList(int ecode) {
		// TODO Auto-generated method stubs
		return sqlSession.selectList("m_storage.materialsList");
	}

	
	}


