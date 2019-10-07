<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Order</title>

</head>
<body>
	<h1>TIFFIN DETAILS :-</h1>
	<hr>
	<p>
	Tiffin Description :-<br>
	${TiffinDesc}<br><br>
	Unit Cost :: ${UnitCost}<br>
	</p>
	
	<form method="post" action="CustomerController">
		Number of tiffins to order :: <input type="number" name="NumOrdered" max="${NumAvl}" min="0">
		&nbsp; Available :: ${NumAvl}<br>
		<input type="hidden" name="id" value="${id}">
		<input type="hidden" name="chef_id" value="${chef_id}">
		<input type="hidden" name="UnitCost" value="${UnitCost}">
		<input type="hidden" name="action" value="ConfirmOrder">
		<button type="submit">Confirm Order</button>
	</form>
</body>
</html>