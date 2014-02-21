<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- $Revision: 1.25 $ -->
<!-- MASTER BRAND VENDOR KIT - 1.x -->
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>

<!-- ***TITLE*** -->
<title>Customer Portal</title>
<!-- ***END TITLE*** -->

<!-- ***META INFO*** -->
<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
<meta name="accessLevel" content="Guest" />
<meta name="country" content="US" />
<meta name="locale" content="US" />
<meta name="language" content="en" />
<meta name="title" content="(SECTION) TITLE" />
<meta name="date" content="Thu Oct 28 12:56:35 PDT 2010" />
<meta name="myMeta" content="VendorKit" />
<!-- ***END META INFO*** -->


<!-- begin: assets - framework -->
<script type="text/javascript"
	src="//www.cisco.com/web/fw/j/painted.mb1.48.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//www.cisco.com/web/fw/c/painted.mb1.45.min.css" />
<link rel="stylesheet" type="text/css"
	href="//www.cisco.com/web/fw/w/cl/painted.cl.min.css" />
<link rel="search" type="application/opensearchdescription+xml"
	title="Search Cisco.com"
	href="//www.cisco.com/web/tsweb/searchplugins/cdc_search.xml" />
<!-- end: assets - framework -->

<!-- ***BEGIN NON-FRAMEWORK ASSETS*** -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="/ciscotogo/resources/metronic_assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="/ciscotogo/resources/metronic_assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="/ciscotogo/resources/metronic_assets/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="/ciscotogo/resources/metronic_assets/plugins/select2/select2_metro.css"/>
<link rel="stylesheet" href="/ciscotogo/resources/metronic_assets/plugins/data-tables/DT_bootstrap.css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link
	href="/ciscotogo/resources/metronic_assets/css/style-metronic.css"
	rel="stylesheet" type="text/css" />
<link href="/ciscotogo/resources/metronic_assets/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="/ciscotogo/resources/metronic_assets/css/style-responsive.css"
	rel="stylesheet" type="text/css" />
<link href="/ciscotogo/resources/metronic_assets/css/plugins.css"
	rel="stylesheet" type="text/css" />
<!-- <link href="/ciscotogo/resources/metronic_assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/> -->
<link href="/ciscotogo/resources/metronic_assets/css/custom.css"
	rel="stylesheet" type="text/css" />
<link href="/ciscotogo/resources/metronic_assets/plugins/bxslider/jquery.bxslider.css" rel="stylesheet" /> 
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
  <script src="/ciscotogo/resources/metronic_assets/plugins/respond.min.js"></script>
  <script src="/ciscotogo/resources/metronic_assets/plugins/excanvas.min.js"></script> 
  <![endif]-->
<script
	src="/ciscotogo/resources/metronic_assets/plugins/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/jquery-migrate-1.2.1.min.js"
	type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script
	src="/ciscotogo/resources/metronic_assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/bxslider/jquery.bxslider.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/jquery.blockui.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/jquery.cokie.min.js"
	type="text/javascript"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/uniform/jquery.uniform.min.js"
	type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script
	src="/ciscotogo/resources/metronic_assets/plugins/flot/jquery.flot.js"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/flot/jquery.flot.resize.js"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/flot/jquery.flot.pie.js"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/flot/jquery.flot.stack.js"></script>
<script
	src="/ciscotogo/resources/metronic_assets/plugins/flot/jquery.flot.crosshair.js"></script>
<script type="text/javascript" src="/ciscotogo/resources/metronic_assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="/ciscotogo/resources/metronic_assets/plugins/data-tables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/ciscotogo/resources/metronic_assets/plugins/data-tables/DT_bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<script src="/ciscotogo/resources/metronic_assets/scripts/app.js"></script>
<script src="/ciscotogo/resources/metronic_assets/scripts/custom.js"></script>
<script>
	jQuery(document).ready(function() {
		// initiate layout and plugins		
		App.init();
       
		// define event handlers
		Custom.init();
		
		Custom.getFoodData();
		
		
		
	});
</script>
<!-- END JAVASCRIPTS -->
<!-- ***END NON-FRAMEWORK ASSETS*** -->

