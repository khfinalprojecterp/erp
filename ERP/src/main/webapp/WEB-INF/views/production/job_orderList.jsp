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
											<th>수량</th>
											<th>창고명/위치</th>
											<th>신청일</th>
											<th>완료여부</th>
										</tr>
									</thead>
									<tbody>
										<!-- 데이터 -->
											<c:forEach items="${list}" var="jo" >
												<tr id="${jo.workcode}" class="${jo.workcode} ${jo.idCode} ${jo.pCode} ${jo.sCode}">
													<td>${jo.workcode}</td>
													<td>${jo.wName}</td>
													<td>${jo.pName}</td>
													<td>${jo.productea}</td>
													<td>${jo.SADDR}</td>
													<td>${jo.orderdate}</td>
													<td>${jo.jostatus}</td>
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
	<!-- 작업지시서 입력용 모달 -->
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
							<input type="text" class="form-control" id="name" value="${employee.wName}" readonly>
							<input type="hidden" class="form-control" id="idcode" value="${employee.idCode}" readonly>

						</div>

						<div class="form-group">
							<label for="message-text" class="col-form-label">물품 선택:</label>&nbsp;
							<select class="custom-select" id="pcode">
								<c:forEach items="${plist}" var="p" >
									<option value="${p.pCode}">${p.pName}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">수량:</label>
							<input type="text" class="form-control" id="insertproductea" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="9";>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고위치:</label>&nbsp;
							<select class="custom-select" id="insertsCode">
								<c:forEach items="${slist}" var="s" >
									<option value="${s.sCode}">${s.sname}</option>
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
	<!-- 작업지시서 수정/삭제용 모달 -->
	<div class="modal fade" id="updateJobOrder" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">작업지시서 수정/삭제</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<input type ="hidden" id="idCode" value="" />
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">지시번호</label>:
							<input type="text" class="form-control" id="workcode" value="${workcode}" readonly>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">담당사원명:</label>
							<input type="text" class="form-control" id="name" value="${employee.wName}" readonly>
							<input type="hidden" class="form-control" id="idcode" value="${employee.idCode}" readonly>
						</div>


						<div class="form-group">
							<label for="message-text" class="col-form-label">물품 선택:</label>&nbsp;
							<select class="custom-select" id="pCode">
								<c:forEach items="${plist}" var="p" >
									<option value="${p.pCode}">${p.pName}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">수량:</label>
							<input type="text" class="form-control" id="updateproductea" value="${productea}" readyonly>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고명/지역:</label>&nbsp;
							<select class="custom-select" id="upscode">
								<c:forEach items="${slist}" var="s" >
									<option value="${s.sCode}">${s.sname}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">완료여부</label>&nbsp;
							<select class="custom-select" id="jostatus">
									<option value="N">N</option>
									<option value="Y">Y</option>
							</select>
						</div>
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateJobOrder();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="deleteJobOrder();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function insertJoborder() {
			
			var idCode = $("#idcode").val();
			var pCode = $("#pcode").val();
			var productea = $("#insertproductea").val();
			var sCode = $("#insertsCode").val();
		
				location.href = "${pageContext.request.contextPath}/production/job_orderInsert.do?idcode="+
				idCode+"&pcode="+pCode+"&productea="+productea+"&sCode="+sCode;
			
		}
		
/* 		<tr id="${jo.workcode}" class="${jo.workcode} ${jo.idCode} ${jo.pCode}">
		<td>${jo.workcode}</td>
		<td>${jo.wName}</td>
		<td>${jo.pName}</td>
		<td>${jo.orderdate}</td>
		<td>${jo.jostatus}</td> */
		
		function updateJobOrder() {
			var beforeprice = 0;
			var afterprice = 0;
	 		var workcode = $("#workcode").val().trim();
	 		var idcode = $("#idcode").val().trim();
	 		var pcode = $("#pCode").val().trim();
	 		var productea = $("#updateproductea").val().trim();
	 		var sCode = $("#upscode").val().trim();
			var jostatus = $("#jostatus").val().trim();

			alert(sCode);
			if(jostatus == "Y"){
				beforeprice= prompt("생산 단가를 입력하세요", "");
				afterprice = prompt("판매 단가를 입력하세요", "");
			}

			if(productea=="") {productea=0;}
				location.href = "${pageContext.request.contextPath}/production/job_orderupdate.do?workcode="
					+workcode+"&idcode="+idcode+"&pCode="+pcode+"&productea="+productea+"&sCode="+sCode+"&jostatus="+jostatus
					+"&beforeprice="+beforeprice+"&afterprice="+afterprice;
		 	 
		}
		
		
		function deleteJobOrder() {
			var workcode = $("#workcode").val();
			location.href = "${pageContext.request.contextPath}/production/job_orderdelete.do?workcode="+ workcode;
		}
		

		
		

/* 		<td>${jo.workcode}</td>
		<td>${jo.wName}</td>
		<td>${jo.pName}</td>
		<td>${jo.productea}</td>
		<td>${jo.sCode}</td>
		<td>${jo.orderdate}</td>
		<td>${jo.jostatus}</td> */
		
		$("#dataTables-example td").each(function(){
			$(this).click(function(){
				
	 			var workcode = $(this).parent().attr('class').split(' ')[0];
	 			var idCode = $(this).parent().attr('class').split(' ')[1];
	 			var pCode = $(this).parent().attr('class').split(' ')[2];
	 			var sCode = $(this).parent().attr('class').split(' ')[3];
	 			document.getElementById("workcode").value = workcode;
	 			document.getElementById("idCode").value = idCode;
	 			document.getElementById("pCode").value = pCode;
	 			// alert($(this).parent().children().eq(2).text());
	 			document.getElementById("workcode").value = $(this).parent().children().eq(0).text();
	 			document.getElementById("idCode").value = $(this).parent().children().eq(1).text();
	 			document.getElementById("pCode").value = pCode;
	 			document.getElementById("updateproductea").value = $(this).parent().children().eq(3).text();
	 			document.getElementById("upscode").value= sCode;
	 			document.getElementById("jostatus").value = $(this).parent().children().eq(6).text();
				
	 			$("#updateJobOrder").modal();
			});
		});
	</script>
</body>
<c:import url="../common/footer.jsp" />