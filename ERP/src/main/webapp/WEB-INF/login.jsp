<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>

.wrapper {    
	margin-top: 80px;
	margin-bottom: 20px;
}

.form-signin {
  max-width: 420px;
  padding: 30px 38px 66px;
  margin: 0 auto;
  background-color: #eee;
  border: 3px dotted rgba(0,0,0,0.1);  
  }

.form-signin-heading {
  text-align:center;
  margin-bottom: 30px;
}

.form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
}

input[type="text"] {
  margin-bottom: 0px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}

input[type="password"] {
  margin-bottom: 20px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.colorgraph {
  height: 7px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}

</style>



<title>Insert title here</title>
</head>
<body>

<!------ Include the above in your HEAD tag ---------->

<div class = "container">
	<div class="wrapper">
		<form id="loginFrm" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  	<div class="form-check form-check-inline">
						<input type="radio" class="form-check-input" name="logintype" id="logintype0" value="0">
						<label for="logintype0">사원</label>
						<input type="radio" class="form-check-input" name="logintype" id="logintype1" value="1" checked="checked">
						<label for="logintype1">기업</label>
					</div>
			  
			  
			 <input type="text" class="form-control" id="userId" name="userId" placeholder="사번/아이디" required>
			  <input type="password" class="form-control" name="userPwd" placeholder="비밀번호" required>  
			 
			 
			 
			 
			  <button type="button" onclick="memberlogin();" class="btn btn-outline-success">로그인</button>
			  
			  <button type="button" onclick="memberEnroll();" class="btn btn-outline-success">회원가입</button>
		</form>			
	</div>
</div>


<script>

	
	function memberEnroll(){

		location.href='${pageContext.request.contextPath}/enterprise/enterpriseEnroll.do';		
	}

		function memberlogin(){
			
		
			if($("input[name=logintype]:checked").val() == "0"){
	         
				var check =$("#userId").val();
				
				
				if(isNaN(check))
				{ 
					alert("사원번호는 문자가 아닙니다."); $("#userId").focus(); return false; 
				};
				

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







</body>
</html>