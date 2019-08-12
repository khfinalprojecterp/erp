package com.kh.erp.mail.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.kh.erp.mail.model.vo.MailMitVo;
import com.kh.erp.mail.model.vo.MailVo;

public class PostCan {
   @Autowired
   JavaMailSenderImpl mailSender;
   
   

   public static List<MailVo> open() throws AddressException, MessagingException {

      ArrayList<MailVo> list = new ArrayList<>();
 

      
   
      System.out.println("여기까지 왔어요");
      Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
      Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
      Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");
      Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
      Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");
      Pattern WHITESPACE = Pattern.compile("\\s\\s+");

      String host = "pop.naver.com";

      String username ="ari5704"; // @naver.com 은 제외하고 아이디만.
      String password = "ari5755704";
      int port = 995;

      Properties props = System.getProperties();

      props.put("mail.pop3.host", host);
      props.put("mail.pop3.port", port);
      props.put("mail.pop3.auth", "true");
      props.put("mail.pop3.ssl.enable", "true");
      props.put("mail.pop3.ssl.trust", host);

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         String un = username;
         String pw = password;

         protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(un, pw);
         }
      });

      session.setDebug(false);
      Store store = session.getStore("pop3");
      store.connect();

      Folder folder = store.getFolder("INBOX");
      folder.open(Folder.READ_ONLY);

      Message[] messages = folder.getMessages();
      Matcher m;
      
		/* for (int i = messages.length, n = 0; i < n; i--) */
		for (int i = 0, n = messages.length; i < n; i++){
         Message message = messages[i];
         
//           System.out.println(":::::::::::::::::::::::::::::::::::");
//           System.out.println("Subject: " + message.getSubject());
//           System.out.println("From: " + message.getFrom()[0]);
//           System.out.println("Date: " + message.getHeader("Date")[0]);
          // System.out.println("Body: " + message.getContent()); 
         
          
          
         MailVo mail = new MailVo();
         
         String content="";
         String body = "";
         try {
            
            if(message.getContent() instanceof MimeMultipart) {
               body = new PostCan().getTextFromMimeMultipart((MimeMultipart)message.getContent());
            } else {
               body = (String)message.getContent();
            }
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         Address[] froms = message.getFrom();
         String emailAdd = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
         
         m = SCRIPTS.matcher(body);
         content=m.replaceAll("");
         m = STYLE.matcher(body);
         content=m.replaceAll("");
         m = TAGS.matcher(body);
         content=m.replaceAll("");
         m = ENTITY_REFS.matcher(body);
         content=m.replaceAll("");
         m = WHITESPACE.matcher(body);
         content=m.replaceAll("");
         
         //System.out.println("확인!!");
         // System.out.println(message.getHeader("Date")[0]);
         SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
         SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm ");
         System.out.println(sdf.format(new Date()));
         String renamedName = null;
         try {
            renamedName = sdf2.format(sdf.parse(message.getHeader("Date")[0]));
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         // String renamedName = sdf2.format();

         System.out.println("바꾼 날짜"+renamedName);
         
         mail.setKeyNum(i);
         mail.setMailContent(content);
         mail.setMailTitle(message.getSubject());
         mail.setMailDate(renamedName);
         mail.setMailSender(emailAdd);

         list.add(mail);

      }
	
      System.out.println("확인 : "+list);
      store.close();

      return list;
   }

   private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
      String result = "";
      int count = mimeMultipart.getCount();
      for (int i = 0; i < count; i++) {
         BodyPart bodyPart = mimeMultipart.getBodyPart(i);
         if (bodyPart.isMimeType("text/plain")) {
            result = result + "\n" + bodyPart.getContent();
            break; // without break same text appears twice in my tests
         } else if (bodyPart.isMimeType("text/html")) {
            String html = (String) bodyPart.getContent();
            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
         } else if (bodyPart.getContent() instanceof MimeMultipart) {
            result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
         }
      }
      return result;
   }
   
   
   
   
   
   
   
   
   
   public static List<MailVo> open2(MailVo mail) throws AddressException, MessagingException {

      ArrayList<MailVo> list = new ArrayList<>();

      Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
      Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
      Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");
      Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
      Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");
      Pattern WHITESPACE = Pattern.compile("\\s\\s+");

      String host = "pop.naver.com";

      final String username = "ari5704"; // @naver.com 은 제외하고 아이디만.
      final String password = "ari5755704";
      int port = 995;

      Properties props = System.getProperties();

      props.put("mail.pop3.host", host);
      props.put("mail.pop3.port", port);
      props.put("mail.pop3.auth", "true");
      props.put("mail.pop3.ssl.enable", "true");
      props.put("mail.pop3.ssl.trust", host);

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         String un = username;
         String pw = password;

         protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(un, pw);
         }
      });

      session.setDebug(false);
      Store store = session.getStore("pop3");
      store.connect();

      Folder folder = store.getFolder("INBOX");
      folder.open(Folder.READ_ONLY);

      Message[] messages = folder.getMessages();
      Matcher m;
      
      
         Message message = messages[mail.getKeyNum()];

         
//           System.out.println(":::::::::::::::::::::::::::::::::::");
//           System.out.println("Subject: " + message.getSubject());
//           System.out.println("From: " + message.getFrom()[0]);
//           System.out.println("Date: " + message.getHeader("Date")[0]);
          // System.out.println("Body: " + message.getContent()); 
         
         System.out.println(message.getSentDate());
          
          
         
         String content="";
         String body = "";
         try {
            
            if(message.getContent() instanceof MimeMultipart) {
               body = new PostCan().getTextFromMimeMultipart((MimeMultipart)message.getContent());
            } else {
               body = (String)message.getContent();
            }
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         Address[] froms = message.getFrom();
         String emailAdd = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
         
         m = SCRIPTS.matcher(body);
         content=m.replaceAll("");
         m = STYLE.matcher(body);
         content=m.replaceAll("");
         m = TAGS.matcher(body);
         content=m.replaceAll("");
         m = ENTITY_REFS.matcher(body);
         content=m.replaceAll("");
         m = WHITESPACE.matcher(body);
         content=m.replaceAll("");
         
         SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
         SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm ");
         System.out.println(sdf.format(new Date()));
         String renamedName = null;
         try {
            renamedName = sdf2.format(sdf.parse(message.getHeader("Date")[0]));
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         // String renamedName = sdf2.format();

         System.out.println("바꾼 날짜"+renamedName);
         
         
         mail.setMailContent(content);
         mail.setMailTitle(message.getSubject());
         mail.setMailDate(renamedName);
         mail.setMailSender(emailAdd);

         list.add(mail);

      
      store.close();

      return list;
   }
   
}