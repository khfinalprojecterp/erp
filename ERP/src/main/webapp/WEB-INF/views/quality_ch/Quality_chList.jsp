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
						<div class="panel-heading">
							품질관리 처리
							<button style="float: right" type="button"
								class="btn btn-primary" data-toggle="modal"
								data-target="#insertQuality_ch">처리 작성</button>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading"></div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>품질관리코드</th>

												<th>사원이름</th>
												<th>기업명</th>
												<th>적격</th>
												<th>부적격</th>
												<th>불/합격</th>
												<th>진행사항</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="quality_ch" items="${list}"
												varStatus="status">
												<tr class="gradeA">
													<%-- <td>${status.count}</td> --%>
													<td>${quality_ch.QRCODE}</td>

													<td>${quality_ch.WNAME}</td>
													<td>${quality_ch.ENAME}</td>
													<td>${quality_ch.QCHT}</td>
													<td>${quality_ch.QCHF}</td>
													<td>${quality_ch.QCHCHECK}</td>
													<td>${quality_ch.QCHSTATUS}</td>

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
				<div class="modal fade" id="insertQuality_ch" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">품질관리처리 작성</h5>
								<!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
							</div>
							<div class="modal-body">
								<form id="quality_chFrm">
									<div class="form-group">
										<label for="message-text" class="col-form-label">사원번호</label>
										<input type="number" class="form-control" id="IDCODE"
											value="${ employee.idCode }" name="IDCODE" readonly>

										<br>
										<!-- 
                     <label for="message-text" class="col-form-label">품질관리코드</label>
                     <input type="number" class="form-control" id="QRCODE" placeholder="숫자만 입력하세요"name="QRCODE" required> -->
										<label for="message-text" class="col-form-label">품질관리코드</label>
										<select class="custom-select" id="QRCODE">
											<c:forEach items="${qrlist}" var="qr">
												<option value="${qr.QRCODE}">${qr.QRCODE}</option>
											</c:forEach>
											<br>
										</select>
										<!--  <label for="message-text" class="col-form-label">사원코드</label>
                     <input type="number" class="form-control" id="IDCODE"placeholder="숫자만 입력하세요"  name="IDCODE" required> -->
										<label for="message-text" class="col-form-label">기업코드</label>
										<select class="custom-select" id="ECODE">
											<c:forEach items="${elist}" var="e">
												<option value="${e.eCode}">${e.ename}</option>
											</c:forEach>
										</select> <br> <br>
										<!--  <label for="message-text" class="col-form-label">기업코드</label>
                     <input type="number" class="form-control" id="ECODE"placeholder="숫자만 입력하세요"  name="ECODE" required> -->

										<!-- <label for="message-text" class="col-form-label">적격</label> <input
											type="number" class="form-control" id="QCHT" maxlength="1"
											placeholder="부적격시 1,적격시 0을 입력해주세요" name="QCHT" required>
										 -->
										
										<label for="message-text"
											class="col-form-label">적격</label> <br> 
											<select
											id="QCHT" name="QCHT" required>

											<option value="1">적격확인</option>
											<option value="2">임시적격</option>
											
										</select>

									<br>

										<!-- <label for="message-text" class="col-form-label">부적격</label> <input
											type="number" class="form-control" id="QCHF" maxlength="1"
											placeholder="부적격시 1,적격시 0을 입력해주세요" name="QCHF" required>
 -->
