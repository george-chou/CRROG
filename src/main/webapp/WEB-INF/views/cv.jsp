<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Personal Resume</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Welcome to my CV">
    <!--meta name="author" content="George"-->    
    <link rel="shortcut icon" href="../resources/assets/images/cv.ico">
    
    <link rel="stylesheet" href="../resources/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/assets/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../resources/assets/plugins/github-activity/css/github-activity-0.1.1.min.css">
    <link rel="stylesheet" href="../resources/assets/plugins/github-activity/css/octicons.min.css">    
    <link rel="stylesheet" href="../resources/assets/css/perfundo.with-icons.css">
    <link rel="stylesheet" href="../resources/assets/plugins/visitormap/css/flag-icon.css">
    <link rel="stylesheet" href="../resources/assets/plugins/visitormap/css/devices.css">  
    <link rel="stylesheet" href="../resources/assets/plugins/visitormap/css/media.css">   
    <link rel="stylesheet" href="../resources/assets/css/styles.css">
    
    <script type="text/javascript" src="../resources/assets/js/require.js"></script>
    <script type="text/javascript" src="../resources/assets/js/config.js"></script>
    <script type="text/javascript" src="../resources/assets/js/skillset.js"></script>
    <script type="text/javascript" src="../resources/assets/js/codemusic.js"></script>
    <script type="text/javascript" src="../resources/assets/js/visitormap.js"></script>
    <script type="text/javascript" src="../resources/assets/js/perfundo.js"></script>
    <script type="text/javascript" src="../resources/assets/js/main.js"></script>
    
    <style>
    	.lang {
    		float: left;    	
    		display: block;
    		width: 100px;
    	}
    </style>
    
</head>

<body>

<div class="unsupported-browser">
  <div class="p-responsive">
      <div class="mr-2">
          <h5>Please note that my CV no longer supports Adblock or old versions of IE Browser.</h5>
          <p>I recommend upgrading to the latest <a href="https://www.apple.com/safari/">Safari</a>, <a href="https://chrome.google.com">Google Chrome</a>, or <a href="https://mozilla.org/firefox/">Firefox</a>.</p>
      </div>
  </div>
