<%@ page language="java" contentType="text/html; charset=ISO-2022-JP"
    pageEncoding="ISO-2022-JP"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Rate Order</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <link type="text/css" href="css/card.css" rel="stylesheet" />
    <link type="text/css" href="css/rating.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>
</head>
<body>
	<!-- NAVBAR -->
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
	      			<a class="nav-link text-light font-weight-bold px-3" href="CustomerController?id=${id}&action=order_food">Order Food</a>
	      		</li>
	      	</ul>
		</div>
	</nav>
	
	<!-- MAIN BODY -->
	<div style="margin-top:10%; text-align: center;">
		<h3>
			How was the food from ${chef_name} ?
		</h3>
		<form action="CustomerController" method="get">
			<input type="hidden" name="id" value="${id}">
	  		<input type="hidden" name="order_id" value="${order_id}">
	  		<input type="hidden" name="chef_id" value="${chef_id}">
	  		<input type="hidden" name="emp_id" value="${emp_id}">
	  		<input type="hidden" name="action" value="rate_chef_emp">
	  		<div class="rating">
		  		<label>
				    <input type="radio" name="chef_rating" value="1" />
				    <span class="icon">★</span>
				  </label>
				  <label>
				    <input type="radio" name="chef_rating" value="2" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				  </label>
				  <label>
				    <input type="radio" name="chef_rating" value="3" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>   
				  </label>
				  <label>
				    <input type="radio" name="chef_rating" value="4" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				  </label>
				  <label>
				    <input type="radio" name="chef_rating" value="5" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				  </label>
			  </div>
			  <br><br>
			<h2>Rate ${del_name}'s delivery</h2>
			  <div class="rating">
		  		<label>
				    <input type="radio" name="def_rating" value="1" />
				    <span class="icon">★</span>
				  </label>
				  <label>
				    <input type="radio" name="del_rating" value="2" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				  </label>
				  <label>
				    <input type="radio" name="del_rating" value="3" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>   
				  </label>
				  <label>
				    <input type="radio" name="del_rating" value="4" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				  </label>
				  <label>
				    <input type="radio" name="del_rating" value="5" />
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				    <span class="icon">★</span>
				  </label>
			  </div>
			  <br>
			  <br>
			  <button class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>