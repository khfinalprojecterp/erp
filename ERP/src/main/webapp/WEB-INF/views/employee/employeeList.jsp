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
		
		<b>사원추가(기업아이디로만가능 사원사용불가)</b>
		
		<form method="post" action="insertEmployee.do">
<table>
						
			
		<tr>
		<th>사원코드(사번/사원ID)</th>
		<td>	
		<input type="text" class="form-control" placeholder="사원코드(숫자만)" name="idCode" id="idCode" required>
		</td>
		</tr>	
			
			
		<tr>
		<th>부서 선택</th>	
		<td>			
	<select name="dCode">
 			<c:forEach var="depart" items="${Dlist}">
			<c:if test="${ enterprise.eCode eq depart.eCode }">
				<option value="${depart.dCode}">${depart.dTitle }</option>	
			</c:if>
			</c:forEach>   
  	</select>
					</td>
					</tr>	
						<tr>
							<th>비밀번호</th>
							<td>	
							<input type="password" class="form-control" placeholder="비밀번호" name="wPwd" id="wPwd" required>
							</td>
						</tr>
						<tr>
							<th>사원명</th>
							<td>	
							<input type="text" class="form-control" placeholder="사원명" name="wName" id="wName" required>
							</td>
						</tr>
					<tr>
							<th>직급</th>
							<td>	
					
							<select name="position">

					<option value="사원">사원</option>
					<option value="주임">주임</option>
					<option value="대리">대리</option>
					<option value="과장">과장</option>
					<option value="차장">차장</option>
					<option value="부장">부장</option>
					<option value="이사">이사</option>
					
							  	</select>
							</td>
						</tr>
					<tr>
							<th>입사일</th>
							<td>	
							<input type="date" class="form-control" placeholder="현재 default-sys" name="enrollDate" id="enrollDate" >
							</td>
						</tr>
						
						<tr>
							<th>재직여부</th>
						<td>
						
								<select name="wStatus">
					<option value="Y">Y</option>
					<option value="N">N</option>
			
					
							  	</select>
							  	
							</td>  	 	
						</tr>		
					<tr>
							<th>퇴사일</th>
							<td>	
							<input type="date" class="form-control" placeholder="퇴사일 현재디폴트처리" name="retireDate" id="retireDate" >
							</td>
						</tr>
				
					</table>
					<input type="submit" class="btn btn-outline-success" value="사원등록" >
				</form>
		
		
		</div>
	</div>

</body>
<c:import url="../common/footer.jsp" />