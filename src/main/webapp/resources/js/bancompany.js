window.onload = function(){
	
	var me = $('tbody');
	
    $.ajax({
		url:"bannedcompanies",
		type:"POST",
		data:{ "ban":true },
		dataType:"json",
		success: function(data)
		{
			$('tbody').empty();

			$.each(data, function(i, item){

				var insert = '<tr><td>' + item.email + '</td>';
				insert += '<td>' + item.company + '</td>';
				insert += '<td style="width:720px;"></td>';
				insert += '<td><a href="data/enterprise/' + item.email + '" target="_blank"><i class="mdl-color-text--blue-grey-400 material-icons">home</i></a></td>';
				insert += '<td><a href="mailto:' + item.email + '@sydney.edu.au"><i class="mdl-color-text--blue-grey-400 material-icons">email</i></a></td>';
			
				insert += '<td><i class="mdl-color-text--blue-400 material-icons" role="' + item.email + '">local_offer</i></td>';

				$('tbody').append(insert);
			})

		},
		error: function(data)
		{
			console.log("Company search failed!");
		}
	});

}


$('tbody').on("click", ".material-icons", function(){
	
	var me = $(this);
	var id = me.attr('role');
	var on = me.hasClass('mdl-color-text--blue-400');
	var isfollow = (me.text() === 'local_offer');

	$.ajax({
		url:"companyban",
		type:"POST",
		data:{
			"email":id,
			"switchon":on
			},
		dataType:"json",
		success: function(data)
		{	
			if(data && me.hasClass('mdl-color-text--blue-grey-400'))
			{
				me.removeClass('mdl-color-text--blue-grey-400');
				me.addClass('mdl-color-text--blue-400');
			}
			else if((!data) && me.hasClass('mdl-color-text--blue-400'))
			{
				me.removeClass('mdl-color-text--blue-400');
				me.addClass('mdl-color-text--blue-grey-400');
			}
		},
		error: function(data)
		{
			console.log("Company ban failed!");
		}		
	});
	
});
