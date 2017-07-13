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
					<div class="col-sm-5">
						<!-- START panel-->
						<div class="panel panel-success">
							<div class="panel-heading">Add Cash</div>
							<div class="panel-body">
								<form class="form-horizontal" method="post">
									<div class="form-group">
										<c:if test="${!empty succesfulTransaction}">
											<div class="row">
												<div
													class="col-lg-offset-1 col-lg-10 col-lg-offset-1 alert alert-success">Successfully
													Added!</div>
											</div>
										</c:if>
										<label class="col-lg-2 control-label">Source</label>
										<div class="col-lg-10">
											<input type="text" name="purpose" required
												class="form-control">
										</div>
									</div>

									<div class="form-group has-success">
										<label class="col-sm-2 control-label">Sum</label>
										<div class="col-sm-10">
											<input type="number" step="any" min="1" name="sum" required
												class="form-control">
										</div>
									</div>

									<div data-pick-time="false"
										class="datetimepicker input-group date mb-lg">
										<input type="text" placeholder="Date" name="date" required
											class="form-control"> <span class="input-group-addon">
											<span class="fa fa-calendar"></span>
										</span>
									</div>									
									<div class="form-group">
										<div class="col-lg-offset-4 col-lg-8 ">
											<button type="submit" class="btn btn-md btn-success">Submit</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- END panel-->
					</div>

					<div class="col-lg-3">
						<div class="panel widget">
							<div class="panel-body bg-success ">
								<div class="row">
									<div class="col-xs-8">
										<br />
										<p class="mb0">Balance</p>

									</div>
									<div class="col-xs-4 text-center">
										<br /> <em class="fa fa-money fa-2x"></em>
									</div>
									<div class="col-xs-8 text-center">
										<br />
									</div>
								</div>

								<div class="row">
									<div class="col-xs-4">
										<h3 class="text-md m0">${currency}</h4>
									</div>
									<div class="col-xs-7">
										<h3 class="text-md m0"
											style="text-align: right; float: right;">
											<fmt:formatNumber type="number" maxFractionDigits="2"
												minFractionDigits="2" value="${cash}" />
										</h3>
									</div>
									<div class="col-xs-1"></div>
								</div>
							</div>
						</div>
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