package com.kh.erp.employee.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.employee.model.vo.Scheduling;


@Repository
public class SchedulingDaoImpl implements SchedulingDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	@Override
	public int insertSchedule(Scheduling schedule) {
		
		return sqlSession.insert("scheduling.insertSchedule",schedule);
	}


	@Override
	public List<Scheduling> selectSchedule() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("scheduling.selectSchedule");
	}

}
