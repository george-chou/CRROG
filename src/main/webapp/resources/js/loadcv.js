$(window).load(function(e) {
	
	$.ajax({
		url:"../cvload/folio",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i === 0)
				{
					$('div[name=firstfolio]').find('a').each(function(index, element) {
                        $(this).attr('href', item.url);
                    });
										
					$('div[name=firstfolio]').find('a').eq(0).text(item.title);
					$('div[name=firstfolio]').find('.summary').text(item.subtitle);
					$('div[name=firstfolio]').find('p').eq(1).text(item.description);					
				}
				else if(i === 1)
				{
					var cfolio = $('div[name=folio]').eq(0);
					
					cfolio.find('a').each(function(index, element) {
                        $(this).attr('href', item.url);
                    });
					
					var src = cfolio.find('img').attr('src') + '2';
					cfolio.find('img').attr('src', src);					
					cfolio.find('a').eq(1).text(item.title);
					cfolio.find('p').eq(0).text(item.description);					
				}
				else
				{
					var pfolio = $('div[name=folio]').eq(0);
					pfolio.clone(false).appendTo(pfolio.parent('div'));
					
					var cfolio = $('div[name=folio]').eq(i - 1);
					
					cfolio.find('a').each(function(index, element) {
                        $(this).attr('href', item.url);
                    });
					
					var id = parseInt(i) + parseInt(1);
					var src = cfolio.find('img').attr('src');
					var newsrc = src.substring(0, src.length - 1) + id;
					cfolio.find('img').attr('src', newsrc);					
					cfolio.find('a').eq(1).text(item.title);
					cfolio.find('p').eq(0).text(item.description);	
					
				}
				
			});
			
			console.log("loading folio success!");

		},
		error: function(data)
		{
			console.log("loading folio failed!");
		}
	});
	
	
	$.ajax({
		url:"../cvload/pp",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var pp = $('div[name=pp]').eq(0);
					pp.clone(false).appendTo(pp.parent('div'));
				}
				
				var cproject = $('div[name=pp]').eq(i);
				cproject.find('a').each(function(index, element) {
					$(this).attr('href', item.url);
				});
				
				cproject.find('a').eq(0).text(item.title);
				var fromto = '(' +  item.from + '~' + item.to + ')';
				cproject.find('.fromto').eq(0).text(fromto);
				cproject.find('.summary').eq(0).text(item.description);
				
			});
			
			console.log("loading practice success!");

		},
		error: function(data)
		{
			console.log("loading practice failed!");
		}
	});
	
		
	$.ajax({
		url:"../cvload/workexp",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var firstwork = $('div[name=workexp]').eq(0);
					firstwork.clone(false).appendTo(firstwork.parent('div'));
				}
				
				var cwork = $('div[name=workexp]').eq(i);
				cwork.find('.job').text(item.job);
				cwork.find('.place').text(item.company);
				var fromto = '(' +  item.from + '~' + item.to + ')';
				cwork.find('.year').text(fromto);
				cwork.find('p').text(item.duty);
			});
			
			console.log("loading workexp success!");

		},
		error: function(data)
		{
			console.log("loading workexp failed!");
		}
	});

	$.ajax({
		url:"../cvload/webs",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var firstweb = $('div[name=webs]').eq(0);
					firstweb.clone(false).appendTo(firstweb.parent('div'));
				}
				
				var cweb = $('div[name=webs]').eq(i);
				cweb.find('a').attr('href', item.url);
				cweb.find('.webname').text(item.webname);
				cweb.find('p').eq(1).text(item.description);
				
			});
			
			console.log("loading webs success!");

		},
		error: function(data)
		{
			console.log("loading webs failed!");
		}
	});	
	

	$.ajax({
		url:"../cvload/edu",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var firstedu = $('div[name=edu]').eq(0);
					firstedu.clone(false).appendTo(firstedu.parent('div'));
				}
				
				var cedu = $('div[name=edu]').eq(i);
				
				var degree = 'Others';				
				switch(parseInt(item.degree))
				{
					case 1: 
						degree = 'Undergraduate';
						break;
						
					case 2:	
						degree = 'Bachelor';
						break;
					
					case 3:
						degree = 'Postgraduate';
						break;
						
					case 4: 
						degree = 'Master';
						break;
						
					case 5: 
						degree = 'PhD';
						break;
						
					default: 
						degree = 'Others';
						break;
				}
				
				cedu.find('.degree').text(degree);
				cedu.find('.major').text(item.major);
				cedu.find('.school').text(item.school);
				var fromto = '(' +  item.from + '~' + item.to + ')';
				cedu.find('.year').text(fromto);
					
			});
			
			console.log("loading education success!");

		},
		error: function(data)
		{
			console.log("loading education failed!");
		}
	});


	$.ajax({
		url:"../cvload/language",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var firstlang = $('li[name=language]').eq(0);
					firstlang.clone(false).appendTo(firstlang.parent('ul'));					
				}
				
				var clang = $('li[name=language]').eq(i);
				clang.find('strong').text(item.language + ': ');
				clang.find('.level').empty();

				for(var j = 0 ; j < Math.floor(item.proficiency) ; j++)
				{
					clang.find('.level').append('<i class="fa fa-star"></i> ');
				}
				
				if(item.proficiency > Math.floor(item.proficiency))
				{
					clang.find('.level').append('<i class="fa fa-star-half"></i>');
				}
				
			});
			
			console.log("loading language success!");

		},
		error: function(data)
		{
			console.log("loading language failed!");
		}
	});
	
	$.ajax({
		url:"../cvload/meet",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item){
				
				if(i > 0)
				{
					var firstmeet = $('li[name=conference]').eq(0);
					firstmeet.clone(false).appendTo(firstmeet.parent('ul'));
				}
				
				var cmeet = $('li[name=conference]').eq(i);
				cmeet.find('a').attr('href', item.url);
				cmeet.find('.meet').text(item.meeting);
				cmeet.find('.loc').text(item.location);
							
			});
			
			console.log("loading conference success!");

		},
		error: function(data)
		{
			console.log("loading conference failed!");
		}
	});
	
	$.ajax({
		url:"../cvload/others",
		type:"POST",
		data:{},
		async:false,
		dataType:"json",
		success: function(data)
		{
			$.each(data, function(i, item)
			{
				if(i === 1)
				{
					$('aside[name=visitormap]').css('display', item.visitormap ? 'block' : 'none');
					$('.music').css('display', item.qqmusicsw ? 'block' : 'none');
					$('.github').css('display', item.gitsw ? 'block' : 'none');
		
					$('.social').find('li').eq(0).css('display', item.twittersw ? 'inline-block' : 'none');
					$('.social').find('li').eq(1).css('display', item.googlesw ? 'inline-block' : 'none');
					$('.social').find('li').eq(2).css('display', item.linkedinsw ? 'inline-block' : 'none');
					$('.social').find('li').eq(3).css('display', item.githubsw ? 'inline-block' : 'none');
					$('.social').find('li').eq(4).css('display', item.ycomsw ? 'inline-block' : 'none');
					
				}
				else
				{
					//var pg = apis.find('fieldset').eq(1);
					
					$('.skills').css('display', item.programming ? 'block' : 'none');
					
					/*
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
					*/
				}
				
			});
			
			console.log("loading others success!");

		},
		error: function(data)
		{
			console.log("loading others failed!");
		}
	});
	
});
