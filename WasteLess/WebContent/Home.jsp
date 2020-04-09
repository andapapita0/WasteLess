<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery List</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/waste?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC"
        user="root" password="root"
    />
    <sql:query var="list_groceries" dataSource="${myDS}">
    	SELECT * FROM food;
	</sql:query>
	
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of groceries you have</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity (grams)</th>
                <th>Calories</th>
                <th>Purchase date</th>
                <th>Expiration date</th>
                <th>Consumption date</th>
            </tr>
            
            <c:forEach var="item" items="${list_groceries.rows}">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.quantity}" /></td>
                    <td><c:out value="${item.calorie_value}" /></td>
                    <td><c:out value="${item.purchase_date}" /></td>
                    <td><c:out value="${item.expiration_date}" /></td>
                    <td><c:out value="${item.consumption_date}" /></td>
                   
                </tr>
            </c:forEach>
        </table>
    
    	<div>
        <h4><a href="NotificationServlet"><span style="color:red">CHECK Notifications</span></a></h4>
             <p><br><span style="color:red"><%=(request.getAttribute("err") == null) ? "" 
            		 : request.getAttribute("err")%></span> </p>  
        </div>
        	
        <div>
        <h4><a href="GroceryListServlet">Ideal burndown rates for groceries:</a></h4>
             <p><br> <%=(request.getAttribute("burn") == null) ? "" : request.getAttribute("burn")%> </p>  
        </div>
        
        <div>
        	<h4><a href="AddItem.jsp">Add new grocery</a></h4>
        	<p><br> <%=(request.getAttribute("add") == null) ? "" : request.getAttribute("add")%>  </p>
        </div>
        <div>
        	<h4><a href="UpdateItem.jsp">Update consumption date</a></h4>
        	<p><br> <%=(request.getAttribute("update") == null) ? "" : request.getAttribute("update")%>  </p>
        </div>
        <div>
        	<h4><a href="DeleteItem.jsp">Delete item from grocery list</a></h4>
        	<p><br> <%=(request.getAttribute("delete") == null) ? "" : request.getAttribute("delete")%>  </p>
        </div>
        <div>
        	<h4><a href="MonthlyReportServlet">Get monthly report</a></h4>
        	<p><br> <%=(request.getAttribute("report") == null) ? "" : request.getAttribute("report")%>  </p>
       </div>
       <div>
        	<h4><a href="WeeklyReportServlet">Get weekly report</a></h4>
        	<p><br> <%=(request.getAttribute("reportw") == null) ? "" : request.getAttribute("reportw")%>  </p>
       </div>
  </div>
  
  <div>
  	<h5> If you want to donate your food before it goes to waste, we suggest the following organizations: </h5>
  	<p><br><a href=https://www.fightforlife.ro/rezultate/o-mas-cald-pentru-bunici-.html>www.fightforlife.ro</a></p>
  	<p><br><a href=http://www.omasacalda.ro>www.omasacalda.ro/</a></p>
  </div>
  
  </body>
  