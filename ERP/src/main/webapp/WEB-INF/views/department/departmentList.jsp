<%@page import="com.kh.erp.enterprise.model.vo.Enterprise"%>
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
				<form method="get" action="insertDepart.do">
				
				<b>추가할 부서(기업아이디로만가능 사원사용불가)</b>
					<table>
						<tr>
							<th>추가할 부서 명</th>
							
							<td>
								<div id="userId-container">
									<input type="text" class="form-control" name="dTitle" id="dTitle" required>
				            	</div>
				            	<input type="hidden" class="form-control" name="eCode" id="eCode" value="${enterprise.eCode}"required>
							</td>
						</tr>
					</table>
					<input type="submit" class="btn btn-outline-success" value="부서추가" >
				</form>
			</div>
			
			
			<table class="table">
			<tr>
				<th scope="col">생성된 부서명</th>
			</tr>
			<c:forEach var="depart" items="${list}">
			<c:if test="${ enterprise.eCode eq depart.eCode }">
			<tr>
				<td>${depart.dTitle}</td>
			</tr>
			</c:if>
			</c:forEach>
		</table>
			
			
		<hr>
		<hr>
		<hr>
		<hr>
		
		
		<b>만들어진 부서 상세 설정 (현장/기자재/생산공장) 설정</b>
		<form method="get" action="insertField.do">
					<table>
						
			<input type="hidden" class="form-control" name="eCode" id="eCode" value="${enterprise.eCode}"required>		
		<tr>
		<th>부서 선택</th>
			
		<td>			
	<select name="dCode">
 			<c:forEach var="depart" items="${list}">
			<c:if test="${ enterprise.eCode eq depart.eCode }">
		
				<option value="${depart.dCode}">${depart.dTitle }</option>
			
			</c:if>
			</c:forEach>   
  	</select>
					</td>
					</tr>	
						<tr>
							<th>파트이름</th>
							<td>	
							<input type="text" class="form-control" placeholder="파트이름" name="fName" id="fName" required>
							</td>
						</tr>
						<tr>
							<th>지역</th>
							<td>	
							<input type="text" class="form-control" placeholder="지역" name="Area" id="Area" required>
							</td>
						</tr>
					
						<tr>
							<th>파트구분</th>
							<td>
							<br><br><br>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" name="fPart" id="fPart0" value="0">
									<label for="fPart0">현장</label>
									<input type="radio" class="form-check-input" name="fPart" id="fPart1" value="1">
									<label for="fPart1">기자재</label>
									<input type="radio" class="form-check-input" name="fPart" id="fPart2" value="2">
									<label for="fPart1">생산공장</label>
								</div>
							</td>
						</tr>
					</table>
					<input type="submit" class="btn btn-outline-success" value="파트등록" >
				</form>
		
		
		
		
		
		<table class="table">
			<tr>
				<th scope="col">생성된  부서 파트명</th>
			</tr>
			<c:forEach var="field" items="${flist}">
			<c:if test="${ enterprise.eCode eq field.eCode }">
			<tr>
				<td>${field.fName} ${field.fArea} ${field.fPart}</td>
			</tr>
			</c:if>
			</c:forEach>
		</table>
			
		
		
		
		
		
		
		
			
			
		
		</div>
	</div>
	
	

</body>
<c:import url="../common/footer.jsp" />