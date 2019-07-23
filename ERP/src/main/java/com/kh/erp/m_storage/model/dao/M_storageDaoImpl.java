package com.kh.erp.m_storage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.m_storage.model.vo.M_storage;
@Repository
public class M_storageDaoImpl implements M_storageDao {

	@Autowired
	SqlSessionTemplate SqlSession;
	
	@Override
	public List<M_storage> selectM_storageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertM_storage(M_storage m_storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public M_storage selectOneM_storage(int IDCODE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateM_storage(M_storage m_storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteM_storage(int IDCODE) {
		// TODO Auto-generated method stub
		return 0;
	}

}
