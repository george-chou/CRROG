<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="shortcut icon" href="resources/assets/images/cv.ico">
	<title>SignIn</title>
    <link href="resources/logAssets/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/logAssets/css/a3common.css" rel="stylesheet">    
    <link href="resources/logAssets/css/fonts.css" rel="stylesheet">
	<link href="resources/logAssets/css/register.css" rel="stylesheet">
    
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    
</head>

<body>


   <div id="main" class="main-warp">
    <div class="main-content">
        <div class="formDiv">
        
        	<h2 class="title text-center">Register</h2>
            
            <form id="registerForm" role="form" class="form-horizontal " action="signin" method="post">
            		<input type="radio" name="clientype" value="user" checked><label for="user">User</label> &nbsp;
					<input type="radio" name="clientype" value="company"><label for="company">Enterprise</label><br/>
                    <div class="form-item">
                        <div class="input-warp" style="width:240px;">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input id="userName" name="username" placeholder="Email" type="text" class="inputs" value="">
                        </div>
                        <label class="suffix" style="float:right; margin-top:-30px; margin-right:15px;">@uni.sydney.edu.au</label>
                        <p id="userNameErr" class="errMsg"></p>
                    </div>
                    <div class="form-item">
                        <div class="input-warp s">
                            <span class="input-icon iconfont icon-yanzhengma"></span>
                            <input id="kaptcha" placeholder="Verify code" type="text" class="inputs" maxlength="4" onKeyUp="if(this.value.length>4){this.value=this.value.substr(0,4)};this.value=this.value.replace(/[^\d]/g,'');" oncontextmenu="return false;" onpaste="return false;" name="verify">
                            <div id="popup-captcha" style="display: none"></div>
                        </div>
                        <div class="pull-right">
                            <button type="button" id="btnSendCode" class="btn lgbtn blue">Send code</button>
                        </div>
                        <p id="kaptchaErr" class="errMsg">${usererr }</p>
                    </div>

                    <div class="form-item">
                        <div class="input-warp">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input id="pwd" type="password" placeholder="8-20 digits in letters, numbers, marks" maxlength="20" name="password" value="" class="inputs">
                        </div>
                        <p id="passwordErr" class="errMsg">${passerr }</p>
                    </div>
                    <div class="form-item">
                        <div class="input-warp">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input id="repwd" type="password" placeholder="8-20 digits in letters, numbers, marks" maxlength="20" name="confirm" value="" class="inputs">
                        </div>
                        <p id="passwordErr2" class="errMsg">${confirmerr }</p>
                    </div>
                    
                    <div class="btn-warp">
                        <div class="text-center">
                            <button type="submit" id="btnSubmit" class="btn lgbtn blue btn-block">Sign in</button>
                            <input id="appName" name="appName" type="hidden" value="jsform"> 
                        </div>
                    </div>
                    <div class="agreement gap">
                        <!--div class="text-right">
                            <div class="pull-left">Already had an account? <a href="login" class="link">Login</a></div>
                        </div-->
                        
                                <div class="pull-right">
                                	<a href="forget" class="link">Forget pass</a>
                                	<span class="split-space">|</span>
                                	<a href="login" class="link">Login</a>
                                </div>
                            
                            <div class="pretty-box">
                                <a href="." class="link">Home</a>
                            </div>
                    </div>
                </form>

        </div>
    </div>
</div>

</body>

<script type="text/javascript" src="resources/js/login.js"></script>

</html>