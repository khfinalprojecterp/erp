<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발주요청</title>
<c:import url="../common/header.jsp" />
<style>
div#demo-container {
	width: 50%;
	padding: 200px;
	margin:  auto;
	border: 1px solid lightgray;
	border-radius: 10px;
	color : white;



}
</style>
</head>
<body>
<div id="container">
		<c:import url="../common/nav.jsp" />
		<div id="demo-container">

			<form id="m_storage">
				<div class="form-group row">
					<label for="IDCODE" class="col-sm-2 col-form-label">사원코드:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="IDCODE"
							name="IDCODE">
					</div>
				</div>
				<div class="form-group row">
					<label for="MCODE" class="col-sm-2 col-form-label">기자재코드:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="MCODE"
							name="MCODE">
					</div>
				</div>
				<div class="form-group row">
					<label for="SCODE" class="col-sm-2 col-form-label">반출 창고 코드:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="SCODE"
							name="SCODE">
					</div>
				</div>
				<div class="form-group row">
					<label for="MSMSTOCK" class="col-sm-2 col-form-label">수량:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="MSMSTOCK"
							name="MSMSTOCK">
					</div>
				<div class="form-group row">
					<label for="MSDATE" class="col-sm-2 col-form-label">신청일</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="MSDATE"
							name="MSMSTOCK">
					</div>
				<div class="form-group row">
					<label for="MSPRICE" class="col-sm-2 col-form-label">납품원가</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="MSPRICE"
							name="MSMSTOCK">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label"></label>
					<div class="col-sm-10">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="MSSTATUS"
								id="MSSTATUS" value="A"> <label
								class="form-check-label" for="MSSTATUS0">신청</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="devGender"
								id="MSTATUS1" value="R"> <label
								class="form-check-label" for="MSTATUS1">거절</label>
					
						</div>
				<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="devGender"
								id="MSSTAUS2" value="C"> <label
								class="form-check-label" for="MSSTAUS2">완료</label>
					
						</div>
			</form>
			
			
			<!-- 전송 버튼 -->
			<div class="list-group">
				
				<button type="button" onclick="m_storage();"
				        class="list-group-item list-group-item-action">
					발주요청
				</button>
				
				
			</div>
			
			
		</div>
		<c:import url="../common/footer.jsp"/>
	</div>
	<script>
	
	function M_storage() {
		
		$('#m_storage').attr("action",
	     	"${pageContext.request.contextPath}/m_storage/M_storageList.do");
		$('#m_storage').submit();
	}
	function insertM_storage(){
		
		if( validation() != true) return;
		
		$('#m_storage').attr("action",
     		"${pageContext.request.contextPath}/m_storage/insertM_storage.do");
		$('#m_storage').attr("method", "post");
		$('#m_storage').submit();
	}
	
	// 유효성 검사 함수
	function validation(){
		// 클라이언트 레벨의 유효성 검사
		
		// form 안에 작성 된 내용을 확인하여
		// 작성이 되어 있지 않으면 false를 반환하는 함수
		
		var result = true;
		
		if($("#IDCODE").val().trim().length == 0){
			alert("코드를 입력해주세요!");
			result = false;
		}
		
		if($("#MCODE").val().trim().length == 0){
			alert("코드를 입력해주세요!!");
			result = false;
		}
		
		
		
		return result;
	}
</script>
</body>
</html>