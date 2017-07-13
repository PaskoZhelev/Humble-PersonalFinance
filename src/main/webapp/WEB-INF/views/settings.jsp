<%@ include file="../common/header.jspf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Home</title>
<link rel="stylesheet" href="vendor/slider/css/slider.css">
<link rel="stylesheet" href="vendor/chosen/chosen.min.css">
<link rel="stylesheet"
	href="vendor/datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="vendor/codemirror/lib/codemirror.css">
<!-- Bootstrap tags-->
<link rel="stylesheet" href="vendor/tagsinput/bootstrap-tagsinput.css">
</head>

<body>
	<!-- START Main wrapper-->
	<section class="wrapper">
		<%@ include file="../common/top-nav.jspf"%>
		<%@ include file="../common/sidebar.jspf"%>
		<%@ include file="../common/offsidebar.jspf"%>
		<!-- START Main section-->
		<section>
			<!-- START Page content-->
			<section class="main-content">

				<div class="row">
					<div class="col-sm-2"></div>

					<div class="col-sm-4">
						<!-- START panel-->
						<div class="panel panel-info">
							<div class="panel-heading">Change Password</div>
							<div class="panel-body">
								<form class="form-horizontal" method="post">
									<div class="form-group col-sm-12">
										
										<label class="control-label">New Password</label> <input
											type="password" name="password" required class="form-control">
									</div>
									<div class="form-group col-sm-12">
										<label class="control-label">Repeat Password</label> <input
											type="password" name="password2" required
											class="form-control">
									</div>

									<div class="form-group">
										<div class="col-lg-offset-4 col-lg-8 ">
											<button type="submit" name="submit-button" value="password"
												class="btn btn-md btn-info">Submit</button>
										</div>
									</div>
									<c:if test="${!empty successfulPasswordChange}">
											<div class="row">
												<div
													class="col-lg-offset-1 col-lg-10 col-lg-offset-1 alert alert-success">Successfully
													Changed Password!</div>
											</div>
										</c:if>
								</form>
							</div>
						</div>
						<!-- END panel-->
					</div>

					<div class="col-sm-4">
						<!-- START panel-->
						<div class="panel panel-warning">
							<div class="panel-heading">Change Currency</div>
							<div class="panel-body">
								<form class="form-horizontal" method="post">
									<div class="form-group col-sm-12">
										<label class="control-label">Currency</label> <select
											name="currency" class="form-control m-b">
											<option value="1">US Dollar (USD)</option>
											<option value="2">Euro (EUR)</option>
											<option value="3">British Pound (GBP)</option>
										</select>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-4 col-lg-8 ">
											<button type="submit" name="submit-button" value="currency"
												class="btn btn-md btn-warning">Submit</button>
										</div>
									</div>
									<c:if test="${!empty successfulCurrencyChange}">
										<div class="row">
											<div
												class="col-lg-offset-1 col-lg-10 col-lg-offset-1 alert alert-success">Successfully
												Changed Currency!</div>
										</div>
									</c:if>
								</form>
							</div>
						</div>

						<!-- END panel-->
					</div>

					<div class="col-sm-2"></div>
				</div>

			</section>
			<!-- END Page content-->
		</section>
		<!-- END Main section-->
	</section>
	<!-- END Main wrapper-->
	<!-- END Main wrapper-->
	<!-- START Scripts-->
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
	<!-- START Page Custom Script-->
	<script src="vendor/codemirror/lib/codemirror.js"></script>
	<script src="vendor/codemirror/addon/mode/overlay.js"></script>
	<script src="vendor/codemirror/mode/markdown/markdown.js"></script>
	<script src="vendor/codemirror/mode/xml/xml.js"></script>
	<script src="vendor/codemirror/mode/gfm/gfm.js"></script>
	<script src="vendor/marked/marked.js"></script>
	<!-- MomentJs and Datepicker-->
	<script src="vendor/moment/min/moment-with-langs.min.js"></script>
	<script src="vendor/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<!-- Tags input-->
	<script src="vendor/tagsinput/bootstrap-tagsinput.min.js"></script>
	<!-- Input Mask-->
	<script src="vendor/inputmask/jquery.inputmask.bundle.min.js"></script>
	<!-- END Page Custom Script-->

	<%@ include file="../common/footer.jspf"%>