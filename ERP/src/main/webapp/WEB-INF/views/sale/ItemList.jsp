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
		<c:import url="../common/bodyNav.jsp" />
		<div id="page-inner">
		
		
			<div class="row">
				<div class="col-md-12">
				
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading"> &nbsp;판매</div>
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
												<td><input type="checkbox" class="chk_std" name="chk_std"></td>
												<td style="display: none;">${status.index}</td><!--9번째-->
											</tr> 
											
										</c:forEach>
									</tbody>
									
								</table>
							</div>
							<br />
							
							<h4>거래처
							<select id="saleProduct">
							<c:forEach items="${partnerList }" var="P">
							<c:if test="${P.parSts.charAt(0).toString() eq 'T'}">
								<option value="${P.partnerC}">${P.parName}</option>
								</c:if>
							</c:forEach>
							</select>
							&nbsp;&nbsp;&nbsp;
							판매사원
							<select id="saleEmpl">
							<c:forEach items="${employeeList}" var="E">
								<option value="${E.idCode}">${E.wName}/${E.dCode}부서</option>
								<!-- ${E.idCode}를 보내야함 -->
							</c:forEach>
							</select>
							
							<button style="float:right" type="button" id="saleModal"
							class="btn btn-primary" data-toggle="modal" data-target="#saleItemModal"
							onclick="saleItemOn();">
  							판매</button>
  							</h4>
						</div>
					</div>
					<!--End Advanced Tables -->
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
	
	var statusIdx = [];
	var PartnerSelect = "";
	var EmployeeSelect = "";
	var salePrice = [];
	var EA = [];
	
function saleItemOn(){
	var chkbox=[];
	PartnerSelect = $("#saleProduct option:selected").text();
	EmployeeSelect = $("#saleEmpl option:selected").text();
	chkbox = $("input:checkbox[name=chk_std]:checked");
	var trigger = 0;
	if(chkbox.length == 0){
		alert("판매 물품을 선택해 주십시오.");	
		setTimeout(function() {
			$("#saleItemModal").modal("hide");
			}, 0.001);
	}else{
		statusIdx = [];
		salePrice = [];
		EA = [];
		var html = "";
		
		
		var pName = [];
		var sAddr = [];
		var sPhone = [];
		var sdCost = [];
		var sdDate = [];
		var sdStock = [];
		
		chkbox.each(function(i){
				 statusIdx.push($(this).parent().parent().children().eq(9).text());
				 
				 pName += $(this).parent().parent().children().eq(0).text()+",";
				 sAddr += $(this).parent().parent().children().eq(1).text()+",";
				 sPhone += $(this).parent().parent().children().eq(2).text()+",";
				 sdCost += $(this).parent().parent().children().eq(3).text()+",";
				 sdDate += $(this).parent().parent().children().eq(4).text()+",";
				 sdStock += $(this).parent().parent().children().eq(5).text()+",";
				 if($(this).parent().parent().children().eq(6).children().val()==null || $(this).parent().parent().children().eq(6).children().val()==0 || $(this).parent().parent().children().eq(7).children().val()==0){
					 trigger = 1;
				 }
				 salePrice += $(this).parent().parent().children().eq(6).children().val()+",";
				 EA += $(this).parent().parent().children().eq(7).children().val()+",";
		});
		var pNameS = pName.split(',');
		var sAddrS = sAddr.split(',');
		var sPhoneS = sPhone.split(',');
		var sdCostS = sdCost.split(',');
		var sdDateS = sdDate.split(',');
		var sdStockS = sdStock.split(',');
		var salePriceS = salePrice.split(',');
		var EAS = EA.split(',');
		
		chkbox.each(function(i){
			html += "<tr>";
			html += "<td>"+pNameS[i]+"</td>";
			html += "<td>"+sAddrS[i]+"</td>";
			html += "<td>"+sPhoneS[i]+"</td>";
			html += "<td>"+sdCostS[i]+"</td>";
			html += "<td>"+sdDateS[i]+"</td>";
			html += "<td>"+sdStockS[i]+"</td>";
			html += "<td>"+salePriceS[i]+"</td>";
			html += "<td>"+EAS[i]+"</td>";
			html +=	"   </tr>";
		});
		
		$("#modalDataBody").html(html);
		html = "판매처 : "+PartnerSelect+"&nbsp;&nbsp;&nbsp;&nbsp;판매사원 : "+EmployeeSelect;
		$("#modalPartnerSelect").html(html);
				if(trigger == 1){
				alert("판매가/수량을 확인해 주십시오.");	
				setTimeout(function() {
					$("#saleItemModal").modal("hide");
					}, 0.001);
				}
	}
}

function newMateCate() {
	PartnerSelect = $("#saleProduct option:selected").val();
	EmployeeSelect = $("#saleEmpl option:selected").val();
	var salePriceS = salePrice.split(',');
	var EAS = EA.split(',');
	
	
	location.href ="${pageContext.request.contextPath}/sale/saleItem.do?ecode="+ecode+"&statusIdx="+statusIdx+"&PartnerSelect="+PartnerSelect+"&EmployeeSelect="+EmployeeSelect+"&salePriceS="+salePriceS+"&EAS="+EAS;//ecode 수정필
	<%--연결--%>
		

		
}
</script>
	<!-- 판매 확인용 모달 -->
	<div class="modal fade" id="saleItemModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document" style="text-align: center;">
			<div class="modal-content" style="width: 800px;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">판매 품목 확인</h5>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<table class="table table-striped table-bordered table-hover"
									id="dataTables-example" style="width: 100%;">
									<thead>
										<tr>
											<th>물품명</th>
											<th>창고 주소지</th>
											<th>주소지 연락처</th>
											<th>생산/구매가</th>
											<th>입고일</th>
											<th>갯수</th>
											<th>판매가</th>
											<th>판매수량</th>
										</tr>
									</thead>
									
									<tbody id="modalDataBody">
									<!-- 여기에 메소드 html 사용됨 -->
									</tbody>
								</table>
									<h5 id="modalPartnerSelect" style="background-color: #D8D8D8;">
									<!-- 여기에 메소드 html 사용됨 -->
									</h5>
						</div>
				</div>
				<div class="modal-footer">
					<button type="text" class="btn btn-primary" onclick="newMateCate();" >판매완료</button>
					<button id="cancelModal" type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
<c:import url="../common/footer.jsp" />