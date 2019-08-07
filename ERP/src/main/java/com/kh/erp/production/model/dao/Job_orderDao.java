package com.kh.erp.production.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.erp.production.model.vo.Job_order;

public interface Job_orderDao {

	List<Map<String, String>> jobOrderList();
//	List<Map<String, String>> elist();	
	List<Map<String, String>> plist();

	int insertJobOrder(int workcode);

	Job_order selectOneJobOrder(int workcode);

	int updateJobOrder(Job_order job_order);

	int deleteJobOrder(int workcode);




}
