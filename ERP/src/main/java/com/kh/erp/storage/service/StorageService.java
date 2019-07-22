package com.kh.erp.storage.service;

import java.util.List;

import com.kh.erp.storage.vo.Storage;

public interface StorageService {
	static final int STRG_SRV_ERROR = 0; // 에러
	static final int STRG_SRV_COMPL = 1; // 성공
	
	List<Storage> storageList();
	
	int insertStorage(Storage storage);
	
	Storage selectOneStorage(int sCode);
	
	int updateStorage(Storage storage);
	
	int deleteStorage(int sCode);
}
