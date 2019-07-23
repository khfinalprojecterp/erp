package com.kh.erp.storage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.storage.model.dao.StorageDao;
import com.kh.erp.storage.model.vo.Storage;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageDao storageDao;

	@Override
	public List<Storage> storageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStorage(Storage storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Storage selectOneStorage(int sCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStorage(Storage storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStorage(int sCode) {
		// TODO Auto-generated method stub
		return 0;
	}
}
