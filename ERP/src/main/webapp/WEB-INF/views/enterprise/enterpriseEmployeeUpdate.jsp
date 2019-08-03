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
		
		<c:if test="${ empty employee && !empty enterprise }">
   		 <span>${enterprise.eName}</a> 님 의 정보</span>
   		 
   		 	<div id="enroll-container">
				<form method="post" action="enterpriseUpdate.do"
				      name="enterpriseEnrollFrm" onsubmit="return fn_enroll_validate();">
					<table>
						<tr>
							<th>기업 아이디</th>
							<td>
								<div id="userId-container">
									<input type="text" class="form-control" value="${enterprise.eId}" name="eId" id="eId" readonly>
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
							<input type="text" class="form-control" value="${enterprise.eName}" name="eName" id="eName" required>
							</td>
						</tr>
						<tr>
							<th>사업자번호</th>
							<td>	
							<input type="text" class="form-control" name="eNo" id="eNo" value="${enterprise.eNo }" readonly >
							</td>
						</tr>
				
						<tr>
							<th>기업 이메일</th>
							<td>	
								<input type="email" class="form-control" placeholder="erp@example.com" name="eEmail" id="eEmail"
									value="${enterprise.eEmail}" required>
							</td>
						</tr>
						
						<tr>
							<th>기업 주소</th>
							<td>	
								<input type="text" class="form-control" placeholder="" name="eAddress" id="eAddress"
								value="${enterprise.eAddress}" required>
							</td>
						</tr>
						
			
						<tr>
							<th>기업 연락처</th>
							<td>	
								<input type="tel" class="form-control" placeholder="(-없이)" name="ePhone" id="ePhone" maxlength="11" required
								value="${enterprise.ePhone }">
							</td>
						</tr>
						
			
						</tr>
					</table>
					<input id="idgo" type="submit" class="btn btn-primary" value="수정하기" >
			
				</form>
			</div>

   	</c:if> 

   	<script> 
 	
 			$('#ePwd2').blur(function(){
 				var p1 = $('#ePwd_').val(),
 				    p2 = $('#ePwd2').val();
 				if(p1 != p2){
 					alert("패스워드가 일치하지 않습니다.");
 					$('#ePwd_').focus().val("");
 					$('#ePwd2').val("");
 				}
 			});
 		
 	</script>
   	
 
  		 <c:if test="${ empty enterprise && !empty employee }">
  		 <span>${employee.wName}</a> 님 의  정보</span>
   		 <div id="enroll-container">
				<form method="post" action="employeeUpdate.do"
				      name="employeeEnrollFrm" onsubmit="return fn_enroll_validate();">
					<table>
						<tr>
							<th>사원 번호</th>
							<td>
								<div id="userId-container">
									<input type="text" class="form-control" value="${employee.idCode}" name="idCode" id="idCode" readonly>
				            	</div>
							</td>
						</tr> 
						<tr>
							<th>패스워드</th>
							<td>
								<input type="password" class="form-control" name="wPwd" id="wPwd_" required>
							</td>
						</tr>
						<tr>
							<th>패스워드확인</th>
							<td>	
								<input type="password" class="form-control" id="wPwd2" required>
							</td>
						</tr> 
						<tr>
							<th>사원명</th>
							<td>	
							<input type="text" class="form-control" value="${employee.wName}" name="wName" id="wName" required>
							</td>
						</tr>
						<tr>
							<th>부서명</th>
							<td>	
							<input type="text" class="form-control" value="${employee.dTitle}" name="dTitle" id="dTitle" readonly>
							</td>
						</tr>
						<tr>
							<th>직급</th>
							<td>	
							<input type="text" class="form-control" name="position" id="position" value="${employee.position }" readonly >
							</td>
						</tr>
						
						<tr>
							<th>입사일</th>
							<td>	
								<input type="text" class="form-control" name="enrollDate" id="enrollDate"
								value="${employee.enrollDate}" readonly>
							</td>
						</tr>

						</tr>
					</table>
					<input id="idgo" type="submit" class="btn btn-primary" value="수정하기" >
			
				</form>
			</div>
 
   		 
    	</c:if>
		
   	<script> 
 	
 			$('#wPwd2').blur(function(){
 				var p1 = $('#wPwd_').val(),
 				    p2 = $('#wPwd2').val();
 				if(p1 != p2){
 					alert("패스워드가 일치하지 않습니다.");
 					$('#wPwd_').focus().val("");
 					$('#wPwd2').val("");
 				}
 			});
 		
 	</script>
		
		
		
	
		
		</div>
	</div>

</body>
<c:import url="../common/footer.jsp" />