<style type="text/css">
/*this is a temporary fix until the prod framework can be updated.*/
#fw-mb-w1 #framework-content-main {
	margin-top: 0;
}

#fw-mb-w1 #framework-footer {
	margin-bottom: 12px;
}
</style>
<script>
	cdc.ut.config.set("send", {
		ntpagetag : true
	});
</script>
<script type="text/javascript">
	cdc.util.useBackpack = true;
</script>
</head>
<body id="w1x" class="cdc-fw cdc-vkit">
	<!--googleoff: index-->
	<!--googleoff: snippet -->
	<!--[if gte IE 9]><div id="gte-ie9" class="ie"><![endif]-->
	<!--[if IE 8]><div id="ie8" class="ie"><![endif]-->
	<!--[if IE 7]><div id="ie7" class="ie ie67"><![endif]-->
	<!--[if lte IE 6]><div id="ie6" class="ie ie67"><![endif]-->
	<div id="fw-mb">
		<div id="fw-mb-w1">

			<!-- begin: masterbrand banner -->
			<div id="fw-banner">
				<div id="fw-banner-w1">

					<!-- skiplinks -->
					<div id="fw-mbsk">
						<p>
							<a href="http://www.cisco.com" tabindex="3">Home</a> <a
								href="#content">Skip to content</a> <a href="#hinav">Skip to
								navigation</a> <a href="#pagefooter">Skip to footer</a>
						</p>
					</div>

					<!-- logo -->
					<div id="fw-mbl">
						<p>
							<a href="http://www.cisco.com">Cisco.com Worldwide Home</a>
						</p>
					</div>

					<!-- megamenus -->
					<div id="fw-mm">
						<table class="mm-items" cellspacing="0" summary="">
							<tr>
								<td class="mm-item" id="products-mm-item"><a
									href="http://www.cisco.com/en/US/products/index.html"
									class="mm-link">Products &amp; Services</a> <a
									href="//www.cisco.com/web/fw/co/painted-menu-content.html#products-mm-menu"
									class="mm-reflink">(menu)</a></td>
								<td class="mm-item" id="support-mm-item"><a
									href="http://www.cisco.com/cisco/web/support/index.html"
									class="mm-link">Support</a> <a
									href="//www.cisco.com/web/fw/co/painted-menu-content.html#support-mm-menu"
									class="mm-reflink">(menu)</a></td>
								<td class="mm-item" id="ordering-mm-item"><a
									href="http://www.cisco.com/en/US/ordering/index.shtml"
									class="mm-link">How to Buy</a> <a
									href="//www.cisco.com/web/fw/co/painted-menu-content.html#ordering-mm-menu"
									class="mm-reflink">(menu)</a></td>
								<td class="mm-item" id="training-mm-item"><a
									href="http://www.cisco.com/en/US/learning/index.html"
									class="mm-link">Training &amp; Events</a> <a
									href="//www.cisco.com/web/fw/co/painted-menu-content.html#training-mm-menu"
									class="mm-reflink">(menu)</a></td>
								<td class="mm-item" id="partner-mm-item"><a
									href="http://www.cisco.com/en/US/partners/index.html"
									class="mm-link">Partners</a> <a
									href="//www.cisco.com/web/fw/co/painted-menu-content.html#partner-mm-menu"
									class="mm-reflink">(menu)</a></td>
							</tr>
						</table>
					</div>
					<!-- end #fw-mm -->

					<!-- search -->
					<span class="search-entitlement">Guest</span>
					<div id="fw-mbs">
						<form name="sitewidesearch"
							action="http://tools.cisco.com/search/JSP/search-results.get"
							method="get" id="sitewidesearch">
							<label for="searchPhrase" name="search" id="search">Search</label>
							<p class="field-button">
								<input type="text" tabindex="1" name="strQueryText"
									class="field-button-field" id="searchPhrase" value=""
									autocomplete="off"> <input type="submit" tabindex="2"
									value="Search" class="field-button-button" id="go">
							</p>
							<input type="hidden" value="cisco.com"
								name="Search All cisco.com"> <input type="hidden"
								value="en" name="language"> <input type="hidden"
								value="US" name="country"> <input type="hidden"
								value="f" name="thissection"> <input type="hidden"
								value="Guest" name="accessLevel">
						</form>
					</div>
					<!-- end #fw-mbs -->
					<script type="text/javascript">
						if ((typeof cdc.search) == "undefined") {
							cdc.search = new Object();
						}
						cdc.search.country = "US";
						cdc.search.language = "en";
					</script>
					<!-- end search -->

					<!-- toolbar -->
					<div id="fw-ft-basic">
						<div class="ft-toolbar">
							<div class="ft-group ft-country-lang-group">
								<div class="ft-sect ft-country">
									<a
										href="http://cisco.com/en/US/swassets/sw274/sitewide_country_language_selector.html"
										class="ft-label"><span class="ft-country-name">Worldwide</span>
										<span class="ft-country-change">[change]</span></a>
								</div>
							</div>
							<div class="ft-group ft-guest-group">
								<div class="ft-sect ft-login">
									<a href="http://www.cisco.com/cgi-bin/login" class="ft-label">Log
										In</a>
								</div>
								<div class="ft-sect ft-account">
									<a
										href="http://www.cisco.com/web/siteassets/account/index.html"
										class="ft-label">Account</a>
								</div>
								<div class="ft-sect ft-register">
									<a href="http://tools.cisco.com/RPF/register/register.do"
										class="ft-label">Register</a>
								</div>
