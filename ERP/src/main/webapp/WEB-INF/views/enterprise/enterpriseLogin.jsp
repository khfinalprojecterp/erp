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
		
		
		
		
	 <form id="loginFrm" method="post">
	      
	      <tr>
		<th>로그인 구분</th>
		<th>사원일경우 아이디 숫자만(사원코드 학번개념)<th>
							<td>
							<br><br><br>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" name="logintype" id="logintype0" value="0">
									<label for="logintype0">사원</label>
									<input type="radio" class="form-check-input" name="logintype" id="logintype1" value="1" checked="checked">
									<label for="logintype1">기업</label>
								</div>
							</td>
						</tr>
	      <div >
			  <input type="text" class="form-control" id="userId" name="userId" placeholder="아이디" required>
			    <br />
			    <input type="password" class="form-control" name="userPwd" placeholder="비밀번호" required>
	      </div>
	        <button type="button" onclick="memberlogin();" class="btn btn-outline-success">로그인</button>
		</form>
	
		
		
		<script>


				

 		
		
		function memberlogin(){
			
		
			if($("input[name=logintype]:checked").val() == "0"){
	         
				
			    $('#loginFrm').attr("action","${pageContext.request.contextPath}/employee/employeeLoginEnd.do");
				$('#loginFrm').attr("method", "post");
				$('#loginFrm').submit();
	
	        }else if($("input[name=logintype]:checked").val() == "1"){
	           
	        $('#loginFrm').attr("action","${pageContext.request.contextPath}/enterprise/enterpriseLoginEnd.do");
			$('#loginFrm').attr("method", "post");
			$('#loginFrm').submit();

	        }
	
		}

		</script>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		</div>
	</div>

</body>
<c:import url="../common/footer.jsp" />