package com.kh.erp.mail_check.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.mail_check.model.dao.MailCheckDao;
import com.kh.erp.mail_check.model.vo.MailCheck;

@Service
public class MailCheckServiceImpl implements MailCheckService {
	
	@Autowired
	private MailCheckDao mailcheckdao;

	@Override
	public int insertMailCheck(MailCheck mailCheck) {
		// TODO Auto-generated method stub
		return mailcheckdao.insertMailCheck(mailCheck);
	}

	@Override
	public MailCheck selectMailCheck(String idCode) {
		// TODO Auto-generated method stub
		return mailcheckdao.selectMailCheck(idCode);
	}
	
	

}
