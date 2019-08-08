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

	<br><br><br><br>

		<div id="enroll-container">
				<form method="post" action="enterpriseEnrollEnd.do"
				      name="enterpriseEnrollFrm" onsubmit="return fn_enroll_validate();" class="form-signin">
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
							<input type="text" class="form-control" name="eNo" id="eNo" placeholder="(-없이)" maxlength="9" required>
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
					</table>
						<br>
					<div align="center">
					<input id="idgo" type="submit" class="btn btn-outline-success" value="가입하기" disabled>
					<input id="idreset" type="reset"  class="btn btn-outline-danger" value="리셋">
					</div>
				</form>
			</div>
			

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
 			
 			
 			
 			$('#eNo').blur(function(){
 			var check =$("#eNo").val();
			
			
			if(isNaN(check))
			{ 
				alert("사업자번호는 문자가 아닙니다."); $("#eNo").focus().val("");  
			};
 			
 			})
 		
 		
 		
 		
 		
 		
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
</html>