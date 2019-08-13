package com.kh.erp.mail.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.DecoderException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.erp.mail.model.vo.MailMitVo;
import com.kh.erp.mail.model.vo.MailVo;
import com.kh.erp.mail_check.model.vo.MailCheck;

@Controller
public class MailController {

	@RequestMapping("/mail/mailList.do")
	public String Mail(Model model, MailCheck mailCk, HttpSession session) throws AddressException, MessagingException,
			InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DecoderException {
		MailCheck ma = (MailCheck) session.getAttribute("mailCk");


		List<MailVo> list = PostCan.open(ma);

		/* System.out.println("1" + MailMitVo); */


		model.addAttribute("list", list);

		return "mail/mailReception";
	}

	@RequestMapping("/mail/mailOne.do")
	public String selectOneMail(MailVo mail, MailCheck mailCk, HttpSession session, Model model)
			throws AddressException, MessagingException, InvalidKeyException, UnsupportedEncodingException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException, DecoderException {
		MailCheck ma = (MailCheck) session.getAttribute("mailCk");
		List<MailVo> list = PostCan.open2(mail, ma);
		model.addAttribute("mail", mail);

		// System.out.println(list);

		return "/mail/mailReceptionOne";
	}

}
