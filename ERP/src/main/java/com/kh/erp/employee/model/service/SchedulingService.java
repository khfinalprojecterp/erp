package com.kh.erp.employee.model.service;

import java.util.List;


import com.kh.erp.employee.model.vo.Scheduling;

public interface SchedulingService {

	

	int insertSchedule(Scheduling schedule);
	
	List<Scheduling> selectSchedule();
	
}
