package com.kh.erp.mail_check.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.erp.buy.controller.AES256Util;
import com.kh.erp.mail_check.model.service.MailCheckService;
import com.kh.erp.mail_check.model.vo.MailCheck;

@Controller
public class MailCheckController {

	@Autowired
	MailCheckService mailCheckService;

	/*
	 * @Autowired private BCryptPasswordEncoder bcryptPasswordEncoder;
	 */

	@RequestMapping("/mail/mailInsert.do")
	public String insertMailCheck(MailCheck mailCheck, Model model,HttpSession session)
			throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, EncoderException {


		String key = mailCheck.getUserMail().split("@")[0];
		String rePass = mailCheck.getUserPass();

		AES256Util aes256 = new AES256Util(key);
		URLCodec codec = new URLCodec();

		mailCheck.setUserPass(codec.encode(aes256.aesEncode(rePass)));

		System.out.println(mailCheck);
		int result = mailCheckService.insertMailCheck(mailCheck);
		session.setAttribute("mailCk", mailCheck);

		String msg = "";
		if (result > 0) {
			msg = "메일등록 성공!";

		} else {
			msg = "메일등록 실패!";
		}

		String loc = "/mailMit/mailMit.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);

		return "common/msg";
	}

}
