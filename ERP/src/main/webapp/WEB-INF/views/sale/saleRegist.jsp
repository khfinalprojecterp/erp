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
						<div class="panel-heading">판매 기록</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>No</th>
											<th>거래일</th>
											<th>거래처</th>
											<th>담당 사원</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${saleList}" var="L">
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

					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-default">
							<div class="panel-heading">
								${fn:substring(saleList[0].salDay,0,4)}년 월별 판매량
                            </div>
								<div id="morris-bar-chart amount"></div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-default">
							<div class="panel-heading">
								${fn:substring(saleList[0].salDay,0,4)}년 월별 순이익
                            </div>
								<div id="morris-bar-chart price"></div>
							</div>
						</div>
					</div>
					
					<div class="row">
					
					<div class="col-md-6">  
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">연도별 판매량</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="line-chart-am" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
					<div class="col-md-6">  
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">연도별 판매액</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="line-chart-pr" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
						
					</div>
					
					
					<script>
					var yearSaleEa = [0,0,0,0,0]<%-- 최근부터 5년만 받음 --%>
					var yearSalePrice = [0,0,0,0,0]
					
					var lastMonth = "${saleList[0].salDay}".substring(5,7)*1;
					var lastYear = "${saleList[0].salDay}".substring(0,4)*1;
					var lasteYM = "${saleList[0].salDay}".substring(0,7)*1;
					
					<%-- 2015,2016,2017,2018,2019 5개 --%>
					<c:forEach var="x" begin="${fn:substring(saleList[0].salDay,0,4)*1-4}" end="${fn:substring(saleList[0].salDay,0,4)*1}" step="1" varStatus="status">
						<c:forEach items="${saleList}" var="I">
							<c:if test="${fn:substring(I.salDay,0,4) eq x}">
								<c:forEach items="${saleItemList}" var="A">
									<c:if test="${A.sal_Code eq I.sal_Code}">
									yearSaleEa[${status.count*1-1}] = yearSaleEa[${status.count*1-1}] + ${A.sal_Amount*1};
									yearSalePrice[${status.count*1-1}] = 
										yearSalePrice[${status.count*1-1}] + ${A.sal_Amount*1}*${A.sal_Profit*1};
									</c:if>
								</c:forEach>
							</c:if>
						</c:forEach>
					</c:forEach>
					
					var ctx = $('#line-chart-am').get(0).getContext('2d');
					var ctx2 = $('#line-chart-pr').get(0).getContext('2d');
						 var data = {
						    labels: [lastYear-4+"년", lastYear-3+"년", lastYear-2+"년", lastYear-1+"년", lastYear+"년"],
						    datasets: [
						      {
						        label: "My First dataset",
						        fillColor: "rgba(34, 167, 240,0.2)",
						        strokeColor: "#22A7F0",
						        pointColor: "#22A7F0",
						        pointStrokeColor: "#fff",
						        pointHighlightFill: "#fff",
						        pointHighlightStroke: "#22A7F0",
						        
						        data: [yearSaleEa[0],yearSaleEa[1],yearSaleEa[2],yearSaleEa[3],yearSaleEa[4]]
						      }
						    ]
						  };
						 var data2 = {
						    labels: [lastYear-4+"년", lastYear-3+"년", lastYear-2+"년", lastYear-1+"년", lastYear+"년"],
						    datasets: [
						    	{
							        label: "My Second dataset",
							        fillColor: "rgba(26, 188, 156,0.2)",
							        strokeColor: "#1ABC9C",
							        pointColor: "#1ABC9C",
							        pointStrokeColor: "#fff",
							        pointHighlightFill: "#fff",
							        pointHighlightStroke: "#1ABC9C",
							        data: [yearSalePrice[0],yearSalePrice[1],yearSalePrice[2],yearSalePrice[3],yearSalePrice[4]]
							    }
						    ]
						  };
						  myLineChart = new Chart(ctx).Line(data, options);
						  myLineChart = new Chart(ctx2).Line(data2, options);
						  
					<%-- /////////////////////////////////////////////// --%>
					
					var saleEa = [0,0,0,0,0,0,0,0,0,0,0,0];
					var salePrice = [0,0,0,0,0,0,0,0,0,0,0,0]; 
					
					<%--<c:forEach items="${saleList}" var="I">
						<c:if test="${fn:substring(I.salDay,0,4) eq fn:substring(saleList[0].salDay,0,4)}">
						</c:if>
					</c:forEach>--%>
					
					<c:forEach items="${saleList}" var="I"><%-- 월별 판매량/순이익 --%>
						<c:if test="${fn:substring(I.salDay,0,4) eq fn:substring(saleList[0].salDay,0,4)}">
							<c:forEach items="${saleItemList}" var="A">
								<c:if test="${I.sal_Code eq A.sal_Code}">
								saleEa["${fn:substring(I.salDay,5,7)}"*1] = saleEa["${fn:substring(I.salDay,5,7)}"*1]+("${A.sal_Amount}"*1);
								salePrice["${fn:substring(I.salDay,5,7)}"*1] = 
									salePrice["${fn:substring(I.salDay,5,7)}"*1] + ("${A.sal_Profit}"*1)*("${A.sal_Amount}"*1);
								</c:if>
							</c:forEach>
						</c:if> 
					</c:forEach>
					
					Morris.Bar({
		                element: 'morris-bar-chart amount',
		                data: [
		                	<c:forEach var="a" begin="1" end="12" step="1">
		                	{y: ${a}+"월", 
		                   	판매량 : saleEa["${a}"*1]}
		                	,
		                	</c:forEach>
		                	
		                ],
		                xkey: 'y',
		                ykeys: ['판매량'],
		                labels: ['판매량'],
						 barColors: [
		    '#22a7f0',
		    '#A8E9DC' 
		  ],
		                hideHover: 'auto',
		                resize: true
		            });
					Morris.Bar({
		                element: 'morris-bar-chart price',
		                data: [
		                	<c:forEach var="a" begin="1" end="12" step="1">
		                	{y: ${a}+"월", 
		                   	순이익 : salePrice["${a}"*1]}
		                	,
		                	</c:forEach>
		                	
		                ],
		                xkey: 'y',
		                ykeys: ['순이익'],
		                labels: ['순이익'],
						 barColors: [
		    '#1abc9c',
		    '#A8E9DC' 
		  ],
		                hideHover: 'auto',
		                resize: true
		            });
					<%-- /////////////////////////////////////////////// --%>
					
					
					</script>
					

					<!--End Advanced Tables -->
				</div>
			</div>
		</div>
	</div>

	<!-- 기자재 수정/삭제용 모달 -->
	<div class="modal fade" id="updateMaterialscate" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
									<th>No</th>
									<th>물품명</th>
									<th>위치</th>
									<th>EA</th>
									<th>원가</th>
									<th>판매가</th>
									<th>수익</th>
									<th>수익율</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody id="modalDataBody">

								<td>데이터가 없습니다.</td>

							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary"
						onclick="itemDelivery();">물품 인계</button>
					<button type="button" class="btn btn-success"
						onclick="saleExcelOutput();">excel로 내보내기</button>
				</div>
			</div>
		</div>
	</div>
	<script>	
	setTimeout(function() {
		$("#dataTables-example th").parent().children().eq(0).trigger("click");
		}, 1);
	
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
						<c:forEach items="${storageList}" var="A">
						<c:if test="${A.sCode eq T.sCode}">
						html += "<td>"+"${A.sAddr}"+"</td>"; 
						</c:if>
						</c:forEach>
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
