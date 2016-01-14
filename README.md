# Akira
Log Reader<br>
It Take Apache format as String and then shows the log in proper format.<br>
There are some condition in formats:
- First condition is if you have any thing inside '{' and '}' please use '"'.<br>
	e.g.<br>
	If this is your Format :<br>
	%{%d-%m-%y:%H:%M:%S}t %v:%p %h %m %U %q %>s %O %D %P %{Referer}i %{User-Agent}i<br>
	You have there entities inside '{' and '}'<br>
	then put this inside quotes ' " '. This fomat should be like <br>
	"%{%d-%m-%y:%H:%M:%S}t" %v:%p %h %m %U %q %>s %O %D %P "%{Referer}i" "%{User-Agent}i"<br>

- Second condition you cant have 2 formatter together without any space or character between them 
   like %U%q is not allowed , it should be %U %q


Working on these condition to over come.
