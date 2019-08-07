package com.kh.erp.production.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.production.model.vo.Job_order;

@Repository
public class Job_orderDaoImpl implements Job_orderDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> jobOrderList() {
		return sqlSession.selectList("jobOrder.selectJobOrderList");
	}
//	@Override
//	public List<Map<String, String>> elist() {
//		return sqlSession.selectList("jobOrder.selectE");
//	}
//	
	@Override
	public List<Map<String, String>> plist() {
		return sqlSession.selectList("jobOrder.selectP");
	}

	@Override
	public int insertJobOrder(int workcode) {
		return sqlSession.insert("", workcode);
	}

	@Override
	public Job_order selectOneJobOrder(int workcode) {
		return sqlSession.selectOne("", workcode);
	}

	@Override
	public int updateJobOrder(Job_order job_order) {
		return sqlSession.update("", job_order);
	}

	@Override
	public int deleteJobOrder(int workcode) {

		return sqlSession.delete("", workcode);
	}


}
