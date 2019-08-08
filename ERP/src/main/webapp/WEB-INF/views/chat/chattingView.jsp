<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- *** 브라우저의 호환성문제(웹소켓을 지원 안하는 경우)를 해결하기 위하여 cnd방식으로 sockjs불러오기 *** -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<!-- 부트스트랩적용 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>실시간 채팅</title>
<script>

	
    /* SockJS객체생성 보낼 url경로를 매개변수로 등록 */
    var sock = new SockJS("<c:url value='/chatting'/>"); //c:url 그냥 찍으면 서버 주소가 찍힘
    /* /info : https://github.com/sockjs/sockjs-protocol/blob/master/sockjs-protocol.py#L250-L263 */
    
    sock.onmessage=onMessage;
    sock.onclose=onClose;
    
    var today=null;
    
    
    
   $(function(){

		
        $("#sendBtn").click(function(){
            console.log("send message.....");
            /* 채팅창에 작성한 메세지 전송 */
            sendMessage();
            /* 전송 후 작성창 초기화 */
            $("#message").val('');
        });
        
        $("#exitBtn").click(function(){
            console.log("exit message.....");
            
            //채팅방 종료
            alert("onClose");
            onClose();
        });
        
        $("#escapeBtn").click(function(){
            console.log("exit message.....");
            // 채팅방에서 나가기
            var chCode= ${room};
            var idCode= ${employee.idCode};
            var resultexit = confirm("대화방에서 나가시겠습니까 ?");
			if(resultexit) {
				location.href = '${pageContext.request.contextPath}/roomexit.do?chCode='+chCode+'&idCode='+idCode;
			} else {
        		alert("취소 하셨습니다.");
        	}
            
        });
        $("#deleteBtn").click(function(){
        	var chCode = ${room};
         	var result = confirm("대화방을 삭제 하시겠습니까 ?");
        	if (result) {
        		location.href = '${pageContext.request.contextPath}/roomdelete.do?chCode='+chCode;
        	} else {
        		alert("취소 하셨습니다.");
        	}
        });
        
        $("#newCodBtn").click(function(){
        	var chCode = ${room};
         	var newchat = prompt("초대할 사원의 사번을 입력하세요.");
         	if(newchat.trim() != null && newchat.length > 0) {
            	location.href = '${pageContext.request.contextPath}/updateMember.do?chCode='+chCode+"&idCode="+newchat;
            	alert("사용자가 초대 되었습니다.");
         	} else {
         		alert("공란을 입력할 수는 없습니다.");
         	}

        });
        
        //사용자 초대
        $("#updateMem").click(function(){
        	var chCode = ${room};
        	var idCode = $("#employeelist").val();
        	if (idCode != null) {
            	location.href = '${pageContext.request.contextPath}/updateMember.do?chCode='+chCode+"&idCode="+idCode;
            	alert("사용자가 초대 되었습니다.");
        	} else {
        		alert("잘못된 초대 입니다.")
        	}

        })

  });
    
    function sendMessage() {
        /* 맵핑된 핸들러 객채의 handleTextMessage매소드가 실행 */
        today=new Date();
        printDate=today.getFullYear()+"/"+today.getMonth()+"/"+today.getDate()+" "+today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
        sock.send($("#message").val() + "|" + printDate);
    };
    
     
     
    function onMessage(evt){
        var data=evt.data;//new text객체로 보내준 값을 받아옴.
        var host=null;//메세지를 보낸 사용자 ip저장
        var strArray=data.split("|");//데이터 파싱처리하기
        var userName=null;//대화명 저장
        
        //전송된 데이터 출력해보기
        for(var i=0;i<strArray.length;i++) {
            console.log('str['+i+'] :' + strArray[i]);	 		
        }
        
        if(strArray.length>1) {
            sessionId=strArray[0];
            message=strArray[1];
            printDate=strArray[2];
            host=strArray[3].substr(1,strArray[3].indexOf(":")-1);
            userName=strArray[4];
            
            console.log(today);
            var ck_host='${host}';
     
            console.log(sessionId);
            console.log(message);
            console.log('host : '+host);
            console.log('ck_host : '+ck_host);
            /* 서버에서 데이터를 전송할 경우 구분짓기 위한 분기 처리 */
            /* Ex) 사용자 접속 안내 등 */
            if(host==ck_host||(host==0&&ck_host.includes('0:0:'))) {
            	
            	var printHTML;
            		
            	if(userName == '${enterprise.eName}'){
            		// 채팅 송신자가 자기 자신이라면....
            		printHTML = "<div style='margin-left: 30%;'>";
            			//+ "<div class='alert alert-success'>";
            	} else {
            		// 채팅 송신자가 자신이 아니라면 ....
            		printHTML = "<div style='margin-right: 30%;'>";
            			//+ "<div class='alert alert-info'>";
            	}
            	
                printHTML+="<sub>"+printDate+"</sub><br/>";
                printHTML+="<strong>["+userName+"] : "+message+"</strong>";
                printHTML+="</div>";
                printHTML+="</div>";
                $('#chatdata').append(printHTML);
            } else {
                var printHTML="style='margin-left: -5%;margin-right:30%;'>";
                printHTML+="<sub>"+printDate+"</sub><br/>";
                printHTML+="<strong>["+userName+"] : "+message+"</strong>";
                printHTML+="</div>";
                printHTML+="</div>";
                $('#chatdata').append(printHTML);
            }
            
            scrollDown();
        } else {
            //나가기 구현
            today=new Date();
            printDate=today.getFullYear()+"/"+today.getMonth()+"/"+today.getDate()+" "+today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
            message=strArray[0];
            var printHTML="<div style='margin-left30%:'>";
            printHTML+="<sub>"+printDate+"</sub><br/>";
            printHTML+="<strong>[서버관리자] : "+message+"</strong>";
            printHTML+="</div>";
            printHTML+="</div>";
            $('#chatdata').append(printHTML);
            
            scrollDown();
        }
    };
    
    /* 채팅 입력 시 스크롤 내리기 */
    function scrollDown(){
    	$('#chatdata').animate({
            scrollTop: $('#chatdata').get(0).scrollHeight
        }, 100);
    }
    
    function onClose(){
        location.href='${pageContext.request.contextPath}';
        self.close();
    };
    
    function loadjoin() {
    	$("#insertModal").modal();
    }
