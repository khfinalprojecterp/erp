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
		
			<div id="container">
				<div id="board-container">
					<input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" value="${board.boardTitle }" required>
					<input type="text" class="form-control" name="boardWriter" value="${board.boardWriter}" readonly required>
				
					<c:forEach items="${attachmentList}" var="a" varStatus="vs">
						<button type="button" 
								class="btn btn-outline-success btn-block"
								onclick="fileDownload('${a.originalFileName}','${a.renamedFileName }');">
							첨부파일${vs.count} - ${a.originalFileName }
						</button>
					</c:forEach>
				    <textarea class="form-control" name="boardContent" placeholder="내용" required>${board.boardContent }</textarea>
				    <br>
				    <button class="btn btn-outline-info" type="button" onclick="location.href='${pageContext.request.contextPath}/board/boardList.do'">리스트로</button>
				    <c:if test="${member.userId eq board.boardWriter}">
				    &nbsp;
					<button class="btn btn-outline-info" type="button" onclick="location.href='${pageContext.request.contextPath}/board/boardUpdateView.do?boardNo=${board.boardNo}'">수정 페이지</button>
					</c:if>
				</div>
			</div>
			
		</div>
	</div>
	<script>
		function fileDownload(oName, rName){
			//한글파일명이 있을 수 있으므로, 명시적으로 encoding
			oName = encodeURIComponent(oName);
			location.href="${pageContext.request.contextPath}/board/fileDownload.do?oName="+oName+"&rName="+rName;
		}
	</script>
</body>
<c:import url="../common/footer.jsp"/>