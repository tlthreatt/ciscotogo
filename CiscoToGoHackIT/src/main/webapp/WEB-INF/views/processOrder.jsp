<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Cisco Software Workspace</title>
    <link href="http://wwwin-dev.cisco.com/it/swc/templates/sow/platform/css/homepage.mb.min.css" rel="stylesheet" type="text/css" />   
    <link href="http://wwwin-dev.cisco.com/it/swc/templates/sow/platform/css/style.css" rel="stylesheet" type="text/css" />
    <!-- Core Application CSS from platform -->
    <link href="http://wwwin-dev.cisco.com/it/swc/templates/sow/platform/css/appcore.min.css" rel="stylesheet" type="text/css">
        <link href="/ciscotogo/resources/css/style.css" rel="stylesheet" type="text/css" />
    <!-- ENterprise Account specific CSS -->
    <link href="css/enterpriseaccounts.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/ciscotogo/resources/metronic_assets/scripts/custom2.js"></script>
  </head>
<body>
  <div class="navbar navbar-static-top">
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
							</div>
					</div>
					<!-- end toolbar -->


				</div>
				<!-- end #fw-banner-w1 -->
			</div>
			<!-- end #fw-banner -->
			<!-- end: masterbrand banner -->
  
  
  
  
  
  
  
<!--     <div class="navbar-inner" style="overflow:hidden; background-image:url(http://wwwin-dev.cisco.com/it/swc/templates/sow/platform/img/cisco-header.png); background-position:center; background-repeat:no-repeat;min-height:75px;"> </div> -->
  </div>
  <div style="width:1024px;height:720px;margin:0 auto;padding-top:20px;" id="csw-module-content">


<div id="psdgraphics-com-table">



<div id="psdg-header">
<span class="psdg-bold">Cisco E- Kitchen</span><br />
</div>

<div id="psdg-top">
<div class="psdg-top-cell" style="width:129px; text-align:left; padding-left: 24px;">Order ID</div>
<div class="psdg-top-cell">Customer Name</div>
<div class="psdg-top-cell">CEC</div>
<div class="psdg-top-cell">Building Name</div>
<div class="psdg-top-cell">Menu Item</div>
<div class="psdg-top-cell">Price</div>
<div class="psdg-top-cell">Status</div>
<div class="psdg-top-cell" style="border:none;">Text Box</div>
</div>


<div id="psdg-middle">

<div id="orderId" class="psdg-left"></div>
<div id="fullName" class="psdg-right"></div>
<div id="cec" class="psdg-right"></div>
<div id="buildingID"class="psdg-right"></div>
<div id="menuItem" class="psdg-right"></div>
<div id="price" class="psdg-right"></div>
<div id="readyButton" class="psdg-right"></div>
<div id="completeBox" class="psdg-right"></div>





<!-- 
<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>


<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>


<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>


<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>


<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>


<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>

<div class="psdg-left"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>
<div class="psdg-right"></div>

-->



<div id="psdg-bottom">
<div class="psdg-bottom-cell" style="width:129px; text-align:left; padding-left: 24px;"></div>
<div class="psdg-bottom-cell"></div>
<div class="psdg-bottom-cell"></div>
<div class="psdg-bottom-cell"></div>
<div class="psdg-bottom-cell"></div>
<div class="psdg-bottom-cell"></div>

<div class="psdg-bottom-cell" style="border:none;"></div>
</div>


</div>


<div id="psdg-footer">

</div>




</div>



  
  </div>
  <div id="footer">
    <div class="wrapper">
      <div class="footerLeft">
        <ul>
          <li><a href="javascript://">Contacts</a></li>
          <li><a href="javascript://">[+] Feedback</a></li>
          <li><a href="javascript://">Help</a></li>
          <li><a href="javascript://">Site Map</a></li>
          <li><a href="javascript://">Terms &amp; Conditions</a></li>
          <li><a href="javascript://">Privacy Statement</a></li>
          <li><a href="javascript://">Cookie Policy</a></li>
          <li><a href="javascript://">Trademarks</a></li>
        </ul>
      </div>
    </div>
  </div>
</body>  
</html>