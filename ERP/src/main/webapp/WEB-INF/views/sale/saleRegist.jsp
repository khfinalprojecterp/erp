<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />

<body>
	<c:import url="../common/nav.jsp" />
	<div id="page-wrapper">
		<c:import url="../common/bodyNavPartner.jsp" />
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">판매 기록
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>판매 코드</th>
											<th>거래일</th>
											<th>거래처</th>
											<th>담당 사원</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${saleList}" var="L" > 
											<tr>
												<td>${L.sal_Code}</td>
												<td>${L.salDay}</td>
												<c:forEach items="${partnerList}" var="I">
												<c:if test="${I.partnerC == L.partnerC}">
												<td>${I.parName}</td>
												</c:if>
												</c:forEach>
												<c:forEach items="${employeeList}" var="E">
												<c:if test="${E.idCode == L.idCode}">
												<td>${E.wName}</td>
												</c:if>
												</c:forEach>
												
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
	
	<!-- 기자재 수정/삭제용 모달 -->
	<div class="modal fade" id="updateMaterialscate" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel">판매물품 확인</h4>
					
				</div>
				<div class="modal-body">
					<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-modal">
									<thead>
										<tr>
											<th>판매 코드</th>
											<th>물품명</th>
											<th>갯수</th>
											<th>제조원가</th>
											<th>판매가</th>
											<th>수익</th>
											<th>수익율</th>
											<th>처리상태</th>
										</tr>
									</thead>
									<tbody id="modalDataBody">
										
										<td>데이터가 없습니다.</td>
										
									</tbody>
								</table>
							</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="itemDelivery();">물품 인계</button>
					<button type="button" class="btn btn-success" onclick="saleExcelOutput();">excel로 내보내기</button>

				</div>
			</div>
		</div>
	</div>
	<script>		
		var statusIdx;
		var checkDelivery;
		$("#dataTables-example td").click(
				function() {
					var html = "";
					statusIdx = Number($(this).parent().children().eq(0).text());
 
					<c:forEach items="${saleList}" var="L" varStatus="I">
					if(${L.sal_Code} == statusIdx){
						
						<c:forEach items="${saleItemList}" var="T">

						<c:if test="${T.sal_Code == L.sal_Code}">
						checkDelivery= "${T.sal_Status.charAt(0).toString()}";
						html += "<tr>";
						html += "<td>"+${T.sal_Code}+"</td>";
						html += "<td>"+"${T.sal_Name}"+"</td>";
						html += "<td>"+${T.sal_Amount}+"</td>";
						html += "<td>"+${T.sal_Price-T.sal_Profit}+"</td>";
						html += "<td>"+${T.sal_Price}+"</td>";
						html += "<td>"+${T.sal_Profit}+"</td>";
						html += "<td>"+${T.sal_Discount}+"%"+"</td>";
						<c:choose>
						<c:when test="${T.sal_Status.charAt(0).toString() eq 'D'}" >
						html += "<td>"+"인계전"+"</td>";
						</c:when>
						<c:otherwise>
						html += "<td>"+"판매완료"+"</td>";
						</c:otherwise>
						</c:choose>
						html += "</tr>";
						</c:if>
						
						</c:forEach>
					}
					</c:forEach>
					
					$("#modalDataBody").html(html);
					
					
					$("#updateMaterialscate").modal(); 
				});
		
		function itemDelivery(){
			if(checkDelivery == 'E'){
			alert("이미 인계한 물품입니다.");
			} else {
			location.href ="${pageContext.request.contextPath}/sale/itemDelivery.do?ecode="+${ecode}+"&statusIdx="+statusIdx;//ecode 수정필
			}
		}

		
		function saleExcelOutput(){
			location.href ="${pageContext.request.contextPath}/sale/saleExcelOutput.do?ecode="+${ecode}+"&statusIdx="+statusIdx;
		}

	</script>
</body>
<c:import url="../common/footer.jsp" />
