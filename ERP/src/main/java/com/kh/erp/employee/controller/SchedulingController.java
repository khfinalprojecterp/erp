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
	
	
	@RequestMapping(value="/employee/insertschedule.do",method=RequestMethod.GET)
	public void insertSchedule(
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

		// ajax 로 받아온값 객체에 넣고 DB전송
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
		
		scheduleService.insertSchedule(schedule);

	}
	
	
	@RequestMapping(value="/employee/selectschedule.do")
	@ResponseBody
	public JSONArray selectSchedule(HttpServletResponse resp,Scheduling schedule ) {
		
		
//		System.out.println(scheduleService.selectSchedule());
		
		
		schedule = null;
		
		List<Scheduling> slist =scheduleService.selectSchedule();		
		JSONArray jArray =new JSONArray();
		
		
		for(int i=0; i<slist.size(); i++) {
			schedule = slist.get(i);
			
			JSONObject jobj = new JSONObject();
			jobj.put("_id", schedule.get_id());
			jobj.put("title", schedule.getTitle());
			jobj.put("description",schedule.getDescription());
			jobj.put("start",schedule.getStart());
			jobj.put("end",schedule.getEnd());
			jobj.put("type",schedule.getType());
			jobj.put("username",schedule.getUsername());
			jobj.put("backgroundColor",schedule.getBackgroundColor());
			jobj.put("textColor",schedule.getTextColor());
			jobj.put("allDay",schedule.getAllDay());

			
//			jobj.put("allDay",schedule.getAllDay());

			jArray.add(jobj);
			
		}
		
		System.out.println(jArray);
		
		
		return jArray;
		
		
		
		
//		ObjectMapper mapper = new ObjectMapper();
//
//		try {
//			String jsonStr = mapper.writeValueAsString(slist);
//			
//			System.out.println(jsonStr);
//			
//			resp.getWriter().print(jsonStr);
//			
//			
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	
//			try {
//				resp.getWriter().print(scheduleService.selectSchedule());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
