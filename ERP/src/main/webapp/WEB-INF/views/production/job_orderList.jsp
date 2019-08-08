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
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">작업지시서
							<button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertStorageDe">
  							작업지시서 입력</button>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>지시번호</th>
											<th>담당자</th>
											<th>물품명</th>
											<th>신청일</th>
											<th>완료여부</th>
										</tr>
									</thead>
									<tbody>
										<!-- 기자재 / 물품 분류 -->
											<c:forEach items="${list}" var="jo" >
												<tr id="${jo.workcode}" class="${jo.workcode}">
													<td>${jo.workcode}</td>
													<td>${jo.wname}</td>
													<td>${jo.pname}</td>
													<td>${jo.orderdate}</td>
													<td>${jo.wstatus}</td>
											</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!--End Advanced Tables -->
				</div>
			</div>
		</div>
	</div>
	<!-- 창고 추가용 모달 -->
	<div class="modal fade" id="insertStorageDe" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">작업지시서 입력</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="message-text" class="col-form-label">담당사원 이름:</label>
							<input type="text" class="form-control" id="newidCode" value="${employee.wName}" readonly>

						</div>

						<div class="form-group">
						
							<label for="message-text" class="col-form-label">물품 선택:</label>&nbsp;
							<select class="custom-select" id="selectP">
								<c:forEach items="${plist}" var="p" >
									<option value="${p.PCODE}">${p.PNAME}</option>
								</c:forEach>
							</select>
							
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="insertJoborder();">추가하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 창고 수정/삭제용 모달 -->
	<div class="modal fade" id="updateStorageDe" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">기자재 수정/삭제</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<input type ="hidden" id="upsdCode" value="" />
							<input type ="hidden" id="upeCode" value="" />
							<input type ="hidden" id="upidCode" value="" />
							
						</div>
						<label for="message-text" class="col-form-label">창고 선택:</label>&nbsp;
						<select class="custom-select" id="selectstorageDe">
							<c:forEach items="${slist}" var="s" >
								<option value="${s.sCode}">${s.sAddr}</option>
							</c:forEach>
						</select>
						<div class="form-group">
							<label for="message-text" class="col-form-label">기업 이름:</label>
							<input type="text" class="form-control" id="updeCode" value="" readonly>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">담당사원 이름:</label>
							<input type="text" class="form-control" id="upeidCode" value="" readonly>
						</div>

						<!-- <div class="form-group">
							<label for="message-text" class="col-form-label">기업 이름:</label>
							<input type="text" class="form-control" id="neweCode" value="${enterprise.eName}" readonly>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">담당사원 이름:</label>
							<input type="text" class="form-control" id="newidCode" value="${employee.wName}" readonly>
						</div>  -->

						<div class="form-group">
							<label for="message-text" class="col-form-label">담당자</label>
							<input type="text" class="form-control" id="newidCoderealName" value="${employee.wName}" readonly>
							
							<label for="message-text" class="col-form-label">물품 선택:</label>
							<select class="custom-select" id="selectProduct">
								<c:forEach items="${plist}" var="p" >
									<option value="${p.pcode}">${p.pname}</option>
								</c:forEach>
							</select>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateJoborder();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="deleteJoborder();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>
    private int workcode;
    private int idcode; // FK_사원번호
    private int pcode; // FK_물품코드
    private Date orderdate;
    private char jostatus;
    
    // 임시변수 
    private String wname;
    private String pname; 
    
		function insertJoborder() {
			var workcode = $("#workcode").val();
			var idCode = $("#idcode").val();
			var pcode = $("#pcode").val();
			var orderdate = $("#orderdate").val();
			var sdPrice = $("#newsdprice").val();
			
			if($("input:radio[name=checkP]:checked").val()=='Ma'){
				var mCode = $("#selectM").val();
				var pCode = "null";
				location.href = "${pageContext.request.contextPath}/storage/storageDetailInsert.do?sCode="+sCode
				+"&eCode="+eCode+"&idCode="+idCode+"&mCode="+mCode+"&sdStock="+sdStock
				+"&sdCost="+sdCost+"&sdPrice="+sdPrice;
		    }else{
		    	var mCode = "null";
				var pCode = $("#selectP").val();
				location.href = "${pageContext.request.contextPath}/storage/storageDetailInsert.do?sCode="+sCode
				+"&eCode="+eCode+"&idCode="+idCode+"&pCode="+pCode+"&sdStock="+sdStock
				+"&sdCost="+sdCost+"&sdPrice="+sdPrice;
		    }
			
		}
		
		function updateJoborder() {
			var sdCode = $("#upsdCode").val();
			var idCode = $("#upidCode").val();
			var eCode = $("#upeCode").val();
			var sCode = $("#selectstorageDe").val();
			var sdStock = $("#upsdstock").val();
			var sdCost = $("#upsdcost").val();
			var sdPrice = $("#upsdprice").val();
			if($("input:radio[name=upcheckP]:checked").val()=='Ma'){
				var mCode = $("#upselectM").val();
				var pCode = "null";
				location.href = "${pageContext.request.contextPath}/storage/storageDetailUpdate.do?sdCode="+sdCode
				+"&eCode="+eCode+"&idCode="+idCode+"&mCode="+mCode+"&sdStock="+sdStock+"&sCode="+sCode
				+"&sdCost="+sdCost+"&sdPrice="+sdPrice;
		    }else{
		    	var mCode = "null";
				var pCode = $("#upselectP").val();
				location.href = "${pageContext.request.contextPath}/storage/storageDetailUpdate.do?sdCode="+sdCode
				+"&eCode="+eCode+"&idCode="+idCode+"&pCode="+pCode+"&sdStock="+sdStock+"&sCode="+sCode
				+"&sdCost="+sdCost+"&sdPrice="+sdPrice;
		    }		
		}
		
		
		function deleteJoborder() {
			var sdCode = $("#upsdCode").val();
			location.href = "${pageContext.request.contextPath}/storage/storageDetailDelete.do?sdCode="+sdCode;
		}
		

		
		
		
		$("#dataTables-example td").each(function(){
			$(this).click(function(){
				
	 			var sdCode = $(this).parent().attr('class').split(' ')[0];
	 			var eCode = $(this).parent().attr('class').split(' ')[1];
	 			var upidCode = $(this).parent().attr('class').split(' ')[2];
	 			document.getElementById("upsdCode").value = sdCode;
	 			document.getElementById("upeCode").value = eCode;
	 			document.getElementById("upidCode").value = upidCode;
	 			document.getElementById("selectstorageDe").value = $(this).parent().children().eq(0).text();
	 			document.getElementById("updeCode").value = $(this).parent().children().eq(1).text();
				document.getElementById("upeidCode").value = $(this).parent().children().eq(2).text();
				if($(this).parent().children().eq(3).text() == "물품") {
					$("#UradioP").prop("checked", true)
					$( "#upselectP" ).show();
                	$( "#upselectM" ).hide();
					document.getElementById("upselectP").value = $(this).parent().attr('class').split(' ')[3];
					
				}
				if($(this).parent().children().eq(3).text() == "기자재") {
					$("#UradioM").prop("checked", true)
					$( "#upselectM" ).show();
                	$( "#upselectP" ).hide();
					document.getElementById("upselectM").value = $(this).parent().attr('class').split(' ')[3];
				}
				document.getElementById("upsdstock").value = $(this).parent().children().eq(6).text();
				document.getElementById("upsdcost").value = $(this).parent().children().eq(7).text();
				document.getElementById("upsdprice").value = $(this).parent().children().eq(8).text();
				$("#updateStorageDe").modal();
			});
		});
	</script>
</body>
<c:import url="../common/footer.jsp" />