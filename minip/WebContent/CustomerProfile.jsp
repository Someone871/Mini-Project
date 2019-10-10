<%@page import="entities.Customer"%> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <title>Customer Profile</title>

    <!-- Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
      rel="stylesheet"
    />

    <!-- Argon CSS -->
    <link type="text/css" href="css/argon.css" rel="stylesheet" />
  </head>

  <body>
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
                    <form method="post" action="CustomerController">
                      <input type="hidden" name="action" value="order_food" />
                      <input type="hidden" name="id" value="${customer.cust_id}" />
                      <input type="button" onclick="this.form.submit()" class="btn btn-sm btn-info" value="Order Food" style="margin-right:140px;"/>
                    </form>
                    <form method="post" action="CustomerController">
                      <input type="hidden" name="action" value="show_current_orders" />
                      <input type="hidden" name="id" value="${customer.cust_id}"/>
                      <input
                        type="button"
                        onClick="this.form.submit()"
                        class="btn btn-sm btn-default"
                        value="Current Orders"
                        style="margin-top: -43px;"
                      />
                    </form>
                    <form method="post" action="CustomerController">
                      <input
                        type="hidden"
                        name="action"
                        value="update_customer_profile"
                      />
                      <input
                        type="hidden"
                        name="id"
                        value="${customer.cust_id}"
                      />
                      <input
                        type="button"
                        onClick="this.form.submit()"
                        class="btn btn-sm btn-default btacc"
                        value="Update Profile"
                      />
                    </form>
                  </div>
                </div>
                <div class="col-lg-4 order-lg-1">
                  <div class="card-profile-stats d-flex justify-content-center">
                    <div>
                      <span class="heading">ID</span>
                      <span class="description">${customer.cust_id}</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center mt-5">
                <h3>
                  ${customer.fullname}
                </h3>
              </div>
              <div class="mt-5 py-5 border-top text-center">
                <div class="row justify-content-center">
                  <div class="col-lg-9">
                    ${customer.address}<br />
                    ${customer.area}<br />
                    ${customer.mobno}<br />
                    ${customer.email}<br />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>

    <br /><br />
    <a href="Login.html">Logout</a>

    <!-- Argon JS -->
    <script src="./js/argon.js"></script>
  </body>
</html>
