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
	public List<Scheduling> selectSchedule(int eCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("scheduling.selectSchedule",eCode);
	}


	@Override
	public int resizeSchedule(Scheduling schedule) {
		// TODO Auto-generated method stub
		return sqlSession.update("scheduling.resizeSchedule",schedule);
	}


	@Override
	public int updateSchedule(Scheduling schedule) {
	
		
		return sqlSession.update("scheduling.updateSchedule",schedule);
	}


	@Override
	public int deleteSchedule(int _id) {
		
		return sqlSession.delete("scheduling.deleteSchedule",_id);
	}

}
