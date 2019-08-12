<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="https://github.com/summernote/summernote/tree/master/lang/summernote-ko-KR.js"></script>



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
            
               
                 
                
                      <label for="message-text" class="col-form-label" style="font-size:xx-large;">발송완료</label>
                	  <br><br>
                        
                     </div>
                     <br>
                     <div align="left">
                         <label for="message-text" class="col-form-label" style="font-size:medium;">
                         <a href="${pageContext.request.contextPath}/mailMit/mailMit.do">메일쓰기</a></label>
                     </div>
                     <br>
                     <div style="text-align: left;">
                        <!-- 내용 -->
                       
                         <label for="message-text" class="col-form-label" style="font-size:medium;">
                        <a href="${pageContext.request.contextPath}/mail/mailList.do">받은메일함</a></label>

                   		
                     

                     
                     <br />
                 <label for="message-text" class="col-form-label" style="font-size:medium;">
                        <a href="${pageContext.request.contextPath}/erp/">메인</a></label>
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