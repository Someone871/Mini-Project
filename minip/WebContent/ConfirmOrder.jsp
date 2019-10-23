<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Order</title>
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
	<div class="container-login100">
      <div class="wrap-login100">
        <form class="login100-form validate-form">
          <h2>Tiffin Details</h2>
          <div class="container" style="margin-top: 60px; font-size: 20px; ">
            <table class="table table-borderless" style="text-align: center;">
              <tbody>
                <tr>
                  <td class=".th-lg ">Tiffin Description</td>
                  <td class=".th-lg ">${TiffinDesc}</td>
                </tr>
                <tr>
                  <td>Unit Cost</td>
                  <td>${UnitCost}</td>
                </tr>
                <tr>
                  <td>Number of tiffins to order</td>
                  <td>
                  	<form method="post" action="CustomerController">
						<input type="number" name="NumOrdered" max="${NumAvl}" min="0" style="border-bottom-color:gray; border-bottom-style: solid; border-bottom-width: 0.1px;">
						&nbsp; Available :: ${NumAvl}<br>
						<input type="hidden" name="id" value="${id}">
						<input type="hidden" name="chef_id" value="${chef_id}">
						<input type="hidden" name="UnitCost" value="${UnitCost}">
						<input type="hidden" name="action" value="ConfirmOrder">
						<button class="login100-form-btn" type="submit">Confirm Order</button>
					</form>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </form>
      </div>
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