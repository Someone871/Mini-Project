<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entities.*" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeliveryExecutive details</title>
</head>

<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
	<div class="container">
	

	<table border=1 class="table table-striped table-bordered">
	<tr class="thead-dark">
		<th>EmpId</th>
		<th>Name</th>
		<th>WorkZone</th>
	    <th>MobileNumber</th>
	</tr>


	<tr>
		<td>${Emp_id}</td>
		<td>${EmpName}</td>
		<td>${WorkZone}</td>
		<td>${EmpMobNo}</td>

<%-- 
	<%= <%
			ArrayList<DeliveryExecutive> list=(ArrayList) request.getAttribute("ListInfo");

	for(int i=0;i<list.size();i++)
	{
		DeliveryExecutive info=new DeliveryExecutive();
		info=list.get(i);
		
	%>	
	        <tr>
				<td><%=info.getEmp_id()%></td>
				 <td><%=info.getEmpName()%></td> 
				<td><%=info.getWorkZone()%></td>
				<td><%=info.getEmpMobNo()%></td>
			
			</tr>	
			
	<%
	}
	%>
 %>

--%>	
	
		
</table> 
<form action="DeliveryExecutiveController" method="post">

	<input type="hidden" value="available_orders"  name="orders" >
	<input type="hidden" value="${Emp_id}" name="id">
	<button type="submit" >Show Orders</button>


</form>




</div>


</body>
</html>