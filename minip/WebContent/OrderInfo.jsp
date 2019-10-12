<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Delivery Executive Details</title>
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
              href="#"
              style="font-size: 18px; margin-left: 10px; margin-right: 10px;"
              >Profile</a
            >
          </li>
        </ul>
      </div>
    </nav>
    <!--end of navbar-->
    <div style="margin-top: 100px;">
      <h2 style="text-align: center;">Delivery Details</h2>
      <p>${message}</p>	
      <table class="table table-striped" style="margin-top: 30px;">
        <thead>
          <tr>
            <th scope="col">Chef Name</th>
            <th scope="col">Chef Address</th>
            <th scope="col">Chef Mobile Number</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Customer Address</th>
            <th scope="col">Customer Mobile Number</th>
            <th scope="col">Message</th>
          </tr>
        </thead>
	<c:forEach items="${List}" var="info">
            <tbody>
               <tr>

                  <td>${info.getChefName()}</td>
                  <td>${info.getChefAddress()}</td>
                  <td>${info.getChefMobNo()}</td>
                  <td>${info.getCustomerName()}</td>
                  <td>${info.getCustomerAddress()}</td>
                  <td>${info.getCustomerMobNo()}</td>
                  
	  <c:if test="${info.getStatus() == 'C' }">
		<td>
		<a href="${pageContext.request.contextPath}/DeliveryExecutiveController?id=${info.getOrderId()}&status=${info.getStatus()}&action=LIST&EmpId=${info.getEmpId()}">Delivery Picked Up</a>
		</td>
	  </c:if>

	  <c:if test="${info.getStatus() == 'D' }">
	       <td>
               <a href="${pageContext.request.contextPath}/DeliveryExecutiveController?id=${info.getOrderId()}&status=${info.getStatus()}&action=LIST&EmpId=${info.getEmpId()}">Package Delivered</a>
	       </td>
	 </c:if>

           </tr>
          </tbody>
	</c:forEach>
      </table>
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
