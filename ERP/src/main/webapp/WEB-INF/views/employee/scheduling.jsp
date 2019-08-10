<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../common/scheduleHeader.jsp" />

<body>
	<div id="page-wrapper">
		<c:import url="../common/bodyNav.jsp" />
		<div id="page-inner">

					<div class="container">
					
					
		<c:if test="${ empty employee && !empty enterprise }">
    	 <input type="hidden" id="SCeCode" name="SCeCode" value="${enterprise.eCode}"/>
    	</c:if>
  		<c:if test="${ empty enterprise && !empty employee }">
  		 <input type="hidden" id="SCeCode" name="SCeCode" value="${employee.eCode}"/>
    	</c:if>
					
					
					
					
					
					
					
			        <!-- 일자 클릭시 메뉴오픈 -->
			        <div id="contextMenu" class="dropdown clearfix">
			            <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
			                style="display:block;position:static;margin-bottom:5px;">
			                <li><a tabindex="-1" href="#">카테고리1</a></li>
			                <li><a tabindex="-1" href="#">카테고리2</a></li>
			                <li><a tabindex="-1" href="#">카테고리3</a></li>
			                <li><a tabindex="-1" href="#">카테고리4</a></li>
			                <li class="divider"></li>
			                <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
			            </ul>
			        </div>
			
			        <div id="wrapper">
			            <div id="loading"></div>
			            <div id="calendar"></div>
			        </div>
			
			
			        <!-- 일정 추가 MODAL -->
			        <div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
			            <div class="modal-dialog" role="document">
			                <div class="modal-content">
			                    <div class="modal-header">
			                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
			                                aria-hidden="true">&times;</span></button>
			                        <h4 class="modal-title"></h4>
			                    </div>
			                    <div class="modal-body">
			
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-allDay">하루종일</label>
			                                <input class='allDayNewEvent' id="edit-allDay" type="checkbox">
			                            </div>
			                        </div>
	
											<c:if test="${ empty employee && !empty enterprise }">
    										 <input type="hidden" id="SCeCode" name="SCeCode" value="${enterprise.eCode}"/>
    										</c:if>
  											<c:if test="${ empty enterprise && !empty employee }">
  		 									<input type="hidden" id="SCeCode" name="SCeCode" value="${employee.eCode}"/>
    										</c:if>
			
			
			
			
			
			
			
			
			
			
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-title">일정명</label>
			                                <input class="inputModal" type="text" name="edit-title" id="edit-title"
			                                    required="required" />
			                            </div>
			                        </div>
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-start">시작</label>
			                                <input class="inputModal" type="text" name="edit-start" id="edit-start" />
			                            </div>
			                        </div>
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-end">끝</label>
			                                <input class="inputModal" type="text" name="edit-end" id="edit-end" />
			                            </div>
			                        </div>
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-type">구분</label>
			                                <select class="inputModal" type="text" name="edit-type" id="edit-type">
			                                    <option value="카테고리1">카테고리1</option>
			                                    <option value="카테고리2">카테고리2</option>
			                                    <option value="카테고리3">카테고리3</option>
			                                    <option value="카테고리4">카테고리4</option>
			                                </select>
			                            </div>
			                        </div>
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-color">색상</label>
			                                <select class="inputModal" name="color" id="edit-color">
			                                    <option value="#D25565" style="color:#D25565;">빨간색</option>
			                                    <option value="#9775fa" style="color:#9775fa;">보라색</option>
			                                    <option value="#ffa94d" style="color:#ffa94d;">주황색</option>
			                                    <option value="#74c0fc" style="color:#74c0fc;">파란색</option>
			                                    <option value="#f06595" style="color:#f06595;">핑크색</option>
			                                    <option value="#63e6be" style="color:#63e6be;">연두색</option>
			                                    <option value="#a9e34b" style="color:#a9e34b;">초록색</option>
			                                    <option value="#4d638c" style="color:#4d638c;">남색</option>
			                                    <option value="#495057" style="color:#495057;">검정색</option>
			                                </select>
			                            </div>
			                        </div>
			                        <div class="row">
			                            <div class="col-xs-12">
			                                <label class="col-xs-4" for="edit-desc">설명</label>
			                                <textarea rows="4" cols="50" class="inputModal" name="edit-desc"
			                                    id="edit-desc"></textarea>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="modal-footer modalBtnContainer-addEvent">
			                        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			                        <button type="button" class="btn btn-primary" id="save-event">저장</button>
			                    </div>
			                    <div class="modal-footer modalBtnContainer-modifyEvent">
			                        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			                        <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
			                        <button type="button" class="btn btn-primary" id="updateEvent">저장</button>
			                    </div>
			                </div><!-- /.modal-content -->
			            </div><!-- /.modal-dialog -->
			        </div><!-- /.modal -->
			
			        <div class="panel panel-default">
			
			            <div class="panel-heading">
			                <h3 class="panel-title">필터</h3>
			            </div>
			
			            <div class="panel-body">
			
			                <div class="col-lg-6">
			                    <label for="calendar_view">구분별</label>
			                    <div class="input-group">
			                        <select class="filter" id="type_filter" multiple="multiple">
			                            <option value="카테고리1">카테고리1</option>
			                            <option value="카테고리2">카테고리2</option>
			                            <option value="카테고리3">카테고리3</option>
			                            <option value="카테고리4">카테고리4</option>
			                        </select>
			                    </div>
			                </div>
			
			                <div class="col-lg-6">
			                    
			                    <div class="input-group" style="display: none;">
			                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="정연"
			                                checked>정연</label>
			                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="다현"
			                                checked>다현</label>
			                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="사나"
			                                checked>사나</label>
			                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="나연"
			                                checked>나연</label>
			                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="지효"
			                                checked>지효</label>
			                    </div>
			                </div>
			
			            </div>
			        </div>
			        <!-- /.filter panel -->
			    </div>
			    <!-- /.container -->
		</div>
	</div>

