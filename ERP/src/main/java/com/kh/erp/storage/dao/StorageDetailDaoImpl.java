package com.kh.erp.storage.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.storage.vo.StorageDetail;

@Repository
public class StorageDetailDaoImpl implements StorageDetailDao {

	@Autowired
	SqlSessionTemplate sqlSession;

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
	public StorageDetail selectOneStorageDetail(int sCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStorageDetail(int sCode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
