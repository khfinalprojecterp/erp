<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>






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
							발주 목록
							<button style="float: right" type="button"
								class="btn btn-primary" data-toggle="modal"
								data-target="#insertM_storage">발주작성</button>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading"></div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>발주 번호</th>
												<th>아이디</th>
												<th>기자재 이름</th>
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
													<td>${m_storage.MSNO}</td>
													<td>${m_storage.wName}</td>
													<td>${m_storage.mName}</td>
													<td>${m_storage.SCODE}</td>
													<td>${m_storage.MSMSTOCK}EA</td>
													<td>${m_storage.MSDATE}</td>
													<td>${m_storage.MSPRICE}원</td>
													<td>${m_storage.MSSTATUS}</td>


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
				<div class="modal fade" id="insertM_storage" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
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


										<!-- <label for="message-text" class="col-form-label">사원번호</label>
                     <input type="number" class="form-control" id="IDCODE" placeholder="숫자만 입력하세요"name="IDCODE" required>
                     
                     <label for="message-text" class="col-form-label">기자재코드</label>
                     <input type="number" class="form-control" id="MCODE" placeholder="숫자만 입력하세요" name="MCODE" required>
                     
                     <label for="message-text" class="col-form-label">창고코드</label>
                     <input type="number" class="form-control" id="SCODE"placeholder="숫자만 입력하세요"  name="SCODE" required> -->

										<label for="message-text" class="col-form-label">사원번호</label>
										<input type="number" class="form-control" id="IDCODE"
											value="${ employee.idCode }" name="IDCODE" readonly>

										<br> <label for="message-text" class="col-form-label">기자재코드</label>
										<select class="custom-select" id="MCODE">
											<c:forEach items="${mlist}" var="m">
												<option value="${m.mCode}">${m.mName}</option>
											</c:forEach>
										</select> <br> <br> <label for="message-text"
											class="col-form-label">창고코드</label> <select
											class="custom-select" id="SCODE">
											<c:forEach items="${slist}" var="s">
												<c:if test="${ employee.eCode eq s.eCode }">
													<option value="${s.sCode}">${s.sAddr}</option>
												</c:if>
											</c:forEach>
										</select> <br> <label for="message-text" class="col-form-label">수량</label>
										<input type="text" class="form-control" id="MSMSTOCK"
											placeholder="수량을 입력하세요" name="MSMSTOCK"   maxlength="9"  onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"required> <label
											for="message-text" class="col-form-label">신청일</label> <input
											type="date" class="form-control" id="MSDATE" name="MSDATE"
											required>
											
											 <label for="message-text"
											class="col-form-label">납품원가(원)</label> <input type="text"
											class="form-control" id="MSPRICE" placeholder="원가을 입력하세요"
											name="MSPRICE"  maxlength="9"  onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"required> <label for="message-text"
											class="col-form-label">발주상태</label> <br> <select
											id="MSSTATUS" name="MSSTATUS" required>

											<option value="신청">신청</option>
											<option value="거절">거절</option>
											<option value="완료">완료</option>

										</select> <br> <br>

									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">취소</button>
								<button type="button" class="btn btn-primary"
									onclick="insertM_storage();">추가하기</button>
							</div>
						</div>
					</div>
				</div>

				<!--발주 내용 업데이트  -->
				<div class="modal fade" id="updateM_storage" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">발주내용 수정 ・ 삭제</h5>

							</div>
							<div class="modal-body">
								<form>

									<div class="form-group">
										<label for="recipient-name" class="col-form-label">수량</label>
										<input type="number" class="form-control" id="MSMSTOCK">
									</div>
									<div class="form-group">
										<label for="message-text" class="col-form-label">납품원가</label>
										<input type="number" class="form-control" id="MSPRICE">
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">취소</button>
								<button type="button" class="btn btn-primary"
									onclick="updateM_storage();">수정하기</button>
								<button type="button" class="btn btn-danger"
									onclick="deleteM_storage();">삭제하기</button>
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

					var MSNO; //전역 변수를 줘 서
					document.getElementById('MSDATE').valueAsDate = new Date();

					$(function() {
						$('#dataTables-example').DataTable();

					});

					function validation() {
						// 클라이언트 레벨의 유효성 검사

						// form 안에 작성 된 내용을 확인하여
						// 작성이 되어 있지 않으면 false를 반환하는 함수

						var result = true;

						if ($("#IDCODE").val().trim().length == 0
								|| $("#MCODE").val().trim().length == 0) {
							alert("공란을 작성해 주세요!");
							result = false;
						}

						return result;
					}

					function insertM_storage() {

						/* // validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
						if (validation()) {
							alert("작성완료");
							$('#m_storageFrm')
									.attr("action",
											"${pageContext.request.contextPath}/m_storage/insertM_storage.do");
							$('#m_storageFrm').attr("method", "post");
							$('#m_storageFrm').submit();

						} else {
							alert("작성실패");
						}
						} */
						
						var IDCODE = $("#IDCODE").val();
						var MCODE = $("#MCODE").val();
						var SCODE = $("#SCODE").val();
						var MSMSTOCK = $("#MSMSTOCK").val();
						var MSDATE = $("#MSDATE").val();
						var MSPRICE = $("#MSPRICE").val();
						var MSSTATUS = $("#MSSTATUS").val();
						
						
						location.href = "${pageContext.request.contextPath}/m_storage/insertM_storage.do?IDCODE="
								+ IDCODE
								+ "&MCODE="
								+ MCODE
								+ "&SCODE="
								+ SCODE
								+ "&MSMSTOCK="
								+ MSMSTOCK
								+ "&MSDATE="
								+ MSDATE
								+ "&MSPRICE="
								+ MSPRICE
								+ "&MSSTATUS="
								+ MSSTATUS

						;
					}
					function updateM_storage() {

						// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
						if (validation()) {
							alert("작성완료");
							$('#m_storageFrm')
									.attr("action",
											"${pageContext.request.contextPath}/m_storage/updateM_storage.do");
							$('#m_storageFrm').attr("method", "post");
							$('#m_storageFrm').submit();

						} else {
							alert("작성실패");
						}
					}

					function updateM_storage() {

						var MSMSTOCK = $("#MSMSTOCK").val();
						var MSPRICE = $("#MSPRICE").val();

						location.href = "${pageContext.request.contextPath}/m_storage/updateM_storage.do?MSMSTOCK="
								+ MSMSTOCK
								+ "&MSPRICE="
								+ MSPRICE
								+ "&MSNO="
								+ MSNO;

						//연결
					}

					function deleteM_storage() {

						var MSMSTOCK = $("#MSMSTOCK").val();
						var MSPRICE = $("#MSPRICE").val();
						location.href = "${pageContext.request.contextPath}/m_storage/deleteM_storage.do?MSMSTOCK="
								+ MSMSTOCK
								+ "&MSPRICE="
								+ MSPRICE
								+ "&MSNO="
								+ MSNO;
						//연결
					}

					$("#dataTables-example td")
							.click(
									function() {
										/* var mCate = $(this).value; */
										MSNO = $(this).parent().children()
												.eq(0).text();
										document.getElementById("MSMSTOCK").value = $(
												this).parent().children().eq(4)
												.text();
										document.getElementById("MSPRICE").value = $(
												this).parent().children().eq(6)
												.text();
										$("#updateM_storage").modal();
									});
					
					function cmaComma(obj) {
					    var firstNum = obj.value.substring(0,1); // 첫글자 확인 변수
					    var strNum = /^[\,0-9]*$/; // 숫자와 , 만 가능
					    var str = "" + obj.value.replace(/,/gi,''); // 콤마 제거  /[^0-9]/gi;
					    var regx = new RegExp(/(-?\d+)(\d{3})/);  
					    var bExists = str.indexOf(".",0);  
					    var strArr = str.split('.');
					    if (!strNum.test(obj.value)) {
					        alert("숫자만 입력하십시오.\n\n특수문자와 한글/영문은 사용할수 없습니다.");
					        obj.value = 1;
					        obj.focus();
					        return false;
					    }
					    while(regx.test(strArr[0])){
					        strArr[0] = strArr[0].replace(regx,"$1,$2");
					    }  
					    if (bExists > -1)  {
					        obj.value = strArr[0] + "." + strArr[1];
					    } else  {
					        obj.value = strArr[0];
					    }
					}
					 
					function commaSplit(n) {// 콤마 나누는 부분
					    var txtNumber = '' + n;
					    var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
					    var arrNumber = txtNumber.split('.');
					    arrNumber[0] += '.';
					    do {
					        arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
					    }
					    while (rxSplit.test(arrNumber[0]));
					    if(arrNumber.length > 1) {
					        return arrNumber.join('');
					    } else {
					        return arrNumber[0].split('.')[0];
					    }
					}

				</script>





			</div>
		</div>
</body>
<c:import url="../common/footer.jsp" />