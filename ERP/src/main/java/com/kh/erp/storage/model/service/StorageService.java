package com.kh.erp.storage.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.erp.storage.model.vo.Storage;

public interface StorageService {
	static final int STRG_SRV_ERROR = 0; // 에러
	static final int STRG_SRV_COMPL = 1; // 성공
	
	List<Map<String, String>> storageList();
	
	int insertStorage(Storage storage);
	
	Storage selectOneStorage(int sCode);
	
	int updateStorage(Storage storage);
	
	int deleteStorage(int sCode);
}
