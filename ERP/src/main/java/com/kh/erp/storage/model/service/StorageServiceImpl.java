package com.kh.erp.storage.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.storage.model.dao.StorageDao;
import com.kh.erp.storage.model.vo.Storage;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageDao storageDao;

	@Override
	public List<Map<String, String>> storageList() {
		return storageDao.storageList();
	}

	@Override
	public int insertStorage(Storage storage) {
		
		return storageDao.insertStorage(storage);
	}

	@Override
	public Storage selectOneStorage(int sCode) {
		
		return null;
	}

	@Override
	public int updateStorage(Storage storage) {
		
		return storageDao.updateStorage(storage);
	}

	@Override
	public int deleteStorage(int sCode) {
		
		return storageDao.deleteStorage(sCode);
	}
}
