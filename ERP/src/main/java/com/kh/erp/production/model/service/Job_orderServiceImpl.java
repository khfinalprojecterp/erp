package com.kh.erp.production.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.production.model.dao.Job_orderDao;
import com.kh.erp.production.model.vo.Job_order;

@Service
public class Job_orderServiceImpl implements Job_orderService {

	@Autowired
	private Job_orderDao job_orderDao;
	
	@Override
	public List<Map<String, String>> jobOrderList() {
		return job_orderDao.jobOrderList();
	}

//	@Override
//	public List<Map<String, String>> elist() {
//		return job_orderDao.elist();
//	}
//	
	@Override
	public List<Map<String, String>> plist() {
		return job_orderDao.plist();
	}

	
	
	@Override
	public int insertJobOrder(int workcode) {
		return job_orderDao.insertJobOrder(workcode);
	}

	@Override
	public Job_order selectOneJobOrder(int workcode) {
		return job_orderDao.selectOneJobOrder(workcode);
	}

	@Override
	public int updateJobOrder(Job_order job_order) {
		return job_orderDao.updateJobOrder(job_order);
	}


	@Override
	public int deleteJobOrder(int workcode) {
		// TODO Auto-generated method stub
		return job_orderDao.deleteJobOrder(workcode);
	}



}
