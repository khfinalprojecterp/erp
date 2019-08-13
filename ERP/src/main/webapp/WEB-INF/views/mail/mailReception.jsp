<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
<title>받은 메일함</title>

<body>

	<c:import url="../common/nav.jsp" />



	<!-- ------------------------------------------------------------------------- -->

	<div id="page-wrapper">
		<c:import url="../common/bodyNav.jsp" />
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">
							메일함
							<button style="float: right" type="button"
								class="btn btn-primary" data-toggle="modal"
								data-target="#insertBuyItem">메일 쓰기</button>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>보낸이</th>
											<th>제목</th>
											<th style="display: none;">메일번호</th>
											<th style="display: none;">메일내용</th>
											<th>받은일자</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="v">
											<tr id="${v.mailSender}">
												<td>${v.mailSender}</td>
												<td>${v.mailTitle}</td>
												<td style="display: none;">${v.keyNum}</td>
												<td style="display: none;">${v.mailContent}</td>
												<td>${v.mailDate}</td>
												<%-- <td style="display: none;">${v.mailSender}</td> --%>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- ------------------------------------------------------------------------- -->



	<script>
		$(function() {

			$("#dataTables-example td")
					.mouseenter(function() {
						$(this).parent().css({
							"background" : "darkgray",
							"cursor" : "pointer"
						});
					})
					.mouseout(function() {
						$(this).parent().css({
							"background" : "white"
						});
					})
					.click(
							function() {
								var mailTitle = $(this).parent().children().eq(
										1).text();
								var keyNum = $(this).parent().children().eq(2)
										.text();
								var mailContent = $(this).parent().children()
										.eq(3).text();
								var mailDate = $(this).parent().children()
										.eq(4).text();
								var mailSender = $(this).parent().children()
										.eq(5).text();

								console.log(mailSender);
								console.log(mailTitle);
								console.log(keyNum);
								console.log(mailContent);
								console.log(mailDate);

								location.href = "${pageContext.request.contextPath}"
										+ "/mail/mailOne.do?keyNum=" + keyNum

							});
		});

		$("#sideNav").click(function() {
			if ($(this).hasClass('closed')) {
				$('.navbar-side').animate({
					left : '0px'
				});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({
					'margin-left' : '260px'
				});

			} else {
				$(this).addClass('closed');
				$('.navbar-side').animate({
					left : '-260px'
				});
				$('#page-wrapper').animate({
					'margin-left' : '0px'
				});
			}
		});
	</script>
</body>
<c:import url="../common/footer.jsp" />