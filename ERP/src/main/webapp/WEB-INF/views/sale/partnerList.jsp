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
						<div class="panel-heading">거래처
							<button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertMaterialscate">
  							거래처 등록</button>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover col-md-12"
									id="dataTables-example" style="width: 100%;">
									<thead>
										<tr>
											<th>거래처명</th>
											<th>거래상태</th>
											<td style="display: none;"></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${partnerList}" var="L" > 
										<c:if test="${L.parSts.charAt(0).toString() eq 'T'}">
											<tr id="${L.partnerC}">
												<td>${L.parName}</td>
												<td>
												<p style="display: none;">${L.parSts.charAt(0).toString()}</p>
												<c:choose>
												<c:when test="${L.parSts.charAt(0).toString() eq 'T'}">거래중</c:when>
												<c:when test="${L.parSts.charAt(0).toString() eq 'S'}">거래중지</c:when>
												</c:choose>
												</td>
												<td style="display: none;">${L.partnerC}</td>
											</tr>
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
	
	<!-- 기자재 추가용 모달 -->
	<div class="modal fade" id="insertMaterialscate" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">거래처 이름으로 추가</h5>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="message-text" class="col-form-label">추가할 거래처명:</label>
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
					<h5 class="modal-title" id="exampleModalLabel">거래처 수정/삭제</h5>

				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
            				<label for="recipient-name" class="col-form-label">거래처명</label>
            				<input type="text" class="form-control" id="CateNum" >
          				</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">거래상태</label>
							<input type="text" class="form-control" id="CateName" readonly>
						</div>
						<div class="form-group" style="display: none;">
							<input type="text" class="form-control" id="CateC">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="changeNamePartner();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="callOffPartner();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>	
	var ecode;
	<c:if test="${empty employee}">
	ecode = "${enterprise.eCode}";
	</c:if>
	<c:if test="${empty enterprise}">
	ecode = "${employee.eCode}";
	</c:if>
		$("#sideNav").click(function(){
			var el = document.getElementById("dataTables-example");
				el.style.width="100%";
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'});
			}
		});
		
		function newMateCate() {
			var mcName = $("#newCate").val();
			location.href = "${pageContext.request.contextPath}/sale/insertPartner.do?partner="+mcName+"&ecode="+ecode;//ecode 수정필
			//연결
		}
		
		function callOffPartner() {
			var mCate = $("#CateNum").val();//거래처이름
			var mcName = $("#CateName").val();//거래상태
			var mCateC = $("#CateC").val();//거래처 코드
			location.href = "${pageContext.request.contextPath}/sale/callOffPartner.do?partner="+mCate+"&ecode="+ecode;
			
			//연결
		}
		
		function changeNamePartner() {
			var mCate = $("#CateNum").val();//거래처이름
			var mcName = $("#CateName").val();//거래상태
			var mCateC = $("#CateC").val();//거래처 코드
			location.href = "${pageContext.request.contextPath}/sale/changeNamePartner.do?partner="+mCate+"&ecode="+ecode+"&partnerC="+ mCateC;
			//연결
		}
		
		
		$("#dataTables-example td").click(
				function() {
					var mCate = $(this).value;
					document.getElementById("CateNum").value = $(this).parent().children().eq(0).text();
					if($(this).parent().children().eq(1).children().eq(0).text()=='T')
					document.getElementById("CateName").value = '거래중';
					document.getElementById("CateC").value = $(this).parent().children().eq(2).text();
					$("#updateMaterialscate").modal();
				});
	</script>
</body>
<c:import url="../common/footer.jsp" />