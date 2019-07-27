<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
	<title>매입 조회</title>
<body>
	<c:import url="../common/nav.jsp" />
	<div id="page-wrapper">
		<c:import url="../common/bodyNav.jsp" />
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">구매 조회
							<button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertBuyItem">
  							기자재 분류 추가</button>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>구매코드</th>
											<th>창고코드</th>
											<th>기자재코드</th>
											<th>물품코드</th>
											<th>사원코드</th>
											<th>수량</th>
											<th>원가</th>
											<th>매입가</th>
											<th>할인율</th>
											<th>처리상태</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="b" > 
											<tr id="${b.buy_code}">
												<td>${b.buy_code}</td>
												<td>${b.sCode}</td>
												<td>${b.mCode}</td>
												<td>${b.pCode}</td>
												<td>${b.idCode}</td>
												<td>${b.buy_amount}</td>
												<td>${b.buy_origin}</td>
												<td>${b.buy_price}</td>
												<td>${b.buy_discount}</td>
												<td>${b.buy_status}</td>
											</tr>
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
	
	<!-- Insert 모달 -->
	<div class="modal fade" id="insertBuyItem" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">구매 추가</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고 번호:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">기자재/물품 코드:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">사원 코드:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">수량:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">원가:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">매입가:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">처리상태:</label>
							<input type="text" class="form-control" id="newCate">
							
							<label for="message-text" class="col-form-label">할인율:</label>
							<input type="text" class="form-control" id="newCate">

							
							
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="newMateCate();">추가하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 기자재 수정/삭제용 모달 -->
	<div class="modal fade" id="updateMaterialscate" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">구매 수정/삭제</h5>

				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
            				<label for="recipient-name" class="col-form-label">분류 번호:</label>
            				<input type="text" class="form-control" id="CateNum" readonly>
          				</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">분류 이름:</label>
							<input type="text" class="form-control" id="CateName">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateMateCate();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="delMateCate();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>		
		
		function newMateCate() {
			var mcName = $("#newCate").val();
			location.href = "${pageContext.request.contextPath}/buy/buy_insert.do?buy_code="+buy_code;
			//연결
		}
		
		function updateMateCate() {
			var mCate = $("#CateNum").val();
			var mcName = $("#CateName").val();
			location.href = "${pageContext.request.contextPath}/materialscate/mateCateUpdate.do?buy_code="+buy_code
					+"&mCate="+mCate;
			
			//연결
		}
		
		function delMateCate() {
			var mCate = $("#CateNum").val();
			var mcName = $("#CateName").val();
			location.href = "${pageContext.request.contextPath}/materialscate/mateCateDelete.do?mcName="+mcName
					+"&mCate="+mCate;
			//연결
		}
		
		
		$("#dataTables-example td").click(
				function() {
					var mCate = $(this).value;
					document.getElementById("CateNum").value = $(this).parent().children().eq(0).text();
					document.getElementById("CateName").value = $(this).parent().children().eq(1).text();
					$("#updateMaterialscate").modal();
				});
	</script>
</body>
<c:import url="../common/footer.jsp" />