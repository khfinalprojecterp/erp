package com.kh.erp.production.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.erp.production.model.vo.Job_order;
import com.kh.erp.storage.model.vo.StorageDetail;

public interface Job_orderDao {

	List<Map<String, String>> jobOrderList();
	List<Map<String, String>> elist();	
	List<Map<String, String>> plist();
	List<Map<String, String>> slist();

	int insertJobOrder(Job_order job_order);

	Job_order selectOneJobOrder(int workcode);

	int updateJobOrder(Job_order job_order);

	int deleteJobOrder(int workcode);

	int insertStorageDetail(StorageDetail storageDetail);



}
