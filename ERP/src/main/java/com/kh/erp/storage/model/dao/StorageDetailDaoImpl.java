package com.kh.erp.storage.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.storage.model.vo.StorageDetail;

@Repository
public class StorageDetailDaoImpl implements StorageDetailDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> storageDetailList() {
		
		return sqlSession.selectList("storage.selectStorageDetailList");
	}

	@Override
	public int insertStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return sqlSession.insert("storage.insertStorageDetail" , storageDetail);
	}

	@Override
	public StorageDetail selectOneStorageDetail(int sCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStorageDetail(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return sqlSession.update("storage.updateStorageDetail" , storageDetail);
	}

	@Override
	public int deleteStorageDetail(int sdCode) {
		// TODO Auto-generated method stub
		return sqlSession.delete("storage.deleteStorageDetail" , sdCode);
	}

	@Override
	public List<Map<String, String>> loadProductList() {
		return sqlSession.selectList("storage.loadProductList");
	}

	@Override
	public List<Map<String, String>> memberList(int eCode) {
		return sqlSession.selectList("storage.selectEmployeeMemberList", eCode);
	}
	
	
}
