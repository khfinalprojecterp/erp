<%@page import="com.kh.erp.enterprise.model.vo.Enterprise"%>
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
                  <div class="panel-heading">부서 조회
                     <button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertDepartment">
                       부서 등록</button>
                  </div>
                  <div class="panel-body">
                     <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover"
                           id="dataTables-example">
                           <thead>
                              <tr>
                                 <th>등록된 부서명</th>
                              </tr>
                           </thead>
                           <tbody>
                        <c:forEach var="depart" items="${list}">
								<c:if test="${ enterprise.eCode eq depart.eCode }">
									<tr id="${depart.dCode}">
									<td style="display: none;">${depart.dCode}</td>
									<td>${depart.dTitle}</td>
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

			 <!-- 부서 추가용 모달 -->
   <div class="modal fade" id="insertDepartment" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">부서 등록</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="departFrm">
                  <div class="form-group">
                     <label for="message-text" class="col-form-label">부서명</label>
                    <input type="text" class="form-control" name="dTitle" id="dTitle" required>
                    <input type="hidden" class="form-control" name="eCode" id="eCode" value="${enterprise.eCode}">
                  </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="insertDepartment();">추가하기</button>
            </div>
         </div>
      </div>
   </div>
	
	<script>
	function insertDepartment() {
         alert("부서 추가");
         $('#departFrm').attr("action","${pageContext.request.contextPath}/department/insertDepart.do");
         $('#departFrm').attr("method", "get");
 		 $('#departFrm').submit();
 		
         
      }
	</script>   
	
		<!-- --------------------- -->
	
			   <!-- 부서 수정 삭제  -->
   <div class="modal fade" id="updateDepartment" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">부서 수정 삭제</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="departUpdateFrm">
                  <div class="form-group">
                  	 
                     <input type="hidden" class="form-control" id="dCode2" name="dCode" readonly>
                  	 </div>
                  	  <div class="form-group">
                     <label for="message-text" class="col-form-label">부서명</label>
                    <input type="text" class="form-control"  name="dTitle" id="dTitle2" required>
                   </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="updateDepartment();">수정하기</button>
               <button type="button" class="btn btn-danger" onclick="deleteDepartment();">삭제하기</button>
            </div>
         </div>
        </div>
       </div>
		<!-- -------------------------------------------------------------------------------------- -->
	
	
	<script>
	 function updateDepartment() {
         alert("부서 정보 수정");
         $('#departUpdateFrm').attr("action","${pageContext.request.contextPath}/department/updateDepartment.do");
         $('#departUpdateFrm').attr("method", "post");
 		 $('#departUpdateFrm').submit();
         
         
         
      }
      
      function deleteDepartment() {
    	  
    	  
    	  $.ajax({
    		url : "${pageContext.request.contextPath}/employee/departCheck.do",
    		type : "post",
    		data : {
    			dCode : $('#dCode2').val()
    		},
    		success : function(data){
    			if(data == 'ok'){
    				alert("부서 정보 삭제");
    		         $('#departUpdateFrm').attr("action","${pageContext.request.contextPath}/department/deleteDepartment.do");
    		         $('#departUpdateFrm').attr("method", "post");
    		 		 $('#departUpdateFrm').submit();
    				
    			}else{
    				
    				alert("해당부서의 등록된 사원들을 모두 정리해주셔야 삭제가 가능합니다.");
    				
    			}
    			
    		},
    		error : function(request, status, error){
    			   console.log("------ ERROR ------");
		               console.log(request);
		               console.log(status);
		               console.log(error);
		               console.log("-------------------");
    		}
    		
    		  
    		  
    	  });
    	
    	  
         
 
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      $("#dataTables-example td").click(
            function() {
               var mCate = $(this).value;
               document.getElementById("dCode2").value = $(this).parent().children().eq(0).text();
               document.getElementById("dTitle2").value = $(this).parent().children().eq(1).text();
               
               $("#updateDepartment").modal();
            });
   </script>
	

		<!-- --------------------- -->
	
		
	<div class="row">
            <div class="col-md-12">
               <!-- Advanced Tables -->
               <div class="panel panel-default">
                  <div class="panel-heading">부서 상세 조회
                     <button style="float:right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertField">
                       부서 상세 등록</button>
                  </div>
                  <div class="panel-body">
                     <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover"
                           id="dataTables-example2">
                           <thead>
                              <tr>
                              	<th>부서코드</th>
                                 <th>부서명</th>
		     					<th>파트명</th>
	                  			 <th>지역</th>
		     					<th>구분</th>
                              </tr>
                           </thead>
                           <tbody>
                           <c:forEach var="field" items="${flist}">
			<c:if test="${ enterprise.eCode eq field.eCode }">
			<tr id="${field.fCode}">
				<td> ${field.fCode}</td>
				<td>${field.dTitle}</td>
				<td>${field.fName}</td>
				<td>${field.fArea}</td>
				<c:if test ="${field.fPart eq 0 }"><td>현장</td></c:if>
				<c:if test ="${field.fPart eq 1 }"><td>기자재</td></c:if>
				<c:if test ="${field.fPart eq 2 }"><td>공장</td></c:if>
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
		
		
		
		 <!-- 부서 추가용 모달 -->
   <div class="modal fade" id="insertField" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">부서 상세 등록</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="fieldFrm">
                  <div class="form-group">
	       <input type="hidden" class="form-control" name="eCode" id="eCode" value="${enterprise.eCode}"required>
                    
	      <label for="message-text" class="col-form-label">부서선택</label>
	      <br>
	       <select name="dCode" id="dCodeInsert">
 	       <c:forEach var="depart" items="${list}">
	       <c:if test="${ enterprise.eCode eq depart.eCode }">
	       <option value="${depart.dCode}">${depart.dTitle }</option>
	       </c:if>
	       </c:forEach>   
  	       </select>
  	       
  	       <br>

	       <label for="message-text" class="col-form-label">파트이름</label>
	       <input type="text" class="form-control" placeholder="파트이름" name="fName" id="fName" required>
		
	        <label for="message-text" class="col-form-label">지역</label>
	        <input type="text" class="form-control" placeholder="지역" name="fArea" id="fArea" required>
		
	        <label for="message-text" class="col-form-label">파트 구분</label>
	        <div class="form-check form-check-inline">
	        <input type="radio" class="form-check-input" name="fPart" id="fPart0" value="0">
	        <label for="fPart0">현장</label>
	        <input type="radio" class="form-check-input" name="fPart" id="fPart1" value="1">
	        <label for="fPart1">기자재</label>
	        <input type="radio" class="form-check-input" name="fPart" id="fPart2" value="2">
	        <label for="fPart1">공장</label>
	        </div>					
                  </div>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" onclick="insertField();">추가하기</button>
            </div>
         </div>
      </div>
   </div>
	
	<script>
	function insertField() {
		
		
		
		
		if($("#fName").val() == "")
		{ 
			alert("파트이름을 입력해주세요"); $("#fName").focus(); return false; 
		}
		if($("#fArea").val() == "")
		{ 
			alert("지역명을 입력해주세요"); $("#fArea").focus(); return false; 
		}
		if($("#dCodeInsert").val() == null)
		{ 
			alert("부서를 입력해주세요"); $("#dCodeInsert").focus(); return false; 
		}
		
		
		
		
		
		
		
		
		
         alert("부서 상세 등록");
         $('#fieldFrm').attr("action","${pageContext.request.contextPath}/department/insertField.do");
         $('#fieldFrm').attr("method", "get");
 		 $('#fieldFrm').submit();
 		
         
      }
	</script>   
	

		<!-- ------------------ -->
		   <!-- 부서 상세  삭제  -->
   <div class="modal fade" id="updateField" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">부서 상세 삭제</h5>
               <!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
            </div>
            <div class="modal-body">
               <form id="fieldUpdateFrm">
               
               
           <div class="form-group">
           <input  type="hidden" class="form-control" name="fCode" id="fCode">
                 	 <label>선택한 정보를 삭제하시겠습니까?</label>
                </div>   
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-danger" onclick="deleteField();">삭제하기</button>
            </div>
         </div>
        </div>
       </div>
		<!-- -------------------------------------------------------------------------------------- -->
	
	
	<script>
	  
      function deleteField() {
         alert("부서 상세 정보 삭제");
         $('#fieldUpdateFrm').attr("action","${pageContext.request.contextPath}/field/deleteField.do");
         $('#fieldUpdateFrm').attr("method", "get");
 		 $('#fieldUpdateFrm').submit();
 
      }
      
      
      $("#dataTables-example2 td").click(
            function() {
               var fCode = $(this).value;
              document.getElementById("fCode").value = $(this).parent().children().eq(0).text();
            
               
               $("#updateField").modal();
            });
   </script>
	
	<!-- --------------------------------------------------------------------------------------- -->
		
		
		
		
		
		
		</div>
	</div>
	

	
	

</body>
<c:import url="../common/footer.jsp" />