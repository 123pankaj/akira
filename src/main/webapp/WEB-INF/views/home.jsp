<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Akira</title>
 <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"> </script> 
<script type="text/javascript" src="js/bootstrap.min.js"> </script>
<script>

var ids = ["verify", "component", "logout"];
var data_file="http://localhost:11011/logs/AUI/get?PageNumber=";
var currentpage=0;   
var xhttp = new XMLHttpRequest();

//Functon to show divs from the nav menu
    function show_div(toShow)
    {
    	for	(index = 0; index < ids.length; index++) {
    		var show = document.getElementById(ids[index]);
    	    if(toShow==ids[index]){
    	    	show.style.display = "";
    	    	if(toShow=="component")
    	    		loadPage();
    	    }
    	    else
    	    	show.style.display = "none";
    	}
    }

    xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4) {
	     var jsonlist=JSON.parse(xhttp.responseText);
	     var i;
	     var table=document.getElementById("logs");
	     
	  for(i=table.rows.length-1;i>=1;i--)
	  table.deleteRow(i);
	   
	     for(i=0;i<jsonlist.length;i++){
	        var row = table.insertRow(i+1);
	    	row.insertCell(0).innerHTML=jsonlist[i].id;
	    	row.insertCell(1).innerHTML=jsonlist[i].endpoint;
	    	row.insertCell(2).innerHTML=jsonlist[i].remoteHostName;
	    	row.insertCell(3).innerHTML=jsonlist[i].requestMethod;
	    	row.insertCell(4).innerHTML=jsonlist[i].urlRequested;
	    	row.insertCell(5).innerHTML=jsonlist[i].statusCode;
	    	row.insertCell(6).innerHTML=jsonlist[i].byteSent;
	    	row.insertCell(7).innerHTML=jsonlist[i].timeInMicro;
	    	row.insertCell(8).innerHTML=jsonlist[i].processId;
	    	row.insertCell(9).innerHTML=jsonlist[i].referHead;
	    	row.insertCell(10).innerHTML=jsonlist[i].userAgent;
	     }
	    }
	  };
    function loadPage(){ 
    	  xhttp.open("GET", data_file+currentpage, true);
    	  xhttp.send();
    	  }

    	     	    
    	  // loadPage();
    	   
    	   function loadnext(){
    		currentpage++;
    		loadPage();  
    	   }
    	   
 function loadprev(){
	 currentpage--;
		loadPage();   
    	   }
 
</script> 
</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
   <!--  <div class="navbar-header">
      
      <a class="navbar-brand" href="#">Home</a>
    </div> -->

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#Verify" onclick="return show_div('verify');">Test <span class="sr-only">(current)</span></a></li>
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Component <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#Component#AUI"  onclick="return show_div('component');">AUI</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">More to come</a></li>
          </ul>
        </li>
         <li><a href="#logout"  onclick="return show_div('logout');">Logout</a></li>
      </ul>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<!-- Test the Format to check the functionality -->
 <div id="verify" >
	<form action="/verify" method="post">
	<div>
		<h1>Apache Format</h1>
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
<!-- Test the Format to check the functionality -->
 <div id="component" style="display: none;">
	<div>
		<table border="1" id="logs">
  		<tr>
   		 	<th>Time</th>
   		 	<th>EndpointIp</th>
   		 	<th>RemoteIp</th>
   		 	<th>RequestMethod</th>
   		 	<th>URLRequested</th>
   		 	<th>StatusCode</th>
   		 	<th>ByteSent</th>
   		 	<th>ResponseTime</th>
   		 	<th>ProcessId</th>
   		 	<th>ReferHead</th>
   		 	<th>UserAgent</th>
  		</tr>
  		<%-- <c:forEach items="${LogArray}" var="item">
  		<tr>
    		<th align="center">${item.time}</th>
    		<th align="center">${item.endpoint}</th>
    		<th align="center">${item.remoteHostName}</th>
    		<th align="center">${item.requestMethod}</th>
    		<th align="center">${item.urlRequested}</th>
    		<th align="center">${item.statusCode}</th>
    		<th align="center">${item.byteSent}</th>
    		<th align="center">${item.timeInMicro}</th>
    		<th align="center">${item.processId}</th>
    		<th align="center">${item.referHead}</th>
    		<th align="center">${item.userAgent}</th>
    	</tr>
	</c:forEach> --%>
	</table>
	</div>
	
	<div style="width:50%;margin-left:auto;margin-right:auto;">
	<button style="float:left" onclick="loadprev()">Previous</button>
	<button style="float:right" onclick="loadnext()">Next</button>
	</div>
	
</div>

<!-- Test the Format to check the functionality -->
 <div id="logout" style="display: none;">
	<div>
		<h1>you can close the window now.</h1>
	</div>
</div>

</body>
</html>