<!-- 								<div class="ft-sect"> -->
<!-- 									<a href="http://www.cisco.com/cisco/psn/web/workspace" -->
<!-- 										class="ft-label">My Cisco</a> -->
<!-- 								</div> -->
							</div>
						</div>
					</div>
					<!-- end toolbar -->


				</div>
				<!-- end #fw-banner-w1 -->
			</div>
			<!-- end #fw-banner -->
			<!-- end: masterbrand banner -->


			<!-- ***PAGE CONTENT HEADER -->
			<div id="mb-title-nav-bar" class="clearfix">
				<div id="framework-content-titles">
					<!--googleon: index-->
					<!--googleon: snippet-->
					<h1 class="title-section">Cisco TOGO</h1>
					<!--googleoff: index-->
					<!--googleoff: snippet-->
				</div>
			</div>
			<!-- ***END PAGE CONTENT HEADER -->


			<table id="framework-base-main" cellspacing="0" cellpadding="0"
				border="0" summary="">
				<tr>
					<td id="framework-column-left" valign="top"><a name="hinav"></a>

						<!-- ***HI-NAV CONTENT*** --> <!--             <div class="hinav"> -->
						<!--                 <h3>Hierarchical Navigation</h3> --> <!--                 <ul class="outer"> -->
						<!--                 <li><a href="http://www.cisco.com/en/US/hmpgs/index.html" class="parent">HOME</a> -->
						<!--                     <ul> --> <!--                     <li><a href="" class="parent">ROOT PAGE / L2 / GRANDPARENT</a> -->
						<!--                         <ul> --> <!--                         <li><a href="" class="parent">L3 / PARENT</a> -->
						<!--                             <ul> --> <!--                             <li><strong><a href="" class="selected">Current Page</a></strong> -->
						<!--                                 <ul> --> <!--                                 <li><a href="" class="child">Child page 1</a></li> -->
						<!--                                 <li><a href="" class="child">Child page 2</a></li> -->
						<!--                                 </ul> --> <!--                             </li> -->
						<!--                             <li><a href="" class="peer">Current page peer 1</a></li> -->
						<!--                             <li><a href="" class="peer">Current page peer 2</a></li> -->
						<!--                             </ul> --> <!--                         </li> -->
						<!--                         </ul> --> <!--                     </li> -->
						<!--                     </ul> --> <!--                 </li> -->
						<!--                 </ul> --> <!--             </div> --> <!-- ***END HI-NAV CONTENT*** -->

					</td>
					<!-- end #framework-column-left -->

					<td id="framework-column-center">
						<table cellspacing="0" id="framework-base-content">
							<tr>
								<td id="framework-column-main"><a name="content"></a>
								<!--googleon: index-->
									<!--googleon: snippet-->
									<div id="framework-content-main">


										<!-- ***MAIN CONTENT SAMPLE*** -->
										<!-- BEGIN CONTAINER -->
										<div class="container">
											<!-- BEGIN CONTENT -->
											<!-- BEGIN TOP 4 TILES -->
											<div class="row">
												<div class="tiles">
													<div id="contactTile" class="tile bg-green inlineTileDivs">
														<div class="tile-body" id="contactTileContents">
														</div>
													</div>
													<div id="orderTile" class="tile bg-purple inlineTileDivs">
														<div class="tile-body" id="orderTileContents">
														</div>
													</div>
													<div class="buildingTiles inlineTileDivs">
														<div>
															<ul class="bxslider"></ul>
														</div>
													</div>
												</div>
											</div>
											<!-- END TOP 4 TILES -->
											<!-- BEGIN BIG BLUE TILE -->
											<div class="row">
												<img src='/ciscotogo/resources/images/ajax-loader-white.gif' id='pageLoadImage' alt='Loading...'>										
												<div id="foodInfoTile" class="tile double bg-blue">
													<div id="foodInfoTileContents" class="tile-body" bg-blue>
														<h1>HEALTH NEWS!</h1>
														<br>
														<br>
														<h3>This just in! Studies show that BROCOLI IS BAD FOR YOU.</h3>
														<br>
														<h3>Eat Healthy! Grab a Snickers.</h3>
														<br>
														<h3>Studies show that spinach makes you DUMB.</h3>
														<br>
														<h3>HEALTH NEWS! is brought to you by HOSTESS (trademark copyright blah blah blah)</h3>
													</div>
												</div>
											</div>

										</div>
										<!-- END CONTAINER -->
										<!-- ***END MAIN CONTENT SAMPLE*** -->


										<!-- End of the actual text content -->
										<!--googleoff: index-->
										<!--googleoff: snippet-->
									</div> <!-- end #framework-content-main --></td>
								<!-- end #framework-column-main -->

								<td id="framework-column-right">
									<div id="framework-content-right">


										<!-- ***RIGHT RAIL CONTENT SAMPLE*** -->
										<!--                     <div style="width:230px;"> -->
										<!--                       Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse a massa et dolor auctor euismod. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed at nibh sit amet metus euismod vehicula.  -->
										<!--                     </div> -->
										<!-- ***END RIGHT RAIL CONTENT SAMPLE*** -->


									</div>
									<!-- end #framework-content-right -->
								</td>
								<!-- end #framework-column-right -->
							</tr>
						</table>
						<!-- end #framework-base-content -->

					</td>
					<!-- end #framework-column-center -->
				</tr>
			</table>
			<!-- end #framework-base-main -->

			<!-- begin: masterbrand fatfooter -->
			<div id="ff"></div>
			<script type="text/javascript">
				cdc.ff
						.setMarker("//www.cisco.com/web/fw/co/painted-fatfooter-content.html"); // fatfooter location
				cdc.ff.init();
			</script>
			<!-- end: masterbrand fatfooter -->

			<!-- begin: legal footer-->
			<a name="pagefooter"></a>
			<div id="framework-footer">
				<div id="footer-nav">
					<a href="http://www.cisco.com/web/siteassets/contacts/index.html">Contacts</a>
					| <a
						href="http://tools.cisco.com/cdc/feedbk/public/FeedbackAction.cdcfdb">Feedback</a>
					| <a href="http://www.cisco.com/web/help/index.html">Help</a> | <a
						href="http://www.cisco.com/web/siteassets/sitemap/index.html">Site
						Map</a> |
				</div>
				<div id="footer-legal">
					<a
						href="http://www.cisco.com/web/siteassets/legal/terms_condition.html">Terms
						&amp; Conditions</a> | <a
						href="http://www.cisco.com/web/siteassets/legal/privacy.html">Privacy
						Statement</a> | <a
						href="http://www.cisco.com/web/siteassets/legal/privacy.html#cookies">Cookie
						Policy</a> | <a
						href="http://www.cisco.com/web/siteassets/legal/trademark.html">Trademarks</a>
				</div>
			</div>
			<!-- end: legal footer-->

		</div>
		<!-- end #fw-mb-w1 -->
	</div>
	<!-- end #fw-mb -->

	<!--[if IE]></div><![endif]-->

</body>
</html>
