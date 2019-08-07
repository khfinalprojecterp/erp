<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<header>
<div id="wrapper">
	<nav class="navbar navbar-default top-navbar" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".sidebar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.jsp"><strong><i
				class="icon fa fa-tasks"></i>&nbsp;&nbsp;FINAL PROJECT</strong></a>

		<div id="sideNav" href="#">
			<i class="fa fa-bars icon"></i>
		</div>
	</div>
	<ul class="nav navbar-top-links navbar-right">
	
	<c:if test="${empty enterprise && empty employee}">
      
        <!-- 로그인,회원가입 버튼 -->
  <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='${pageContext.request.contextPath}/enterprise/enterpriseLogin.do'" method="post">로그인</button>
 <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='${pageContext.request.contextPath}/enterprise/enterpriseEnroll.do'">회원가입</button>
  
    </c:if>
    
    
    <c:if test="${!empty enterprise || !empty employee}">
    
    
    	<c:if test="${ empty employee && !empty enterprise }">
    	 <span>
    	 <!-- <button class="btn btn-outline-success my-2 my-sm-0" type="button" style="margin-left : 10px;" onclick="fn_chatting();">채팅하기</button> -->
    	 
   		 ${enterprise.eName}</a> 님, 안녕하세요</span>
    	</c:if>
   
  		 <c:if test="${ empty enterprise && !empty employee }">
  		  <span>
  		  <button class="btn btn-outline-success my-2 my-sm-0" type="button" style="margin-left : 10px;" onclick="fn_chatting();">채팅하기</button>
  		  
   		 ${employee.wName}</a> 님, 안녕하세요</span>
    	</c:if>
  
  
	
	
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" aria-expanded="false"> <i
				class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-messages">
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<strong>John Smith</strong> <span class="pull-right text-muted">
								<em>어제</em>
							</span>
						</div>
						<div>내용</div>
				</a></li>
			</ul> <!-- /.dropdown-messages --></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" aria-expanded="false"> <i
				class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-tasks">
				<li><a href="#">
						<div>
							<p>
								<strong>Task 1</strong> <span class="pull-right text-muted">60%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (success)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 2</strong> <span class="pull-right text-muted">28%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="28" aria-valuemin="0" aria-valuemax="100"
									style="width: 28%">
									<span class="sr-only">28% Complete</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 3</strong> <span class="pull-right text-muted">60%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (warning)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 4</strong> <span class="pull-right text-muted">85%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"
									style="width: 85%">
									<span class="sr-only">85% Complete (danger)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a class="text-center" href="#"> <strong>See
							All Tasks</strong> <i class="fa fa-angle-right"></i>
				</a></li>
			</ul> <!-- /.dropdown-tasks --></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" aria-expanded="false"> <i
				class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-alerts">
				<li><a href="#">
						<div>
							<i class="fa fa-comment fa-fw"></i> New Comment <span
								class="pull-right text-muted small">4 min</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
								class="pull-right text-muted small">12 min</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-envelope fa-fw"></i> Message Sent <span
								class="pull-right text-muted small">4 min</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-tasks fa-fw"></i> New Task <span
								class="pull-right text-muted small">4 min</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
								class="pull-right text-muted small">4 min</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a class="text-center" href="#"> <strong>See
							All Alerts</strong> <i class="fa fa-angle-right"></i>
				</a></li>
			</ul> <!-- /.dropdown-alerts --></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" aria-expanded="false"> <i
				class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="${pageContext.request.contextPath}/enterprise/enterpriseEmployeeUpdate.do"><i class="fa fa-user fa-fw"></i> User
						Profile</a></li>		
				<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
				<li class="divider"></li>
				
				
				<c:if test="${ empty employee && !empty enterprise }">
				<li><a href="${pageContext.request.contextPath}/enterprise/enterpriseLogout.do"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
				</c:if>
				
				
				
				
				 <c:if test="${ empty enterprise && !empty employee }">
				 <li><a href="${pageContext.request.contextPath}/employee/employeeLogout.do"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
				 </c:if>
				
				
				</li>

				
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</c:if>
	</ul>
	
	</nav>
	<!--/. NAV TOP  -->
	<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">

			<li><a class="active-menu" href="index.html"><i	class="fa fa-dashboard"></i>ERP</a></li>
			
			<!-- 세호 -->
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>부서 & 사원관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                     <li><a href="#">사원관리<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="${pageContext.request.contextPath}/employee/employeeList.do">사원관리</a></li>
                            <li><a href="${pageContext.request.contextPath}/employee/pmanageList.do">급여관리</a></li>
                            <li><a href="${pageContext.request.contextPath}/employee/attendanceList.do">근태관리</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/department/departmentList.do">부서관리</a></li>
                </ul>
            </li>
			
			<!-- 기석 -->
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>창고 관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/storage/storageList.do">창고 목록</a></li>
                    <li><a href="${pageContext.request.contextPath}/storage/storageDetailList.do">창고 상세 목록</a></li>
                    <li><a href="#">Second Level Link<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">Third Level Link</a></li>
                            <li><a href="#">Third Level Link</a></li>
                            <li><a href="#">Third Level Link</a></li>
                        </ul>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-sitemap"></i>기자재 관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/materialscate/mateCateList.do">기자재 분류</a></li>
                    <li><a href="${pageContext.request.contextPath}/materialscate/mateList.do">기자재 목록</a></li>
                    <li><a href="#">Second Level Link<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">Third Level Link</a></li>
                            <li><a href="#">Third Level Link</a></li>
                            <li><a href="#">Third Level Link</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
			<!-- 원석 -->
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>매입 관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/buy/buy_lookup.do">구매조회</a></li>
                    <li><a href="${pageContext.request.contextPath}/buy/buy_insert.do">구매입력</a></li>
                    <li><a href="${pageContext.request.contextPath}/buy/buy_status.do">구매현황</a></li>
                </ul>
            </li>
        	<!-- 효근 -->
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>매출 관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/sale/partnerList.do?ecode=${enterprise.eCode}">거래처 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/sale/ItemList.do?ecode=${enterprise.eCode}">물품 판매</a></li>
                    <li><a href="${pageContext.request.contextPath}/sale/saleRegist.do?ecode=${enterprise.eCode}">판매 기록</a></li>
                </ul>
            </li>
			<!-- 한솔 -->
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>생산 관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/production/job_orderList.do">작업지시서</a></li>
                    <li><a href="#">생산불출<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">생산품목</a></li>
                        </ul>
                    </li>
                    <li><a href="#">생산입고</a></li>
                </ul>
            </li>	
      
             <li>
                <a href="#"><i class="fa fa-sitemap"></i>물품관리<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                   <li><a href="${pageContext.request.contextPath}/m_storage/M_storageList.do">발주 목록</a></li>
                   <li><a href="${pageContext.request.contextPath}/product/ProductList.do">물품목록</a></li>
                     <li><a href="${pageContext.request.contextPath}/product_category/Product_CategoryList.do">물품분류<span class="fa arrow"></span></a>
                         <li><a href="${pageContext.request.contextPath}/quality_r/Quality_rList.do">품질관리 요청</a></li>
                         <li><a href="${pageContext.request.contextPath}/quality_ch/Quality_chList.do">품질관리 처리</a></li>
                        <ul class="nav nav-third-level">
                            <li><a href="#">생산품목</a></li>
                        </ul>
                    </li>
                    <li><a href="#">생산입고</a></li>
                </ul>
            </li>							
            </li>				
		</ul>

	</div>

	</nav>
	<!-- /. NAV SIDE  -->
</div>

</header>
<script>
	function fn_chatting(){
		
			
		var title = "myChatting";
		var url = '${pageContext.request.contextPath}/chattingRoom.do';
		var status = "width=600px, height=400px, toolbar=no, location=no, status=no, memubar=no, scrollbars=no";
		
		var popup = window.open(url, title, status);
	}
</script>

