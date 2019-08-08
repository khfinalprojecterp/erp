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
                  <div class="panel-heading">급여 관리
                  </div>
                  <div class="panel-body">
                     <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover"
                           id="dataTables-example">
                           <thead>
                              <tr>
                                 <th>사번</th>
                                 <th>사원명</th>
                                 <th>부서명</th>
                                 <th>지급일</th>
                                 <th>월급</th>
                              </tr>
                           </thead>
                           <tbody>
                        <c:forEach var="pmanage" items="${list}">
								<c:if test="${ enterprise.eCode eq pmanage.eCode }">
									<tr id="${pmanage.idCode}">
									<td>${pmanage.idCode}</td>
									<td>${pmanage.wName}</td>
									<td>${pmanage.dTitle}</td>
									<td>${pmanage.payment}</td>
									<td>${pmanage.mincome}</td>
									</tr>
								</c:if>
						</c:forEach>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
          
            </div>
         </div>
		
		<!-- -------------------------------- -->
		
			<!-- ----------------------수정---------------------------------- -->
	
		
		
	<div class="modal fade" id="updatePmanage" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">급여 관리 수정</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="pmanageUpdateFrm">
               
               
                  <div class="form-group">
                        <label for="recipient-name" class="col-form-label">사번</label>
                        <input type="text" class="form-control" id="idCode" name="idCode" readonly>
                     </div>
                      
                 
                  <div class="form-group">
                     <label for="message-text" class="col-form-label">사원이름</label>
                     <input type="text" class="form-control" id="wName"  readonly>
                  </div>
        
     				<div class="form-group">
                     <label for="message-text" class="col-form-label">부서명</label>
                  	 <input type="text" class="form-control" id="dTitle" readonly>
     				</div>
                    <div class="form-group">
                     <label for="message-text" class="col-form-label">지급일</label>
                     <input type="Date" class="form-control" id="payment" name="payment">
                     </div>
     				 <div class="form-group">
                     <label for="message-text" class="col-form-label">월급</label>
                     <input type="text" class="form-control" id="mincome" name="mincome" maxlength="9">
                     </div>
     
     
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="updatepmanage();">수정하기</button>
            </div>
         </div>
	
	
	<!-- -------------------------------------------------------------------------------------- -->
	
	
	<script>
	 function updatepmanage() {
         alert("사원 급여 정보 수정");
         $('#pmanageUpdateFrm').attr("action","${pageContext.request.contextPath}/pmanagement/updatePmanage.do");
         $('#pmanageUpdateFrm').attr("method", "get");
 		 $('#pmanageUpdateFrm').submit();
         
         
         
      }
      
      $("#dataTables-example td").click(
            function() {
               var mCate = $(this).value;
               document.getElementById("idCode").value = $(this).parent().children().eq(0).text();
               document.getElementById("wName").value = $(this).parent().children().eq(1).text();
               document.getElementById("dTitle").value = $(this).parent().children().eq(2).text();
               document.getElementById("payment").value = $(this).parent().children().eq(3).text();
               document.getElementById("mincome").value = $(this).parent().children().eq(4).text();
     
               $("#updatePmanage").modal();
            });
   </script>
	
	<!-- --------------------------------------------------------------------------------------- -->
	
		
		
		</div>
	</div>
	</div>
	</div>

</body>
<c:import url="../common/footer.jsp" />