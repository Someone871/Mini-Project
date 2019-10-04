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
<a href="SetMenu.jsp">Set Menu</a>
</body>
</html>