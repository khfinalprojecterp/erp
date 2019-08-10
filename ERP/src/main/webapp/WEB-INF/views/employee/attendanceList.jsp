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
		
		<!------- 화면---------- -->
		
		<div class="row">
            <div class="col-md-12">
               <!-- Advanced Tables -->
               <div class="panel panel-default">
                  <div class="panel-heading">근태 관리
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
                                 <th>휴가여부</th>
                                 <th>결근일수</th>
                              </tr>
                           </thead>
                           <tbody>
                           
                        <c:if test="${ empty employee && !empty enterprise }">   
                        <c:forEach var="attendance" items="${list}">
								<c:if test="${ enterprise.eCode eq attendance.eCode }">
									<tr id="${ attendance.idCode}">
									<td>${attendance.idCode}</td>
									<td>${attendance.wName}</td>
									<td>${attendance.dTitle}</td>
									<td>${attendance.vStatus}</td>
									<td>${attendance.absence}</td>
									</tr>
								</c:if>
						</c:forEach>
						</c:if>
						<c:if test="${ empty enterprise && !empty employee }">
						<c:forEach var="attendance" items="${list}">
								<c:if test="${ employee.eCode eq attendance.eCode }">
									<tr id="${ attendance.idCode}">
									<td>${attendance.idCode}</td>
									<td>${attendance.wName}</td>
									<td>${attendance.dTitle}</td>
									<td>${attendance.vStatus}</td>
									<td>${attendance.absence}</td>
									</tr>
								</c:if>
						</c:forEach>
						</c:if>

                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
               <!--End Advanced Tables -->
            </div>
         </div>
		
		<!-- -------------------------------- -->
		
			<!-- ----------------------수정---------------------------------- -->
	
		
		
	<div class="modal fade" id="updateAttendance" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">사원 근태 수정</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="attendanceUpdateFrm">
               
               
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
                     <label for="message-text" class="col-form-label">휴가여부</label>
                    	<br>
                     <select name="vStatus" id="vStatus" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
					</select>
                     
                     <br>

                     
                     </div>
     				 <div class="form-group">
                     <label for="message-text" class="col-form-label">결근일수</label>
                     <input type="text" class="form-control" id="absence" name="absence" maxlength="9">
                     </div>
     
     
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="updateattendance();">수정하기</button>
            </div>
         </div>
	
	
	<!-- -------------------------------------------------------------------------------------- -->
	
	
	<script>
	 function updateattendance() {
         alert("사원 근태 수정");
         $('#attendanceUpdateFrm').attr("action","${pageContext.request.contextPath}/employee/updateAttendance.do");
         $('#attendanceUpdateFrm').attr("method", "get");
 		 $('#attendanceUpdateFrm').submit();
         
         
         
      }
      
      $("#dataTables-example td").click(
            function() {
               var mCate = $(this).value;
               document.getElementById("idCode").value = $(this).parent().children().eq(0).text();
               document.getElementById("wName").value = $(this).parent().children().eq(1).text();
               document.getElementById("dTitle").value = $(this).parent().children().eq(2).text();
               document.getElementById("vStatus").value = $(this).parent().children().eq(3).text();
               document.getElementById("absence").value = $(this).parent().children().eq(4).text();
     
               $("#updateAttendance").modal();
            });
   </script>
	
	<!-- --------------------------------------------------------------------------------------- -->

		<!-- ----------------------- -->
	
		
		</div>
	</div>

</body>
<c:import url="../common/footer.jsp" />