# akira
Log Reader<br>
It Take Apache format as String and then shows the log in proper format.<br>
Only condition is if you have any thing inside '{' and '}' please use '"'.<br>
e.g.<br>
If this is your Format :<br>
%{%d-%m-%y:%H:%M:%S}t %v:%p %h %m %U%q %>s %O %D %P %{Referer}i %{User-Agent}i<br>
You have there entities inside '{' and '}'<br>
then put this inside quotes ' " '. This fomat should be like <br>
"%{%d-%m-%y:%H:%M:%S}t" %v:%p %h %m %U%q %>s %O %D %P "%{Referer}i" "%{User-Agent}i"<br>

