<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Company</title>

<!-- Add to homescreen for Chrome on Android -->
<meta name="mobile-web-app-capable" content="yes">
<!--link rel="icon" sizes="192x192" href="images/android-desktop.png"-->

<!-- Add to homescreen for Safari on iOS -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Material Design Lite">
<!--link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png"-->

<!-- Tile icon for Win8 (144x144 + tile color) -->
<!--meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png"-->
<meta name="msapplication-TileColor" content="#3372DF">

<link rel="shortcut icon" href="resources/assets/images/cv.ico">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
<link rel="stylesheet" href="resources/css/enterprise.css">
<style>
#view-source {
	position: fixed;
	display: block;
	right: 0;
	bottom: 0;
	margin-right: 40px;
	margin-bottom: 40px;
	z-index: 900;
}
</style>
</head>
<body>
	<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
		<header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">Company Details</span>
				<div class="mdl-layout-spacer"></div>

				<button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
					<i class="material-icons">more_vert</i>
				</button>
				<ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
					<a href="logout" style="text-decoration: none;"><li class="mdl-menu__item">Logout</li></a>
				</ul>
			</div>
		</header>
		<jsp:include page="navigation_bar.jsp" />
		<main class="mdl-layout__content mdl-color--grey-100">

		  <div class="mdl-card mdl-cell mdl-cell--12-col">
			<div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<h5>Company Name</h5>
					${sessionScope.client.getCompanyname() }
				</div>
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<h5>Contact Number</h5>
					${sessionScope.client.getPhone() }
				</div>
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<h5>Address</h5>
					${sessionScope.client.getLocation() }
				</div>
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<h5>ABN</h5>
					${sessionScope.client.getCompanycode() }
				</div>
                
                <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<h5>License</h5>
					<img src="data/enterprise/${sessionScope.client.getEmail() }" />
				</div>
                
			</div>
			<div class="mdl-card__actions">
                <a href="cedit" class="mdl-button">Update</a>
            </div>
          </div>
	   </main>
  	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>
