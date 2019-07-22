package com.kh.erp.storage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.storage.model.dao.StorageDetailDao;
import com.kh.erp.storage.model.vo.StorageDetail;

@Service
public class StorageDetailServiceImpl implements StorageDetailService {
	
	@Autowired
	private StorageDetailDao storageDetailDao;

	@Override
	public List<StorageDetail> storageDetailList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StorageDetail selectOneStorageDetail(int sdCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStorageDetail(int sdCode) {
		// TODO Auto-generated method stub
		return 0;
	}

}
