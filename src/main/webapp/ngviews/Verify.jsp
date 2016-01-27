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