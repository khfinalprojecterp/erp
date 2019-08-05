<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</head>
<body>
	<div style="float: left; position:absolute; left:0px; right:0; height: auto; width: auto; margin: 15px 25px 15px 15px; padding: 10px;" >
		<h3>채팅방 목록</h3>
		<hr style="border-bottom: 3px solid skyblue; width: 100% ">
	
		<ul class="list-unstyled">
			<c:forEach items="${list}" var="r" > 
				<li class="media" id="li-room">
					<input type ="hidden" id="hiddenchCode" value="${ r.chCode }" />
					<input type ="hidden" id="hiddenchName" value="${ r.chName }" />
					<div style="right:0" class="media-body">
						<h5 class="mt-0 mb-1">${ r.chName }</h5>
						<c:forEach items="${mlist}" var="m" >
							<c:if test="${ m.chCode eq r.chCode }" >
								${m.wName}&nbsp;
							</c:if>
						</c:forEach> 
					</div>
				</li>
				<hr style="border-bottom: 1px solid skyblue; width: 100% ">
			</c:forEach>
			
		</ul>
		<button type="button" class="btn btn-primary btn-lg btn-block" onclick="newRoom();">대화방 추가</button>
	</div>
	
	<script>
	
	$("#li-room div").each(function(){
		$(this).click(function(){
			var chCode = $(this).parent().children().eq(0).val();
			var chName = $(this).parent().children().eq(1).val();
			var title = "myChatting " + chName;
			var url = '${pageContext.request.contextPath}/chatting.do?chCode='+chCode;
			var status = "width=500px, height=700px, toolbar=no, location=no, status=no, memubar=no, scrollbars=no";
			var popup = window.open(url, title, status);
		});
	});
	
	function newRoom(){
		var idCode = ${employee.idCode};
		
		var chName = prompt("대화방의 이름을 입력하세요", "새로운 방 제목");
		if(chName.length > 0 && chName.trim() != null ) {
			location.href = '${pageContext.request.contextPath}/roomcreate.do?idCode='+idCode+'&chName=' +chName;
		} else {
			alert("제목을 입력해 주세요");
		}	
	}
	
	</script>
</body>

</html>