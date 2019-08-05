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
                  <div class="panel-heading">물품 분류
                     <button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertProduct_Category">
                       분류작성</button>
                  </div>
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
										<th>분류코드</th>
											<th>분류명</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="product_category" items="${list}" varStatus="status">
										<tr class="gradeA">
												<%-- <td>${status.count}</td> --%>
												<td>${product_category.PCATE}</td>
												<td>${product_category.PCNAME}</td>
												
										
										
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
   <div class="modal fade" id="insertProduct_Category" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">품질관리 </h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
<form id="product_categoryFrm">
                  <div class="form-group">
                 
                     
                     <label for="message-text" class="col-form-label">분류코드</label>
                     <input type="text" class="form-control" id="PCATE" placeholder="코드를 입력하세요"name="PCATE" required>
                     
                      <label for="message-text" class="col-form-label">분류명</label>
                     <input type="text" class="form-control" id="PCNAME" placeholder="코드를 입력하세요" name="PCNAME" required>
                     
                   
                    
                     <br>
                     
                  </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="insertProduct_Category();">추가하기</button>
            </div>
         </div>
      </div>
   </div>

<!--발주 내용 업데이트  -->
 <div class="modal fade" id="updateProduct_Category" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">발주내용 수정 ・ 삭제</h5>

				</div>
				<div class="modal-body">
					<form id="uppcFrm">
					
						<!-- <div class="form-group">
            				<label for="recipient-name" class="col-form-label">분류코드</label>
            				<input type="number" class="form-control" placeholder="숫자만 입력하세요"id="UPCATE" >
          				</div> -->
						<div class="form-group">
							<input type="hidden" class="form-control" id="UPCATE" name="PCATE" />
							<label for="message-text" class="col-form-label">분류명</label>
							<input type="text" class="form-control" placeholder="코드를 입력하세요" id="UPCNAME" name="PCNAME" >
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateProduct_Category();">수정하기</button>
					<button type="button" class="btn btn-danger" onclick="deleteProduct_Category();">삭제하기</button>
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
	
	var PCATE;  //전역 변수를 줘 서
	/* document.getElementById('MSDATE').valueAsDate = new Date();
 */
	$(function(){
		$('#dataTables-example').DataTable();
		
	});
	
	 function validation(){
		// 클라이언트 레벨의 유효성 검사
		
		// form 안에 작성 된 내용을 확인하여
		// 작성이 되어 있지 않으면 false를 반환하는 함수
		
		var result = true;
		
		if($("#PCNAME").val().trim().length == 0){
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
			
			if($("#UPCNAME").val().trim().length == 0){
				alert("공란을 작성해 주세요!");
				result = false;
			}
			
			return result;
		}
	
	
	function insertProduct_Category() {
         
		// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
		if (validation()) {
			alert("작성완료");
	         $('#product_categoryFrm').attr("action","${pageContext.request.contextPath}/product_category/insertProduct_Category.do");
	         $
	         ('#product_categoryFrm').attr("method", "post");
	 		 $('#product_categoryFrm').submit();
			
		 } else{
		alert("작성실패");         
      }
	}
	
	function updateProduct_Category() {
        // 수정 버튼을 눌렀을 때 uppcFrm 이라는 폼의 정보를
        // updateProduct_Category.do 한테 전달한다.
        
		// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
		if (update_validation()) {
			alert("작성완료");
	         $('#uppcFrm').attr("action","${pageContext.request.contextPath}/product_category/updateProduct_Category.do");
	         $('#uppcFrm').attr("method", "post");
	 		 $('#uppcFrm').submit();
			
		 } else{
		alert("작성실패");         
      }
	}

/* /* 	function updateProduct_Category() {
	
		/* var PCATE = $("#UPCATE").val(); */
/* 		var PCNAME = $("#UPCNAME").val();
		
		
		
		
		location.href = "${pageContext.request.contextPath}/product_category/updateProduct_Category.do?PCODE="+PCODE
+&PCNAME="+PCNAME
				;
		
		//연결
	} */
/* 	 */ 
	function deleteProduct_Category() {
		
		/* var PCATE = $("#PCATE").val(); */
		var PCNAME = $("#PCNAME").val();
		location.href = "${pageContext.request.contextPath}/product_category/deleteProduct_Category.do?PNAME="+PNAME
		;
		//연결
	}
	 
	 $("#dataTables-example td").click(
			function() {
				/* var mCate = $(this).value; */
				PCATE = $(this).parent().children().eq(0).text();
				$('#UPCATE').val(PCATE);
				
				
				
				PCNAME = $(this).parent().children().eq(1).text();
				$('#UPCNAME').val(PCNAME);
			
				$("#updateProduct_Category").modal();
			}); 
	 /*  function insertM_storage() {
		  alert("작성완료");
	         $('#m_storageFrm').attr("action","${pageContext.request.contextPath}/m_storage/insertM_storage.do");
	         $('#m_storageFrm').attr("method", "post");
	 		 $('#m_storageFrm').submit();
	
	  } 
	 */
	  
	/*   
	  $("#MSMSTOCK"),  $("#MSRPRICE").click(
				function() {
					var mCate = $(this).value;
					document.getElementById("MSMSTOCK").value = $(this).parent().children().eq(1).text();
					
					$("#updateM_storage").modal();
				}); 
	   */
	 
	</script>   
	
	
	
	

		</div>
	</div>
</body>
<c:import url="../common/footer.jsp" />