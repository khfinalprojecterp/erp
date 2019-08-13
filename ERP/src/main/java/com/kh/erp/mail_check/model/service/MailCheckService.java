package com.kh.erp.mail_check.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.mail_check.model.vo.MailCheck;

public interface MailCheckService {

	/**
	 * 이메일 인증 완료
	 * @param mailCheck
	 * @return
	 */
	int insertMailCheck(MailCheck mailCheck);
	

	/**
	 * 세션
	 * @param idCode
	 * @return
	 */
	MailCheck selectMailCheck(String idCode);

	
}
