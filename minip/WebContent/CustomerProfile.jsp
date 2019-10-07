<%@page import="entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Profile</title>
</head>
<body>

<h1>Customer Profile</h1>
<hr>
<p>
Customer ID   :: ${customer.cust_id}<br>
Full Name 	  :: ${customer.fullname}<br>
Address 	  :: ${customer.address}<br>
Area 		  :: ${customer.area}<br>
Mobile Number :: ${customer.mobno}<br>
E-Mail 		  :: ${customer.email}<br>
</p>

<br><br>

<form method="post" action="CustomerController">
	<input type="hidden" name="action" value="order_food">
	<input type="hidden" name="id" value="${customer.cust_id}">
	<button type="submit">Order Food</button>
</form>

</body>
</html>