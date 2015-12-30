<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Akira</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
</head>
<body>
<div id="sse2">
  <div id="sses2">
    <ul>
      <li><a href="?menu=2&skin=2&p=Javascript-Menus">Javascript Menus</a></li>
      <li><a href="?menu=2&skin=2&p=Horizontal-Menus">Horizontal Menus</a></li>
      <li><a href="?menu=2&skin=2&p=Web-Menus">Web Menus</a></li>
    </ul>
  </div>
</div>

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