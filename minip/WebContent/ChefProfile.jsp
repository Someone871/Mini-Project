<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chef Profile</title>
</head>
<body>
<h1>Chef Profile</h1>
<p>
Chef_id: ${Chef_id}<br>
Name: ${Name}<br>
Address: ${Address}<br>
Mobile no: ${Mobno}<br>
</p>
<br>
<%session.setAttribute("Chef_id",request.getAttribute("Chef_id")); %>
<input type="hidden" name="id" value="${Chef_id}">
<form action="SetMenu.jsp">
	<input type="hidden" name="action" value="ViewOrderRequests">
	<input type = "submit" value="Set Menu">
</form>
<br>
<form action="ChefController" method="post">
	<input type="hidden" name="action" value="ViewOrderRequests">
	<input type = "submit" value="View Pending Requests">
</form>
<br>
<form action="ChefController" method="post">
	<input type="hidden" name="action" value="ViewAcceptedOrders">
	<input type = "submit" value="View Accepted Requests">
</form>
<br><br>
<a href="Login.html">Logout</a>
</body>
</html>