<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/fullcalendar.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/ko.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/vendor/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/js/main.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/js/schedule/js/addEvent.js"></script> --%>
<script src="${pageContext.request.contextPath}/resources/js/schedule/js/editEvent.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule/js/etcSetting.js"></script>

<script>
var eventModal = $('#eventModal');

var modalTitle = $('.modal-title');
var editAllDay = $('#edit-allDay');
var editTitle = $('#edit-title');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editColor = $('#edit-color');
var editDesc = $('#edit-desc');
var editeCode = $('#SCeCode');

console.log(editeCode.val());
var addBtnContainer = $('.modalBtnContainer-addEvent');
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');




/* ****************
 *  새로운 일정 생성
 * ************** */
var newEvent = function (start, end, eventType) {
	
	console.log("asdasdsad");

    $("#contextMenu").hide(); //메뉴 숨김

    modalTitle.html('새로운 일정');
    editStart.val(start);
    editEnd.val(end);
    editType.val(eventType).prop("selected", true);

    addBtnContainer.show();
    modifyBtnContainer.hide();
    eventModal.modal('show');

    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    //var eventId = 1 + Math.floor(Math.random() * 1000);

    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/

    //새로운 일정 저장버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {
    	alert("asdasdaasdasdasd");
    	console.log("qewwqeqwewqeqwe");
        var eventData = {
          //  _id: eventId,
            title: editTitle.val(),
            start: editStart.val(),
            end: editEnd.val(),
           
            description: editDesc.val(),
            type: editType.val(),
            username: '사나',
            backgroundColor: editColor.val(),
            textColor: '#ffffff',
            allDay: false
        };

        if (eventData.start > eventData.end) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (eventData.title === '') {
            alert('일정명은 필수입니다.');
            return false;
        }

        var realEndDay;

        if (editAllDay.is(':checked')) {
        	console.log("asdasdsad");
        	
        	eventData.start = moment(eventData.start).format('YYYY-MM-DD');
            //render시 날짜표기수정
            eventData.end = moment(eventData.end).format('YYYY-MM-DD'); //.add(1, 'days')
            //DB에 넣을때(선택)
            realEndDay = moment(eventData.end).format('YYYY-MM-DD');

            console.log(eventData.end + eventData.start);
            
            eventData.allDay = true;
        	
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);
        eventModal.find('input, textarea').val('');
        editAllDay.prop('checked', false);
        eventModal.modal('hide');
      
        //새로운 일정 저장
        $.ajax({
            type: "get",
            url: "insertschedule.do",
            data: {
            	
            	  title: eventData.title,
                  start: eventData.start,
                  end: eventData.end,
                  
                  eCode: editeCode.val(),
                  
                  description: eventData.description,
                  type: eventData.type,
                  username: '사나',
                  backgroundColor: editColor.val(),
                  textColor: '#ffffff',
                  allDay: eventData.allDay

            },
            success: function (response) {
              
               $('#calendar').fullCalendar('removeEvents');
               $('#calendar').fullCalendar('refetchEvents');

            }
        });
    });
};

</script>

</body>
</html>