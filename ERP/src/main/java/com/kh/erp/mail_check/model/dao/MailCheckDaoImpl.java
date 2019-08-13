package com.kh.erp.mail_check.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.mail_check.model.vo.MailCheck;

@Repository
public class MailCheckDaoImpl implements MailCheckDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int insertMailCheck(MailCheck mailCheck) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("mailCheck.insertMailCheck",mailCheck);
	}

	@Override
	public MailCheck selectMailCheck (String idCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mailCheck.selectMail",idCode);
	}

}
