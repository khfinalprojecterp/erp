package com.kh.erp.storage.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.storage.model.vo.Storage;

@Repository
public class StorageDaoImpl implements StorageDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> storageList() {
		
		return sqlSession.selectList("storage.selectStorageList");
	}

	@Override
	public int insertStorage(Storage storage) {
		
		return sqlSession.insert("storage.insertStorage", storage);
	}

	@Override
	public Storage selectOneStorage(int sCode) {
		
		return null;
	}

	@Override
	public int updateStorage(Storage storage) {
		
		return sqlSession.update("storage.updateStorage", storage);
	}

	@Override
	public int deleteStorage(int sCode) {
		
		return sqlSession.delete("storage.deleteStorage", sCode);
	}
}
