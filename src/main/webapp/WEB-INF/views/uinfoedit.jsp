<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="resources/assets/images/cv.ico">
	<title>User info edit</title>
    
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

    <script src="resources/userAssets/js/select_gj.min.js" type="text/javascript" defer></script>
    <script src="resources/userAssets/js/select2_1.js" type="text/javascript" defer></script>
 
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
                                	<a href="user">Abort</a>
		                        	<h3 class="wizard-title">Information edit</h3>
		                        	<p class="category">Please edit your personal information.</p>
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
												Basic information
											</a>
										</li>
			                            <li style="width: 25%;">
											<a href="#type" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-direction-alt"></i>
												</div>
												Required skills
											</a>
										</li>
			                            <li style="width: 25%;">
											<a href="#location" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-map"></i>
												</div>
												Optional experiences
											</a>
										</li>
			                            <li style="width: 25%;">
											<a href="#facilities" data-toggle="tab">
												<div class="icon-circle">
                                                    <i class="ti-panel"></i>
												</div>
												Control panel
											</a>
										</li>
                                        
			                        </ul>
								</div>
		                        <div class="tab-content">
		                            <div class="tab-pane active" id="description">
		                            	<div class="row">
		                                	<div class="col-sm-12">
		                                    	<h5 class="info-text"> Edit your basic information.</h5>
		                            		</div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>First name</label>
		                                        	<input type="text" class="form-control" placeholder="Your given name" name="firstname" value="${sessionScope.client.getFirstname() }">
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5">
		                                    	<div class="form-group">
		                                        	<label>Last name</label>
		                                        	<input type="text" class="form-control" placeholder="Your family name" name="lastname" value="${sessionScope.client.getLastname() }">
		                                    	</div>
		                                	</div>
                                                                                                                                  
		                                	<div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>Gender</label>
		                                        	<select class="form-control" name="gender">
			                                            <option value="2" selected style="display:none;">- Gender -</option>
			                                            <option value="0">Female</option>
			                                            <option value="1">Male </option>
			                                            <option value="2">Others</option>
		                                        	</select>
		                                    	</div>
		                                	</div>
                                            
                                            <div class="col-sm-5">
		                                    	<div class="form-group">
		                                            <label>Birth</label><br>
                                            		<input class="form-control mydatepicker" type='date' name="birth" value="${sessionScope.client.getBirth() }">
		                                		</div>
                                            </div>
                                            
		                                	<div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        	<label>Country/Region</label><br>
		                                           	<select name="country" class="fastbannerform__country">
														<option value="America" title="AC">America</option>
														<option value="Andorra" title="AD">Andorra</option>
														<option value="United Arab Emirates" title="AE">United Arab Emirates</option>
														<option value="Afghanistan" title="AF">Afghanistan</option>
														<option value="Antigua and Barbuda" title="AG">Antigua and Barbuda</option>
														<option value="Albania" title="AL">Albania</option>
														<option value="Armenia" title="AM">Armenia</option>
														<option value="Angola" title="AO">Angola</option>
														<option value="Argentina" title="AR">Argentina</option>
														<option value="Austria" title="AT">Austria</option>
														<option value="Australia" title="AU" selected>Australia</option>
														<option value="Aruba" title="AW">Aruba</option>
														<option value="Azerbaijan" title="AZ">Azerbaijan</option>
														<option value="Bosnia and Herzegovina" title="BA">Bosnia and Herzegovina</option>
														<option value="Barbados" title="BB">Barbados</option>
														<option value="Bangladesh" title="BD">Bangladesh</option>
														<option value="Belgium" title="BE">Belgium</option>
														<option value="Burkina Faso" title="BF">Burkina Faso</option>
														<option value="Bulgaria" title="BG">Bulgaria</option>
														<option value="Bahrain" title="BH">Bahrain</option>
														<option value="Burundi" title="BI">Burundi</option>
														<option value="Benin" title="BJ">Benin</option>
														<option value="Bermuda" title="BM">Bermuda</option>
														<option value="Brunei" title="BN">Brunei</option>
														<option value="Bolivia" title="BO">Bolivia</option>
														<option value="Brazil" title="BR">Brazil</option>
														<option value="Bahamas" title="BS">Bahamas</option>
														<option value="Bhutan" title="BT">Bhutan</option>
														<option value="Botswana" title="BW">Botswana</option>
														<option value="Belarus" title="BY">Belarus</option>
														<option value="Belize" title="BZ">Belize</option>
														<option value="Canada" title="CA">Canada</option>
														<option value="Democratic Republic of the Congo" title="CD">Democratic Republic of the Congo</option>
														<option value="Central African Republic" title="CF">Central African Republic</option>
														<option value="Democratic Republic of the Congo" title="CG">Democratic Republic of the Congo</option>
														<option value="Switzerland" title="CH">Switzerland</option>
														<option value="Chile" title="CL">Chile</option>
														<option value="Cameroon" title="CM">Cameroon</option>
														<option value="China" title="CN">China</option>
														<option value="Colombia" title="CO">Colombia</option>
														<option value="Costa Rica" title="CR">Costa Rica</option>
														<option value="Cuba" title="CU">Cuba</option>
														<option value="Cape Verde" title="CV">Cape Verde</option>
														<option value="Cyprus" title="CY">Cyprus</option>
														<option value="Czech Republic" title="CZ">Czech Republic</option>
														<option value="Germany" title="DE">Germany</option>
														<option value="Djibouti" title="DJ">Djibouti</option>
														<option value="Denmark" title="DK">Denmark</option>
														<option value="Dominica" title="DM">Dominica</option>
														<option value="Dominican Republic" title="DO">Dominican Republic</option>
														<option value="Algeria" title="DZ">Algeria</option>
														<option value="Ecuador" title="EC">Ecuador</option>
														<option value="Estonia" title="EE">Estonia</option>
														<option value="Egypt" title="EG">Egypt</option>
														<option value="Eritrea" title="ER">Eritrea</option>
														<option value="Spain" title="ES">Spain</option>
														<option value="Ethiopia" title="ET">Ethiopia</option>
														<option value="Finland" title="FI">Finland</option>
														<option value="Fiji" title="FJ">Fiji</option>
														<option value="Falkland Islands" title="FK">Falkland Islands</option>
														<option value="Micronesia" title="FM">Micronesia</option>
														<option value="Faroe Islands" title="FO">Faroe Islands</option>
														<option value="France" title="FR">France</option>
														<option value="Gabon" title="GA">Gabon</option>
														<option value="United Kingdom" title="GB">United Kingdom</option>
														<option value="Grenada" title="GD">Grenada</option>
														<option value="Georgia" title="GE">Georgia</option>
														<option value="Ghana" title="GH">Ghana</option>
														<option value="Gibraltar" title="GI">Gibraltar</option>
														<option value="Gambia" title="GM">Gambia</option>
														<option value="Guinea" title="GN">Guinea</option>
														<option value="Equatorial Guinea" title="GQ">Equatorial Guinea</option>
														<option value="Greece" title="GR">Greece</option>
														<option value="Guatemala" title="GT">Guatemala</option>
														<option value="Guinea-Bissau" title="GW">Guinea-Bissau</option>
														<option value="Guyana" title="GY">Guyana</option>
														<option value="Hong Kong" title="HK">Hong Kong</option>
														<option value="Honduras" title="HN">Honduras</option>
														<option value="Croatia" title="HR">Croatia</option>
														<option value="Haiti" title="HT">Haiti</option>
														<option value="Hungary" title="HU">Hungary</option>
														<option value="Indonesia" title="ID">Indonesia</option>
														<option value="Ireland" title="IE">Ireland</option>
														<option value="Israel" title="IL">Israel</option>
														<option value="India" title="IN">India</option>
														<option value="Iraq" title="IQ">Iraq</option>
														<option value="Iran" title="IR">Iran</option>
														<option value="Iceland" title="IS">Iceland</option>
														<option value="Italy" title="IT">Italy</option>
														<option value="Jamaica" title="JM">Jamaica</option>
														<option value="Jordan" title="JO">Jordan</option>
														<option value="Japan" title="JP">Japan</option>
														<option value="Kenya" title="KE">Kenya</option>
														<option value="Kyrgyzstan" title="KG">Kyrgyzstan</option>
														<option value="Cambodia" title="KH">Cambodia</option>
														<option value="Kiribati" title="KI">Kiribati</option>
														<option value="Comoros" title="KM">Comoros</option>
														<option value="Saint Kitts and Nevis" title="KN">Saint Kitts and Nevis</option>
														<option value="North Korea" title="KP">North Korea</option>
														<option value="South Korea" title="KR">South Korea</option>
														<option value="Kuwait" title="KW">Kuwait</option>
														<option value="Cayman Islands" title="KY">Cayman Islands</option>
														<option value="Kazakhstan" title="KZ">Kazakhstan</option>
														<option value="Laos" title="LA">Laos</option>
														<option value="Lebanon" title="LB">Lebanon</option>
														<option value="Saint Lucia" title="LC">Saint Lucia</option>
														<option value="Liechtenstein" title="LI">Liechtenstein</option>
														<option value="Sri Lanka" title="LK">Sri Lanka</option>
														<option value="Liberia" title="LR">Liberia</option>
														<option value="Lesotho" title="LS">Lesotho</option>
														<option value="Lithuania" title="LT">Lithuania</option>
														<option value="Luxembourg" title="LU">Luxembourg</option>
														<option value="Latvia" title="LV">Latvia</option>
														<option value="Libya" title="LY">Libya</option>
														<option value="Morocco" title="MA">Morocco</option>
														<option value="Monaco" title="MC">Monaco</option>
														<option value="Moldova" title="MD">Moldova</option>
														<option value="Montenegro" title="ME">Montenegro</option>
														<option value="Madagascar" title="MG">Madagascar</option>
														<option value="Macedonia" title="MK">Macedonia</option>
														<option value="Mali" title="ML">Mali</option>
														<option value="Myanmar" title="MM">Myanmar</option>
														<option value="Mongolia" title="MN">Mongolia</option>
														<option value="Macao" title="MO">Macao</option>
														<option value="Mauritania" title="MR">Mauritania</option>
														<option value="Malta" title="MT">Malta</option>
														<option value="Mauritius" title="MU">Mauritius</option>
														<option value="Maldives" title="MV">Maldives</option>
														<option value="Malawi" title="MW">Malawi</option>
														<option value="Mexico" title="MX">Mexico</option>
														<option value="Malaysia" title="MY">Malaysia</option>
														<option value="Mozambique" title="MZ">Mozambique</option>
														<option value="Namibia" title="NA">Namibia</option>
														<option value="Niger" title="NE">Niger</option>
														<option value="Nigeria" title="NG">Nigeria</option>
														<option value="Nicaragua" title="NI">Nicaragua</option>
														<option value="Netherlands" title="NL">Netherlands</option>
														<option value="Norway" title="NO">Norway</option>
														<option value="Nepal" title="NP">Nepal</option>
														<option value="Nauru" title="NR">Nauru</option>
														<option value="New Zealand" title="NZ">New Zealand</option>
														<option value="Oman" title="OM">Oman</option>
														<option value="Panama" title="PA">Panama</option>
														<option value="Peru" title="PE">Peru</option>
														<option value="Papua New Guinea" title="PG">Papua New Guinea</option>
														<option value="Philippines" title="PH">Philippines</option>
														<option value="Pakistan" title="PK">Pakistan</option>
														<option value="Poland" title="PL">Poland</option>
														<option value="Puerto Rico" title="PR">Puerto Rico</option>
														<option value="Palestine" title="PS">Palestine</option>
														<option value="Portugal" title="PT">Portugal</option>
														<option value="Palau" title="PW">Palau</option>
														<option value="Paraguay" title="PY">Paraguay</option>
														<option value="Qatar" title="QA">Qatar</option>
														<option value="Romania" title="RO">Romania</option>
														<option value="Serbia" title="RS">Serbia</option>
														<option value="Russia" title="RU">Russia</option>
														<option value="Rwanda" title="RW">Rwanda</option>
														<option value="Saudi Arabia" title="SA">Saudi Arabia</option>
														<option value="Solomon Islands" title="SB">Solomon Islands</option>
														<option value="Seychelles" title="SC">Seychelles</option>
														<option value="Sudan" title="SD">Sudan</option>
														<option value="Sweden" title="SE">Sweden</option>
														<option value="Singapore" title="SG">Singapore</option>
														<option value="Slovenia" title="SI">Slovenia</option>
														<option value="Slovak Republic" title="SK">Slovak Republic</option>
														<option value="Sierra Leone" title="SL">Sierra Leone</option>
														<option value="San Marino" title="SM">San Marino</option>
														<option value="Senegal" title="SN">Senegal</option>
														<option value="Somalia" title="SO">Somalia</option>
														<option value="Suriname" title="SR">Suriname</option>
														<option value="Sao Tome and Principe" title="ST">Sao Tome and Principe</option>
														<option value="El Salvador" title="SV">El Salvador</option>
														<option value="Syria" title="SY">Syria</option>
														<option value="Swaziland" title="SZ">Swaziland</option>
														<option value="Chad" title="TD">Chad</option>
														<option value="Togo" title="TG">Togo</option>
														<option value="Thailand" title="TH">Thailand</option>
														<option value="Tajikistan" title="TJ">Tajikistan</option>
														<option value="Turkmenistan" title="TM">Turkmenistan</option>
														<option value="Tunisia" title="TN">Tunisia</option>
														<option value="Tonga" title="TO">Tonga</option>
														<option value="Turkey" title="TR">Turkey</option>
														<option value="Trinidad and Tobago" title="TT">Trinidad and Tobago</option>
														<option value="Tuvalu" title="TV">Tuvalu</option>
														<option value="Taiwan" title="TW">Taiwan</option>
														<option value="Tanzania" title="TZ">Tanzania</option>
														<option value="Ukraine" title="UA">Ukraine</option>
														<option value="Uganda" title="UG">Uganda</option>
														<option value="Uruguay" title="UY">Uruguay</option>
														<option value="Uzbekistan" title="UZ">Uzbekistan</option>
														<option value="Saint Vincent And The Grenadine" title="VC">Saint Vincent And The Grenadine</option>
														<option value="Venezuela" title="VE">Venezuela</option>
														<option value="British Virgin Islands" title="VG">British Virgin Islands</option>
														<option value="Vietnam" title="VN">Vietnam</option>
														<option value="Vanuatu" title="VU">Vanuatu</option>
														<option value="Wallis and Futuna" title="WF">Wallis and Futuna</option>
														<option value="Western Samoa" title="WS">Western Samoa</option>
														<option value="Yemen" title="YE">Yemen</option>
														<option value="South Africa" title="ZA">South Africa</option>
														<option value="Zambia" title="ZM">Zambia</option>
														<option value="Zimbabwe" title="ZW">Zimbabwe</option>
                                               		</select>
		                                    	</div>
		                                	</div>
                                            
		                                	<div class="col-sm-5">
		                                    	<div class="form-group">
		                                            <label>City</label>
		                                        	<input type="text" class="form-control" placeholder="Where is your place located?" name="city" value="${sessionScope.client.getCity() }">
		                                        </div>
		                                	</div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                        <div class="form-group">
                                                	<label>About you</label>
		                                            <textarea class="form-control" placeholder="Introduce yourself" rows="9" name="about"></textarea>
		                                        </div>
		                                    </div>
                                            
                                            <div class="col-sm-5">
		                                    	<div class="form-group">
		                                            <label>Job orientation</label>
		                                        	<input type="text" class="form-control" placeholder="What job are you looking for?" name="job" value="${sessionScope.client.getJob() }">
		                                        </div>
		                                	</div>
                                            
		                                    <div class="col-sm-5">
		                                        <div class="form-group">
		                                            <label>Photo</label>
                                                    <input type="file" name="photo" accept=".png" required>
		                                        </div>
		                                    </div>
                                            
                                            
		                            	</div>
		                            </div>
                                    
                                    
		                            <div class="tab-pane" id="type">
                                    <div class="row">
                                        	<h5 class="info-text">Edit your required skills.</h5>
		                                    <div class="col-sm-5 col-sm-offset-1">
		                                        <div class="form-group" name="language">
                                                <label>Language</label>
                                                <fieldset>
                                                	<legend><button type="button" class="add">+</button></legend>
		                                            <select>
                                                    	<option selected disabled style="display:none;">Language</option>
    													<option value="Afrikanns">Afrikanns</option> 
    													<option value="Albanian">Albanian</option> 
    													<option value="Arabic">Arabic</option> 
    													<option value="Armenian">Armenian</option> 
    													<option value="Basque">Basque</option> 
    													<option value="Bengali">Bengali</option> 
    													<option value="Bulgarian">Bulgarian</option> 
    													<option value="Catalan">Catalan</option> 
    													<option value="Cambodian">Cambodian</option> 
    													<option value="Chinese">Chinese</option> 
    													<option value="Croation">Croation</option> 
    													<option value="Czech">Czech</option> 
    													<option value="Danish">Danish</option> 
    													<option value="Dutch">Dutch</option> 
    													<option value="English">English</option> 
    													<option value="Estonian">Estonian</option> 
    													<option value="Fiji">Fiji</option> 
    													<option value="Finnish">Finnish</option> 
    													<option value="French">French</option> 
    													<option value="Georgian">Georgian</option> 
    													<option value="German">German</option> 
    													<option value="Greek">Greek</option> 
    													<option value="Gujarati">Gujarati</option> 
    													<option value="Hebrew">Hebrew</option> 
    													<option value="Hindi">Hindi</option> 
    													<option value="Hungarian">Hungarian</option> 
    													<option value="Icelandic">Icelandic</option> 
    													<option value="Indonesian">Indonesian</option> 
    													<option value="Irish">Irish</option> 
    													<option value="Italian">Italian</option> 
    													<option value="Japanese">Japanese</option> 
    													<option value="Javanese">Javanese</option> 
    													<option value="Korean">Korean</option> 
    													<option value="Latin">Latin</option> 
    													<option value="Latvian">Latvian</option> 
    													<option value="Lithuanian">Lithuanian</option> 
    													<option value="Macedonian">Macedonian</option> 
    													<option value="Malay">Malay</option> 
    													<option value="Malayalam">Malayalam</option> 
    													<option value="Maltese">Maltese</option> 
    													<option value="Maori">Maori</option> 
    													<option value="Marathi">Marathi</option> 
    													<option value="Mongolian">Mongolian</option> 
    													<option value="Nepali">Nepali</option> 
    													<option value="Norwegian">Norwegian</option> 
    													<option value="Persian">Persian</option> 
    													<option value="Polish">Polish</option> 
    													<option value="Portuguese">Portuguese</option> 
    													<option value="Punjabi">Punjabi</option> 
    													<option value="Quechua">Quechua</option> 
    													<option value="Romanian">Romanian</option> 
    													<option value="Russian">Russian</option> 
    													<option value="Samoan">Samoan</option> 
    													<option value="Serbian">Serbian</option> 
    													<option value="Slovak">Slovak</option> 
    													<option value="Slovenian">Slovenian</option> 
    													<option value="Spanish">Spanish</option> 
    													<option value="Swahili">Swahili</option> 
    													<option value="Swedish ">Swedish </option> 
    													<option value="Tamil">Tamil</option> 
    													<option value="Tatar">Tatar</option> 
    													<option value="Telugu">Telugu</option> 
    													<option value="Thai">Thai</option> 
    													<option value="Tibetan">Tibetan</option> 
    													<option value="Tonga">Tonga</option> 
    													<option value="Turkish">Turkish</option> 
    													<option value="Ukranian">Ukranian</option> 
    													<option value="Urdu">Urdu</option> 
    													<option value="Uzbek">Uzbek</option> 
    													<option value="Vietnamese">Vietnamese</option> 
    													<option value="Welsh">Welsh</option> 
    													<option value="Xhosa">Xhosa</option> 
													</select>
                                                    <select>
                                                    	<option selected disabled style="display:none;">Proficiency</option>
                                                    	<option value="0.5">0.5</option> 
    													<option value="1.0">1.0</option> 
    													<option value="1.5">1.5</option> 
    													<option value="2.0">2.0</option> 
    													<option value="2.5">2.5</option> 
    													<option value="3.0">3.0</option> 
    													<option value="3.5">3.5</option> 
    													<option value="4.0">4.0</option> 
    													<option value="4.5">4.5</option> 
    													<option value="5.0">5.0</option> 
                                                   	</select><br><br>                                                   
                                                 </fieldset>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-5">
		                                        <div class="form-group" name="education">
                                                	<label>Education</label>
		                                            <fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
                                                    	<select>
                                                    		<option selected disabled style="display:none;">Degree</option> 
                                                    		<option value="0">College or below</option> 
    														<option value="1">Undergraduate</option> 
    														<option value="2">Bachelor</option>
    														<option value="3">Postgraduate</option> 
    														<option value="4">Master</option> 
    														<option value="5">PhD</option>
                                                   		</select><br><br>
                                                    	<input class="form-control" placeholder="Major" type="text"><br>
                                                    	<input class="form-control" placeholder="School" type="text"><br>
                                                    	<span class="datespan">From</span><input class="form-control mydatepicker" type='date'/><br> 
                                                    	<span class="datespan">To</span><input class="form-control mydatepicker" type='date'/><br><br>
                                                    </fieldset>
		                                        </div>
		                                    </div>
                                            
                                            <div class="col-sm-5 col-sm-offset-1">
		                                        <div class="form-group" name="workexp">
                                                	<label>Work experience</label>
                                                	<fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
		                                            	<input type="text" class="form-control" placeholder="Job"><br>
                                                        <input type="text" class="form-control" placeholder="Company"><br>
                                                        <span class="datespan">From</span><input class="form-control mydatepicker" type='date'/><br> 
                                                    	<span class="datespan">To</span><input class="form-control mydatepicker" type='date'/><br><br>
                                                        <textarea class="form-control" placeholder="Duty" rows="9"></textarea><br><br>
                                                     </fieldset>
		                                        </div>
		                                    </div>
                                            
                                            <div class="col-sm-5">
		                                        <div class="form-group" name="practice">
                                                	<label>Practical projects</label>
		                                            <fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
                                                    	<input type="text" class="form-control" placeholder="Title"><br>
                                                    	<input type="text" class="form-control" placeholder="URL"><br>
                                                   		<span class="datespan">From</span><input class="form-control mydatepicker" type="date"/><br>
                                                    	<span class="datespan">To</span><input class="form-control mydatepicker" type="date"/><br><br>
                                                    	<textarea class="form-control" placeholder="Project descriptions" rows="9"></textarea><br>
                                                    </fieldset>
		                                        </div>
		                                    </div>
                                            
                                            
		                                </div>
		                            </div>
                                    
                                    
		                            <div class="tab-pane" id="location">
		                                <h5 class="info-text">Edit your optional experiences.</h5>
		                                <div class="row">
                                        
                                        	<div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group" name="folios">
                                                	<label>Latest folios</label>
		                                        	<fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
                                                    	<input type="text" class="form-control" placeholder="Title"><br>
                                                        <input type="text" class="form-control" placeholder="Subtitle"><br>
                                                    	<input type="text" class="form-control" placeholder="URL"><br>
                                                        <input type="file" name="foliopic" accept=".png" required><br>
                                                    	<!--img src="#" /><br><br-->
                                                    	<textarea class="form-control" placeholder="Descriptions" rows="9"></textarea><br>
                                                    </fieldset>
		                                    	</div>
		                                    </div>
                                        
		                                    <div class="col-sm-5">
		                                    	<div class="form-group" name="award">
                                                	<label>Award</label>
		                                        	<fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
                                                    	<input type="text" class="form-control" placeholder="Award title"><br>
                                                    	<input type="text" class="form-control" placeholder="Institution"><br>
                                                    	<input type="text" class="form-control" placeholder="URL"><br>
		                                        		<input type="file" name="awardpic" accept=".png" required><br><br>                                     
                                                		<span class="datespan" style="width:60px;">Datetime</span><input class="form-control mydatepicker" type='date'/><br><br>
                                                    	<textarea class="form-control" placeholder="Award descriptions" rows="9"></textarea><br>
                                                    </fieldset>
		                                    	</div>
		                                    </div>
                                            
		                                    <div class="col-sm-5 col-sm-offset-1">
		                                    	<div class="form-group" name="webs">
                                                	<label>Webs</label>
		                                        	<fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
                                                    	<input type="text" class="form-control" placeholder="Web name"><br>
                                                    	<input type="text" class="form-control" placeholder="URL"><br>
                                                    	<input type="text" class="form-control" placeholder="Description"><br>
                                                    </fieldset>
		                                    	</div>
		                                    </div>
                                            
		                                    <div class="col-sm-5">
		                                    	<div class="form-group" name="meeting">
                                                	<label>Conference</label>
		                                        	<fieldset>
                                                		<legend><button type="button" class="add">+</button></legend>
                                                    	<input type="text" class="form-control" placeholder="Meeting"><br>
                                                    	<input type="text" class="form-control" placeholder="URL"><br>
                                                    	<input type="text" class="form-control" placeholder="Location"><br>
                                                    </fieldset>
		                                    	</div>
		                                    </div>
                                            
                                            
		                                </div>
		                            </div>
                                    
                                    
		                            <div class="tab-pane" id="facilities">
		                                <div class="row">
                                        
		                                    <h5 class="info-text">Turn on/off customised APIs.</h5>
		                                    <div class="col-sm-5 col-sm-offset-1">
		                                        <div class="form-group" name="apis">
		                                            <fieldset>
                                                		<legend>API switches</legend>
		                                            	<input type="text" class="form-control" placeholder="GitHub account name">
                                                        <input type="checkbox" name="gitapi" value="gitapi"><br><br>
                                                        <input type="text" class="form-control" placeholder="QQMusic songlist">
                                                        <input type="checkbox" name="qqmusic" value="qqmusic"><br><br>
                                                        <label>Visitor map</label>
                                                        <input type="checkbox" name="visitor" value="visitor"><br><br>
                                                        <fieldset>
                                                			<legend>Programming<input type="checkbox" style="float:right;"></legend>
                                                            C/C++ <input type="checkbox" style="float:right;"><br>
                                                            JavaScript <input type="checkbox" style="float:right;"><br>
                                                            HTML &amp; CSS <input type="checkbox" style="float:right;"><br>
                                                            C# <input type="checkbox" style="float:right;"><br>
                                                            Matlab <input type="checkbox" style="float:right;"><br>
                                                            Java <input type="checkbox" style="float:right;"><br>
                                                            PHP <input type="checkbox" style="float:right;"><br>
                                                            Python <input type="checkbox" style="float:right;"><br>
                                                            Visual Basic <input type="checkbox" style="float:right;"><br>
                                                            <!--input type="file" name="file" accept=".zip"-->
                                                        </fieldset>
                                                    </fieldset>
		                                        </div>
		                                    </div>
                                            
		                                    <div class="col-sm-5">
		                                        <div class="form-group" name="social">
		                                            <fieldset>
                                                		<legend>Social links</legend>
		                                            	<input type="text" class="form-control" placeholder="Twitter URL" value="${sessionScope.client.getTwitterurl() }">
                                                        <input type="checkbox" name="twitter" value="twitter"><br><br>
                                                        <input type="text" class="form-control" placeholder="Google+ URL" value="${sessionScope.client.getGoogleurl() }">
                                                        <input type="checkbox" name="google" value="google"><br><br>
                                                        <input type="text" class="form-control" placeholder="Linkedin URL" value="${sessionScope.client.getLinkedinurl() }">
                                                        <input type="checkbox" name="linkedin" value="linkedin"><br><br>
                                                        <input type="text" class="form-control" placeholder="GitHub URL" value="${sessionScope.client.getGithuburl() }">
                                                        <input type="checkbox" name="github" value="github"><br><br>
                                                        <input type="text" class="form-control" placeholder="Ycombinator URL" value="${sessionScope.client.getYcomurl() }">
                                                        <input type="checkbox" name="Ycombinator" value="ycombinator">
                                                    </fieldset>
		                                        </div>
		                                    </div>
                                            
                                            <div class="col-sm-5">
		                                        <div class="form-group" name="mycv">
		                                            <fieldset>
                                                		<legend>Style selection</legend>
		                                            	<select>
                                                    		<option value="0" selected disabled style="display:none;">Theme</option> 
                                                    		<option value="0">Default</option> 
    														<option value="1">Yellow</option> 
    														<option value="2">Blue</option>
                                                   		</select>
                                                        <label style="float:right;">Show my cv</label>
                                                        <input type="checkbox" style="float:right;">
                                                    </fieldset>
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

<script src="resources/js/uinfoload.js" type="text/javascript"></script>
<script src="resources/js/usubmit.js" type="text/javascript"></script>

 
</html>