<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="views/common/header.jsp" />

<body>

<c:import url="views/common/nav.jsp" />
<div id="page-wrapper">
<c:import url="views/common/bodyNav.jsp" />
   
            <div id="page-inner">

                <!-- /. ROW  -->
   
                 <div class="row">
                        <div class="col-sm-6 col-xs-12">  
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Line Chart</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="line-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Bar Chart</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="bar-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
            
      <div class="row">
         <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
               <div class="panel-body easypiechart-panel">
                  <h4>Profit</h4>
                  <div class="easypiechart" id="easypiechart-blue" data-percent="82" ><span class="percent">82%</span>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
               <div class="panel-body easypiechart-panel">
                  <h4>Sales</h4>
                  <div class="easypiechart" id="easypiechart-orange" data-percent="55" ><span class="percent">55%</span>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
               <div class="panel-body easypiechart-panel">
                  <h4>Customers</h4>
                  <div class="easypiechart" id="easypiechart-teal" data-percent="84" ><span class="percent">84%</span>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
               <div class="panel-body easypiechart-panel">
                  <h4>No. of Visits</h4>
                  <div class="easypiechart" id="easypiechart-red" data-percent="46" ><span class="percent">46%</span>
                  </div>
               </div>
            </div>
         </div>
      </div><!--/.row-->
         
      
            <div class="row">
            <div class="col-md-5">
                  <div class="panel panel-default">
                  <div class="panel-heading">
                     Line Chart
                  </div>
                  <div class="panel-body">
                     <div id="morris-line-chart"></div>
                  </div>                  
               </div>   
               </div>      
               
                  <div class="col-md-7">
               <div class="panel panel-default">
               <div class="panel-heading">
                                Bar Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-bar-chart"></div>
                            </div>
                  
               </div>  
               </div>
               
            </div> 
          
            
            
                <div class="row">
                    <div class="col-md-9 col-sm-12 col-xs-12">
                        <div class="panel panel-default">                            
                     <div class="panel-heading">
                     Area Chart
                  </div>
                  <div class="panel-body">
                     <div id="morris-area-chart"></div>
                  </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Donut Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                            </div>
                        </div>
                    </div>

                </div>
            <div class="row">
            <div class="col-md-12">
            
               </div>      
            </div>    
                <!-- /. ROW  -->

      
            
            
            
                <div class="row">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Tasks Panel
                            </div>
                            <div class="panel-body">
                                <div class="list-group">

                                    <a href="#" class="list-group-item">
                                        <span class="badge">7 minutes ago</span>
                                        <i class="fa fa-fw fa-comment"></i> Commented on a post
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">16 minutes ago</span>
                                        <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">36 minutes ago</span>
                                        <i class="fa fa-fw fa-globe"></i> Invoice 653 has paid
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">1 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has been added
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">1.23 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has added
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">yesterday</span>
                                        <i class="fa fa-fw fa-globe"></i> Saved the world
                                    </a>
                                </div>
                                <div class="text-right">
                                    <a href="#">More Tasks <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-8 col-sm-12 col-xs-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Responsive Table Example
                            </div> 
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>S No.</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>User Name</th>
                                                <th>Email ID.</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>John</td>
                                                <td>Doe</td>
                                                <td>John15482</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Kimsila</td>
                                                <td>Marriye</td>
                                                <td>Kim1425</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Rossye</td>
                                                <td>Nermal</td>
                                                <td>Rossy1245</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Richard</td>
                                                <td>Orieal</td>
                                                <td>Rich5685</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Jacob</td>
                                                <td>Hielsar</td>
                                                <td>Jac4587</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>Wrapel</td>
                                                <td>Dere</td>
                                                <td>Wrap4585</td>
                                                <td>name@site.com</td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
</div>
                    </div>
                </div>
                <!-- /. ROW  -->   



<script>
Morris.Bar({
    element: 'morris-bar-chart',
    data: [{
        y: '2006',
        a: 100,
        b: 90
    }, {
        y: '2007',
        a: 75,
        b: 65
    }, {
        y: '2008',
        a: 50,
        b: 40
    }, {
        y: '2009',
        a: 75,
        b: 65
    }, {
        y: '2010',
        a: 50,
        b: 40
    }, {
        y: '2011',
        a: 75,
        b: 65
    }, {
        y: '2012',
        a: 100,
        b: 90
    }],
    xkey: 'y',
    ykeys: ['a', 'b'],
    labels: ['Series A', 'Series B'],
	 barColors: [
'#22a7f0','#1abc9c',
'#A8E9DC' 
],
    hideHover: 'auto',
    resize: true
});



Morris.Donut({
    element: 'morris-donut-chart',
    data: [{
        label: "Download Sales",
        value: 12
    }, {
        label: "In-Store Sales",
        value: 30
    }, {
        label: "Mail-Order Sales",
        value: 20
    }],
	   colors: [
'#22a7f0','#1abc9c',
'#A8E9DC' 
],
    resize: true
});


Morris.Area({
    element: 'morris-area-chart',
    data: [{
        period: '2010 Q1',
        iphone: 2666,
        ipad: null,
        itouch: 2647
    }, {
        period: '2010 Q2',
        iphone: 2778,
        ipad: 2294,
        itouch: 2441
    }, {
        period: '2010 Q3',
        iphone: 4912,
        ipad: 1969,
        itouch: 2501
    }, {
        period: '2010 Q4',
        iphone: 3767,
        ipad: 3597,
        itouch: 5689
    }, {
        period: '2011 Q1',
        iphone: 6810,
        ipad: 1914,
        itouch: 2293
    }, {
        period: '2011 Q2',
        iphone: 5670,
        ipad: 4293,
        itouch: 1881
    }, {
        period: '2011 Q3',
        iphone: 4820,
        ipad: 3795,
        itouch: 1588
    }, {
        period: '2011 Q4',
        iphone: 15073,
        ipad: 5967,
        itouch: 5175
    }, {
        period: '2012 Q1',
        iphone: 10687,
        ipad: 4460,
        itouch: 2028
    }, {
        period: '2012 Q2',
        iphone: 8432,
        ipad: 5713,
        itouch: 1791
    }],
    xkey: 'period',
    ykeys: ['iphone', 'ipad', 'itouch'],
    labels: ['iPhone', 'iPad', 'iPod Touch'],
    pointSize: 2,
    hideHover: 'auto',
	  pointFillColors:['#ffffff'],
	  pointStrokeColors: ['black'],
	  lineColors:['#22a7f0','#1abc9c'],
    resize: true
});

Morris.Line({
    element: 'morris-line-chart',
    data: [
		  { y: '2014', a: 50, b: 90},
		  { y: '2015', a: 165,  b: 185},
		  { y: '2016', a: 150,  b: 130},
		  { y: '2017', a: 175,  b: 160},
		  { y: '2018', a: 80,  b: 65},
		  { y: '2019', a: 90,  b: 70},
		  { y: '2020', a: 100, b: 125},
		  { y: '2021', a: 155, b: 175},
		  { y: '2022', a: 80, b: 85},
		  { y: '2023', a: 145, b: 155},
		  { y: '2024', a: 160, b: 195}
	],

	 
xkey: 'y',
ykeys: ['a', 'b'],
labels: ['Total Income', 'Total Outcome'],
fillOpacity: 0.6,
hideHover: 'auto',
behaveLikeLine: true,
resize: true,
pointFillColors:['#ffffff'],
pointStrokeColors: ['black'],
lineColors:['gray','#1abc9c']

});
</script>

   
   
</div>

</body>
<c:import url="views/common/footer.jsp" />