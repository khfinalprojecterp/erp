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
                  <div class="panel-heading">물품등록
                     <button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertProduct">
                       물품등록</button>
                       
                  </div>
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
										<th>물품코드</th>
											<th>분류명</th>
											<th>물품명</th>
											<th>규격명</th>
											<th>바코드번호</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="product" items="${list}" varStatus="status">
										<tr class="gradeA">
												<%-- <td>${status.count}</td> --%>
												<td>${product.PCODE}</td>
												<td>${product.PCNAME}</td>
												<td>${product.PNAME}</td>
												<td>${product.PSIZE}</td>
												<td>${product.PBARCODE}</td>
												
										
										
										</tr>
									
										</c:forEach>
										
									</tbody>
									 
								</table>
								
							</div>
						</div>
					</div>
				
				</div>
				
			</div>
			

 <!-- 발주 작성용 모달 -->
   <div class="modal fade" id="insertProduct" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">물품등록</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="productFrm">
                  <div class="form-group">
                 
                     
<!--                      <label for="message-text" class="col-form-label">물품코드</label> -->
<!--                      <input type="text" class="form-control" id="PCODE" name="PCODE"> -->
                     
                      <!-- <label for="message-text" class="col-form-label">분류코드</label>
                     <input type="text" class="form-control" id="PCATE" placeholder="코드를 입력해주세요" name="PCATE" required> -->
                      <label for="message-text" class="col-form-label">분류코드</label>
                    <select class="custom-select" id="PCATE">
						<c:forEach items="${pclist}" var="pc" >
							<option value="${pc.PCATE}">${pc.PCNAME}</option>
						</c:forEach>
						
					</select>
					<br>
						<br >
						
                     <label for="message-text" class="col-form-label">물품명</label>
                     <input type="text" class="form-control" id="PNAME"placeholder="물품명 입력해주세요"  maxlength="14"  name="PNAME"required>
                     
                     <label for="message-text" class="col-form-label">규격</label>
                     <input type="text" class="form-control" id="PSIZE"placeholder="규격을 입력해주세요"  maxlength="14" name="PSIZE" required>
                     
                     <label for="message-text" class="col-form-label">바코드번호</label>
                     <input type="text" class="form-control" id="PBARCODE"  placeholder="바코드번호를 -없이 입력해주세요" maxlength="9" name="PBARCODE" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"required>
        
					<br>
                    
                     <br>
                     
                  </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="insertProduct();">추가하기</button>
            </div>
         </div>
      </div>
   </div>
 
