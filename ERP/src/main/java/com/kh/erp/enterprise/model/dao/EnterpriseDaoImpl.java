package com.kh.erp.enterprise.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.enterprise.model.vo.Enterprise;


@Repository
public class EnterpriseDaoImpl implements EnterpriseDao {
	
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insertEnterprise(Enterprise enterprise) {
		
		
		return sqlSession.insert("enterprise.insertEnterprise",enterprise);
		
	}
	
	
	@Override
	public Enterprise selectEnterprise(String eId) {
		
		return sqlSession.selectOne("enterprise.selectEnterprise", eId);
	}

	@Override
	public int updateEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEnterprise(String eId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkIdDuplicate(HashMap<String, Object> hmap) {
		// TODO Auto-generated method stub
		return 0;
	}

}
