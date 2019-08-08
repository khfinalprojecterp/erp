package com.kh.erp.storage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.storage.model.dao.StorageDetailDao;
import com.kh.erp.storage.model.vo.StorageDetail;

@Service
public class StorageDetailServiceImpl implements StorageDetailService {
	
	@Autowired
	private StorageDetailDao storageDetailDao;

	@Override
	public List<Map<String, String>> storageDetailList() {
		// TODO Auto-generated method stub
		return storageDetailDao.storageDetailList();
	}

	@Override
	public int insertStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return storageDetailDao.insertStorageDetail(storageDetail);
	}

	@Override
	public StorageDetail selectOneStorageDetail(int sdCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return storageDetailDao.updateStorageDetail(storageDetail);
	}

	@Override
	public int deleteStorageDetail(int sdCode) {
		// TODO Auto-generated method stub
		return storageDetailDao.deleteStorageDetail(sdCode);
	}
	
	//임시
	@Override
	public List<Map<String, String>> loadProductList() {
		return storageDetailDao.loadProductList();
	}

	@Override
	public List<Map<String, String>> memberList(int eCode) {
		
		return storageDetailDao.memberList(eCode);
	}

}
