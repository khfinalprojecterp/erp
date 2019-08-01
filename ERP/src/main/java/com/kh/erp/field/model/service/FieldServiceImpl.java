package com.kh.erp.field.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.field.model.dao.FieldDao;
import com.kh.erp.field.model.vo.Field;


@Repository
public class FieldServiceImpl implements FieldService {

	@Autowired
	FieldDao fieldDao;
	
	
	@Override
	public int insertField(Field field) {
		
		return fieldDao.insertField(field);
	}

	@Override
	public List<Field> selectFieldList() {
		// TODO Auto-generated method stub
		return fieldDao.selectFieldList();
	}
	@Override
	public int deleteField(int fCode) {
		// TODO Auto-generated method stub
		return fieldDao.deleteField(fCode);
	}


}
