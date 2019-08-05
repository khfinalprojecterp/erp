package com.kh.erp.employee.model.dao;

import java.util.List;

import com.kh.erp.employee.model.vo.Scheduling;

public interface SchedulingDao {


	int insertSchedule(Scheduling schedule);
	
	List<Scheduling> selectSchedule();
}
