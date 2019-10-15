<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <!-- Required meta tags -->
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
      <!-- navbar -->
 
<nav class="navbar navbar-expand-md navbar-light bg-dark fixed-top">
 <button type="button" class="navbar-toggler bg-light" data-toggle="collapse" data-target="#nav">
  <span class="navbar-toggler-icon"></span>
 </button>
  
 <div class="collapse navbar-collapse justify-content-between" id="nav">
    <ul class="navbar-nav">
      <li class="nav-item dropdown" data-toggle="dropdown">
      <a class="nav-link text-light font-weight-bold px-3 dropdown-toggle" href="#">Search By Cuisine</a>
       <div class="dropdown-menu">
       <a class="dropdown-item" href="CustomerController?action=order_food&id=${id}&cuisine=Indian">Indian</a>
       <a class="dropdown-item" href="CustomerController?action=order_food&id=${id}&cuisine=Chinese">Chinese</a>
       <a class="dropdown-item" href="CustomerController?action=order_food&id=${id}&cuisine=Italian">Italian</a>
       <a class="dropdown-item" href="CustomerController?action=order_food&id=${id}&cuisine=Thai">Thai</a>
       </div>
      </li>
      
      <li class="nav-item">
      <a class="nav-link text-light font-weight-bold px-3" href="CustomerController?action=show_profile&id=${id}">
		Profile
	  </a>
      </li>
     
      <li class="nav-item">
      <a class="nav-link text-light font-weight-bold px-3" href="#">Current Orders</a>
      </li>
   </ul>
</div>
</nav>  
	<!--Each row has one cards-->
	<div class="row">
	<!--first card of 6 columns-->
	<c:forEach items="${list}" var="chef">
		<div class="col-md-12">
			<div class="card mb-3 card-design" style="width: 850px; height: 400px;">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img
							class="rounded-circle"
							src="images/avatar-01.jpg"
							class="card-img"
							alt="..."
						/>
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center; font-size: 30px;">Dish</h4>
								<p class="card-text style-card">
									<table>                                              
										<tr>
											<td class="field">Chef</td>
											<td class="value">${chef.getName()}</td>
										</tr>
										<tr>
											<td class="field">Cuisine</td>
											<td class="value">${chef.getCuisine()}</td>
										</tr>
										<tr>
											<td class="field">Price</td>
											<td class="value">${chef.getUnitCost()}</td>
										</tr>
									</table>
                                <br />
                                <p class="descript">${chef.getTiffinDesc()}</p>
                                </p>
                                <a href="${pageContext.request.contextPath}/CustomerController?action=AddOrder&
									id=${id}&chef_id=${chef.getChef_id()}&TiffinDesc=${chef.getTiffinDesc()}
									&UnitCost=${chef.getUnitCost()}&NumAvl=${chef.getNumAvl()}"
								>
                                	<button class="btn btn-md btn-success btn-block btn-order">
                                  		ORDER
                                	</button>
                                </a>
                              </p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
  </body>
</html>