</div>

	<!-- ******HEADER****** --> 
    <header class="header">
        <div class="container">                       
            <img class="profile-image img-responsive pull-left" src="../data/user/${sessionScope.temp.getEmail() }" alt="${sessionScope.temp.getFirstname() } ${sessionScope.temp.getLastname() }" />
            <div class="profile-content pull-left">
                <h1 class="name">${sessionScope.temp.getFirstname() } ${sessionScope.temp.getLastname() }</h1>
                <h2 class="desc">${sessionScope.temp.getJob() }</h2>   
                <ul class="social list-inline">
                    <li><a href="${sessionScope.temp.getTwitterurl() }" target="_blank"><i class="fa fa-twitter"></i></a></li>                   
                    <li><a href="${sessionScope.temp.getGoogleurl() }" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="${sessionScope.temp.getLinkedinurl() }" target="_blank"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="${sessionScope.temp.getGithuburl() }" target="_blank"><i class="fa fa-github-alt"></i></a></li>                  
                    <li class="last-item"><a href="${sessionScope.temp.getYcomurl() }" target="_blank"><i class="fa fa-hacker-news"></i></a></li>                 
                </ul> 
            </div><!--//profile-->
            <!--a class="btn btn-cta-secondary pull-right" style="margin-left:5px;" href="./index-cn.html">中文</a-->
            <a class="btn btn-cta-primary pull-right" href="mailto:${sessionScope.temp.getEmail() }@uni.sydney.edu.au"><i class="fa fa-paper-plane"></i> Contact Me</a>              
        </div><!--//container-->
    </header><!--//header-->
    
    <div class="container sections-wrapper">
        <div class="row">
            <div class="primary col-md-8 col-sm-12 col-xs-12">
                <section class="about section">
                    <div class="section-inner">
                        <h2 class="heading">About Me</h2>
                        <div class="content">
                            <p>${sessionScope.temp.getAbout() }</p>
                         
                        </div><!--//content-->
                    </div><!--//section-inner-->                 
                </section><!--//section-->
    
               <section class="latest section">
                    <div class="section-inner">
                        <h2 class="heading">Latest Folios</h2>
                        <div class="content">    
                                               
                            <div class="item featured text-center" name="firstfolio">
                                <h3 class="title"><a href="#" target="_blank"><!--title--></a></h3>
                                <p class="summary"><!--subtitle--></p>
                                <div class="featured-image">
                                    <a href="#" target="_blank">
                                    	<img class="img-responsive project-image" src="../img/${sessionScope.temp.getEmail() }/folios/1" />
                                    </a>
                                    <div class="ribbon">
                                        <div class="text">New</div>
                                        </div>
                                    </div>
                                    
                                <div class="desc text-left">                                    
                                    <p><!--description--></p>
                                </div><!--//desc-->         
                                <a class="btn btn-cta-secondary" href="#" target="_blank"><i class="fa fa-thumbs-o-up"></i> Back my project</a>                 
                            </div><!--//item-->
                            <hr class="divider" />
                            
                            
                            <div class="item row" name="folio">
                                <a class="col-md-4 col-sm-4 col-xs-12" href="#" target="_blank">
                                	<img class="img-responsive project-image" src="../img/${sessionScope.temp.getEmail() }/folios/" />
                                </a>
                                <div class="desc col-md-8 col-sm-8 col-xs-12">
                                    <h3 class="title"><a href="#" target="_blank"><!--title--></a></h3>
                                    <p><!--description--></p>
                                    <p><a class="more-link" href="#" target="_blank"><i class="fa fa-external-link"></i> View on GitHub</a></p>
                                </div><!--//desc-->                          
                            </div><!--//item-->
                            
                            
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </section><!--//section-->
                
                
                <section class="projects section">
                    <div class="section-inner">
                        <h2 class="heading">Practical Projects</h2>
                        <div class="content">
                        
                            <div class="item" name="pp">
                                <h3 class="title"><a href="#" target="_blank"><!-- title --></a> <span class="fromto"></span></h3><br>
                                <p class="summary"><!-- description --></p>
                                <p><a class="more-link" href="#" target="_blank"><i class="fa fa-external-link"></i> Find out more</a></p>
                            </div><!--//item-->


                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </section><!--//section-->
                
                <section class="experience section">
                    <div class="section-inner">
                        <h2 class="heading">Work Experience</h2>
                        <div class="content">
                        
                              <div class="item" name="workexp">
                                <h3 class="title"><span class="job"><!-- job --></span> - <span class="place"><!-- company --></span> <span class="year"> <!-- date --></span></h3>
                                <p><!-- duty --></p>
                              </div>

                            
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </section><!--//section-->
                <section class="github section">
                    <div class="section-inner">
                        <h2 class="heading">My GitHub</h2>
                        <p>You can embed your GitHub activities using ${sessionScope.temp.getGithubname() }'s <a href="https://github.com/${sessionScope.temp.getGithubname() }" target="_blank">GitHub Activity Stream</a> widget.        
                        <!--//Usage: http://zigzagbob.com/projects/github-activity/ -->                       
                        <div id="ghfeed" class="ghfeed">
                        </div><!--//ghfeed-->
                        
                    </div><!--//secton-inner-->
                </section><!--//section-->
            </div><!--//primary-->
            <div class="secondary col-md-4 col-sm-12 col-xs-12">
                 <aside class="info aside section">
                    <div class="section-inner">
                        <h2 class="heading sr-only">Basic Information</h2>
                        <div class="content">
                            <ul class="list-unstyled">
                                <li><i class="fa fa-map-marker"></i><span class="sr-only">Location:</span>${sessionScope.temp.getCity() }, ${sessionScope.temp.getCountry() }</li>
                                <li><i class="fa fa-envelope-o"></i><span class="sr-only">Email:</span><a href="mailto:${sessionScope.temp.getEmail() }@uni.sydney.edu.au">${sessionScope.temp.getEmail() }@uni.sydney.edu.au</a></li>
                                <li><i class="fa fa-link"></i><span class="sr-only">Website:</span><a href="${sessionScope.temp.getHomepage() }" target="_blank">${sessionScope.temp.getHomepage() }</a></li>
                            </ul>
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//aside-->
                
                <aside class="skills aside section">
                    <div class="section-inner">
                        <h2 class="heading">Programming</h2>
                        <div class="content">
                            <p class="intro">Utilizing frequency of language is from 0% (Never) to 100% (Always).</p>
                            <div class="skillset"></div>         
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//section-->
                
                <aside class="testimonials aside section">
                    <div class="section-inner">
                        <h2 class="heading">Webs</h2>
                        <div class="content">
                        
                        
                        	<div class="item" name="webs">
                            	<blockquote class="quote">
                                	<p><a class="more-link" href="#" target="_blank"><i class="fa fa-external-link"></i> <span class="webname"></span></a></p>
                                	<p><!-- description --></p>
                                </blockquote>
                            </div>

                            
                        </div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                
                <aside class="education aside section">
                    <div class="section-inner">
                        <h2 class="heading">Education</h2>
                        <div class="content">
                        
                        	<div class="item" name="edu">                      
                                <h3 class="title"><i class="fa fa-graduation-cap"></i> <span class="degree"><!-- degree --></span> <span class="major"><!-- major --></span></h3>
                                <h4 class="university"><span class="school"><!-- university --></span> <span class="year"><!-- fromto --></span></h4>
                            </div>

                        </div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                            
                <aside class="languages aside section">
                    <div class="section-inner">
                        <h2 class="heading">Languages</h2>
                        <div class="content">
                            <ul class="list-unstyled">
                            
                                <li class="item" name="language">
                                    <span class="title"><strong class="lang"><!-- language --></strong></span>
                                    <span class="level"></span>
                                </li><!--//item-->

                            </ul>
                        </div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                
                <!--aside class="blog aside section">
                    <div class="section-inner">
                        <h2 class="heading">Latest Blog Posts</h2>
                        <p>You can use zigzagbob's <a href="https://weibo.com/" target="_blank">Sina Weibo</a> to pull in your blog post feeds.</p>
                        <div id="rss-feeds" class="content">

                        </div>
                    </div>
                </aside-->
                
                <aside class="list music aside section">
                    <div class="section-inner">
                        <h2 class="heading">Favourite coding music</h2>
                        <div class="content">
                            <ul class="list-unstyled"></ul>
                        </div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                
                <aside class="list conferences aside section">
                    <div class="section-inner">
                        <h2 class="heading">Conferences</h2>
                        <div class="content">
                            <ul class="list-unstyled">
                            
                                <li name="conference"><i class="fa fa-calendar"></i> <a href="#" target="_blank"><span class="meet"></span></a> (<span class="loc"></span>)</li>

                            </ul>
                        </div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                
                <aside class="education aside section">
                    <div class="section-inner">
                        <h2 class="heading">Awards</h2>
                        <div class="content"></div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                
                
                <aside class="info aside section" name="visitormap">
                    <div class="section-inner">
                        <h2 class="heading">Visitor map</h2>
                        <div id="chartdiv"></div>
                        
                        <table class="vl">
                        	<tr class="tbhead">
                        		<td>Recent Visitors (History: <span>-</span>)</td><td>Browser</td><td>OS</td>
                        	</tr>
                        </table>
                        
                    </div>
                </aside>
                
              
            </div><!--//secondary-->    
        </div><!--//row-->
    </div><!--//masonry-->

	<div class="returnTop"><span class="s"></span><span class="b"></span></div>
    <!--div class="qrCode"></div>
    <span id="qr"><img src="../resources/assets/images/qrcode/qrc.png" /><h5>Scan to browse on mobile.</h5></span-->
    
    <div id="perfundo-single2" class="perfundo__overlay fadeIn">
    	<figure class="perfundo__content perfundo__figure">
        	<div class="perfundo__image"></div>
        		<figcaption class="perfundo__figcaption">
                	<p class="perfundo__caption"></p>
                </figcaption>
       </figure>
       <a href="#perfundo-none" class="perfundo__close perfundo__control">Close</a>
	</div>
    
  </body>
	<script src="../resources/userAssets/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="../resources/js/loadcv.js" type="text/javascript"></script>
</html> 

