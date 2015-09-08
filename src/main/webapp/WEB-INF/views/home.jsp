<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Akira</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="container">
<section id="content">
	<form action="/store" method="post">
	<div>
		<h1>Apache Format</h1>
	</div>
	<div >
		<input type="text" placeholder="%v:%p %h %l %u %t ..." required="" id="logFormat" name="logFormat"/>
		<input type="text" placeholder="testStr" required="" id="testStr" name="testStr"/>
		<br/><br/>
	</div>
	<div>
		<input type="submit" value="Store" />
	</div>
	</form>
	</section>
	
</div>
</body>
</html>