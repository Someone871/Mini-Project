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
      <h1 style="text-align: center;"><b>Chef Report</b></h1><br /><br />
      <h2 style="text-align: center;"><b>Today's Report</b></h2><br />
      <h4 style="text-align: center;">Number of Orders Sent: ${count}</h4><br />
      <h4 style="text-align: center;">Total Money Earned: ${sum}</h4><br /><br /><br />
      <h2 style="text-align: center;"><b>Overall Report</b></h2><br /><br />
      <table class="table table-striped" style="margin-top: 30px;">
        <thead>
          <tr>
            <th scope="col">Date</th>
            <th scope="col">Number of Orders</th>
            <th scope="col">Money Earned</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${report}" var="chefrep">
			<tr>
				<th scope="row">${chefrep.date}</th>
				<td>${chefrep.count}</td>
				<td>${chefrep.sum}</td>
			</tr>
		</c:forEach>
        </tbody>
      </table>
      <br /><br /><br /><br />
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