</script>
<style>
#chatdata{
	height:300px; 
	overflow: auto;
}

</style>
</head>
<body>
	<div style='display: inline; width: 700px; height:500px;'>
		<div style='display: inline; float: left; height: 500px; width: 500px; padding:3%;'>
			<div class='form-group'>
				<label id='sessionuserid'><h3>${employee.wName}님,
						어서오세요!</h3></label><br />
				<!-- 대화내용이 출력되는 부분 -->
				<div class='panel panel-default'>
					<div id='chatdata' class='panel-body'></div>
				</div>
				<!-- 메세지 작성부분 -->
				<textarea name='message' id='message' style="width: 100%;"></textarea>
				<br />
				<button class='btn btn-primary' type="button" id='sendBtn'>전송</button>
				<div style="float:right">
					<button class='btn btn-primary' type="button" id='escapeBtn'>대화방 나가기</button>
					<button class='btn btn-primary' type="button" id='exitBtn'>종료</button>
				</div><br><br>
				<button type="button" class="btn btn-primary" onclick="loadjoin();">사용자 초대</button>
				<button class='btn btn-primary' type="button" id='newCodBtn'>사번으로 초대</button>
				<button style="float:right" class='btn btn-primary' type="button" id='deleteBtn'>대화방 삭제</button>
			</div>
		</div>
	</div>
	
<!-- Modal -->
<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">사용자 초대</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
			<label for="message-text" class="col-form-label">사원 초대:</label>
			<c:if test="${ empty elist }">
			</c:if>
			<select class="custom-select" id="employeelist">
				<c:set var = "memberIdlist" value = "${chMember}"/>
				<c:forEach items="${elist}" var="e" >
					<c:set var = "idCode" value = "${e.idCode}"/>
					<c:if test="${!fn:contains(memberIdlist,idCode)}">
						<option value="${e.idCode}">${e.wName}</option>
					</c:if>
				</c:forEach>
			</select>
		
			<script>
				if($('#employeelist').children('option').length == 0){
					$('<p>초대할수 있는 사원이 없습니다.</p>').insertAfter($('#employeelist'));
					$('#employeelist').remove();
				}
			</script>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary" id="updateMem">초대</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>