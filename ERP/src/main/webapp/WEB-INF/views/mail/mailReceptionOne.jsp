<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />

<body>
<c:import url="../common/nav.jsp" />
               <!-- ================================================================================== -->
<div id="page-wrapper">
		<c:import url="../common/bodyNav.jsp" />
	<div id="page-inner">
			<div class="row">
				<div class="col-md-12" style="text-align: center;">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="background-color: #EFF8FB; border-radius: 50px; border: solid 3px #E0ECF8;">
            
               
                 
                  <form id="send" action="${pageContext.request.contextPath}/mail/mailSending.do"
                    onsubmit="return sendForm()" method="post" enctype="multipart/form-data">
                     <div>
                     <div align="left">
                     <br />
                      <label for="message-text" class="col-form-label" style="font-size:xx-large;">수신메일</label>
                	  <br><br>
                	   <label for="message-text" class="col-form-label" style="font-size:medium;">메일번호</label>
                	   <input type="text" name="userMail" style="width: 50%; background-color: #EFF8FB; border: solid 1px #E0ECF8;"
                            class="form-control" readonly value="${mail.keyNum}" >
                            <label for="message-text" class="col-form-label" style="font-size:medium;">수신일자</label>
                            <input type="text" name="userMail" style="width: 50%; background-color: #EFF8FB; border: solid 1px #E0ECF8;"
                            class="form-control" readonly value="${mail.mailDate}" >

                            <br><br>

                	  <label for="message-text" class="col-form-label" style="font-size:medium;">송신자</label>
                        <input type="text" name="from" style="width: 50%"
                             class="form-control" readonly value="${mail.mailSender}">
                            </div>
                     </div>
                     <br>
                     <div align="left">
                        <!-- 제목 -->
                         <label for="message-text" class="col-form-label" style="font-size:medium;">제목</label>
                        <input type="text" name="title" size="120" style="width: 50%"
                            class="form-control" readonly value="${mail.mailTitle}"> 
                     </div>
                     <br>
                     <div style="text-align: left;">
                        <!-- 내용 -->
                       
                        <div>
                        ${mail.mailContent}
                           </div>

                     </div>               
            		<br />
                     <div align="center">
                        <a href="${pageContext.request.contextPath}/mailMit/mailMit.do">메일쓰기</a><br><br>
                        <a href="${pageContext.request.contextPath}/mail/mailList.do">받은메일함</a>
                     </div>
                     

                     
                     <br />
                  </form>
               </div>
               <div class="col-md-2"></div>
               </div>
               </div>
               </div>
</div>

               <!-- ================================================================================== -->



</body>
<c:import url="../common/footer.jsp" />