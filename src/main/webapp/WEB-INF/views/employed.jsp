<!doctype html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Mark</title>

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
<script type="text/javascript" src="resources/js/jquery.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="resources/css/material.cyan-light_blue.min.css">
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

th, td {
	text-align: center !important;
}
</style>
</head>
<body>
	<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
		<!--jsp:include page="layout_header.jsp" /-->      
		<jsp:include page="navigation_bar.jsp" />
		<main class="mdl-layout__content mdl-color--grey-100">
			<section class="mdl-grid" id="my-table">
        
        		<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        		
					<thead>
            			<tr>
            				<th style="width:114px;">Name</th>
                			<th style="width:64px;">Job</th>                    		
                    		<th style="width:720px;"></th>
                    		<th>View</th>
                    		<th>Contact</th>
                    		<th>Collect</th>
                    		<th>Hire</th>
                 		</tr>
             		</thead>
             		
          	 		<tbody>
          	 		</tbody>
          	 		
				</table><br>
				
				<div class="mdl-layout-spacer"></div>
			</section>
		</main>
	</div>
	
<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script src="resources/js/hire.js"></script>
	
</body>
</html>
