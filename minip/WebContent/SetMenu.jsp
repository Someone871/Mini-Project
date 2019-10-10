<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Set Menu</title>
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
	<%
		String chef_id = session.getAttribute("Chef_id").toString();
	%>
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
              href="${pageContext.request.contextPath}/ChefController?action=show_profile&id=<%out.print(chef_id);%>"
              style="font-size: 18px; margin-left: 10px; margin-right: 10px;"
              >Profile</a
            >
          </li>
        </ul>
      </div>
    </nav>

    <div class="container-login100">
      <div class="wrap-login100">
        <form class="login100-form validate-form" action="ChefController" method="post">
          <h2>Today's Tiffin Details</h2>
          <!--Cuisine-->
          <div class="wrap-input100 m-t-85  m-b-35">
            <select name="cuisine" class="input100">
              <option value="" selected disabled hidden>Cuisine</option>
              <option value="Italian">Italian</option>
              <option value="Chinese">Chinese</option>
              <option value="Indian">Indian</option>
              <option value="Thai">Thai</option>
            </select>
          </div>

          <!--Tiffin Description-->
          <div class="wrap-input100  m-b-50">
            <input class="input100" type="text" name="tiff_desc" />
            <span
              class="focus-input100"
              data-placeholder="Tiffin Description"
            ></span>
          </div>

          <!--Number of Tiffins-->
          <div class="wrap-input100 validate-input m-b-50">
            <input class="input100" type="number" name="num_avl" />
            <span
              class="focus-input100"
              data-placeholder="Number of Tiffins"
            ></span>
          </div>

          <!--Cost per tiffin-->
          <div class="wrap-input100  m-b-50">
            <input class="input100" type="number" name="unit_cost" />
            <span
              class="focus-input100"
              data-placeholder="Cost Per Tiffin"
            ></span>
          </div>

          <div class="container-login100-form-btn">
            <button class="login100-form-btn">
              SUBMIT
            </button>
          </div>
          <input type="hidden" name="action" value="set_menu">
		  <input type="hidden" name="id" value="<%out.print(chef_id);%>">
        </form>
      </div>
    </div>

    <div id="dropDownSelect1"></div>

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