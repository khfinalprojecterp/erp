package com.kh.erp.employee.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.employee.model.vo.Pmanagement;

@Repository
public class PmanagementDaoImpl implements PmanagementDao {


	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Pmanagement> selectPmanageList() {
		
		return sqlSession.selectList("employee.selectPmanageList");
	}

	@Override
	public int updatePmanage(Pmanagement pmanage) {
		
		return sqlSession.update("employee.updatePmanage",pmanage);
	}

}
