window.onload = function(){
	
	var me = $('tbody');
	
    $.ajax({
		url:"marksearch",
		type:"POST",
		data:{ "isCollect":true },
		dataType:"json",
		success: function(data)
		{
			me.empty();

			$.each(data, function(i, item){

				var insert = '<tr><td>' + item.name + '</td>';
				insert += '<td>' + item.job + '</td>';
				insert += '<td style="width:720px;"></td>';
				insert += '<td><a href="cv/' + item.email + '" target="_blank"><i class="mdl-color-text--blue-grey-400 material-icons">home</i></a></td>';
				insert += '<td><a href="mailto:' + item.email + '@uni.sydney.edu.au"><i class="mdl-color-text--blue-grey-400 material-icons">email</i></a></td>';
			
				if(item.collected === 'true')
				{
					insert += '<td><i class="mdl-color-text--blue-400 material-icons" role="' + item.email + '">local_offer</i></td>';
				}
				else
				{
					insert += '<td><i class="mdl-color-text--blue-grey-400 material-icons" role="' + item.email + '">local_offer</i></td>';
				}

				if(item.hired === 'true')
				{
					insert += '<td><i class="mdl-color-text--blue-400 material-icons" role="' + item.email + '">people</i></td></tr>';
				}
				else
				{
					insert += '<td><i class="mdl-color-text--blue-grey-400 material-icons" role="' + item.email + '">people</i></td></tr>';
				}
				
				me.append(insert);
			})

		},
		error: function(data)
		{
			$('input[type=text][name=usersearch]').val("search failed!");
		}
	});

}

$('tbody').on("click", ".material-icons", function(){
	
	var me = $(this);
	var id = me.attr('role');
	var on = me.hasClass('mdl-color-text--blue-400');
	var isfollow = (me.text() === 'local_offer');

	$.ajax({
		url:"mark",
		type:"POST",
		data:{
			"email":id,
			"switchon":on,
			"iscollect":isfollow
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
				if(isfollow)
				{
					me.parent('td').parent('tr').remove();
				}
				else
				{
					me.removeClass('mdl-color-text--blue-400');
					me.addClass('mdl-color-text--blue-grey-400');
				}
				
			}
		},
		error: function(data)
		{
			$('input[type=text][name=usersearch]').val("mark failed!");
		}		
	});
	
});
