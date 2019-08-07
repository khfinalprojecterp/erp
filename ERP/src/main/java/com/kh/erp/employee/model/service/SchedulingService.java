package com.kh.erp.employee.model.service;

import java.util.List;


import com.kh.erp.employee.model.vo.Scheduling;

public interface SchedulingService {

	

	int insertSchedule(Scheduling schedule);
	
	List<Scheduling> selectSchedule(int eCode);
	
	int resizeSchedule(Scheduling schedule);
	int updateSchedule(Scheduling schedule);
	int deleteSchedule(int _id);
	
}
