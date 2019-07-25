<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/header.jsp" />
<%-- <head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<c:import url="../common/header.jsp"/>
	<style>
		/*글쓰기버튼*/
		input#btn-add{float:right; margin: 0 0 15px;}
	</style>
	<script>
		function fn_goBoardForm(){
			location.href = "${pageContext.request.contextPath}/board/boardForm.do";
		}
		
		$(function(){
			$("tr[id]").on("click",function(){
				var boardNo = $(this).attr("id");
				console.log("bordNo="+boardNo);
				location.href = "${pageContext.request.contextPath}/board/boardView.do?no="+boardNo;
			});
		});
	</script>
</head> --%>
<body>
	<c:import url="../common/nav.jsp" />
	<div id="page-wrapper">
		<c:import url="../common/bodyNav.jsp" />
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">자유 게시판</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>작성자</th>
											<th>작성일</th>
											<th>첨부파일</th>
											<th>조회수</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="b">
											<tr id="${b.boardNo}">
												<td>${b.boardNo}</td>
												<td>${b.boardTitle}</td>
												<td>${b.boardWriter}</td>
												<td>${b.boardDate}</td>
												<td align="center"><c:if test="${b.fileCount>0}">
														<img alt="첨부파일"
															src="${pageContext.request.contextPath}/resources/images/file.png"
															width=16px>
													</c:if></td>
												<td>${b.readCount }</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
					<!--  end  Context Classes  -->
				</div>
			</div>
			<!-- /. ROW  -->
		</div>
	</div>
</body>
<c:import url="../common/footer.jsp" />