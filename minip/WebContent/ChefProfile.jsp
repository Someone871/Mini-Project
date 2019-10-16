<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <title>Chef Profile</title>

    <!-- Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
      rel="stylesheet"
    />

    <!-- Argon CSS -->
    <link type="text/css" href="css/argon.css" rel="stylesheet" />
  </head>
  
<body>
	<%session.setAttribute("Chef_id",request.getAttribute("Chef_id")); %>
    <main class="profile-page">
      <section class="section-profile-cover section-shaped my-0">
        <!-- Circles background -->
        <div class="shape shape-style-1 shape-primary alpha-4"></div>
      </section>
      <section class="section">
        <div class="container">
          <div class="card card-profile shadow mt--300">
            <div class="px-4">
              <div class="row justify-content-center">
                <div class="col-lg-3 order-lg-2">
                  <div class="card-profile-image">
                    <a href="#">
                      <img
                        src="images/avatar-01.jpg"
                        class="rounded-circle"
                        alt="image"
                      />
                    </a>
                  </div>
                </div>
                <div
                  class="col-lg-4 order-lg-3 text-lg-right align-self-lg-center"
                >
                  <div class="card-profile-actions py-4 mt-lg-0">
                  
                  	<form action="SetMenu.jsp">
                      <input
                        type="button"
                        onclick="this.form.submit()"
                        class="btn btn-sm btn-info"
                        value="Set Menu"
                        style="margin-right:140px;"
                      />
                    </form>
                  	
                  	<form method="post" action="ChefController">
                      <input type="hidden" name="action" value="ViewOrderRequests" />
                      <input
                        type="button"
                        onclick="this.form.submit()"
                        class="btn btn-sm btn-info"
                        value="View Pending Orders"
                        style="margin-right:-43px;"
                      />
                    </form>
                  	
                  	<form method="post" action="ChefController">
                      <input
                        type="hidden"
                        name="action"
                        value="ViewAcceptedOrders"
                      />
                      <input
                        type="button"
                        onClick="this.form.submit()"
                        class="btn btn-sm btn-default btacc"
                        value="View Accepted Orders"
                      />
                    </form>
                    
                    <form method="post" action="ChefController">
                      <input
                        type="hidden"
                        name="action"
                        value="ChefReport"
                      />
                      <input
                        type="button"
                        onClick="this.form.submit()"
                        class="btn btn-sm btn-default btacc"
                        value="View Chef Report"
                      />
                    </form>
                  	
                  </div>
                </div>
                <div class="col-lg-4 order-lg-1">
                  <div class="card-profile-stats d-flex justify-content-center">
                    <div>
                      <span class="heading">ID</span>
                      <span class="description">${chef.chef_id}</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center mt-5">
                <h3>
                  ${chef.name}
                </h3>
              </div>
              <div class="mt-5 py-5 border-top text-center">
                <div class="row justify-content-center">
                  <div class="col-lg-9">
                  	<h4>Profile</h4><br />
                    <b>Address:</b> ${chef.address}<br />
                    <b>Area:</b> ${chef.area}<br />
                    <b>Mobile Number:</b> ${chef.mobno}<br />
                    <b>Rating:<br />
                    ${chef.rating}</b>
                  </div>
                </div>
              </div>
              
              <c:if test="${chef.cuisine != NULL}">
              <div class="mt-5 py-5 border-top text-center">
                <div class="row justify-content-center">
                  <div class="col-lg-9">
                  	<h4>Tiffin Details</h4><br />
                    <b>Cuisine:</b> ${chef.cuisine}<br />
                    <b>Tiffin Description:</b> ${chef.tiffinDesc}<br />
                    <b>Number of tiffins available:</b> ${chef.numAvl}<br />
                    <b>Unit Cost of tiffin:</b> ${chef.unitCost}<br /><br />
                    <c:if test="${chef.numAvl==0}">
                    	<b>Congratulations!!<br />
                    	All tiffins for today have been delivered!!</b>
                    </c:if>
                  </div>
                </div>
              </div>
              </c:if>
              
            </div>
          </div>
        </div>
      </section>
    </main>

    <!-- Argon JS -->
    <script src="./js/argon.js"></script>
  </body>
</html>