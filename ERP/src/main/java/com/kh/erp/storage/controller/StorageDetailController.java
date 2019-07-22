package com.kh.erp.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.erp.storage.model.service.StorageDetailService;

@Controller
public class StorageDetailController {

	@Autowired
	StorageDetailService storageDetailService;
	
	/* 
	 * detail 을 하나 혹은 여러개를 수정해야 할 수 있으니(인서트도?) 객체로 받아온다.
	 * 이를 controller 에서 for 문을 통해 여러번 처리하거나 , (next()) 사용
	 * 객체 덩어리로 넘겨준후 , dao 혹은 service에서 처리하게 구현 한다.
	 */
}
