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
    //Functon to show divs from the nav menu
    function show_div(toShow)
    {
    	for	(index = 0; index < ids.length; index++) {
    		var show = document.getElementById(ids[index]);
    	    if(toShow==ids[index])
    	    	show.style.display = "";
    	    else
    	    	show.style.display = "none";
    	}
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
		<h1>Component Detail </h1>
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