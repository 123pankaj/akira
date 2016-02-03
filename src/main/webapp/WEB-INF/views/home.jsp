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
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/angular-chart.min.css"/>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"> </script> 
<script type="text/javascript" src="js/bootstrap.min.js"> </script>
<script type="text/javascript" src="js/angular.min.js"> </script>
<script type="text/javascript" src="js/angular-route.min.js"> </script>
<script type="text/javascript" src="js/bootstrap-paginator.js"> </script>
<script type="text/javascript" src="js/chart.js"></script>
<script type="text/javascript" src="js/angular-chart.min.js"> </script>

    
<style>
#logs tr th { cursor: pointer; }
</style>
</head>

<body>

<div>


<nav class="navbar navbar-inverse">
  <div class="container-fluid" >
  

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#Verify" ng-click="showDiv('verify')">Test<span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="#/">Test <span class="sr-only">(current)</span></a></li>
       
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Component <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/logs">AUI</a></li>
            <li role="separator" class="divider"></li>
            <li><a>More to come</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">AWS <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/logs">AutoScaling Group</a></li>
            <li role="separator" class="divider"></li>
            <li><a>More to come</a></li>
          </ul>
        </li>
         <li><a  href="#/logout">Logout</a></li>
      </ul>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div ng-view></div>
</div>
<script type="text/javascript" src="js/homeInit.js"></script>
<script type="text/javascript" src="js/controllers/logCtrl.js"></script>
<script type="text/javascript" src="js/controllers/summaryCtrl.js"></script>
<script type="text/javascript" src="js/services/Constant.js"></script>
<script type="text/javascript" src="js/services/urlService.js"></script>
</body>
</html>