<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="shortcut icon" href="resources/assets/images/cv.ico">
	<title>Login</title>
    <link href="resources/logAssets/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/logAssets/css/a3common.css" rel="stylesheet">
    <link href="resources/logAssets/css/login.css" rel="stylesheet">
    <link href="resources/logAssets/css/fonts.css" rel="stylesheet">
    
    <script src="resources/js/jquery.js" type="text/javascript"></script>
    
</head>


<body>


    <div id="main" class="main-warp">
        <div class="main-content">
            <div class="formDiv">
                
                    <h2 class="text-center">Login</h2>
                
                
                <form id="loginForm" action="login" method="post">
                
                	<input type="radio" name="clientype" value="user" checked><label for="user">User</label> &nbsp; 
					<input type="radio" name="clientype" value="company"><label for="company">Enterprise</label><br/>
                    
                    <div class="dataform">
                        <div class="input-warp gap" style="width:240px;">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input id="userName" name="username" type="text" class="inputs" placeholder="Email" maxlength="64">
                        </div>
                        <label class="suffix">@uni.sydney.edu.au</label>
                        <div class="error-content">
                        	<span class="errMsg">${usererr }</span>
                        </div>

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
                        <div class="gap">
                            
                                <div class="pull-right">
                                	<a href="forget" class="link">Forget pass</a>
                                	<span class="split-space">|</span>
                                	<a href="signin" class="link">Sign in</a>
                                </div>
                            
                            <div class="pretty-box">
                                <a href="." class="link">Home</a>
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