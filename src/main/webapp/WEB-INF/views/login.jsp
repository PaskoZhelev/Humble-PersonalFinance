<%@ include file="../common/header.jspf"%>
   <title>Login Panel</title>
   </head>

<body>
   <!-- START Main wrapper-->
   <section class="wrapper">
            
      <!-- START Main section-->
      <section>
         <!-- START Page content-->
         
                  
         <section class="main-content">
         
         <div class="row">
         <div class="col-lg-2"></div>
         
         <div class="col-lg-5">
         <!-- conditional display of a second password field -->
            
                <c:if test = "${!empty unsuccessfulLogin}">
         			<div class="alert alert-danger">Username or Password is incorrect!</div>
      			</c:if>
      			<c:if test = "${!empty successfulRegistration}">
         			<div class="alert alert-success">The Registration is Successful!</div>
      			</c:if>
      			
            <div class="panel panel-info">
                        <div class="panel-heading">
                           <div class="panel-title">Login Form</div>
                        </div>
                       <form action="/login" method="post">
                        <div class="panel-body">                          
                           <div class="form-group">
                              <label class="control-label">Username</label>
                              <input type="text" name="username" required class="form-control">
                           </div>
                           <div class="form-group">
                              <label class="control-label">Password</label>
                              <input type="password" name="password" required class="form-control">
                           </div>   
                        </div>
                        <div class="panel-footer">
                           <button type="submit" class="btn btn-info" >Login</button>
                           &nbsp; &nbsp;
                           <a href="/register"><label class="control-label">Register new account</label></a>
                        </div>
                       </form>
                     </div>
         </div>
         <div class="col-lg-2"></div>
         </div>
         </section>
         
         
         <!-- END Page content-->
      </section>
      <!-- END Main section-->
   </section>
   <!-- END Main wrapper-->
      <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
   <!-- Plugins-->
   <script src="vendor/chosen/chosen.jquery.min.js"></script>
   <script src="vendor/slider/js/bootstrap-slider.js"></script>
   <script src="vendor/filestyle/bootstrap-filestyle.min.js"></script>
   <!-- Animo-->
   <script src="vendor/animo/animo.min.js"></script>
   <!-- Sparklines-->
   <script src="vendor/sparklines/jquery.sparkline.min.js"></script>
   <!-- Slimscroll-->
   <script src="vendor/slimscroll/jquery.slimscroll.min.js"></script>

<%@ include file="../common/footer.jspf"%>