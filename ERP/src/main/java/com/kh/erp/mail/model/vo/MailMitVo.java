package com.kh.erp.mail.model.vo;


import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MailMitVo implements Serializable {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1688L;
   private String userMail;
   private String userPass;
   private String tomail;
   private String title;
   private String content;
   private String contents;
   private String originalFileName;
   private String renamedFileName;
   private String empEmail;
   public MailMitVo() {
      super();
      // TODO Auto-generated constructor stub
   }
public MailMitVo(String userMail, String userPass, String tomail, String title, String content, String contents,
		String originalFileName, String renamedFileName, String empEmail) {
	super();
	this.userMail = userMail;
	this.userPass = userPass;
	this.tomail = tomail;
	this.title = title;
	this.content = content;
	this.contents = contents;
	this.originalFileName = originalFileName;
	this.renamedFileName = renamedFileName;
	this.empEmail = empEmail;
}

public String getUserMail() {
	return userMail;
}
public void setUserMail(String userMail) {
	this.userMail = userMail;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}
public String getTomail() {
	return tomail;
}
public void setTomail(String tomail) {
	this.tomail = tomail;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public String getOriginalFileName() {
	return originalFileName;
}
public void setOriginalFileName(String originalFileName) {
	this.originalFileName = originalFileName;
}
public String getRenamedFileName() {
	return renamedFileName;
}
public void setRenamedFileName(String renamedFileName) {
	this.renamedFileName = renamedFileName;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}

@Override
public String toString() {
	return "MailMitVo [userMail=" + userMail + ", userPass=" + userPass + ", tomail=" + tomail + ", title=" + title
			+ ", content=" + content + ", contents=" + contents + ", originalFileName=" + originalFileName
			+ ", renamedFileName=" + renamedFileName + ", empEmail=" + empEmail + "]";
}
   
   
   
}