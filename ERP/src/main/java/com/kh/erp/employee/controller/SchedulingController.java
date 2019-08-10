package com.kh.erp.employee.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.kh.erp.employee.model.service.SchedulingService;
import com.kh.erp.employee.model.vo.Scheduling;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class SchedulingController {

	
	
	@Autowired
	SchedulingService scheduleService;
	
	@RequestMapping(value="/employee/enterschedule.do")
	public String enterSchedule() {
		
		
		
		
		return "employee/scheduling";
	}
	
	
	
	
	
	@RequestMapping(value="/employee/insertschedule.do",method=RequestMethod.GET)
	@ResponseBody
	public void insertSchedule(
			@RequestParam int eCode,
			@RequestParam String title,
			@RequestParam String start,
			@RequestParam String end,
			@RequestParam String description,
			@RequestParam String type,
			@RequestParam String username,
			@RequestParam String backgroundColor,
			@RequestParam String textColor,
			@RequestParam String allDay,
			HttpServletResponse resp,Scheduling schedule ) {

		
		if(allDay.equals("false")){allDay="N";}
		else {allDay="Y";}

		
		
		// ajax 로 받아온값 객체에 넣고 DB전송
		schedule.seteCode(eCode);
		schedule.setTitle(title);
		schedule.setStart(start);
		schedule.setEnd(end);
		schedule.setDescription(description);
		schedule.setType(type);
		schedule.setUsername(username);
		schedule.setBackgroundColor(backgroundColor);
		schedule.setTextColor(textColor);
		schedule.setAllDay(allDay);
		
		schedule.toString();
		
		System.out.println("^_^"+schedule);
		
		scheduleService.insertSchedule(schedule);

	}
	
	
	@RequestMapping(value="employee/selectschedule.do")
	@ResponseBody
	public JSONArray selectSchedule(
			@RequestParam int eCode,
			HttpServletResponse resp,Scheduling schedule ) {
		
		
//		System.out.println(scheduleService.selectSchedule());
		
		
		schedule = null;
		
		List<Scheduling> slist =scheduleService.selectSchedule(eCode);		
		JSONArray jArray =new JSONArray();
		
		
		for(int i=0; i<slist.size(); i++) {
			schedule = slist.get(i);
			
			JSONObject jobj = new JSONObject();
			jobj.put("_id", schedule.get_id());
			jobj.put("eCode", schedule.geteCode());
			jobj.put("title", schedule.getTitle());
			jobj.put("description",schedule.getDescription());
			jobj.put("start",schedule.getStart());
			jobj.put("end",schedule.getEnd());
			jobj.put("type",schedule.getType());
			jobj.put("username",schedule.getUsername());
			jobj.put("backgroundColor",schedule.getBackgroundColor());
			jobj.put("textColor",schedule.getTextColor());
			

			if(schedule.getAllDay().equals("N"))
			{
				jobj.put("allDay",false);

			}
			else 
			{
			jobj.put("allDay",true);
			}
			
//			jobj.put("allDay",schedule.getAllDay());

			jArray.add(jobj);
			
		}
		
		System.out.println(jArray);
		
		
		return jArray;
	
	}

	@RequestMapping(value="employee/resizeschedule.do")
	public void resizeSchedule(	
								@RequestParam int _id,
								@RequestParam String start,
								@RequestParam String end,
								Scheduling schedule,
								HttpServletResponse resp) {

		schedule.set_id(_id);
		schedule.setStart(start);
		schedule.setEnd(end);
		
		
		
		scheduleService.resizeSchedule(schedule);
		
		
		
		
	
	}
	
	@RequestMapping(value="employee/dragschedule.do")
	@ResponseBody
	public void dragSchedule(	
								@RequestParam int _id,
								@RequestParam String start,
								@RequestParam String end,
								Scheduling schedule ) {

		schedule.set_id(_id);
		schedule.setStart(start);
		schedule.setEnd(end);
		
		scheduleService.resizeSchedule(schedule);
		
		
	}
	
	@RequestMapping(value="/updateschedule.do")
	@ResponseBody
	public void updateSchedule(	
								@RequestParam int _id,
								@RequestParam String title,
								@RequestParam String start,
								@RequestParam String end,
								@RequestParam String description,
								@RequestParam String type,
								@RequestParam String username,
								@RequestParam String backgroundColor,
								@RequestParam String textColor,
								@RequestParam String allDay,
								Scheduling schedule ) {

		if(allDay.equals("false")){allDay="N";}
		else {allDay="Y";}
		
		
		schedule.set_id(_id);
		schedule.setTitle(title);
		schedule.setStart(start);
		schedule.setEnd(end);
		schedule.setDescription(description);
		schedule.setType(type);
		schedule.setUsername(username);
		schedule.setBackgroundColor(backgroundColor);
		schedule.setTextColor(textColor);
		schedule.setAllDay(allDay);
		
		scheduleService.updateSchedule(schedule);

	}
	
	@RequestMapping(value="/deleteschedule.do")
	@ResponseBody
	public void deleteSchedule(	
								@RequestParam int _id
								) {

		
		scheduleService.deleteSchedule(_id);
		
	}
	
	
	
	
	
	
	
	
}
