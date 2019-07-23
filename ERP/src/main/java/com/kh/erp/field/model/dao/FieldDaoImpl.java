package com.kh.erp.field.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.field.model.vo.Field;


@Repository
public class FieldDaoImpl implements FieldDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int insertField(Field field) {
		return sqlSession.insert("field.insertField",field);
	}

	@Override
	public List<Field> selectFieldList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("field.selectFieldList");
	}

}
