<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script> 
function validate()
{ 
 var name = document.form.name.value;
 var quantity = document.form.quantity.value;
 var calorie_value = document.form.calorie_value.value; 
 var purchase_date = document.form.purchase_date.value;
 var expiration_date= document.form.expiration_date.value;
 
 if (name==null || name=="")
 { 
 alert("Name can't be blank"); 
 return false; 
 }
 else if (quantity==null || quantity=="")
 { 
 alert("The quantity can't be blank"); 
 return false; 
 }
 else if (calorie_value==null || calorie_value=="")
 { 
 alert("The calories field can't be blank"); 
 return false; 
 }
 else if(purchase_date==null || purchase_date=="")
 { 
 alert("Purchase date can't be blank."); 
 return false; 
 } 
 else if (expiration_date==null || expiration_date=="")
 { 
 alert("Expiration date can't be blank."); 
 return false; 
 } 
 } 
</script> 
</head>
<body>
	<br>
	<h2 align ="center">Input grocery details: </h2>
		<form name="form" action="AddItemServlet" method="post" onsubmit="return validate()">
			<table style="margin: 0 auto;">
 				<tr>
 					<td>Name</td>
 					<td><input type="text" name="name" /></td>
 				</tr>
 				<tr>
 					<td>Quantity</td>
 					<td><input type="text" name="quantity" /></td>
 				</tr>
 				<tr>
 					<td>Calories</td>
 					<td><input type="text" name="calorie_value" /></td>
 				</tr>
 				<tr>
 					<td>Purchase date</td>
 					<td><input type="text" name="purchase_date" /></td>
 				</tr>
 				<tr>
 					<td>Expiration date</td>
 					<td><input type="text" name="expiration_date" /></td>
 				</tr>
 				<tr>
 					<td>Consumption date</td>
 					<td><input type="text" name="consumption_date" /></td>
 				</tr>
 				
 				<tr>
 					<td><span style="color:red"><%=(request.getAttribute("add") == null) ? ""
 						: request.getAttribute("add")%></span></td>
 				</tr>
 				<tr>
 					<td></td>
 					<td><input type="submit" value="Add"></input><input
 					type="reset" value="Reset"></input></td>
 				</tr>
			</table>
		</form>
</body>
</html>