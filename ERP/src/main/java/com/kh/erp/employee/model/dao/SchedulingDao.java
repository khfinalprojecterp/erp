package com.kh.erp.employee.model.dao;

import java.util.List;

import com.kh.erp.employee.model.vo.Scheduling;

public interface SchedulingDao {


	int insertSchedule(Scheduling schedule);
	
	List<Scheduling> selectSchedule();
	
	int resizeSchedule(Scheduling schedule);
	int updateSchedule(Scheduling schedule);
	int deleteSchedule(int _id);
}
