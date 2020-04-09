<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WeeklyReport</title>
</head>
<body>
<ul> 
	<li><p>
            <%=(request.getAttribute("reportw") == null) ? "" : request.getAttribute("reportw")%>
     </p>
     </li></ul>
</body>
</html>