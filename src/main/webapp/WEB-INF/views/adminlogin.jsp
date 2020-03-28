<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="shortcut icon" href="resources/assets/images/cv.ico">
	<title>Admin Login</title>
    <link href="resources/logAssets/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/logAssets/css/a3common.css" rel="stylesheet">
    <link href="resources/logAssets/css/login.css" rel="stylesheet">
    <link href="resources/logAssets/css/fonts.css" rel="stylesheet">
    
    <script src="resources/js/jquery.js" type="text/javascript"></script>
    
</head>


<body>


    <div id="main" class="main-warp" style="background:#37474f !important;">
        <div class="main-content">
            <div class="formDiv">
                
                    <h2 class="text-center">Admin login</h2>
                                                 
                	<form id="loginForm" action="adminlogin" method="post">

                    <div class="dataform">

                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input class="inputs" type="password" name="password" placeholder="Password" id="pwd" maxlength="20">
                        </div>
                        
                        <div class="error-content">
							<span class="errMsg">${passerr }</span>
                        </div>

                        <div class="btn-warp gap">
                            <div class="text-center">                               
                                <input type="hidden" value="jsform" id="_app">
                                <button type="submit" id="btnLogin" class="btn btn-block lgbtn blue">Login</button>
                            </div>
                        </div>
                        
                    </div>
                </form>

            </div>
        </div>
    </div>



</body>

<script src="resources/js/login.js" type="text/javascript"></script>

</html>