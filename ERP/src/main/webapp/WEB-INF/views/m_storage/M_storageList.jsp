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
                  <div class="panel-heading">발주 목록
                     <button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertM_storage">
                       발주작성</button>
                  </div>
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>사원번호</th>
											<th>기자재 코드</th>
											<th>창고코드</th>
											<th>수량</th>
											<th>신청일</th>
											<th>납품원가</th>
											<th>상태</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="m_storage" items="${list}" varStatus="status">
										<tr class="gradeA">
												<%-- <td>${status.count}</td> --%>
												<td>${m_storage.IDCODE}</td>
												<td>${m_storage.MCODE}</td>
												<td class="center">${m_storage.SCODE}</td>
												<td class="center">${m_storage.MSMSTOCK}</td>
												<td class="center">${m_storage.MSDATE}</td>
												<td class="center">${m_storage.MSPRICE}</td>
												<td class="center">${m_storage.MSSTATUS}</td>
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
   <div class="modal fade" id="insertM_storage" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">발주</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="m_storageFrm">
                  <div class="form-group">
                     <label for="message-text" class="col-form-label">사원번호</label>
                     <input type="text" class="form-control" id="newCate" name="IDCODE" required>
                     
                      <label for="message-text" class="col-form-label">기자재코드</label>
                     <input type="text" class="form-control" id="newCate" name="MCODE" required>
                     
                     <label for="message-text" class="col-form-label">창고코드</label>
                     <input type="text" class="form-control" id="newCate" name="SCODE" required>
                     
                     <label for="message-text" class="col-form-label">수량</label>
                     <input type="text" class="form-control" id="newCate" name="MSMSTOCK" required>
                     
                     <label for="message-text" class="col-form-label">신청일</label>
                     <input type="date" class="form-control" id="newCate" name="MSDATE" required>
                     
                     <label for="message-text" class="col-form-label">납품원가</label>
                     <input type="text" class="form-control" id="newCate" name="MSPRICE" required>
                     
                     
                     
                     <label for="message-text" class="col-form-label">발주상태</label>
                     <br>
                    <select name="MSSTATUS" required>

					<option value="A">신청</option>
					<option value="R">거절</option>
					<option value="C">완료</option>
					
					</select>
					<br>
                    
                     <br>
                     
                  </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="insertM_storage();">추가하기</button>
            </div>
         </div>
      </div>
   </div>


	<script>
	$(function(){
		$('#dataTables-example').DataTable();
		
	});
	
	
	function insertM_storage() {
         alert("작성완료");
         $('#m_storageFrm').attr("action","${pageContext.request.contextPath}/m_storage/insertM_storage.do");
         $('#m_storageFrm').attr("method", "post");
 		 $('#m_storageFrm').submit();
 		
         
      }
	/* function validation(){
		// 클라이언트 레벨의 유효성 검사
		
		// form 안에 작성 된 내용을 확인하여
		// 작성이 되어 있지 않으면 false를 반환하는 함수
		
		var result = true;
		
		if($("#IDCODE")$("#MCODE")$("#SCODE")$("#MSMSTOCK")$("MSPRICE").val().trim().length == 0){
			alert("공란을 작성해 주세요!");
			result = false;
		}
		
		
		return result;
	} */
	
	
	
	
	
	
	</script>   
	
	
	
	

		</div>
	</div>
</body>
<c:import url="../common/footer.jsp" />