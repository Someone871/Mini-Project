<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<p>${message}</p>

	<table border=1 class="table table-striped table-bordered">
	<tr class="thead-dark">
		<th>ChefName</th>
		<th>ChefAddress</th>
		<th>ChefMobNo</th>
	    <th>CustomerNamer</th>
	    <th>CustomerAddress</th>
	    <th>CustomerMobNo</th>
	    <th>Message</th>
	</tr>
	
<%
ArrayList<ChefCustomer> list=(ArrayList) request.getAttribute("List");

for(int i=0;i<list.size();i++)
{
	ChefCustomer info=new ChefCustomer();
	info=list.get(i);
	
%>	

<%
	if(info.getStatus().charAt(0)=='C')
	{
%>	
	<!-- for status C -->
	<tr>

		
			<td><%=info.getChefName()%></td>
			 <td><%=info.getChefAddress()%></td> 
			<td><%=info.getChefMobNo()%></td>
			<td><%=info.getCustomerName()%></td>
			<td><%=info.getCustomerAddress()%></td>
			<td><%=info.getCustomerMobNo()%></td>
			<td>
			<a href="${pageContext.request.contextPath}/DeliveryExecutiveController?id=<%=info.getOrderId()%>&status=<%=info.getStatus()%>&action=LIST&EmpId=<%= info.getEmpId()%>">Delivery Picked Up</a>
			</td>
    </tr>	
	
<% 		
	}
%>

<%
	if(info.getStatus().charAt(0)=='D')
	{
%>
	<!-- for status D -->
	<tr>

		
			<td><%=info.getChefName()%></td>
			 <td><%=info.getChefAddress()%></td> 
			<td><%=info.getChefMobNo()%></td>
			<td><%=info.getCustomerName()%></td>
			<td><%=info.getCustomerAddress()%></td>
			<td><%=info.getCustomerMobNo()%></td>
			<td>
			<a href="${pageContext.request.contextPath}/DeliveryExecutiveController?id=<%= info.getOrderId()%>&status=<%=info.getStatus()%>&action=LIST&EmpId=<%= info.getEmpId()%>">Package Delivered</a>
			</td>
    </tr>	
	
	
<% 	
	}
%>


		
<%
}
%>
		
</table> 

</div>
	
	  
	  


</body>
</html>