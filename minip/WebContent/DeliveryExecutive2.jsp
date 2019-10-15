		<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <title>Delivery Executive Profile</title>

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
                <div class="col-lg-4 order-lg-3 text-lg-right align-self-lg-center">
                  <div class="card-profile-actions py-4 mt-lg-0">
			<form action="DeliveryExecutiveController" method="post">
				<input
					type="hidden"
					value="${Emp_id}"
					name="id"/>
			
               <input type="hidden" value="ShowOrders"  name="orders" >
               <button type="submit" class="btn btn-sm btn-default">Show Orders</button>
           
                <input
                	type="button"
                	value="Update Profile"
                	name="action"
                	class="btn btn-sm btn-default"/>
			</form>
                   </div>
                </div>
                <div class="col-lg-4 order-lg-1">
                  <div class="card-profile-stats d-flex justify-content-center">
                    <div>
                      <span class="heading">${Emp_id}</span>
                      <span class="description">Delivery Executive ID</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center mt-5">
                <h3>
                  ${EmpName}
                </h3>
              </div>
              <div class="mt-5 py-5 border-top text-center">
                <div class="row justify-content-center">
                  <div class="col-lg-9">
                  
                  <table align="center">
                  	<tr>
                  	 	<td><b>WorkZone</b></td>
                  		<td>${WorkZone}</td>
                  	</tr>
                  	
                  	<tr>
                  		<td><b>MobileNumber</b></td>
                  		<td>${EmpMobNo}</td>
                  	</tr>
                  	
                  	<tr>
                  		<td><b>Rating</b></td>
                  		<td>${Rating}</td>
                  	</tr>
                  
                  </table>
                 
 
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>

    <!-- Argon JS -->
    <script src="./js/argon.js"></script>
  </body>
</html>
