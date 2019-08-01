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
						<div class="panel-heading">기자재 조회
							<button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertMaterials">
  							기자재 추가</button>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>기자재 번호</th>
											<th>기자재 분류</th>
											<th>기자재 이름</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="m" >
											<tr id="${m.mCode}" class="${m.mCate}">
												<td>${m.mCode}</td>
												<td>${m.mcName}</td>
												<td>${m.mName}</td>
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
	<!-- 기자재 추가용 모달 -->
	<div class="modal fade" id="insertMaterials" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">기자재 추가</h5>
				</div>
				<div class="modal-body">
					<form>
						<!-- 부트 스트랩 버전이 안맞는듯? -->
						<div class="form-group">
							<label for="message-text" class="col-form-label">추가할 기자재 분류:</label><br>
							<select class="custom-select" id="selectcate">
								<option selected>분류를 선택하세요</option>
								<c:forEach items="${calist}" var="ca" >
									<option value="${ca.mCate}">${ca.mcName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">추가할 기자재 이름:</label>
							<input type="text" class="form-control" id="newMate">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="newMate();">추가하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 기자재 수정/삭제용 모달 -->
	<div class="modal fade" id="updateMaterial" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">기자재 수정/삭제</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
            				<label for="recipient-name" class="col-form-label">분류 번호:</label>
            				<input type="text" class="form-control" id="MateNum" readonly>
          				</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">변경할 기자재 분류:</label><br>
							<select class="custom-select" id="selectcatego">
								<c:forEach items="${calist}" var="ca" >
									<option value="${ca.mCate}">${ca.mcName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">변경할 기자재 이름:</label>
							<input type="text" class="form-control" id="Matenam">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateMate();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="delMate();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>		
		
		function newMate() {
			var mName = $("#newMate").val();
			var mCate = $("#selectcate").val();
			location.href = "${pageContext.request.contextPath}/materialscate/mateInsert.do?mName="+mName
					+"&mCate="+mCate;

		}
		
		function updateMate() {
			var mCode = $("#MateNum").val();
			var mName = $("#Matenam").val();
			var mCate = $("#selectcatego").val();
			location.href = "${pageContext.request.contextPath}/materialscate/mateUpdate.do?mName="+mName
			+"&mCate="+mCate + "&mCode="+mCode;
		}
		
		function delMate() {
			var mCode = $("#MateNum").val();
			location.href = "${pageContext.request.contextPath}/materialscate/mateDelete.do?mCode="+mCode;
		}
		
		
		$("#dataTables-example td").each(function(){
			$(this).click(function(){
					var mCate = $(this).parent().attr('class').split(' ')[0];
					document.getElementById("MateNum").value = $(this).parent().children().eq(0).text();
					document.getElementById("selectcatego").value = mCate;
					document.getElementById("Matenam").value = $(this).parent().children().eq(2).text();
					$("#updateMaterial").modal();
			});
		});
	</script>
</body>
<c:import url="../common/footer.jsp" />