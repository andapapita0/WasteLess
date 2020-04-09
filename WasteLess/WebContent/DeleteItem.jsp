<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete</title>
<script> 
function validate()
{ 
 var id = document.form.id.value; 

 
 if (id==null || id=="")
 { 
 alert("Id cannot be blank"); 
 return false; 
 }
 
}
</script> 
</head>
<body>
<br>
	<h2 align ="center">Delete item by id: </h2>
		<form name="form" action="DeleteItemServlet" method="post" onsubmit="return validate()">
			<table style="margin: 0 auto;">
 				<tr>
 					<td>Id of item: </td>
 					<td><input type="text" name="id" /></td>
 				</tr>
 				
 				<tr>
 					<td><%=(request.getAttribute("errMessage") == null) ? ""
 					: request.getAttribute("errMessage")%></td>
 				</tr>
 				<tr>
 					<td></td>
 					<td><input type="submit" value="Delete"></input><input
 					type="reset" value="Reset"></input></td>
 				</tr>
			</table>
		</form>
</body>
</html>