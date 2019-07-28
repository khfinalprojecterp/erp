package com.kh.erp.employee.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.employee.model.vo.Attendance;
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

	@Override
	public int updateEmployee(Employee emp) {
		System.out.println(emp+"1");
		return sqlSession.update("employee.updateEmp",emp);
	}

	
	@Override
	public int deleteEmployee(int idCode) {
		
		return sqlSession.delete("employee.deleteEmp",idCode);
	}

	@Override
	public void insertSub(Employee emp) {

		sqlSession.insert("employee.insertPmanage",emp);
		sqlSession.insert("employee.insertAttendance",emp);
	}

	@Override
	public List<Attendance> selectAttendnaceList() {
		
		return sqlSession.selectList("employee.selectAttendanceList");
	}

	@Override
	public int updateAttendance(Attendance attendance) {
		
		return sqlSession.update("employee.updateAttendance",attendance);
	}

	
}
