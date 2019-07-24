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
                  <div class="panel-heading">사원 조회
                     <button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertEmployee">
                       사원 등록</button>
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
                                 <th>직급</th>
                                 <th>재직여부</th>
                                 <th>입사일</th>
		   						 <th>퇴사일</th>
                              </tr>
                           </thead>
                           <tbody>
                            <c:forEach var="emp" items="${list}">
			<c:if test="${ enterprise.eCode eq emp.eCode }">
			<tr id="${emp.idCode}">
				<td>${emp.idCode}</td>
				<td>${emp.wName}</td>
				<td>${emp.dTitle}</td>
				<td>${emp.position}</td>
				<td>${emp.wStatus}</td>
				<td>${emp.enrollDate}</td>
				<td>${emp.retireDate}</td>
		     </tr>
		   </c:if>
		</c:forEach>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
               <!--End Advanced Tables -->
            </div>
         </div>
  
		<!-- ------------------ -->	
	
	 <!-- 사원 추가용 모달 -->
   <div class="modal fade" id="insertEmployee" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">사원 등록</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="empFrm">
                  <div class="form-group">
                     <label for="message-text" class="col-form-label">사번</label>
                     <input type="text" class="form-control" id="newCate" name="idCode" required>
                     
                      <label for="message-text" class="col-form-label">비밀번호</label>
                     <input type="password" class="form-control" id="newCate" name="wPwd" required>
                     
                     <label for="message-text" class="col-form-label">사원명</label>
                     <input type="text" class="form-control" id="newCate" name="wName" required>
                     
                     
                     
                     
                     <label for="message-text" class="col-form-label">부서명</label>
                     <br>
                     <select name="dCode" required>
 					 <c:forEach var="depart" items="${Dlist}">
			         <c:if test="${ enterprise.eCode eq depart.eCode }">
				     <option value="${depart.dCode}">${depart.dTitle }</option>	
		           	 </c:if>
			         </c:forEach>   
  	                 </select>
  	                 <br>
                     
          
                     
                     <label for="message-text" class="col-form-label">직급</label>
                     <br>
                    <select name="position" required>

					<option value="사원">사원</option>
					<option value="주임">주임</option>
					<option value="대리">대리</option>
					<option value="과장">과장</option>
					<option value="차장">차장</option>
					<option value="부장">부장</option>
					<option value="이사">이사</option>
					
					</select>
					<br>
                     
                     <label for="message-text" class="col-form-label">재직 여부</label>
                     <br>
                     <select name="wStatus" required>
					 <option value="Y">Y</option>
					 <option value="N">N</option>
					 </select>
                     <br>
                     <label for="message-text" class="col-form-label">입사일</label>
                     <input type="Date" class="form-control" id="newCate" name="enrollDate"required>
                  </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="insertEmployee();">추가하기</button>
            </div>
         </div>
      </div>
   </div>
	
	<script>
	function insertEmployee() {
         alert("사원 추가");
         $('#empFrm').attr("action","${pageContext.request.contextPath}/employee/insertEmployee.do");
         $('#empFrm').attr("method", "post");
 		 $('#empFrm').submit();
 		
         
      }
	</script>   
	

		<!-- ------------------ -->
	
		
	
		</div>
	</div>

</body>
<c:import url="../common/footer.jsp" />