<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />

<body>

<c:import url="../common/nav.jsp" />
	<div id="page-wrapper">
		<c:import url="../common/bodyNav.jsp" />
		<div id="page-inner">
		
		<div id="enroll-container">
				<form method="post" action="enterpriseEnrollEnd.do"
				      name="enterpriseEnrollFrm" onsubmit="return fn_enroll_validate();">
					<table>
						<tr>
							<th>기업 아이디</th>
							<td>
								<div id="userId-container">
									<input type="text" class="form-control" placeholder="4글자이상" name="eId" id="eId" required>
									<input type="button" value="중복검사" id="idCheck">
				            	</div>
							</td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td>
								<input type="password" class="form-control" name="ePwd" id="ePwd_" required>
							</td>
						</tr>
						<tr>
							<th>패스워드확인</th>
							<td>	
								<input type="password" class="form-control" id="ePwd2" required>
							</td>
						</tr>  
						<tr>
							<th>기업명</th>
							<td>	
							<input type="text" class="form-control" name="eName" id="eName" required>
							</td>
						</tr>
						<tr>
							<th>사업자번호</th>
							<td>	
							<input type="text" class="form-control" name="eNo" id="eNo" placeholder="(-없이)" required>
							</td>
						</tr>
				
						<tr>
							<th>기업 이메일</th>
							<td>	
								<input type="email" class="form-control" placeholder="erp@example.com" name="eEmail" id="eEmail">
							</td>
						</tr>
						
						<tr>
							<th>기업 주소</th>
							<td>	
								<input type="text" class="form-control" placeholder="" name="eAddress" id="eAddress">
							</td>
						</tr>
						
			
						<tr>
							<th>기업 연락처</th>
							<td>	
								<input type="tel" class="form-control" placeholder="(-없이)" name="ePhone" id="ePhone" maxlength="11" required>
							</td>
						</tr>
						
			
						</tr>
					</table>
					<input id="idgo" type="submit" class="btn btn-outline-success" value="가입하기" disabled>
					<input id="idreset" type="reset"  class="btn btn-outline-danger" value="리셋">
				</form>
			</div>
			

 		<script> 
 	
 			$('#ePwd2').blur(function(){
 				var p1 = $('#ePwd_').val(),
 				    p2 = $('#ePwd2').val();
 				if(p1 != p2){
 					alert("패스워드가 일치하지 않습니다.");
 					$('#ePwd_').focus();
 				}
 			});
 		
 		
 		
 		
 		
 		
 		$('#idreset').click(function(){
 			
 			
 			$('#eId').attr("readonly",false);
 			$('#idgo').attr("disabled", true);
 			
 			
 		});
 		
 		
 		
  		  $('#idCheck').click(function() {
  		         $.ajax({
  		            url : "${pageContext.request.contextPath}/enterprise/checkIdDuplicate.do",
  		            type : "post",
  		            data : {
  		               eId : $('#eId').val()
  		            },	  
  		            success : function(data) {
  		                console.log(data);            
  		               if (data == 'ok' && $('#eId').val() != "") {
  		                  
  		            	   $('#idgo').attr("disabled", false);
  		            	   $('#eId').attr("readonly",true);
  		            	   alert("사용 가능한 아이디입니다.");

  		               } else {
  		                  alert("이미 사용 중인 ID와 공백은 사용 할 수 없는 ID 입니다."); 
  		             	  $('#idgo').attr("disabled", true);
  		                  $('#eId').select().val("");
  		                  
  		               } 
  		            },
  		            error : function(request, status, error) {
  		               console.log("------ ERROR ------");
  		               console.log(request);
  		               console.log(status);
  		               console.log(error);
  		               console.log("-------------------");
  		            }
  		         });
  	      });
  		</script>  

		
		</div>
	</div>


</body>
<c:import url="../common/footer.jsp" />