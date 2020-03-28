$(window).load(function(){
	
	$.ajax({
		url:"uload/award",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=award]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=award]').find('fieldset').eq(i);
				now.find('input').eq(0).val(item.title);
				now.find('input').eq(1).val(item.institution);
				now.find('input').eq(2).val(item.url);
				//now.find('input').eq(3).val(item.image);
				now.find('input').eq(4).val(item.date);
				now.find('textarea').eq(0).val(item.description);
				
			});
			
			console.log("loading award success!");

		},
		error: function(data)
		{
			console.log("loading award failed!");
		}
	});
	
	$.ajax({
		url:"uload/meet",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=meeting]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=meeting]').find('fieldset').eq(i);
				now.find('input').eq(0).val(item.meeting);
				now.find('input').eq(1).val(item.url);
				now.find('input').eq(2).val(item.location);				
			});
			
			console.log("loading conference success!");

		},
		error: function(data)
		{
			console.log("loading conference failed!");
		}
	});
	
	
	$.ajax({
		url:"uload/edu",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=education]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=education]').find('fieldset').eq(i);
				now.find('select').eq(0).find('option[value=' + item.degree + ']').eq(0).attr("selected", "selected");
				now.find('input').eq(0).val(item.major);
				now.find('input').eq(1).val(item.school);
				now.find('input').eq(2).val(item.from);		
				now.find('input').eq(3).val(item.to);		
			});
			
			console.log("loading education success!");

		},
		error: function(data)
		{
			console.log("loading education failed!");
		}
	});
	
	$.ajax({
		url:"uload/folio",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=folios]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=folios]').find('fieldset').eq(i);
				now.find('input').eq(0).val(item.title);
				now.find('input').eq(1).val(item.subtitle);
				now.find('input').eq(2).val(item.url);
				//now.find('input').eq(3).val(item.image);
				now.find('input').eq(4).val(item.date);
				now.find('textarea').eq(0).val(item.description);
				
			});
			
			console.log("loading folio success!");

		},
		error: function(data)
		{
			console.log("loading folio failed!");
		}
	});
	
	
	$.ajax({
		url:"uload/language",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=language]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=language]').find('fieldset').eq(i);
				now.find('select').eq(0).find('option[value=' + item.language + ']').attr('selected', 'selected');
				now.find('select').eq(1).find('option[value="' + item.proficiency + '"]').attr('selected', 'selected');
			});
			
			console.log("loading language success!");

		},
		error: function(data)
		{
			console.log("loading language failed!");
		}
	});

	$.ajax({
		url:"uload/pp",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=practice]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=practice]').find('fieldset').eq(i);
				now.find('input').eq(0).val(item.title);
				now.find('input').eq(1).val(item.url);
				now.find('input').eq(2).val(item.from);
				now.find('input').eq(3).val(item.to);
				now.find('textarea').eq(0).val(item.description);
			});
			
			console.log("loading practice success!");

		},
		error: function(data)
		{
			console.log("loading practice failed!");
		}
	});
	
	$.ajax({
		url:"uload/webs",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=webs]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=webs]').find('fieldset').eq(i);
				now.find('input').eq(0).val(item.webname);
				now.find('input').eq(1).val(item.url);
				now.find('input').eq(2).val(item.description);	
			});
			
			console.log("loading webs success!");

		},
		error: function(data)
		{
			console.log("loading webs failed!");
		}
	});
			
	$.ajax({
		url:"uload/workexp",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var prev = $('div[name=workexp]').find('fieldset').eq(i - 1);
					prev.clone(true).appendTo(prev.parent('div'));
					var addbtn = prev.find('button').eq(0);
					addbtn.removeClass('add');
					addbtn.addClass('delete');
					addbtn.text('-');
					addbtn.unbind('click');
				}
				
				var now = $('div[name=workexp]').find('fieldset').eq(i);
				now.find('input').eq(0).val(item.job);
				now.find('input').eq(1).val(item.company);
				now.find('input').eq(2).val(item.from);
				now.find('input').eq(3).val(item.to);
				now.find('textarea').eq(0).val(item.duty);
			});
			
			console.log("loading workexp success!");

		},
		error: function(data)
		{
			console.log("loading workexp failed!");
		}
	});
	
	$.ajax({
		url:"uload/others",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item)
			{
				var apis = $('div[name=apis]');
				
				if(i === 1)
				{
					$('select[name=gender]').find('option[value=' + item.gender + ']').attr('selected', 'selected');
					$('.fastbannerform__country').find('option[value="' + item.country + '"]').attr('selected', 'selected');
					$('textarea[name=about]').val(item.about);
										
					apis.find('input').eq(0).val(item.githubname);
					setCheck(apis.find('input').eq(1), item.gitsw);
					apis.find('input').eq(2).val(item.songlist);
					setCheck(apis.find('input').eq(3), item.qqmusicsw);
					setCheck(apis.find('input').eq(4), item.visitormap);
					
					var social = $('div[name=social]');
					//social.find('input').eq(0).val(item.twitterurl);
					setCheck(social.find('input').eq(1), item.twittersw);
					//social.find('input').eq(2).val(item.googleurl);
					setCheck(social.find('input').eq(3), item.googlesw);
					//social.find('input').eq(4).val(item.linkedinurl);
					setCheck(social.find('input').eq(5), item.linkedinsw);
					//social.find('input').eq(6).val(item.githuburl);
					setCheck(social.find('input').eq(7), item.githubsw);
					//social.find('input').eq(8).val(item.ycomurl);
					setCheck(social.find('input').eq(9), item.ycomsw);
					
					var mycv = $('div[name=mycv]');
					mycv.find('select').eq(0).find('option[value=' + item.style + ']').attr('selected', 'selected');
					setCheck(mycv.find('input').eq(0), item.showcv);
				}
				else
				{
					var pg = apis.find('fieldset').eq(1);
					
					setCheck(pg.find('input').eq(0), item.programming);
 					setCheck(pg.find('input').eq(1), item.cpp);
 					setCheck(pg.find('input').eq(2), item.js);
 					setCheck(pg.find('input').eq(3), item.html);
 					setCheck(pg.find('input').eq(4), item.cs);
 					setCheck(pg.find('input').eq(5), item.matlab);
 					setCheck(pg.find('input').eq(6), item.java);
 					setCheck(pg.find('input').eq(7), item.php);
 					setCheck(pg.find('input').eq(8), item.python);
 					setCheck(pg.find('input').eq(9), item.vb);

				}
				
			});
			
			console.log("loading others success!");

		},
		error: function(data)
		{
			console.log("loading others failed!");
		}
	});
			
$('.delete').click(function(e) { $(this).parent('legend').parent('fieldset').remove(); });

$('.add').click(function(e) {
		
	var me = $(this);
	var myparent = me.parent('legend').parent('fieldset');
	myparent.clone(true).appendTo(myparent.parent('div'));
	me.removeClass('add');
	me.addClass('delete');
	me.text('-');
	me.unbind('click');
	myparent.next('fieldset').find('input, textarea').val('');
	//myparent.next('fieldset').find('select').find('option').eq(0).attr('selected', 'selected');
	
	$('.delete').click(function(e) {		
		$(this).parent('legend').parent('fieldset').remove(); 
	});
	
});
	
});

function setCheck(checkbox, on)
{
	if(on)
	{
		checkbox.attr('checked', 'checked');
	}
	else
	{
		checkbox.removeAttr('checked');
	}
}