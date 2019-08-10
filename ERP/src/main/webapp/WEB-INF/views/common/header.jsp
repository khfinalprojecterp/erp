<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta content="" name="description" />
<meta content="webthemez" name="author" />
<title>BRILLIANT Free Bootstrap Admin Template - WebThemez</title>
<!-- Bootstrap Styles-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="${pageContext.request.contextPath}/resources/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="${pageContext.request.contextPath}/resources/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesmain.css/js/Lightweight-Chart/cssCharts.css">
<!-- TABLE STYLES-->
<link href="${pageContext.request.contextPath}/resources/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
<%-- 효근 수정(스케쥴러용) --%>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/schedule/vendor/css/fullcalendar.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/schedule/vendor/css/select2.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/schedule/vendor/css/bootstrap-datetimepicker.min.css" />




<!-- JS -->
<!-- JS Scripts-->
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- jQuery Js -->

<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>

<!-- Bootstrap Js -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<!-- Metis Menu Js -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.metisMenu.js"></script>
<!-- Morris Chart Js -->
<script src="${pageContext.request.contextPath}/resources/js/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/morris/morris.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/easypiechart.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/easypiechart-data.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/Lightweight-Chart/jquery.chart.js"></script>

<!-- DATA TABLE SCRIPTS -->
<script src="${pageContext.request.contextPath}/resources/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables/dataTables.bootstrap.js"></script>
<script>
	$(document).ready(function () {
	    $('#dataTables-example').dataTable();
	});
</script>


<!-- Custom Js -->
<script src="${pageContext.request.contextPath}/resources/js/custom-scripts.js"></script>

  
<!-- Chart Js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chart.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chartjs.js"></script>

<!-- style -->
	<style>
		/*글쓰기버튼*/
		input#btn-add{float:right; margin: 0 0 15px;}
		
		div#board-container{width:400px; margin:0 auto; text-align:center;}
		div#board-container input,div#board-container button{margin-bottom:15px;}
		/* 부트스트랩 : 파일라벨명 정렬*/
		div#board-container label.custom-file-label{text-align:left;}
		
	</style> 
	

</head>
