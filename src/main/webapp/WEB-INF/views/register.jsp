<%@ include file="../common/header.jspf"%>
   <title>Register Panel</title>
   </head>

<body>
   <!-- START Main wrapper-->
   <section class="wrapper">
            
      <!-- START Main section-->
      <section>
         <!-- START Page content-->
         
                  
         <section class="main-content">
         <div class="col-lg-6 col-lg-offset-1">
            <c:if test = "${!empty usernameTaken}">        			    			
                       <div class="alert alert-danger">Username is already taken!</div>

                </c:if>        
            <div class="panel panel-default">         
                        <div class="panel-heading">
                           <div class="panel-title">Registration Form</div>
                        </div>
                       <form action="/register" method="post">
                        <div class="panel-body">                          
                           <div class="form-group">
                              <label class="control-label">New Username</label>
                              <input type="text" name="username" required class="form-control">
                           </div>
                           <div class="form-group">
                              <label class="control-label">Password</label>
                              <input type="password" name="password" required class="form-control">
                           </div>
                           <div class="form-group">
                              <label class="control-label">Cash</label>
                              <input type="number" step="any" min="1" name="cash" required class="form-control">
                           </div> 
                           
                           <div class="form-group">
                           <label class="col-sm-2 control-label">Currency</label>
                           <div class="col-sm-10">
                              <select name="currency" class="form-control m-b">                               
                                 <option value="1">US Dollar (USD)</option>
                                 <option value="2">Euro (EUR)</option>
                                 <option value="3">British Pound (GBP)</option>
                              </select>                             
                           </div>
                        </div>    
                        </div>
                        <div class="panel-footer">
                           <button type="submit" class="btn btn-primary">Register</button>                          
                        </div>
                       </form>
                     </div>
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