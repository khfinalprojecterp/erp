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
											<th>기자재/물품</th>
											<th>물품명</th>
											<th>사원명</th>
											<th>수량</th>
											<th>원가</th>
											<th>매입가</th>
											<th>거래처</th>
											<th>처리상태</th>
											<th>구매날자</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="b" > 
											<%-- 	<tr id="${b.buy_code}" >
												<td>${b.buy_code}</td>
												<td>${b.sCode}</td> --%>
											<c:if test="${ empty b.mCode }">
												<tr id="${b.buy_code}" class="${b.buy_code} ${b.sCode} ${b.idCode} ${b.pCode} ${ptCode}">  
												</c:if>
												<c:if test="${ empty b.pCode }">
												<tr id="${b.buy_code}" class="${b.buy_code} ${b.sCode} ${b.idCode} ${b.mCode} ${ptCode}">
												</c:if>
												<td>${b.buy_code}</td>
												<td>${b.sCode}</td>
												<c:if test="${ empty b.mCode}">
													<td>물품</td>
													<td>${b.pName}</td>
												</c:if>
												<c:if test="${ empty b.pCode}">
													<td>기자재</td>
													<td>${b.mName}</td>
												</c:if>
												<td>${b.wName}</td>
												<td>${b.buy_amount}</td>
												<td>${b.buy_origin}</td>
												<td>${b.buy_price}</td>
												<td>${b.parName}</td> 
												<c:if test="${b.buy_status eq 'E'}" >
												<td>승인완료</td>
												</c:if>
												<c:if test="${b.buy_status ne 'E'}">
												<td>미승인</td>
												</c:if>
												<td><fmt:formatDate value="${b.buy_date}" pattern="yyyy/MM/dd"/></td>
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
							<select class="custom-select" name="sCode" id="sCode">
								<c:forEach items="${slist}" var="s" >
								<c:if test="${ employee.eCode eq s.eCode }">
									<option value="${s.sCode}">${s.sCode}</option>
									</c:if>
								</c:forEach>
							</select><br><br>
							
							<label for="message-text" class="col-form-label">기자재/물품 구분</label>
								<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="sddivi" id="m_code" value="M">기자재
								<input type="radio" class="form-check-input" name="sddivi" id="p_code" value="U">물품
							</div><br>
							
							<label for="message-text" class="col-form-label" id="mcode-id" style="display:none">기자재명 :</label>
							<!-- <input type="text" class="form-control" name="mCode" id="mCode" style="display:none"> -->
							<select class="custom-select" name="mCode" id="mCode" style="display:none">
								<option value=""></option> <!-- null값용 -->
								<c:forEach items="${mlist}" var="m" >
									<option value="${m.mCode}">${m.mName}</option>
								</c:forEach>				
							</select>
							<label for="message-text" class="col-form-label" id="pcode-id" style="display:none">물품명 :</label>
							<!-- <input type="text" class="form-control" name="pCode" id="pCode" style="display:none"> -->
							<select class="custom-select" name="pCode" id="pCode" style="display:none">
							<option value=""></option> <!-- null값용 -->
								<c:forEach items="${plist}" var="p" >
									<option value="${p.pCode}">${p.pName}</option>
								</c:forEach>				
							</select><br>
							
							<label for="message-text" class="col-form-label">사원 :</label>
							<input type="text" class="form-control" name="idName" id="idName" value="${employee.wName}" readonly> <br><br>
							
							<label for="message-text" class="col-form-label">거래처 :</label>
							<select class="custom-select" name="ptCode" id="ptCode">
							<option value=""></option> <!-- null값용 -->
								<c:forEach items="${ptlist}" var="pt" >
								<c:if test="${ employee.eCode eq pt.eCode }">
									<option value="${pt.parC}">${pt.parName}</option>
									</c:if>
								</c:forEach>
							</select><br><br>
							
							
							<label for="message-text" class="col-form-label">수량 :</label>
							<input type="text" class="form-control" name="buy_amount" id="buy_amount">
							
							<label for="message-text" class="col-form-label">원가 :</label>
							<input type="text" class="form-control" name="buy_origin" id="buy_origin">
							
							<label for="message-text" class="col-form-label">매입가 :</label>
							<input type="text" class="form-control" name="buy_price" id="buy_price">

							<!-- <label for="message-text" class="col-form-label">구매일자 :</label>
							<input type="Date" class="form-control" name="buy_date" id="buy_date"> -->
							
							<input type="hidden" class="form-control" name="eCode" id="eCode" value="${employee.eCode}">
							<input type="hidden" class="form-control" name="idCode" id="idCode" value="${employee.idCode}">
							
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
							<input type="text" class="form-control" name="buy_code" id="buy_code2" readonly>
							<br />
							<label for="message-text" class="col-form-label">창고 번호:</label>
							<select class="custom-select" name="sCode" id="sCode2">
								<c:forEach items="${slist}" var="s" >
								<c:if test="${ employee.eCode eq s.eCode }">
									<option value="${s.sCode}">${s.sCode}</option>
									</c:if>
								</c:forEach>
							</select><br><br>
							
							<label for="message-text" class="col-form-label">기자재/물품 구분</label>
								<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="sddivi" id="m_code2" value="M">기자재
								<input type="radio" class="form-check-input" name="sddivi" id="p_code2" value="U">물품
							</div> <br>
							<div class="form-group">
							<label for="message-text" class="col-form-label" id="mcode-id2" style="display:none">기자재명 :</label>
							<select class="custom-select" name="mCode" id="mCode2" style="display:none">
								<option value=""></option>
								<c:forEach items="${mlist}" var="m" >
									<option value="${m.mCode}">${m.mName}</option>
								</c:forEach>				
							</select>
							<label for="message-text" class="col-form-label" id="pcode-id2" style="display:none">물품명 :</label>
							<!-- <input type="text" class="form-control" name="pCode" id="pCode" style="display:none"> -->
							<select class="custom-select" name="pCode" id="pCode2" style="display:none">
							<option value=""></option>
								<c:forEach items="${plist}" var="p" >
									<option value="${p.pCode}">${p.pName}</option>
								</c:forEach>				
							</select><br>
							</div>
							<label for="message-text" class="col-form-label">사원명 :</label>
							<input type="text" class="form-control" name="idName" id="idName" value="${employee.wName}" readonly> <br><br>
							
							<label for="message-text" class="col-form-label">거래처명 :</label>
							<select class="custom-select" name="ptCode2" id="ptCode2">
								<c:forEach items="${ptlist}" var="pt" >
								<c:if test="${ employee.eCode eq pt.eCode }">
									<option value="${pt.parC}">${pt.parName}</option>
									</c:if>
								</c:forEach>
							</select><br><br>
							
							<label for="message-text" class="col-form-label">수량 :</label>
							<input type="text" class="form-control" name="buy_amount" id="buy_amount2">
							
							<label for="message-text" class="col-form-label">원가 :</label>
							<input type="text" class="form-control" name="buy_origin" id="buy_origin2">
							
							<label for="message-text" class="col-form-label">매입가 :</label>
							<input type="text" class="form-control" name="buy_price" id="buy_price2">							
							
							<input type="text" class="form-control" name="eCode" id="eCode2" value="${employee.eCode}" style="display:none">
							<input type="text" class="form-control" name="eCode" id="idCode2" value="${employee.idCode}" style="display:none">
							
							<input type="hidden" class="form-control" name="buy_status" id="buy_status" value="E">
							
							<!-- <label for="message-text" class="col-form-label">구매일자 :</label>
							<input type="Date" class="form-control" name="buy_date" id="buy_date2"> -->
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="updateBuyB" onclick="updateBuy();">수정하기</button>
					<button type="button" class="btn btn-danger" id="deleteBuyB" onclick="deleteBuy();">삭제하기</button>
					<br><br>
					<button type="button" class="btn btn-primary" id="insertS" onclick="insertBuyS();">구매확인</button>

				</div>
			</div>
		</div>
	</div>
	<script>
	
	
	$("input:radio[name=sddivi]").click(function(){
        
	    if($("input:radio[name=sddivi]:checked").val()=='M'){
            $( "#pCode" ).css("display", "none");
            $( "#pcode-id" ).css("display", "none");
            $( "#mcode-id" ).css("display", "block");
            $( "#mCode" ).css("display", "block");
	    }else{
            $( "#mCode" ).css("display", "none");
            $( "#mcode-id" ).css("display", "none");
            $( "#pcode-id" ).css("display", "block");
            $( "#pCode" ).css("display", "block");
	    }
	});
	
	$("input:radio[name=sddivi]").click(function(){
        
	    if($("input:radio[name=sddivi]:checked").val()=='M'){
            $( "#pCode2" ).css("display", "none");
            $( "#pcode-id2" ).css("display", "none");
            $( "#mcode-id2" ).css("display", "block");
            $( "#mCode2" ).css("display", "block");
	    }else{
            $( "#mCode2" ).css("display", "none");
            $( "#mcode-id2" ).css("display", "none");
            $( "#pcode-id2" ).css("display", "block");
            $( "#pCode2" ).css("display", "block");
	    }
	});
	
	
	
	

		function insertBuy() {
			 var amount = $("#buy_amount").val();
			var origin = $("#buy_origin").val();
			var price = $("#buy_price").val();
			
			if($("#sCode").val() == "")
			{ 
				alert("창고를 선택해 주십시오."); $("#sCode").focus(); return false; 
			}
			if($("#mCode").val() == "" && $("#pCode").val() == "")
			{ 
				alert("품목을 선택해 주십시오."); $("#mCode").focus(); return false; 
			}
			if($("#ptCode").val() == "")
			{ 
				alert("거래처를 선택해 주십시오."); $("#ptCode").focus(); return false; 
			}
			if($("#buy_amount").val() == "")
			{ 
				alert("수량을 입력해 주십시오."); $("#buy_amount").focus(); return false; 
			}
			if(isNaN(amount) == true)
			{ 
				alert("수량은 숫자만 입력이  가능합니다."); $("#buy_amount").focus(); return false; 
			}
			if($("#buy_origin").val() == "")
			{ 
				alert("원가를 입력해 주십시오."); $("#buy_origin").focus(); return false; 
			}
			if(isNaN(origin) == true)
			{ 
				alert("원가는 숫자만 입력이  가능합니다."); $("#buy_origin").focus(); return false; 
			}
			if($("#buy_price").val() == "")
			{ 
				alert("구매가를 입력해 주십시오."); $("#buy_price").focus(); return false; 
			}
			if(isNaN(price) == true)
			{ 
				alert("구매가는 숫자만 입력이  가능합니다."); $("#buy_price").focus(); return false; 
			} 
			
			 $('#insertBuy').attr("action","${pageContext.request.contextPath}/buy/buy_insert.do");
				$('#insertBuy').attr("method", "post");
				$('#insertBuy').submit();
			//연결
		}
		
		function insertBuyS() {
			 var amount = $("#buy_amount2").val();
			var origin = $("#buy_origin2").val();
			var price = $("#buy_price2").val();
			
			if($("#sCode2").val() == "")
			{ 
				alert("창고를 선택해 주십시오."); $("#sCode2").focus(); return false; 
			}
			if($("#mCode2").val() == "" && $("#pCode2").val() == "")
			{ 
				alert("품목을 선택해 주십시오."); $("#mCode2").focus(); return false; 
			}
			if($("#ptCode2").val() == "")
			{ 
				alert("거래처를 선택해 주십시오."); $("#ptCode2").focus(); return false; 
			}
			if($("#buy_amount2").val() == "")
			{ 
				alert("수량을 입력해 주십시오."); $("#buy_amount2").focus(); return false; 
			}
			if(isNaN(amount) == true)
			{ 
				alert("수량은 숫자만 입력이  가능합니다."); $("#buy_amount2").focus(); return false; 
			}
			if($("#buy_origin2").val() == "")
			{ 
				alert("원가를 입력해 주십시오."); $("#buy_origin2").focus(); return false; 
			}
			if(isNaN(origin) == true)
			{ 
				alert("원가는 숫자만 입력이  가능합니다."); $("#buy_origin2").focus(); return false; 
			}
			if($("#buy_price2").val() == "")
			{ 
				alert("구매가를 입력해 주십시오."); $("#buy_price2").focus(); return false; 
			}
			if(isNaN(price) == true)
			{ 
				alert("구매가는 숫자만 입력이  가능합니다."); $("#buy_price2").focus(); return false; 
			} 
			
			 $('#updateBuy').attr("action","${pageContext.request.contextPath}/buy/buy_insertS.do");
				$('#updateBuy').attr("method", "post");
				$('#updateBuy').submit();
				$('#updateBuy').attr("action","${pageContext.request.contextPath}/buy/buy_updateS.do");
				$('#updateBuy').attr("method", "post");
				$('#updateBuy').submit();
/* 				var buy_code = $("#buy_code2").val();
				var buy_code = $("#buy_status2").val();
				location.href = "${pageContext.request.contextPath}/buy/buy_updateS.do?buy_code="+buy_code+"&buy_status="+buy_status; */
				
			//연결
		}
		
		function updateBuy() {
			 var amount = $("#buy_amount2").val();
			var origin = $("#buy_origin2").val();
			var price = $("#buy_price2").val();
			
			if($("#sCode2").val() == "")
			{ 
				alert("창고를 선택해 주십시오."); $("#sCode2").focus(); return false; 
			}
			if($("#mCode2").val() == "" && $("#pCode2").val() == "")
			{ 
				alert("품목을 선택해 주십시오."); $("#mCode2").focus(); return false; 
			}
			if($("#ptCode2").val() == "")
			{ 
				alert("거래처를 선택해 주십시오."); $("#ptCode2").focus(); return false; 
			}
			if($("#buy_amount2").val() == "")
			{ 
				alert("수량을 입력해 주십시오."); $("#buy_amount2").focus(); return false; 
			}
			if(isNaN(amount) == true)
			{ 
				alert("수량은 숫자만 입력이  가능합니다."); $("#buy_amount2").focus(); return false; 
			}
			if($("#buy_origin2").val() == "")
			{ 
				alert("원가를 입력해 주십시오."); $("#buy_origin2").focus(); return false; 
			}
			if(isNaN(origin) == true)
			{ 
				alert("원가는 숫자만 입력이  가능합니다."); $("#buy_origin2").focus(); return false; 
			}
			if($("#buy_price2").val() == "")
			{ 
				alert("구매가를 입력해 주십시오."); $("#buy_price2").focus(); return false; 
			}
			if(isNaN(price) == true)
			{ 
				alert("구매가는 숫자만 입력이  가능합니다."); $("#buy_price2").focus(); return false; 
			} 
			
			 $('#updateBuy').attr("action","${pageContext.request.contextPath}/buy/buy_update.do");
				$('#updateBuy').attr("method", "post");
				$('#updateBuy').submit();
				
			
			
			//연결
		}
		
		function deleteBuy() {
			var buy_code = $("#buy_code2").val();
			location.href = "${pageContext.request.contextPath}/buy/buy_delete.do?buy_code="+buy_code;
			//연결
		}
		
		
		$("#dataTables-example td").click(
				function() {
					var buy_code2 = $(this).parent().attr('class').split(' ')[0];
		 			var sCode2 = $(this).parent().attr('class').split(' ')[1];
		 			var idCode = $(this).parent().attr('class').split(' ')[2];
		 			/* var selectedPar = $(this).parent().children().eq(8).text();
		 			alert(selectedPar); */
		 			
		 			/* var idCode2 = $("#idCode2 option:selected").text(); */
					
		 			/*var buyCode = $(this).value; */
					document.getElementById("buy_code2").value = buy_code2;
					document.getElementById("sCode2").value = sCode2;
					if($(this).parent().children().eq(2).text() == "물품") {
						$("#p_code2").prop("checked", true)
   						$( "#pCode2" ).css("display", "block");
			            $( "#pcode-id2" ).css("display", "block");
			            $( "#mcode-id2" ).css("display", "none");
			            $( "#mCode2" ).css("display", "none");
						document.getElementById("pCode2").value = $(this).parent().attr('class').split(' ')[3];
						
					}
					if($(this).parent().children().eq(2).text() == "기자재") {
						$("#m_code2").prop("checked", true)
			            $( "#mCode2" ).css("display", "block");
			            $( "#mcode-id2" ).css("display", "block");
			            $( "#pcode-id2" ).css("display", "none");
			            $( "#pCode2" ).css("display", "none");
						document.getElementById("mCode2").value = $(this).parent().attr('class').split(' ')[3];
					} 
					/* document.getElementById("pCode2").value = $(this).parent().children().eq(3).text(); */
					document.getElementById("idCode2").value =  $("#idCode2 option:selected").val();
					document.getElementById("buy_amount2").value = $(this).parent().children().eq(5).text();
					document.getElementById("buy_origin2").value = $(this).parent().children().eq(6).text();
					document.getElementById("buy_price2").value = $(this).parent().children().eq(7).text();
					document.getElementById("ptCode2").text = $(this).parent().attr('class').split(' ')[4];
						
					
					
					
					if($(this).parent().children().eq(9).text() == "승인완료") {
						$("#insertS").attr("disabled", true);
						$("#updateBuyB").attr("disabled", true);
					}
					
					

				
					
					document.getElementById("eCode2").value = ${employee.eCode};
/* 					 if($("input:radio[name=buy_status]:checked").val()=='D'){
						 $("#buy_status1").prop("checked", true)
						 document.getElementById("buy_status1").value = $(this).parent().children().eq(8).text();
					 }  
					 if($("input:radio[name=buy_status]:checked").val()=='E'){
						 $("#buy_status2").prop("checked", true)
						 document.getElementById("buy_status2").value = $(this).parent().children().eq(8).text();
					 } */
					
					
					$("#updateBuyItem").modal();
				});
		
		
		
		
		
		$("#sideNav").click(function(){
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
		
	</script>
</body>
<c:import url="../common/footer.jsp" />