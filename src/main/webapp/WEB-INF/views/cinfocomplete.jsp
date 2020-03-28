<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="resources/assets/images/cv.ico">
	<title>Company info completion</title>
    
    <link href="resources/userAssets/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/userAssets/css/paper-bootstrap-wizard.css" rel="stylesheet">
    <link href="resources/userAssets/css/font-awesome.css" rel="stylesheet">
	<link href="resources/userAssets/css/themify-icons.css" rel="stylesheet">
    <link href="resources/userAssets/css/dcalendar.picker.css" rel="stylesheet">
    <link href="resources/userAssets/css/select_gj.css" rel="stylesheet">
      
	<script src="resources/userAssets/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="resources/userAssets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="resources/userAssets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
	<script src="resources/userAssets/js/paper-bootstrap-wizard.js" type="text/javascript"></script>
	<script src="resources/userAssets/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="resources/userAssets/js/dcalendar.picker.js" type="text/javascript"></script>
    <script src="resources/userAssets/js/select_gj.min.js" type="text/javascript"></script>
    <script src="resources/userAssets/js/select2_1.js" type="text/javascript"></script>
 
</head>

<body>
	<div class="image-container set-full-height" style="background:#37474f; height: auto;">

	    <!--   Big container   -->
	    <div class="container">
	        <div class="row">
		        <div class="col-sm-8 col-sm-offset-2">

		            <!--      Wizard container        -->
		            <div class="wizard-container">
		                <div class="card wizard-card" data-color="green" id="wizard">
		                	<form>
                        
                        		<div class="wizard-header">
                                	<a href="logout">Log out</a>
		                        	<h3 class="wizard-title">Information completion</h3>
		                        	<p class="category">Please complete your company information.</p>
		                    	</div>
								<div class="wizard-navigation">
									<div class="progress-with-circle">
									    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="4" style="width: 12.5%;"></div>
									</div>
									<ul class="nav nav-pills">
			                            <li class="active" style="width: 25%;">
											<a href="#description" data-toggle="tab" aria-expanded="true">
												<div class="icon-circle checked">
													<i class="ti-comments"></i>
												</div>
												Required information
											</a>
										</li>
			                            <li style="width: 25%;">
											<a href="#type" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-direction-alt"></i>
												</div>
												Optional information
											</a>
										</li>			                            
                                        
			                        </ul>
								</div>
                                
		                        <div class="tab-content">
                                
		                            <div class="tab-pane active" id="description">
		                            	<div class="row">
                                        
		                                	<div class="col-sm-12">
		                                    	<h5 class="info-text"> Complete required information.</h5>
		                            		</div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>Company name</label>
		                                        	<input type="text" class="form-control" placeholder="Your company name" name="companyname">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5">
		                                    	<div class="form-group">
		                                        	<label>ABN</label>
		                                        	<input type="text" class="form-control" placeholder="Your company code" name="companycode">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>Address</label>
		                                        	<input type="text" class="form-control" placeholder="Your company location" name="location">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5">
		                                    	<div class="form-group">
                                                	<label>Erection date</label>
                                                    <input type="date" class="form-control" placeholder="Your company erection date" name="establishdate">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
                                                	<label>License</label>
                                                    <input type="file" name="license" accept=".png">
		                                    	</div>
		                                	</div>
                                            
		                            	</div>
		                            </div>
                                    
                                    
		                            <div class="tab-pane" id="type">
                                   		<div class="row">
                                    		<h5 class="info-text">Add optional information.</h5>
                                            
	                                       	 <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>Company index</label>
		                                        	<input type="text" class="form-control" placeholder="Your company homepage" name="homepage">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5">
		                                    	<div class="form-group">
		                                        	<label>Contact number</label>
		                                        	<input type="text" class="form-control" placeholder="Your company phone" name="phone">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>Company type</label>
		                                        	<input type="text" class="form-control" placeholder="Your company type" name="companytype">
		                                    	</div>
		                                	</div>
                                            
                                           <div class="col-sm-5">
		                                    	<div class="form-group">
		                                        	<label>Company scale</label><br>
		                                        	<select name="scale">
                                                    	<option selected disabled style="display:none;">Scale</option>
                                                        <option value="0">1-500 people</option> 
    													<option value="1">500-2000 people</option> 
    													<option value="2">over 2000 people</option>
                                                   	</select>
		                                    	</div>
		                                	</div>
                                            
		                                </div>
		                            </div>
                                    
                                    
                                </div>
                                
                                
		                        <div class="wizard-footer">
	                            	<div class="pull-right">
	                                    <input type="button" class="btn btn-next btn-fill btn-success btn-wd" name="next" value="Next">
	                                    <input type="button" class="btn btn-finish btn-fill btn-success btn-wd" name="finish" value="Finish" style="display: none;">
									</div>

	                                <div class="pull-left">
	                                    <input type="button" class="btn btn-previous btn-default btn-wd disabled" name="previous" value="Previous">
	                                </div>
	                                <div class="clearfix"></div>
		                        </div>
		                    </form>
		                </div>
		            </div> <!-- wizard container -->
		        </div>
                
                
	        </div> <!-- row -->
	    </div> <!--  big container -->
        
	</div>



</body>

<script src="resources/js/csubmit.js" type="text/javascript"></script>

</html>