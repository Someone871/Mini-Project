<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Food</title>
</head>
<body>
	
	<h1>Available Tiffin Choices</h1>
	<hr>
	
	<!-- TiffinDesc, UnitCost, cuisine, Name, NumAvl -->
	
	<p>Customer ID :: ${cust_id}</p><br>
	
	<table border="2px">
		<tr>
			<th>Chef Name</th>
			<th>Cuisine</th>
			<th>Tiffin Description</th>
			<th>Cost</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${list}" var="chef">
			<tr>
				<td>${chef.getName()}</td>
				<td>${chef.getCuisine()}</td>
				<td>${chef.getTiffinDesc()}</td>
				<td>${chef.getUnitCost()}</td>
				<td>
					<a href="${pageContext.request.contextPath}/CustomerController?action=AddOrder&
					id=${id}&chef_id=${chef.getChef_id()}&TiffinDesc=${chef.getTiffinDesc()}
					&UnitCost=${chef.getUnitCost()}&NumAvl=${chef.getNumAvl()}"
					>Order
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>