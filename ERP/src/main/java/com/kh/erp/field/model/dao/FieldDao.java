package com.kh.erp.field.model.dao;

import java.util.List;

import com.kh.erp.field.model.vo.Field;

public interface FieldDao {

	
int insertField(Field field);
	
	List<Field> selectFieldList();
	
	
	
	
	
	
	
}
