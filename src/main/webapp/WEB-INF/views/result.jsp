<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> Result Page </title>
</head>
<c:forEach items="${map}" var="entry">
    ${entry.key} =  ${entry.value}<br>
</c:forEach>
</html>
