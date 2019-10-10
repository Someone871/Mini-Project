<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <link type="text/css" href="css/card.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>

</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light bg-dark fixed-top">
 		<button type="button" class="navbar-toggler bg-light" data-toggle="collapse" data-target="#nav">
  		<span class="navbar-toggler-icon"></span>
 		</button>
  
	 	<div class="collapse navbar-collapse justify-content-between" id="nav">
	    	<ul class="navbar-nav">
	      		<li class="nav-item">
	      			<a class="nav-link text-light font-weight-bold px-3" href="CustomerController?action=show_profile&id=${id}">
	      				Profile
	      			</a>
	      		</li>
	      		<li class="nav-item">
	      			<a class="nav-link text-light font-weight-bold px-3" href="#">Order Food</a>
	      		</li>
	      	</ul>
		</div>
	</nav>

	<div class="d-flex justify-content-center" style="margin-top: 50px;">
		<c:forEach items="${list}" var="order">
			<div class="card" style="width: 70%;margin-top:20px;">
		  		<div class="card-header">
		    		Order ID :: ${order.getOrder_id()}
		  		</div>
			  	<div class="card-body">
			    	<p class="card-text">Chef Name - ${order.getChefName()}</p>
			    	<p class="card-text">Tiffin Description :-</p>
			    	<p class="card-text">${order.getTiffinDesc()}</p>
			    	<br>
			    	<p class="card-text">Total Cost                :: ${order.getTotal_cost()}</p>
			    	<p class="card-text">Number of tiffins ordered  - ${order.getNumOrdered()}</p>
			    	<p class="card-text">Delivery Executive Name    - ${order.getDelName()}</p>
			    	<p class="card-text">Delivery Executive Contact - ${order.getDelContact()}</p>
			    	<p class="card-text">Order Status               - 
						<c:if test="${order.getStatus() == 'W'}">
							Waiting for Chef to Accept Order
							<br>
							<a href="CustomerController?
								id=${order.getCust_id()}
								&action=cancel_order
								&order_id=${order.getOrder_id()}
								&emp_id=${order.getEmp_id()}
								&chef_id=${order.getChef_id()}
								&NumOrdered=${order.getNumOrdered()}" 
								class="btn btn-primary"
							>
								Cancel Order
							</a>
						</c:if>
						<c:if test="${order.getStatus() == 'C'}">
							Cooking
						</c:if>
						<c:if test="${order.getStatus() == 'D'}">
							Under Delivery
						</c:if>
						<c:if test="${order.getStatus() == 'Z'}">
							Order Delivered
						</c:if>
						<c:if test="${order.getStatus() == 'X'}">
							Order Cancelled
						</c:if>
					</p>
			  	</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>