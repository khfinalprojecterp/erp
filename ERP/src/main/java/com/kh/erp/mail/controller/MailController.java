package com.kh.erp.mail.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.erp.mail.model.vo.MailMitVo;
import com.kh.erp.mail.model.vo.MailVo;




@Controller
public class MailController {
   
   @RequestMapping("/mail/mailList.do")
   public String Mail(Model model) throws AddressException, MessagingException {
      System.out.println("여기까지 왔어요!!");
      List<MailVo> list = PostCan.open();
      //System.out.println("가"+list);
    
      model.addAttribute("list",list);
      
      return "mail/mailReception";
   }
   
   @RequestMapping("/mail/mailOne.do")
   public String selectOneMail(MailVo mail,Model model) throws AddressException, MessagingException {
      
      List<MailVo> list = PostCan.open2(mail);
      model.addAttribute("mail",mail);
      
      //System.out.println(list);
      
      return "/mail/mailReceptionOne";
   }
   
}
