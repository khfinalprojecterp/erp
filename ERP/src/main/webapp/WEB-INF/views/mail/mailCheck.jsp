<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script
	src="https://github.com/summernote/summernote/tree/master/lang/summernote-ko-KR.js"></script>


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
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12" style="text-align: center;">
					<div class="col-md-2"></div>
					<div class="col-md-8"
						style="background-color: #EFF8FB; border-radius: 50px; border: solid 3px #E0ECF8;">
						<form id="mailCheckForm"
							action="${pageContext.request.contextPath}/mail/mailInsert.do"
							method="post" enctype="multipart/form-data">
							<div>
								<div align="left">
									<br /> <label for="message-text" class="col-form-label"
										style="font-size: xx-large;">메일 인증</label> <br>
										<input type="hidden" class="form-control" name="idCode" id="idCode" value="${employee.idCode}">

									<br> <input type="text" name="userMail" id="userMail" style="width: 50%"
										placeholder="naverId" class="form-control"> ex : example O , example@naver.com X
										<br>
										<input type="password" name="userPass" id="userPass" style="width: 50%"
										placeholder="naverPassword" class="form-control">
										
										<br>
										
										
										<input type="text" name="mail_take" id="mail_take" class="form-control" style="width: 15%">
										<br>
										<input type="button" class="btn btn-primary" value="인증번호 발송" id="mailCheck">
										<br><br>
										<input type="button" class="btn btn-primary" value="인증번호 확인" id="mailCheck2" onclick="checkCode();">
								</div>
							</div>
							<br>
							<div align="left">
								<!-- 제목 -->
								<input type="hidden" name="title" id="title"readonly class="form-control" value="erp 이메일 인증번호 입니다.">
							</div>
							<br>

								<!-- 내용 -->
							<input type="hidden" name="content" id="num" readonly
									class="form-control" value="<%=getRandom()%>">

							<br />
							<div align="center">
								<input type="submit" id="Check" value="메일 등록" class="btn btn-warning" disabled="true">
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
		<%!public int getRandom() {
			int random = 0;
			random = (int) Math.floor((Math.random() * (999999 - 100000 + 1))) + 100000;
			return random;
		}%>
		
		
		function checkCode(){
		     var v1 = $("#num").val();
		     var v2 =  $("#mail_take").val();
		     if(v1!=v2){

		        alert("잘못된 인증번호입니다.");
		     
		     }else{

		        alert("인증이 확인되었습니다.");
		         
		        $("#Check").attr("disabled",false);
		        $("#mailCheck2").attr("disabled",true).text('인증 완료!').css({
		           border : "gray",
		           background : "gray",
		           color : "white"
		        });
		      
		        $("#mailCheck").attr("disabled",true).css({
		           border : "gray",
		           background : "gray",
		           color : "white"
		        });;
		        
		        
		     }
		    }
		
		
		
		$('#mailCheck').click(function() {

	         var checkCode = $('#num').val();

	         var email = $('#userMail').val()+"@naver.com";
	         
	         var title = $('#title').val();
	         

	         console.log(email);

	         $.ajax({
	            url : "${pageContext.request.contextPath}/mail/mailCk.do",
	            type : "post",
	            data : {
	               tomail : email,
	               content : checkCode,
	               title : title
	            },
	            complete : function(data) {
	               alert("이메일 인증번호가 발송되었습니다.");
	            },
	            success : function(data) {

	            }

	         });

	      });
		
		/* $('#Check').click(function() {
			var userMail = $('#userMail').val() + "@naver.com";
			var userPass = $('#userPass').val();
			var idCode = $('#idCode').val();
			
			$('#mailCheckForm').attr("action","${pageContext.request.contextPath}/mail/mailInsert.do");
			$('#mailCheckForm').attr("method", "post");
			$('#mailCheckForm').submit();
		} */
		
	</script>

</body>
<c:import url="../common/footer.jsp" />