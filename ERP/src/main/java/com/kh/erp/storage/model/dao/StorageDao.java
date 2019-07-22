package com.kh.erp.storage.model.dao;

import java.util.List;

import com.kh.erp.storage.model.vo.Storage;

public interface StorageDao {
	
	List<Storage> storageList();
	
	int insertStorage(Storage storage);
	
	Storage selectOneStorage(int sCode);
	
	int updateStorage(Storage storage);
	
	int deleteStorage(int sCode);
}