<!--물품 내용 업데이트  -->
  <div class="modal fade" id="updateProduct" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">물품내용 수정 ・ 삭제</h5>

				</div>
				<div class="modal-body">
					<form id="updateFrm">
						<div class="form-group">
            				<label for="recipient-name" class="col-form-label">물품번호</label>
            				<input type="text" class="form-control"placeholder="코드를 임력해주세요" id="UPCODE" name="PCODE">
          				</div>
						<div class="form-group">
            				<label for="recipient-name" class="col-form-label">물품명</label>
            				<input type="text" class="form-control"placeholder="코드를 임력해주세요" id="UPNAME" name="PNAME">
          				</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">규격명</label>
							<input type="text" class="form-control" placeholder="코드를 임력해주세요" id="UPSIZE"  name="PSIZE">
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">바코드명</label>
							<input type="number" class="form-control" placeholder="숫자코드를 임력해주세요" id="UPBARCODE" name="PBARCODE" >
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateProduct();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="deleteProduct();">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
 



 

	<script>

	//아까 num
	//NumberFormatException  이 일어난 이유 string 값에 int가 들어감 
	// msno를 못 받은 이유 -
	//전역변수를 준 이유는 MSSOCK 이랑 MSPRICE는 받을 공간 이 있는데 
	//MSNO는 없으므로 지역 변수 말고 전역 변수로 넗게 줘서
	// 여러 함수가 쓸수 있도록 함이다.
	
	var PCODE;  //전역 변수를 줘 서
	/* document.getElementById('MSDAT').valueAsDate = new Date(); */

	$(function(){
		$('#dataTables-example').DataTable();
		
	});
	
	function validation(){
		// 클라이언트 레벨의 유효성 검사
		
		// form 안에 작성 된 내용을 확인하여
		// 작성이 되어 있지 않으면 false를 반환하는 함수
		
		var result = true;
		
		if($("#PNAME").val().trim().length == 0|| $("#PSIZE").val().trim().length == 0){
			alert("공란을 작성해 주세요!");
			result = false;
		}
		
		return result;
	}
	
	function update_validation(){
		// 클라이언트 레벨의 유효성 검사
		
		// form 안에 작성 된 내용을 확인하여
		// 작성이 되어 있지 않으면 false를 반환하는 함수
		
		var result = true;
		
		if($("#UPNAME").val().trim().length == 0|| $("#UPSIZE").val().trim().length == 0){
			alert("공란을 작성해 주세요!");
			result = false;
		}
		
		return result;
	}
	
	
	
	function insertProduct() {
         
		// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
		if (validation()) {
			alert("작성완료");
	         /* $('#productFrm').attr("action","${pageContext.request.contextPath}/product/insertProduct.do");
	         $('#productFrm').attr("method", "post");
	 		 $('#productFrm').submit(); */
	 		 
	 		var PCATE = $("#PCATE").val();
	 		
	 		var PNAME = $("#PNAME").val();
	 		var PSIZE = $("#PSIZE").val();
	 		var PBARCODE = $("#PBARCODE").val();
	 		location.href = "${pageContext.request.contextPath}/product/insertProduct.do?PCATE="
	 				+PCATE+"&PNAME="+PNAME+"&PSIZE="+PSIZE+"&PBARCODE="+PBARCODE;

			
		 } else{
		alert("작성실패");         
      }
	}
	
	function updateProduct() {
        
		// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
		if (update_validation()) {
			alert("작성완료");
	         $('#updateFrm').attr("action","${pageContext.request.contextPath}/product/updateProduct.do");
	         $('#updateFrm').attr("method", "post");
	 		 $('#updateFrm').submit();
			
		 } else{
		alert("작성실패");         
      }
	}
/* 
	function updateProduct() {
		
		var PNAME = $("#PNAME").val();
		var PSIZE = $("#PSIZE").val();
		var PBARCODE = $("#PBARCODE").val();
		
		
		
		location.href = "${pageContext.request.contextPath}/product/updateProduct.do?PNAME="+PNAME+"&PSIZE="+PSIZE+"&PBARCODE="+PBARCODE;
		
		//연결
	}
	 */
	function deleteM_storage() {
		
		var PNAME = $("#PNAME").val();
		var PSIZE = $("#PSIZE").val();
		var PBARCODE = $("#PBARCODE").val();
		location.href = "${pageContext.request.contextPath}/product/deleteProduct.do?PCODE="+PCODE
		+"&PSIZE="+PSIZE+"&PBARCODE="+PBARCODE;
		//연결
	}
	 
	 $("#dataTables-example td").click(
			function() {
				
				PCODE = $(this).parent().children().eq(0).text();
				$('#UPCODE').val(PCODE);
				
				PNAME = $(this).parent().children().eq(2).text();
				$('#UPNAME').val(PNAME);
				
				PSIZE = $(this).parent().children().eq(3).text();
				$('#UPSIZE').val(PSIZE);
				
				PBARCODE = $(this).parent().children().eq(4).text();
				$('#UPBARCODE').val(PBARCODE);
				
				$("#updateProduct").modal(); // 모달창 호출
			}); 
	
	 
	</script>   
	
	
	
	

		</div>
	</div>
</body>
<c:import url="../common/footer.jsp" />