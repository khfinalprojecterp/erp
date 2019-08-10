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
							품질관리 요청
							<button style="float: right" type="button"
								class="btn btn-primary" data-toggle="modal"
								data-target="#insertQuality_r">요청 작성</button>
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
												<th>창고위치</th>
												<th>물품명</th>


												<th>기업명</th>
												<th>적요</th>
												<th>검사구분</th>
												<th>수량</th>
												<th>진행상황</th>
												

											</tr>
										</thead>
										<tbody>
											<c:forEach var="quality_r" items="${list}" varStatus="status">
												<tr class="gradeA">
													<%-- <td>${status.count}</td> --%>
													<td>${quality_r.QRCODE}</td>
													<td>${quality_r.WNAME}</td>
													<td>${quality_r.SADDR}</td>
													<td>${quality_r.PNAME}</td>
													<td>${quality_r.ENAME}</td>
													<td>${quality_r.QRCHECK}</td>
													<td>${quality_r.QRNOTE}</td>
													<td>${quality_r.QRSTOCK}EA</td>
													<td>${quality_r.QRSTATUS}</td>

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
				<div class="modal fade" id="insertQuality_r" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">품질관리요청</h5>
								<!-- <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button> -->
							</div>
							<div class="modal-body">
								<form id="quality_rFrm">
									<div class="form-group">


										<!--     <label for="message-text" class="col-form-label">품질번호</label>
                     <input type="number" class="form-control" id="QRCODE" placeholder="숫자만 입력하세요"name="QRCODE" required> -->
										<label for="message-text" class="col-form-label">사원번호</label>
										<input type="number" class="form-control" id="IDCODE"
											value="${ employee.idCode }" name="IDCODE" readonly>
										<br> <label for="message-text" class="col-form-label">창고코드</label>

										<select class="custom-select" name="selectScode" id="SCODE">
											<c:forEach items="${slist}" var="s">
												<option value="${s.sCode}">${s.sAddr}</option>
											</c:forEach>
										</select> <br> <label for="message-text" class="col-form-label">물품코드</label>
										<select class="custom-select" id="PCODE">
											<c:forEach items="${plist}" var="p">
												<option value="${p.PCODE}">${p.PCODE}</option>
											</c:forEach>
										</select> <br> <label for="message-text" class="col-form-label">기업코드</label>

										<select class="custom-select" id="ECODE">
											<c:forEach items="${elist}" var="e">
												<option value="${e.eCode}">${e.ename}</option>
											</c:forEach>
										</select> <br> <br>
										<!-- <inputtype="number" class="form-control" id="PCODE"
											placeholder="숫자만 입력하세요" name="PCODE" required> <label
											for="message-text" class="col-form-label">기업 코드</label> <input
											type="number" class="form-control" id="ECODE"
											placeholder="코드를 입력하세요" name="ECODE" required> -->
										<!-- <label for="message-text" class="col-form-label">검사구분</label>
										<input type="text" class="form-control" id="QRCHECK"
											placeholder="코드를 입력하세요" name="QRCHECK" required>  -->
											<label for="message-text"
											class="col-form-label">검사구분</label> <br> 
											<select
											id="QRCHECK" name="QRCHECK" required>

											<option value="상시">상시</option>
											<option value="수시">수시</option>
											
										</select>
										<br><br>
											<label
											for="message-text" class="col-form-label">적요</label> <input
											type="text" class="form-control" id="QRNOTE"
											placeholder="필요한 내용을 입력하세요" name="QRNOTE" maxlength="9"   required> 
											
											<label
											for="message-text" class="col-form-label">수량</label> 
											<input
											type="text" class="form-control" id="QRSTOCK"
											placeholder="숫자만 입력해주세요" name="QRSTOCK"  maxlength="9"  onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"required> 
											
											
											
											<label for="message-text"
											class="col-form-label">진행사항</label> <br> 
											<select
											id="QRSTATUS" name="QRSTATUS" required>

											<option value="1">진행중</option>
											<option value="2">완료</option>
											
										</select>
										
											<br><br>
											
											<!-- 
											<label
											for="message-text" class="col-form-label">진행상황</label> <input
											type="text" class="form-control" id="QRCHECK"
											placeholder="진행 중 OR완료 를 입력하세요" name="QRCHECK" required> -->

									<!-- 	<label for="message-text" class="col-form-label">유무</label>
										<input type="text" class="form-control" id="QRSTATUS"
											placeholder="진행 중 OR완료 를 입력하세요" name="QRSTATUS" required>
										<!--  -->
										<!-- <label for="message-text"
											class="col-form-label">신청유무</label> <br> 
											<select
											id="QRSTATUS" name="QRSTATUS" required>

											<option value="1">신청</option>
											<option value="2">거절</option>
											 --> 
										</select>
										
										<br> <br>

									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">취소</button>
								<button type="button" class="btn btn-primary"
									onclick="insertQuality_r();">추가하기</button>

							</div>
						</div>
					</div>
				</div>

				<!--발주 내용 업데이트  -->
				<!-- <div class="modal fade" id="updateQuality_r" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">품질관리요청 수정 ・
									삭제</h5>

							</div>
							<div class="modal-body">
								<form id="Uquality_rFrm">


									<div class="form-group">
										<label for="recipient-name" class="col-form-label">품질관리코드</label>
										<input type="number" class="form-control" id="QRCODE">
									</div>
									<div class="form-group">
										<label for="message-text" class="col-form-label">사원코드</label>
										<input type="number" class="form-control" id="IDCODE">
									</div>
									<div class="form-group">
										<label for="message-text" class="col-form-label">창고코드</label>
										<input type="number" class="form-control" id="SCODE">
									</div>
									<div class="form-group">
										<label for="message-text" class="col-form-label">물품코드</label>
										<input type="number" class="form-control" id="PCODE">
									</div>
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">기업코드</label> <input
									type="number" class="form-control" id="ECODE">
							</div>

							<div class="form-group">
								<label for="message-text" class="col-form-label">검사구분</label> <input
									type="number" class="form-control" id="QRCHECK">
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">적요</label> <input
									type="text" class="form-control" id="QRNOTE">
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">수량</label> <input
									type="number" class="form-control" id="QRSTOCK">
							</div>
							<div class="form-group">
							<label for="message-text" class="col-form-label">진행상황</label>
							<input type="text" class="form-control" id="QRSTATUS"  >
						</div>
						 -->



				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<!-- <button type="button" class="btn btn-primary"
								onclick="updateQuality_r();">수정하기</button>
							<button type="button" class="btn btn-danger"
								onclick="deleteQuality_r();">삭제하기</button> -->
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
		/* 	document.getElementById('MSDATE').valueAsDate = new Date(); */

		$(function() {
			$('#dataTables-example').DataTable();

		});

		/* function validation(){
			// 클라이언트 레벨의 유효성 검사
			
			// form 안에 작성 된 내용을 확인하여
			// 작성이 되어 있지 않으면 false를 반환하는 함수
			
			var result = true;
			
			if($("#QRCODE").val().trim().length() == 0|| $("#IDODE").val().trim().length() == 0){
				alert("공란을 작성해 주세요!");
				result = false;
			}
			
			return result;
		}
		 */

		function insertQuality_r() {

			// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
			/* 	/* if (validation()) { */
			/* alert("작성완료");
			$('#quality_rFrm')
					.attr("action",
							"${pageContext.request.contextPath}/quality_r/insertQuality_r.do").attr("method", "post");
			$('#quality_rFrm').submit(); */

			/// */
			/* 	var QRCODE = $("#QRCODE").val();
				alert(QRCODE) */
			var IDCODE = $("#IDCODE").val();

			var SCODE = $("#SCODE").val();
			var PCODE = $("#PCODE").val();
			var ECODE = $("#ECODE").val();
			var QRCHECK = $("#QRCHECK").val();
			var QRNOTE = $("#QRNOTE").val();
			var QRSTOCK = $("#QRSTOCK").val();
			var QRSTATUS = $("#QRSTATUS").val();
			var QRSTATUS = $("#QRSTATUS").val();
			

			location.href = "${pageContext.request.contextPath}/quality_r/insertQuality_r.do?IDCODE="
					+ IDCODE
					+ "&SCODE="
					+ SCODE
					+ "&PCODE="
					+ PCODE
					+ "&ECODE="
					+ ECODE
					+ "&QRCHECK="
					+ QRCHECK
					+ "&QRNOTE="
					+ QRNOTE + "&QRSTOCK=" + QRSTOCK + "&QRSTATUS=" + QRSTATUS;
			/* } else{
			alert("작성실패");         
			} */
		}

		function updateQuality_r() {

			// validation() true : 빈칸이 없다! 즉, 송신 가능 / false : 빈칸이 있다!, 송신 불가
			if (validation()) {
				alert("작성완료");
				$('#Uquality_rFrm')
						.attr("action",
								"${pageContext.request.contextPath}/quality_r/updateQuality_r.do");
				$('#Uquality_rFrm').attr("method", "post");
				$('#Uquality_rFrm').submit();

			} else {
				alert("작성실패");
			}
		}

		function updateQuality_r() {

			var QRCODE = $("#PCATE	").val();
			var IDCODE = $("#IDCODE").val();

			location.href = "${pageContext.request.contextPath}/quality_r/updateQuality_r.do?QRCODE="
					+ QRCODE + "&IDCDOE=" + IDCODE;

			//연결
		}

		function deletequality_r() {

			var QRCODE = $("#QRCODE").val();
			var IDCODE = $("#IDCODE").val();
			location.href = "${pageContext.request.contextPath}/quality_r/deleteQuality_r.do?QRCODE="
					+ QRCODE + "&IDCODE=" + IDCODE;
			//연결
		}

		$("#dataTables-example td").click(
				function() {
					/* var mCate = $(this).value; */
					QRCODE = $(this).parent().children().eq(0).text();
					document.getElementById("IDCODE").value = $(this).parent()
							.children().eq(1).text();
					document.getElementById("SCODE").value = $(this).parent()
							.children().eq(2).text();
					document.getElementById("PCODE").value = $(this).parent()
							.children().eq(3).text();
					document.getElementById("ECODE").value = $(this).parent()
							.children().eq(4).text();

					document.getElementById("QRCHECK").value = $(this).parent()
							.children().eq(5).text();
					document.getElementById("QRNOTE").value = $(this).parent()
							.children().eq(6).text();
					document.getElementById("QRNOTE").value = $(this).parent()
							.children().eq(7).text();
					document.getElementById("QRSTOCK").value = $(this).parent()
							.children().eq(8).text();

					$("#updateQuality_r").modal();
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