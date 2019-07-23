package com.kh.erp.employee.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.employee.model.vo.Employee;



@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	@Override
	public int insertEmployee(Employee emp) {
	
		return sqlSession.insert("employee.insertEmp",emp);
	}

	@Override
	public Employee selectEmployee(String idCode) {
		
		return sqlSession.selectOne("employee.selectEmp",idCode);
	}

	@Override
	public List<Employee> selectEmpList() {
		
		return sqlSession.selectList("employee.selectEmpList");
	}

}
