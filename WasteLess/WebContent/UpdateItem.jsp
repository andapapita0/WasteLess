<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update consumption date</title>
<script> 
function validate()
{ 
 var name = document.form.name.value; 
 var consumption_date = document.form.consumption_date.value; 
 
 if (name==null || name=="")
 { 
 alert("Name cannot be blank"); 
 return false; 
 }

 if (consumption_date==null || consumption_date=="")
 { 
 alert("Consumption date cannot be blank"); 
 return false; 
 }
 
}
</script> 
</head>
<body>
<br>
	<h2 align ="center">Update consumption date: </h2>
		<form name="form" action="UpdateServlet" method="post" onsubmit="return validate()">
			<table style="margin: 0 auto;">
 				<tr>
 					<td>Name of grocery item: </td>
 					<td><input type="text" name="name" /></td>
 				</tr>
 				<tr>
 					<td>Consumption (when the grocery item is fully consumated): </td>
 					<td><input type="text" name="consumption_date" /></td>
 				</tr>
 				
 				<tr>
 					<td><%=(request.getAttribute("errMessage") == null) ? ""
 					: request.getAttribute("errMessage")%></td>
 				</tr>
 				<tr>
 					<td></td>
 					<td><input type="submit" value="Save"></input><input
 					type="reset" value="Reset"></input></td>
 				</tr>
			</table>
		</form>
</body>
</html>