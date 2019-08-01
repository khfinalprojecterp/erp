package com.kh.erp.department.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.department.model.vo.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insertDepart(Department depart) {
		
		return sqlSession.insert("department.insertDepartment",depart);
	}

	@Override
	public List<Department> selectDepartList() {
		
		return sqlSession.selectList("department.selectDepartList");
	}
	
	
	@Override
	public int updateDepart(Department depart) {
		// TODO Auto-generated method stub
		return sqlSession.update("department.updateDepartment",depart);
	}

	@Override
	public int deleteDepart(int dCode) {
		
		return sqlSession.delete("department.deleteDepartment",dCode);
	}

}