<br>
										<label for="message-text"
											class="col-form-label">부적격</label> <br> 
											<select
											id="QCHF" name="QCHF" required>

											<option value="1">부적격확인</option>
											<option value="2">임시부적격</option>
											
										</select>



										<!-- <label for="message-text" class="col-form-label">불/합격</label>
										<input type="text" class="form-control" id="QCHCHECK"
											placeholder="합격  불합격을 작성해주세요" name="QCHCHECK" required>
			
 -->
 										<br>
 										
 										
 										<label for="message-text"
											class="col-form-label">합격유무</label> <br> 
											<select
											id="QCHCHECK" name="QCHCHECK" required>

											<option value="합격">합격</option>
											<option value="불합격">불합격</option>
											
										</select>
										<!-- <label for="message-text" class="col-form-label">진행상황</label>
										<input type="text" class="form-control" id="QCHSTATUS"
											placeholder="입력해주세요" name="QCHSTATUS" required> <br>
 -->							
 										<!-- <label for="message-text"
											class="col-form-label"></label> <br> 
											<select
											id=QCHCHECK name="QCHCHECK" required>

											<option value="1">완료</option>
											<option value="2">비완료</option>
											
										</select>
  -->
 <br>
 										
 
 											<label for="message-text"
											class="col-form-label">진행상황</label> <br> 
											<select
											id="QCHSTATUS" name="QCHSTATUS" required>

											<option value="1">완료</option>
											<option value="2">비완료</option>
											
										</select>
 											
										<br>

									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">취소</button>
								<button type="button" class="btn btn-primary"
									onclick="insertQuality_ch();">추가하기</button>
							</div>
						</div>
					</div>
				</div>

				<!--발주 내용 업데이트  -->
				<div class="modal fade" id="updateQuality_ch" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">품질관리 수정 및 삭제</h5>

							</div>
							<div class="modal-body">
								<form id="Uquality_chFrm">


									<div class="form-group">
										<label for="recipient-name" class="col-form-label">품질코드</label>
										<input type="number" class="form-control" id="UQRCODE"
											name="QRCODE">
									</div>

									<div class="form-group">
										<label for="message-text" class="col-form-label">사원코드</label>
										<input type="number" class="form-control" id="UIDCODE"
											name="IDCODE">
									</div>
									<div class="form-group">
										<label for="message-text" class="col-form-label">기업코드</label>
										<input type="number" class="form-control" id="UECODE"
											name="ECODE">
									</div>
									<div class="form-group"></div>
									<label for="message-text" class="col-form-label">적격</label> <input
										type="number" class="form-control" id="UQCHT" name="QCHT">
									<div class="form-group">
										<label for="message-text" class="col-form-label">부적격</label> <input
											type="number" class="form-control" id="UQCHF" name="QCHF">
									</div>
									<div class="form-group">
										<label for="message-text" class="col-form-label">불/합격</label>
										<input type="text" class="form-control" id="UQCHCHECK"
											name="QCHCHECK">
									</div>
									<div class="form-group">

										<label for="message-text" class="col-form-label">상태</label> <input
											type="text" class="form-control" id="UQCHSTATUS"
											name="QCHSTATUS">





									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">취소</button>
								<!-- <button type="button" class="btn btn-primary"
									onclick="updateQuality_ch();">수정하기</button>
								<button type="button" class="btn btn-danger"
									onclick="deleteQuality_ch();">삭제하기</button> -->
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

					var QRCODE; //전역 변수를 줘 서
					/* document.getElementById('MSDATE').valueAsDate = new Date(); */

					$(function() {
						$('#dataTables-example').DataTable();

					});

					function validation() {
						// 클라이언트 레벨의 유효성 검사

						// form 안에 작성 된 내용을 확인하여
						// 작성이 되어 있지 않으면 false를 반환하는 함수

						var result = true;

						if ($("#QRCODE").val().trim().length == 0
								|| $("#IDCODE").val().trim().length == 0) {
							alert("공란을 작성해 주세요!");
							result = false;
						}

						return result;
					}

					function insertQuality_ch() {

						// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
			/* 			if (validation()) {
							alert("작성완료");
							$('#quality_chFrm')
									.attr("action",
											"${pageContext.request.contextPath}/quality_ch/insertQuality_ch.do");
							$('#quality_chFrm').attr("method", "post");
							$('#quality_chFrm').submit();

						} else {
							alert("작성실패");
						}
					} */
					var QRCODE = $("#QRCODE").val();
					var IDCODE = $("#IDCODE").val();
					var ECODE = $("#ECODE").val();
					var QCHT = $("#QCHT").val();
					var QCHCHECK = $("#QCHCHECK").val();
					var QCHSTATUS = $("#QCHSTATUS").val();
					var QCHF = $("#QCHF").val();
					
					
				location.href = "${pageContext.request.contextPath}/quality_ch/insertQuality_ch.do?QRCODE="
						+ QRCODE
						+ "&IDCODE="
						+ IDCODE
						+ "&QCHF="
						+ QCHF
						+ "&ECODE="
						+ ECODE
						+ "&QCHT="
						+ QCHT
						+ "&QCHCHECK="
						+ QCHCHECK
						+ "&QCHSTATUS="
						+ QCHSTATUS; 
						
					
					}
					
					
					function updateQuality_ch() {

						// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
						if (validation()) {
							alert("작성완료");
							$('#Uquality_chFrm')
									.attr("action",
											"${pageContext.request.contextPath}/quality_ch/updateQuality_ch.do");
							$('#Uquality_chFrm').attr("method", "post");
							$('#Uquality_chFrm').submit();

						} else {
							alert("작성실패");
						}
					}

					/* function updateQuality_ch() {
						
						var QRCODE = $("#QRCODE").val();
						var IDCODE = $("#IDCODE").val();
						
						
						
						
						location.href = "${pageContext.request.contextPath}/quality_ch/updateQuality_ch.do?QRCODE="+QRCODE
								+"&IDCODE="+IDCODE;
						
						//연결
					}
					 */
					function deleteQuality_ch() {

						var QRCODE = $("#QRCODE").val();
						var IDCODE = $("#IDCODE").val();
						location.href = "${pageContext.request.contextPath}/quality_ch/deleteQuality_ch.do?QRCODE="
								+ QRCODE + "&IDCODE=" + IDCODE;
						//연결
					}

					$("#dataTables-example td")
							.click(
									function() {
										/* var mCate = $(this).value; */
										QRCODE = $(this).parent().children()
												.eq(0).text();

										document.getElementById("IDCODE").value = $(
												this).parent().children().eq(1)
												.text();
										document.getElementById("ECODE").value = $(
												this).parent().children().eq(2)
												.text();
										document.getElementById("QCHT").value = $(
												this).parent().children().eq(3)
												.text();
										document.getElementById("QCHF").value = $(
												this).parent().children().eq(4)
												.text();
										document.getElementById("QCHCHECK").value = $(
												this).parent().children().eq(5)
												.text();
										document.getElementById("QCHSTATUS").value = $(
												this).parent().children().eq(6)
												.text();

										$("#updateQuality_ch").modal();
									});
				</script>





			</div>
		</div>
</body>
<c:import url="../common/footer.jsp" />