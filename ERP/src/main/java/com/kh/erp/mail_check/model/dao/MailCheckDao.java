package com.kh.erp.mail_check.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.erp.mail_check.model.vo.MailCheck;

public interface MailCheckDao {

	
	/**
	 * 이메일 인증 완료
	 * @param mailCheck
	 * @return
	 */
	int insertMailCheck(MailCheck mailCheck);
	
	/**
	 * 이메일 정보
	 * @return
	 */
	List<Map<String, String>> mailList();
}
