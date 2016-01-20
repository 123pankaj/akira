<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html ng-app="akira" >
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Akira</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"> </script> 
<script type="text/javascript" src="js/bootstrap.min.js"> </script>
<script type="text/javascript" src="js/angular.min.js"> </script>
<style>
#logs tr th { cursor: pointer; }
</style>
</head>

<body>

<div ng-controller="logCtrl">

<nav class="navbar navbar-inverse">
  <div class="container-fluid" >
  

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a ng-click="showDiv('verify')">Test <span class="sr-only">(current)</span></a></li>
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Component <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a ng-click="showDiv('component')">AUI</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">More to come</a></li>
          </ul>
        </li>
         <li><a ng-click="showDiv('logout')">Logout</a></li>
      </ul>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<!-- Test the Format to check the functionality -->
 <div ng-show="isVerify">
	<form action="/verify" method="post">
	<div>
		<h1>Apache</h1>
	</div>
	
	<div >
		<input type="text" placeholder="%v:%p %h %l %u %t ..." required="" id="logFormat" name="logFormat"/><br>
		<input type="text" placeholder="testStr" required="" id="testStr" name="testStr"/>
		<br/><br/>
	</div>
	<div>
		<input type="submit" value="Test" />
	</div>
	</form>
	
</div>

 <div ng-show="isComponent">
	<div>
		<table class="table table-hover table-bordered" id="logs">
  		<tr>
   		 	<th ng-click="sortBy('id')">Id</th>
   		 	<th ng-click="sortBy('Endpoint')">EndpointIp</th>
   		 	<th ng-click="sortBy('RemoteHostName')">RemoteIp</th>
   		 	<th ng-click="sortBy('RequestMethod')">RequestMethod</th>
   		 	<th ng-click="sortBy('URLRequested')">URLRequested</th>
   		 	<th ng-click="sortBy('statusCode')">StatusCode</th>
   		 	<th ng-click="sortBy('byteSent')">ByteSent</th>
   		 	<th ng-click="sortBy('TimeInMicro')">ResponseTime</th>
   		 	<th ng-click="sortBy('ProcessId')">ProcessId</th>
   		 	<th ng-click="sortBy('ReferHead')">ReferHead</th>
   		 	<th ng-click="sortBy('userAgent')">UserAgent</th>
  		</tr>
  		<tr ng-repeat="item in LogArray">
    		<td>{{item.id}}</td>
    		<td>{{item.endpoint}}</td>
    		<td>{{item.remoteHostName}}</td>
    		<td>{{item.requestMethod}}</td>
    		<td>{{item.urlRequested}}</td>
    		<td>{{item.statusCode}}</td>
    		<td>{{item.byteSent}}</td>
    		<td>{{item.timeInMicro}}</td>
    		<td>{{item.processId}}</td>
    		<td>{{item.referHead}}</td>
    		<td>{{item.userAgent}}</td>
    	</tr>
	</table>
	</div>
	
	<div style="width:50%;margin-left:auto;margin-right:auto;" >
	<button style="float:left"  ng-click="loadPreLogs()">Previous</button>
	<button style="float:right" ng-click="loadNextLogs()">Next</button>
	</div>
	
</div>


 <div ng-show="isLogout">
	<div>
		<h1>you can close the window now.</h1>
	</div>
</div>

</div>
<script type="text/javascript" src="js/controllers/logCtrl.js">

</script>
<script type="text/javascript" src="js/services/Constant.js"></script>
<script type="text/javascript" src="js/services/urlService.js"></script>
<script>
$(function () {
    $("button").click(function(){
       $(this).button('toggle');
       $
    });
 });
</script>
</body>
</html>