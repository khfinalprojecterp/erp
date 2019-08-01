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
  							구매 추가</button>
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
												<td>${b.buy_discount}%</td>
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
					<form id="insertBuy" method="post">
						<div class="form-group">
							<label for="message-text" class="col-form-label">창고 번호:</label>
							<input type="text" class="form-control" name="sCode">
							
							<label for="message-text" class="col-form-label">기자재/물품 구분</label>
								<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="sddivi" id="m_code" value="M" checked="checked">기자재
								<input type="radio" class="form-check-input" name="sddivi" id="p_code" value="U">물품
							</div> 	
							<label for="message-text" class="col-form-label" id="mcode-id">기자재 코드:</label>
							<input type="text" class="form-control" name="mCode" id="mCode">				
							
							<label for="message-text" class="col-form-label" id="pcode-id">물품 코드:</label>
							<input type="text" class="form-control" name="pCode" id="pCode">
							
							<label for="message-text" class="col-form-label">사원 코드:</label>
							<input type="text" class="form-control" name="idCode">
							
							<label for="message-text" class="col-form-label">수량:</label>
							<input type="text" class="form-control" name="buy_amount">
							
							<label for="message-text" class="col-form-label">원가:</label>
							<input type="text" class="form-control" name="buy_origin">
							
							<label for="message-text" class="col-form-label">매입가:</label>
							<input type="text" class="form-control" name="buy_price">
							
							<label for="message-text" class="col-form-label">처리상태:</label>
							
								<!-- <select name="buy_status" class="form-control input-sm">
									<option value="D">미처리</option>
									<option value="E">처리완료</option>						
							  	</select>  -->
							  	
							 <div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="buy_status" id="buy_status1" value="D" checked="checked">미처리
								<input type="radio" class="form-check-input" name="buy_status" id="buy_status2" value="E">처리완료
							</div> 			
							
							<label for="message-text" class="col-form-label">할인율:</label>
							<input type="text" class="form-control" name="buy_discount">

							
							
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="insertBuy();">추가하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 기자재 수정/삭제용 모달 -->
	<div class="modal fade" id="updateBuyItem" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">구매 수정/삭제</h5>

				</div>
				<div class="modal-body">
					<form id="updateBuy" method="post">
						<div class="form-group">
							<label for="message-text" class="col-form-label">구매 번호:</label>
							<input type="text" class="form-control" name="buy_code" id="buy_code" readonly>
						
							<label for="message-text" class="col-form-label">창고 번호:</label>
							<input type="text" class="form-control" name="sCode" id="sCode">
							
							<label for="message-text" class="col-form-label">기자재/물품 구분</label>
								<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="sddivi" id="m_code" value="M" checked="checked">기자재
								<input type="radio" class="form-check-input" name="sddivi" id="p_code" value="U">물품
							</div> 	
							<label for="message-text" class="col-form-label" id="mcode-id">기자재 코드:</label>
							<input type="text" class="form-control" name="mCode" id="mCode">				
							
							<label for="message-text" class="col-form-label" id="pcode-id">물품 코드:</label>
							<input type="text" class="form-control" name="pCode" id="pCode">
							
							<label for="message-text" class="col-form-label">사원 코드:</label>
							<input type="text" class="form-control" name="idCode" id="idCode">
							
							<label for="message-text" class="col-form-label">수량:</label>
							<input type="text" class="form-control" name="buy_amount" id="buy_amount">
							
							<label for="message-text" class="col-form-label">원가:</label>
							<input type="text" class="form-control" name="buy_origin" id="buy_origin">
							
							<label for="message-text" class="col-form-label">매입가:</label>
							<input type="text" class="form-control" name="buy_price" id="buy_price">
							
							<label for="message-text" class="col-form-label">처리상태:</label>
							
								<!-- <select name="buy_status" class="form-control input-sm">
									<option value="D">미처리</option>
									<option value="E">처리완료</option>						
							  	</select>  -->
							  	
							 <div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="buy_status" id="buy_status1" value="D" checked="checked">미처리
								<input type="radio" class="form-check-input" name="buy_status" id="buy_status2" value="E">처리완료
							</div> 			
							
							<label for="message-text" class="col-form-label">할인율:</label>
							<input type="text" class="form-control" name="buy_discount" id="buy_discount">

							
							
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateBuy();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="deleteBuy();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<script>		
	
	$("input:radio[name=sddivi]").click(function(){
        
	    if($("input:radio[name=sddivi]:checked").val()=='M'){
            $( "#pCode" ).hide();
            $( "#pcode-id" ).hide();
            $( "#mcode-id" ).show();
            $( "#mCode" ).show();
	    }else{
            $( "#mCode" ).hide();
            $( "#mcode-id" ).hide();
            $( "#pcode-id" ).show();
            $( "#pCode" ).show();
	    }
	});
	

		function insertBuy() {
			 $('#insertBuy').attr("action","${pageContext.request.contextPath}/buy/buy_insert.do");
				$('#insertBuy').attr("method", "post");
				$('#insertBuy').submit();
			//연결
		}
		
		function updateBuy() {
			 $('#updateBuy').attr("action","${pageContext.request.contextPath}/buy/buy_update.do");
				$('#updateBuy').attr("method", "post");
				$('#updateBuy').submit();
			
			
			//연결
		}
		
		function deleteBuy() {
			var buy_code = $("#buy_code").val();
			location.href = "${pageContext.request.contextPath}/buy/buy_delete.do?buy_code="+buy_code;
			//연결
		}
		
		
		$("#dataTables-example td").click(
				function() {
					var buyCode = $(this).value;
					document.getElementById("buy_code").value = $(this).parent().children().eq(0).text();
					document.getElementById("sCode").value = $(this).parent().children().eq(1).text();
					document.getElementById("mCode").value = $(this).parent().children().eq(2).text();
					document.getElementById("pCode").value = $(this).parent().children().eq(3).text();
					document.getElementById("idCode").value = $(this).parent().children().eq(4).text();
					document.getElementById("buy_amount").value = $(this).parent().children().eq(5).text();
					document.getElementById("buy_origin").value = $(this).parent().children().eq(6).text();
					document.getElementById("buy_price").value = $(this).parent().children().eq(7).text();
					document.getElementById("buy_discount").value = $(this).parent().children().eq(8).text();
					 if($("input:radio[name=buy_status]:checked").val()=='D'){
						 $("#buy_status1").prop("checked", true)
						 document.getElementById("buy_status1").value = $(this).parent().children().eq(9).text();
					 }  
					 if($("input:radio[name=buy_status]:checked").val()=='E'){
						 $("#buy_status2").prop("checked", true)
						 document.getElementById("buy_status2").value = $(this).parent().children().eq(9).text();
					 }
					
					
					$("#updateBuyItem").modal();
				});
	</script>
</body>
<c:import url="../common/footer.jsp" />