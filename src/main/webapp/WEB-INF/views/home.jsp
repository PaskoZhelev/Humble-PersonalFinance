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

					<div class="col-lg-4">
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
										<h4>${currency}</h4>
									</div>
									<div class="col-xs-7">
										<h3 class="text-lg m0"
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

					<div class="col-sm-2">
						<!-- START widget-->
						<div class="panel widget">
							<div class="panel-body bg-info text-center">
								<div>
									<h4>${currency}
										<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${shoppingSum}" />
									</h4>
								</div>
								<p>Shopping</p>
								<em class="fa fa-shopping-cart fa-2x"></em>
							</div>
						</div>
						<!-- END widget-->
					</div>
					<div class="col-sm-2">
						<!-- START widget-->
						<div class="panel widget">
							<div class="panel-body bg-warning text-center">
								<div>
									<h4>${currency}
										<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${foodSum}" />
									</h4>
								</div>
								<p>Food & Drinks</p>
								<em class="fa fa-cutlery fa-2x"></em>
							</div>
						</div>
						<!-- END widget-->
					</div>
					<div class="col-sm-2">
						<!-- START widget-->
						<div class="panel widget">
							<div class="panel-body bg-danger text-center">
								<div>
									<h4>${currency}
										<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${billsSum}" />
									</h4>
								</div>
								<p>Bills & Utilities</p>
								<em class="fa fa-home fa-2x"></em>
							</div>
						</div>
						<!-- END widget-->
					</div>
					<div class="col-sm-2">
						<!-- START widget-->
						<div class="panel widget">
							<div class="panel-body bg-inverse text-center">
								<div>
									<h4>${currency}
										<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${othersSum}" />
									</h4>
								</div>
								<p>Others</p>
								<em class="fa fa-leaf fa-2x"></em>
							</div>
						</div>
						<!-- END widget-->
					</div>


				</div>
				<div class="row">
					<div class="col-lg-8">
						<div class="panel panel-default">
							<div class="panel-heading">Recent Transactions</div>
							<div class="panel-body">
								<table id="datatable1"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Purpose</th>
											<th>Category</th>
											<th class="sort-numeric">Sum</th>
											<th>Date</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${transactions}" var="transaction">
											<tr>
												<td>${transaction.getPurpose()}</td>
												<c:choose>
													<c:when test="${transaction.getCategory() == 'Revenue'}">
														<td class="text-center"><div class="label label-success">${transaction.getCategory()}</div></td>
       													<td class="text-success text-right">+<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${transaction.getSum()}" />
															${currency}</td>
													</c:when>
													
													<c:when test="${transaction.getCategory() == 'Shopping'}">
														<td class="text-center"><div class="label label-info">${transaction.getCategory()}</div></td>
       													<td class="text-danger text-right">-<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${transaction.getSum()}" />
															${currency}</td>
													</c:when>
													
													<c:when test="${transaction.getCategory() == 'Food'}">
														<td class="text-center"><div class="label label-warning">${transaction.getCategory()}</div></td>
       													<td class="text-danger text-right">-<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${transaction.getSum()}" />
															${currency}</td>
													</c:when>
													
													<c:when test="${transaction.getCategory() == 'Bills'}">
														<td class="text-center"><div class="label label-danger">${transaction.getCategory()}</div></td>
       													<td class="text-danger text-right">-<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${transaction.getSum()}" />
															${currency}</td>
													</c:when>
													
													<c:when test="${transaction.getCategory() == 'Others'}">
														<td class="text-center"><div class="label label-warning">${transaction.getCategory()}</div></td>
       													<td class="text-danger text-right">-<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${transaction.getSum()}" />
															${currency}</td>
													</c:when>
													
													<c:otherwise>
														<td class="text-center"><div class="label label-warning">${transaction.getCategory()}</div></td>
       													<td class="text-danger text-right">-<fmt:formatNumber type="number" maxFractionDigits="2"
											minFractionDigits="2" value="${transaction.getSum()}" />
															${currency}</td>
													</c:otherwise>
												</c:choose>																								
												
												<td class="text-center">${transaction.getDate()}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div class="col-sm-4">
						<!-- START panel-->
						<div class="panel panel-danger">
							<div class="panel-heading">Add Expenditure</div>
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
										<label class="col-lg-2 control-label">Purpose</label>
										<div class="col-lg-10">
											<input type="text" name="purpose" required
												class="form-control">
										</div>
									</div>

									<div class="form-group has-error">
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
										<label class="col-sm-2 control-label">Category</label>&nbsp;
										<div class="col-sm-12 text-center">
											<label class="radio-inline c-radio" title="Shopping">
												<input id="inlinecheckbox10" name="i-category" type="radio"
												value="Shopping" checked> <span class="fa fa-check"></span><em
												class="fa fa-shopping-cart"></em>
											</label> <label class="radio-inline c-radio" title="Food & Drink">
												<input id="inlinecheckbox20" name="i-category" type="radio"
												value="Food"> <span class="fa fa-check"></span><em
												class="fa fa-cutlery"></em>
											</label> <label class="radio-inline c-radio"
												title="Bills & Utilities"> <input
												id="inlinecheckbox30" name="i-category" type="radio"
												value="Bills"> <span class="fa fa-check"></span><em
												class="fa fa-home"></em></label> <label class="radio-inline c-radio"
												title="Others"> <input id="inlinecheckbox30"
												name="i-category" type="radio" value="Others"> <span
												class="fa fa-check"></span><em class="fa fa-leaf"></em></label> 
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-4 col-lg-8 ">
											<button type="submit" class="btn btn-md btn-danger">Submit</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- END panel-->
					</div>

				</div>
				<!-- END ROW -->


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