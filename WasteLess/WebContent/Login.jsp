<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script> 
function validate()
{ 
 var username = document.form.username.value; 
 var password = document.form.password.value;
 
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(password==null || password=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
}
</script> 
</head>
<body>
    <h1>Login</h1>
    <form action="LoginServlet" method="post" onsubmit="return validate()">
        <table cellpadding="3pt">
            <tr>
                <td>Username :</td>
                <td><input type="text" name="username" size="30" /></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><input type="password" name="password" size="30" /></td>
            </tr>
 
            <tr>
                <td>Confirm Password :</td>
                <td><input type="password" name="password" size="30" /></td>
            </tr>
            <tr>
            	<td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
 			</tr>
        </table>
        <p />
        <input type="submit" value="Login" />
    </form>
</body>
</html>