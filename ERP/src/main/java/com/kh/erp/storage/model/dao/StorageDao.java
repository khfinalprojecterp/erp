package com.kh.erp.storage.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.erp.storage.model.vo.Storage;

public interface StorageDao {
	
	List<Map<String, String>> storageList();
	
	int insertStorage(Storage storage);
	
	Storage selectOneStorage(int sCode);
	
	int updateStorage(Storage storage);
	
	int deleteStorage(int sCode);
}
