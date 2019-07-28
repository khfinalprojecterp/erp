<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />

<body>
	<c:import url="../common/nav.jsp" />
	<div id="page-wrapper">
		<c:import url="../common/bodyNavitemList.jsp" />
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
				
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading"> <br /> &nbsp;판매</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
									<!-- 거래처partner와 판매직원employee은 별도 INPUT으로 하나만 선택  -->
										<tr>
											<th>물품명</th>
											<th>창고 주소지</th>
											<th>주소지 연락처</th>
											<th>생산/구매가</th>
											<th>입고일</th>
											<th>갯수</th>
											<th>판매가</th>
											<th>수량 선택</th>
											<th>판매 선택</th>
											<th style="display: none;"></th><!--9번째-->
										</tr>
									</thead>
									
									<tbody>
										<c:forEach items="${storageDetailList}" var="L" varStatus="status"> 
											 <tr>
												<td>${L.pName}</td>
												<td>${storageList[L.sCode-1].sAddr}</td>
												<td>${storageList[L.sCode-1].sPhone}</td>
												<td>${L.sdCost}</td>
												<td>${L.sdDate}</td>
												<td>${L.sdStock}</td>
												<td><input type="number" min="1" placeholder="판매가 입력"/></td>
												<td><select>
													<c:forEach var="i" begin="0" end="${L.sdStock}">
													<option value="${ i }">${ i }</option>
													</c:forEach>
												</select></td>
												<td><input type="checkbox" name="chk_std" id="chk_sale" value="${status.index}"></td>
												<td style="display: none;">${status.index}</td><!--9번째-->
											</tr> 
											
										</c:forEach>
									</tbody>
									
								</table>
							</div>
							<br />
							
							<h4>판매처
							<select >
							<c:forEach items="${partnerList }" var="P">
								<option value="${P.parName}">${P.parName}</option>
							</c:forEach>
							</select>
							&nbsp;&nbsp;&nbsp;
							판매사원
							<select >
							<c:forEach items="${employeeList}" var="E">
								<option value="${E.idCode}">${E.wName}/${E.dCode}부서</option>
							</c:forEach>
							</select>
							
							<button style="float:right" type="button" id="saleModal"
							class="btn btn-primary" data-toggle="modal" data-target="#saleItemModal">
  							판매</button>
  							</h4>
						</div>
					</div>
					<!--End Advanced Tables -->
				</div>
			</div>
		</div>
	</div>
	
	<!-- 판매 확인용 모달 -->
	<div class="modal fade" id="saleItemModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">판매 품목 확인</h5>
				</div>
				<script>
				$("#saleModal").click(function(){
					if($(document.getElementById("chk_sale")).prop("checked")){
						alert("");
					}
				})
				</script>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>000</th>
											<th>000</th>
											<th>000</th>
											<th>000</th>
											<th>000</th>
										</tr>
									</thead>
									
									<tbody>
											 <tr>
												<td>111</td>
												<td>111</td>
												<td>111</td>
												<td>111</td>
												<td>111</td>
											</tr> 
									</tbody>
									
								</table>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="newMateCate();">판매완료</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 기자재 수정/삭제용 모달 -->
	<!-- <div class="modal fade" id="updateMaterialscate" tabindex="-1" role="dialog"
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
	</div> -->
	<script>		
		
		function newMateCate() {
			var mcName = $("#newCate").val();
			location.href = "${pageContext.request.contextPath}/sale/insertPartner.do?partner="+mcName+"&ecode="+1;//ecode 수정필
			//연결
		}
		
		/* function callOffPartner() {
			var mCate = $("#CateNum").val();//거래처이름
			var mcName = $("#CateName").val();//거래상태
			var mCateC = $("#CateC").val();//거래처 코드
			location.href = "${pageContext.request.contextPath}/sale/callOffPartner.do?partner="+mCate+"&ecode="+1;
			
			//연결
		}
		
		function changeNamePartner() {
			var mCate = $("#CateNum").val();//거래처이름
			var mcName = $("#CateName").val();//거래상태
			var mCateC = $("#CateC").val();//거래처 코드
			location.href = "${pageContext.request.contextPath}/sale/changeNamePartner.do?partner="+mCate+"&ecode="+1+"&partnerC="+ mCateC;
			//연결
		} */
		
		
		/* $("#dataTables-example td").click(
				function() {
					var mCate = $(this).value;
					document.getElementById("CateNum").value = $(this).parent().children().eq(0).text();
					document.getElementById("CateName").value = $(this).parent().children().eq(1).text();
					document.getElementById("CateC").value = $(this).parent().children().eq(2).text();
					$("#updateMaterialscate").modal();
				}); */
	</script>
</body>
<c:import url="../common/footer.jsp" />