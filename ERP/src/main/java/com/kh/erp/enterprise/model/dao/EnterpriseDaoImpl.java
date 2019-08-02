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
		
		return sqlSession.update("enterprise.updateEnterprise",enterprise);
	}

	@Override
	public int deleteEnterprise(String eId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkIdDuplicate(String eId) {
		// TODO Auto-generated method stub
		
	 int result =	sqlSession.selectOne("enterprise.selectEnterprise2",eId);
		
		
//		return sqlSession.selectOne("enterprise.selectEnterprise2",eId);
	System.out.println(result);
	return result ;
	}

}
