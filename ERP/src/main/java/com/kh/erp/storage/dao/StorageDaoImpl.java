package com.kh.erp.storage.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.storage.vo.Storage;

@Repository
public class StorageDaoImpl implements StorageDao {

	@Autowired
	SqlSessionTemplate sqlSession;

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
