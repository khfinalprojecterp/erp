package com.kh.erp.employee.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.employee.model.dao.SchedulingDao;
import com.kh.erp.employee.model.vo.Scheduling;

@Service
public class SchedulingServiceImpl implements SchedulingService {

	@Autowired
	SchedulingDao schedulingDao;
	
	
	@Override
	public int insertSchedule(Scheduling schedule) {
		
		return schedulingDao.insertSchedule(schedule);
	}


	@Override
	public List<Scheduling> selectSchedule(int eCode) {
		// TODO Auto-generated method stub
		return schedulingDao.selectSchedule(eCode);
	}


	@Override
	public int resizeSchedule(Scheduling schedule) {
		
		return schedulingDao.resizeSchedule(schedule);
	}


	@Override
	public int updateSchedule(Scheduling schedule) {
	
		return schedulingDao.updateSchedule(schedule);
	}


	@Override
	public int deleteSchedule(int _id) {
		
		return schedulingDao.deleteSchedule(_id);
	}

}
