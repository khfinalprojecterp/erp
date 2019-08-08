package com.kh.erp.production.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.production.model.vo.Job_order;

public interface Job_orderService {

	static final int JORDER_SRV_ERROR = 0; // 에러
	static final int JORDER_SRV_COMPL = 1; // 성공
	
	/**
	 * 생산 업무지시서 리스트 조회 메소드
	 * @return
	 */
	List<Map<String, String>> jobOrderList();
	List<Map<String, String>> elist();
	List<Map<String, String>> plist();
	/**
	 * 생산 업무지시서 추가 메소드 
	 * @param mcName
	 * @return
	 */
	int insertJobOrder(Job_order job_order);
	
	/**
	 * 생산 업무지시서 분류 선택 메소드
	 * @param mCate
	 * @return
	 */
	Job_order selectOneJobOrder(int workcode); 

	/**
	 * 기자재 분류 수정 메소드
	 * @param materialsCategory
	 * @return
	 */
	int updateJobOrder(Job_order job_order);
	
	/**
	 * 기자재 분류 삭제 메소드
	 * @param mCate
	 * @return
	 */
	int deleteJobOrder(int workcode);

}
