<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pending Orders</title>
</head>
<body>
	<h1>Pending Orders!!</h1>
	<table border="1">
	
		<tr>
				<th>Order Id</th>
				<th>Customer Id</th>
				<th>Total Cost</th>
				<th>Action</th>
		</tr>
		
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.order_id}</td>
				<td>${order.cust_id}</td>
				<td>${order.total_cost}</td>
				<td>
					<a href = "${pageContext.request.contextPath}/ChefController?action=Accept&id=${order.chef_id}&o_id=${order.order_id}">Accept</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><hr/>
	
	<form action="ChefController" method="post">
		<input type="hidden" name="action" value="show_profile">
		<input type="hidden" name="id" value="${id}">
		<input type = "submit" value="Profile Page">
	</form>
</body>
</html>