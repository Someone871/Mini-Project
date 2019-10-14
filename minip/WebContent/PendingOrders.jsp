<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Orders</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="imgs/icons/favicon.ico" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/bootstrap/css/bootstrap.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="fonts/iconic/css/material-design-iconic-font.min.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/css-hamburgers/hamburgers.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/animsition/css/animsition.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/select2/select2.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/daterangepicker/daterangepicker.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css" />
    <link rel="stylesheet" type="text/css" href="css/signupcss.css" />
    <!--===============================================================================================-->
  </head>
<body>
    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item ">
            <a
              class="nav-link"
              href="#"
              style="font-size: 18px; margin-left: 10px; margin-right: 10px;"
              >Home <span class="sr-only">(current)</span></a
            >
          </li>
          <li class="nav-item">
            <a
              class="nav-link"
              href="${pageContext.request.contextPath}/ChefController?action=show_profile&id=${id}"
              style="font-size: 18px; margin-left: 10px; margin-right: 10px;"
              >Profile</a
            >
          </li>
        </ul>
      </div>
    </nav>
    <!--end of navbar-->
    <div style="margin-top: 100px;">
      <h1 style="text-align: center;">Pending Orders</h1>
      <c:if test="${!orders.isEmpty()}">
      <table class="table table-striped" style="margin-top: 30px;">
        <thead>
          <tr>
            <th scope="col">Order ID</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Delivery Exec Name</th>
            <th scope="col">Number ordered</th>
            <th scope="col">Total Cost</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${orders}" var="order">
			<tr>
				<th scope="row">${order.order_id}</th>
				<td>${order.custName}</td>
				<td>${order.delName}</td>
				<td>${order.numOrdered}</td>
				<td>${order.total_cost}</td>
				<td>
					<a href = "${pageContext.request.contextPath}/ChefController?action=Accept&id=${order.chef_id}&o_id=${order.order_id}">Accept</a>
				</td>
			</tr>
		</c:forEach>
        </tbody>
      </table>
      </c:if>
      <c:if test="${orders.isEmpty()}">
      <br /><br />
      <h4 style="text-align: center;">No Orders Pending!!</h4>
      </c:if>
    </div>

    <!--===============================================================================================-->
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/animsition/js/animsition.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/select2/select2.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/daterangepicker/moment.min.js"></script>
    <script src="vendor/daterangepicker/daterangepicker.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/countdowntime/countdowntime.js"></script>
    <!--===============================================================================================-->
    <script src="js/main.js"></script>
  </body>
</html>