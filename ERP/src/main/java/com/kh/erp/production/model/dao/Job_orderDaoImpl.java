package com.kh.erp.production.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.production.model.vo.Job_order;
import com.kh.erp.storage.model.vo.StorageDetail;

@Repository
public class Job_orderDaoImpl implements Job_orderDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> jobOrderList() {
		return sqlSession.selectList("jobOrder.selectJobOrderList");
	}
	@Override
	public List<Map<String, String>> elist() {
		return sqlSession.selectList("jobOrder.selectE");
	}
	
	@Override
	public List<Map<String, String>> plist() {
		return sqlSession.selectList("jobOrder.selectP");
	}
	@Override
	public List<Map<String, String>> slist() {
		return sqlSession.selectList("jobOrder.selectS");
	}

	@Override
	public int insertJobOrder(Job_order job_order) {
		System.out.println(job_order);
		return sqlSession.insert("jobOrder.insertJobOrder", job_order);
	}

	@Override
	public Job_order selectOneJobOrder(int workcode) {
		return sqlSession.selectOne("", workcode);
	}

	@Override
	public int updateJobOrder(Job_order job_order) {
		return sqlSession.update("jobOrder.updateJobOrder", job_order);
	}

	@Override
	public int deleteJobOrder(int workcode) {

		return sqlSession.delete("jobOrder.deleteJobOrder", workcode);
	}
	@Override
	public int insertStorageDetail(StorageDetail storageDetail) {
		
		return sqlSession.insert("jobOrder.insertStorage", storageDetail);
	}


}
