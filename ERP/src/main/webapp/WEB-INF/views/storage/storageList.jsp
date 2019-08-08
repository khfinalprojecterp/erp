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
						<div class="panel-heading">창고 조회
							<button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertStorage">
  							창고 추가</button>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>창고 번호</th>
											<th>기업명</th> <!-- 이름으로 변경 -->
											<th>담당사원명</th> <!-- 이름으로 변경 -->
											<th>구분</th>
											<th>창고연락처</th>
											<th>창고주소</th>
											<th>사용여부</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="s" >
											<c:if test="${empty enterprise}">
												<c:if test="${s.eCode eq employee.eCode }">
													<tr id="${s.sCode}" class="${s.eCode} ${s.idCode}">
														<td>${s.sCode}</td>
														<td>${s.sEname}</td>
														<td>${s.sWname}</td>
														<td>${s.sCate}</td>
														<td>${s.sPhone}</td>
														<td>${s.sAddr}</td>
														<td>${s.sStatus}</td>
													</tr>
												</c:if>
											</c:if>
											<c:if test="${empty employee }">
												<c:if test="${s.eCode eq enterprise.eCode }">
													<tr id="${s.sCode}" class="${s.eCode} ${s.idCode}">
														<td>${s.sCode}</td>
														<td>${s.sEname}</td>
														<td>${s.sWname}</td>
														<td>${s.sCate}</td>
														<td>${s.sPhone}</td>
														<td>${s.sAddr}</td>
														<td>${s.sStatus}</td>
													</tr>												
												</c:if>
											</c:if>

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
	<div class="modal fade" id="insertStorage" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">창고 추가</h5>
				</div>
				<div class="modal-body">
					<form>
						<c:if test="${empty enterprise}">
							<input type="hidden" class="form-control" id="neweCode" value="${employee.eCode }">
							<input type="hidden" class="form-control" id="newidCode" value="${employee.idCode }">
							<div class="form-group">
								<label for="message-text" class="col-form-label">기업 이름:</label>
								<input type="text" class="form-control" id="neweCoderealName" value="${employee.eName}" readonly>
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">담당사원 이름:</label>
								<input type="text" class="form-control" id="newidCoderealName" value="${employee.wName}" readonly>
							</div>
						</c:if>
						<c:if test="${empty employee }">
							<input type="hidden" class="form-control" id="neweCodeET" value="${enterprise.eCode }">
							<div class="form-group">
								<label for="message-text" class="col-form-label">기업 이름:</label>
								<input type="text" class="form-control" id="neweCoderealNameET" value="${enterprise.eName}" readonly>
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">담당사원 이름:</label>
								<select class="custom-select" id="newidCodeET">
									<c:forEach items="${memberlist}" var="member" >
										<option value="${member.idCode}">${member.sWname}</option>
									</c:forEach>
								</select>
							</div>
						</c:if>
						<div class="form-group">
							<label for="message-text" class="col-form-label">구분:</label>
							<input type="text" class="form-control" id="newsCate">
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고연락처: </label>
							<input type="text" class="form-control" id="newsPhone">
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고주소:</label>
							<input type="text" class="form-control" id="newsAddr">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="newStorage();">추가하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 창고 수정/삭제용 모달 -->
	<div class="modal fade" id="updateStorage" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">기자재 수정/삭제</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<input type ="hidden" id="upseCode" value="" />
							<input type ="hidden" id="upidCode" value="" />
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고 번호:</label>
							<input type="text" class="form-control" id="upsCode" readonly>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">기업 이름:</label>
							<input type="text" class="form-control" id="upeName" readonly>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">담당사원 이름:</label>
							<input type="text" class="form-control" id="upwName" readonly>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">구분:</label>
							<input type="text" class="form-control" id="upsCate">
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고연락처: </label>
							<input type="text" class="form-control" id="upsPhone">
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고주소:</label>
							<input type="text" class="form-control" id="upsAddr">
						</div>
						<div class="form-group">
							<label for="check" class="col-form-label">사용여부:</label>&nbsp;
						        <input type = "radio" name = "check" id="radioY" value = "Y">사용
						        <input type = "radio" name = "check" id="radioN" value = "N">미사용
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateStorage();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="delStorage();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		
		function newStorage() {
			if ($("#neweCode").val() ==null) {
				var eCode = $("#neweCodeET").val();
				var idCode = $("#newidCodeET").val();
			} else {
				var eCode = $("#neweCode").val();
				var idCode = $("#newidCode").val();
			}

			var sCate = $("#newsCate").val();
			var sPhone = $("#newsPhone").val();
			var sAddr = $("#newsAddr").val();
			location.href = "${pageContext.request.contextPath}/storage/storageInsert.do?eCode="+eCode
					+"&idCode="+idCode+"&sCate="+sCate+"&sPhone="+sPhone+"&sAddr="+sAddr;

		}
		
		function updateStorage() {
			var eCode = $("#upseCode").val();
			var idCode = $("#upidCode").val();
			var sCode = $("#upsCode").val();
			var sCate = $("#upsCate").val();
			var sPhone = $("#upsPhone").val();
			var sAddr = $("#upsAddr").val();
			var radiocheck = document.getElementsByName('check');
			var sStatus; // 여기에 선택된 radio 버튼의 값이 담기게 된다.
			for(var i=0; i<radiocheck.length; i++) {
			    if(radiocheck[i].checked) {
			    	sStatus = radiocheck[i].value;
			    }
			}
			location.href = "${pageContext.request.contextPath}/storage/storageUpdate.do?eCode="+eCode
				+"&idCode="+idCode +"&sCode="+sCode +"&sCate="+sCate +"&sPhone="+sPhone +"&sAddr="+sAddr+"&sStatus="+sStatus;
		}
		
		function delStorage() {
			var sCode = $("#upsCode").val();
			location.href = "${pageContext.request.contextPath}/storage/storageDelete.do?sCode="+sCode;
		}
		
		
		$("#dataTables-example td").each(function(){
			$(this).click(function(){
	 			var eCode = $(this).parent().attr('class').split(' ')[0];
	 			var idCode = $(this).parent().attr('class').split(' ')[1];
	 			document.getElementById("upseCode").value = eCode;
				document.getElementById("upidCode").value = idCode;
				document.getElementById("upsCode").value = $(this).parent().children().eq(0).text();
				document.getElementById("upeName").value = $(this).parent().children().eq(1).text();
				document.getElementById("upwName").value = $(this).parent().children().eq(2).text();
				document.getElementById("upsCate").value = $(this).parent().children().eq(3).text();
				document.getElementById("upsPhone").value = $(this).parent().children().eq(4).text();
				document.getElementById("upsAddr").value = $(this).parent().children().eq(5).text();
				if($(this).parent().children().eq(6).text() == 'Y') {
					$("#radioY").prop("checked", true)
				}
				if($(this).parent().children().eq(6).text() == 'N') {
					$("#radioN").prop("checked", true)
				}
				$("#updateStorage").modal();
			});
		});
	</script>
</body>
<c:import url="../common/footer.jsp" />