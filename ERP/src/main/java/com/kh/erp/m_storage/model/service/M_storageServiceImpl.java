package com.kh.erp.m_storage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.m_storage.model.dao.M_storageDao;
import com.kh.erp.m_storage.model.vo.M_storage;
@Service
public class M_storageServiceImpl implements M_storageService {

	@Autowired
	private M_storageDao m_storageDao; 
	@Override
	public List<M_storage> selectM_storageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertM_storage(M_storage m_storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public M_storage selectOneM_storage(int IDCODE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateM_storage(M_storage m_storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteM_storage(int IDCODE) {
		// TODO Auto-generated method stub
		return 0;
	}

}
