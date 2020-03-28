<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<link rel="shortcut icon" href="resources/assets/images/cv.ico">
<title>User panel</title>

<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Material Design Lite">
<meta name="msapplication-TileColor" content="#3372DF">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
<link rel="stylesheet" href="resources/css/enterprise.css">

<script src="resources/userAssets/js/jquery-1.11.0.min.js" type="text/javascript"></script>

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

fieldset span {
	display:block;
	width:200px;
	float:left;
}

select[name=cvtheme] {
	width: 196px;
}

.form-control {
	display:block;
	width:196px;
	float:left;
}
</style>
</head>
<body>
	<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
		<header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">User control panel</span>
				<div class="mdl-layout-spacer"></div>

				<button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
					<i class="material-icons">more_vert</i>
				</button>
				<ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
					<a href="logout" style="text-decoration: none;"><li class="mdl-menu__item">Logout</li></a>
				</ul>
			</div>
		</header>
		<jsp:include page="usernav_bar.jsp" />
		<main class="mdl-layout__content mdl-color--grey-100">

		  <div class="mdl-card mdl-cell mdl-cell--12-col">
			<div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<fieldset>
						<legend><h5>CV theme selection</h5></legend>
						<select name="cvtheme">
                    		<option selected disabled style="display:none;">Theme</option>
                        	<option value="0">Default</option>
                        	<option value="1">Yellow</option>
                        	<option value="2">Blue</option>
                    	</select>
                    </fieldset>
				</div>
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<fieldset>
						<legend><h5>CV switch</h5></legend>
						<span>Show/hide CV</span><input type="checkbox" name="cvswitch">
					</fieldset>
				</div>
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">					
					<fieldset>
						<legend><h5>API switches</h5></legend>
                        <input type="text" class="form-control" placeholder="GitHub account name">
                        <input type="checkbox" name="gitapi" value="gitapi"><br><br>
                        <input type="text" class="form-control" placeholder="QQMusic songlist">
                        <input type="checkbox" name="qqmusic" value="qqmusic"><br><br>
                        <span>Visitor map</span><input type="checkbox" name="visitor" value="visitor"><br><br>                        
                	</fieldset>
				</div>
				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
                	<fieldset>
                    	<legend><h5>Social links</h5></legend>
                        <span>Twitter</span><input type="checkbox" name="twitter" value="twitter"><br><br>
                        <span>Google+</span><input type="checkbox" name="google" value="google"><br><br>
                        <span>Linkedin</span><input type="checkbox" name="linkedin" value="linkedin"><br><br>
                        <span>GitHub</span><input type="checkbox" name="github" value="github"><br><br>
                        <span>Ycombinator</span><input type="checkbox" name="Ycombinator" value="ycombinator">
                	</fieldset>
				</div>
                
                <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<fieldset>
                    	<legend><h5>Programming</h5></legend>
                    	<span><b>On/off</b></span><input type="checkbox" name="pg"><br>
                    	<span>C/C++</span><input type="checkbox" name="cpp"><br>
                   		<span>JavaScript</span><input type="checkbox" name="js"><br>
                    	<span>HTML &amp; CSS</span><input type="checkbox" name="htm"><br>
                     	<span>C#</span><input type="checkbox" name="cs"><br>
                      	<span>Matlab</span><input type="checkbox" name="mat"><br>
                     	<span>Java</span><input type="checkbox" name="java"><br>
                     	<span>PHP</span><input type="checkbox" name="php"><br>
                     	<span>Python</span><input type="checkbox" name="py"><br>
                     	<span>Visual Basic</span><input type="checkbox" name="vb"><br>
					</fieldset>
				</div>

				<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
					<fieldset>
                    	<legend><h5>Resume generator</h5></legend>
                    	<button>Apply settings</button> &nbsp <button id="viewcv">View my CV</button>
					</fieldset>
				</div>
                
			</div>
          </div>
	   </main>
  	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
    <script>
    	$('#viewcv').click(function(e) {
           window.open('cv/${sessionScope.client.getEmail() }', '_blank'); 
        });    
    </script>
    
</body>
</html>
