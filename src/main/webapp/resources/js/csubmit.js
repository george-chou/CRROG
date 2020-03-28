$('input[type=button][name=finish]').click(function(){
	
	var companyname = $('input[name=companyname]').val();
	var companycode = $('input[name=companycode]').val();
	var location = $('input[name=location]').val();
	var establishdate = $('input[name=establishdate]').val();
	var license = $('input[name=license]').val();
	
	var homepage = $('input[name=homepage]').val();
	var phone = $('input[name=phone]').val();
	var companytype = $('input[name=companytype]').val();
	var scale = $('select[name=scale]').find('option:selected').val();
	
	$.ajax({
		url:"ecomplete",
		type:"POST",
		async:false,
		data:{
			"companyname":companyname,
			"companycode":companycode,
			"location":location,
			"establishdate":establishdate,
			"license":license,
			"homepage":homepage,
			"phone":phone,
			"companytype":companytype,
			"scale":scale
			},
		dataType:"json",
		success: function(data)
		{
			console.log("plain text post success!");
		},
		error: function(data)
		{
			console.log("plain text post failed!");
		}		
	});
	
	
$.ajax({
	type: "POST",
	enctype: 'multipart/form-data',
	url: "cinform",
	data : new FormData($('form')[0]),
	dataType: 'JSON',
	cache: false,
	processData: false,
	contentType: false,
	success: function (data) {
		console.log("SUCCESS : ", data);
		window.location = "logout";
	},
	error: function (e) {
		console.log("ERROR : ", e);
	}
});


});