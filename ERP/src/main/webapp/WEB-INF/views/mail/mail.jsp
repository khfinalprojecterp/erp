<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="https://github.com/summernote/summernote/tree/master/lang/summernote-ko-KR.js"></script>


<!-- <script>
   $(function() {
      $('[name=upFile]').on('change', function() {
         var fileName = $(this).prop('files')[0].name;//파일명(jquery)
         console.log($(this).val());
         $(this).next('.custom-file-label').html(fileName);
      })
   });
   
   function Email(email) {
      console.log(email);
      location.href = "${pageContext.request.contextPath}/mail/mailSending.do";
   }
</script> -->
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
                      <label for="message-text" class="col-form-label" style="font-size:xx-large;">메일 보내기</label>
                	  <br><br>
                	  <c:forEach items="${mailList}" var="m" >
                	  <c:if test="${ employee.idCode eq m.idCode }">
                	   <input type="text" name="userMail" style="width: 50%; background-color: #EFF8FB; border: solid 1px #E0ECF8;"
                            placeholder="발송이메일" class="form-control" readonly value="${m.userMail}" >
                            </c:if>
                            </c:forEach>
                            <br><br>
                            
                            <c:forEach items="${mailList}" var="m" >
                	  <c:if test="${ employee.idCode eq m.idCode }">
                	   <input type="hidden" name="userPass" style="width: 50%; background-color: #EFF8FB; border: solid 1px #E0ECF8;"
                            placeholder="발송비밀번호" class="form-control" readonly value="${m.userPass}" >
                            </c:if>
                            </c:forEach>
                	  
                        <input type="text" name="tomail" style="width: 50%"
                            placeholder="이메일을 입력해주세요" class="form-control"> ex : test@example.com
                            </div>
                     </div>
                     <br>
                     <div align="left">
                        <!-- 제목 -->
                        <input type="text" name="title" size="120" style="width: 50%"
                           placeholder="제목을 입력해주세요" class="form-control"> 
                     </div>
                     <br>
                     <div style="text-align: left;">
                        <!-- 내용 -->
                       
                        <div>
                        <textarea id="summernote" name="content" cols="500" rows="12"
                           style="width: 50%; resize: none" placeholder="내용"
                           class="form-control"></textarea>
                           </div>

                     </div>               
            		<br />
                     <div align="center">
                        <input type="submit" id="sendBtn" value="메일 보내기" class="btn btn-warning">
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


<script>
/* $(function() {
	
    $('sendBtn').on('click', function(){
        $('.summernote').append('textarea[name="content"]');
        $('#content').val($('.summernote').code());
        $('send').submit();
    })
}); */
$('#summernote').summernote({
    lang: 'ko-KR',
    placeholder: '내용을 입력하세요',
    tabsize: 2,
    height: 300
    
	 }); 
  
	var sendForm = function() {

    var content =  $('textarea[name="content"]').html($('#summernote').code());

}

</script>

</body>
<c:import url="../common/footer.jsp" />