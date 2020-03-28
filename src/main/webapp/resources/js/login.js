$('input[type=radio][name=clientype]').change(function() {
	if (this.value == 'user')
	{
		$(".suffix").text("@uni.sydney.edu.au");
	}
	else if (this.value == 'company')
	{
		$(".suffix").text("@sydney.edu.au");
	}
});

$('#btnSendCode').click(function(){
	
	$.ajax({
		url:"sendemail",
		type:"POST",
		data:{
			"username":$('input[type=text][name=username]').val(),
			"suffix":$('input[type=radio][name=clientype]:checked').val()
			},
		dataType:"json",
		success: function(data)
		{
			if(data.result == "Sending success.")
			{
				$('#btnSendCode').attr("disabled", "disabled");
    			var time = 120;
    			var set = setInterval(function() {        				
        			$('#btnSendCode').text(time.toString() + "s");
					time--;
        			if(time === 0) 
					{
						clearInterval(set);
						$('#btnSendCode').text("Resend code");
						$('#btnSendCode').removeAttr("disabled");
        			}
    			}, 1000);
			}
			else
			{
				$('#userNameErr').text(data.result);
				setTimeout(function(){ $('#userNameErr').text(" "); }, 3000);
			}
			
		},
		error: function(data)
		{
			$('#userNameErr').text(data.result);
		}
	});

});
