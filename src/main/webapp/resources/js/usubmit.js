$('input[type=button][name=finish]').click(function(){

	var firstname = $('input[type=text][name=firstname]').val();
	var lastname = $('input[type=text][name=lastname]').val();
	var gender = $('select[name=gender] option:selected').val();
	var birth = $('input[type=date][name=birth]').val();
	var country = $('.fastbannerform__country option:selected').val();
	var city = $('input[type=text][name=city]').val();
	var job = $('input[type=text][name=job]').val();
	var about = $('textarea[name=about]').val();
	var photo = $('input[type=file][name=photo]').val();
	
	var langset = [];
	$('div[name=language]').find('fieldset').each(function(index, element) {
		
		var lang = $(this).find('select').eq(0);
		var prof = $(this).find('select').eq(1);		
		var language = lang.children('option:selected').val();
		var proficiency = prof.children('option:selected').val();
		
		langset.push({'language':language, 'proficiency':proficiency});		
    });
		
	var eduset = [];
	$('div[name=education]').find('fieldset').each(function(index, element) {
		
		var degree = $(this).find('select').eq(0).children('option:selected').val();
		var major = $(this).find('input').eq(0).val();
		var school = $(this).find('input').eq(1).val();
		var from = $(this).find('input').eq(2).val();
		var to = $(this).find('input').eq(3).val();
		
		eduset.push({'degree':degree, 'major':major, 'school':school, 'from':from, 'to':to});		
    });
	
	var workexpset = [];
	$('div[name=workexp]').find('fieldset').each(function(index, element) {
		
		var job = $(this).find('input').eq(0).val();
		var company = $(this).find('input').eq(1).val();
		var from = $(this).find('input').eq(2).val();
		var to = $(this).find('input').eq(3).val();
		var duty = $(this).find('textarea').eq(0).val();
		
		workexpset.push({'job':job, 'company':company, 'duty':duty, 'from':from, 'to':to});		
    });
	
	var ppset = [];
	$('div[name=practice]').find('fieldset').each(function(index, element) {
		
		var title = $(this).find('input').eq(0).val();
		var url = $(this).find('input').eq(1).val();
		var from = $(this).find('input').eq(2).val();
		var to = $(this).find('input').eq(3).val();
		var description = $(this).find('textarea').eq(0).val();
		
		ppset.push({'title':title, 'url':url, 'description':description, 'from':from, 'to':to});		
    });
	
	var folioset = [];
	$('div[name=folios]').find('fieldset').each(function(index, element) {
		
		var title = $(this).find('input').eq(0).val();
		var subtitle = $(this).find('input').eq(1).val();
		var url = $(this).find('input').eq(2).val();
		var image = $(this).find('input').eq(3).val();
		var description = $(this).find('textarea').eq(0).val();
		
		folioset.push({'title':title, 'subtitle':subtitle, 'url':url, 'image':image, 'description':description});		
    });
	
	
	var awardset = [];
	$('div[name=award]').find('fieldset').each(function(index, element) {
		
		var title = $(this).find('input').eq(0).val();
		var institution = $(this).find('input').eq(1).val();
		var url = $(this).find('input').eq(2).val();
		var image = $(this).find('input').eq(3).val();
		var date = $(this).find('input').eq(4).val();
		var description = $(this).find('textarea').eq(0).val();
		
		awardset.push({'title':title, 'institution':institution, 'url':url, 'image':image, 'date':date, 'description':description});		
    });
	
	var webset = [];
	$('div[name=webs]').find('fieldset').each(function(index, element) {
		
		var webname = $(this).find('input').eq(0).val();
		var url = $(this).find('input').eq(1).val();
		var description = $(this).find('input').eq(2).val();
		
		webset.push({'webname':webname, 'url':url, 'description':description});		
    });
	
	var meetingset = [];
	$('div[name=meeting]').find('fieldset').each(function(index, element) {
		
		var meeting = $(this).find('input').eq(0).val();
		var url = $(this).find('input').eq(1).val();
		var location = $(this).find('input').eq(2).val();
		
		meetingset.push({'meeting':meeting, 'url':url, 'location':location});		
    });
	
	var apis = $('div[name=apis]');
	var gitname = apis.find('input').eq(0).val();
	var gitsw = apis.find('input').eq(1).is(':checked');
	var qmuslist = apis.find('input').eq(2).val();
	var qmusw = apis.find('input').eq(3).is(':checked');
	var mapsw = apis.find('input').eq(4).is(':checked');
	
	var pg = apis.find('fieldset').eq(1);
	var pgsw = pg.find('input').eq(0).is(':checked');
	var cpp = pg.find('input').eq(1).is(':checked');
	var js = pg.find('input').eq(2).is(':checked');
	var htm = pg.find('input').eq(3).is(':checked');
	var cs = pg.find('input').eq(4).is(':checked');
	var mat = pg.find('input').eq(5).is(':checked');
	var java = pg.find('input').eq(6).is(':checked');
	var php = pg.find('input').eq(7).is(':checked');
	var py = pg.find('input').eq(8).is(':checked');
	var vb = pg.find('input').eq(9).is(':checked');
	//var codepath = pg.find('input').eq(10).val();
	
	var pgset = [{'cpp':cpp, 'js':js, 'html':htm, 'cs':cs, 'matlab':mat, 'java':java, 'php':php, 'python':py, 'vb':vb}];
	
	var social = $('div[name=social]');
	var twitterurl = social.find('input').eq(0).val();
	var twittersw = social.find('input').eq(1).is(':checked');
	var googleurl = social.find('input').eq(2).val();
	var googlesw = social.find('input').eq(3).is(':checked');
	var linkinurl = social.find('input').eq(4).val();
	var linkinsw = social.find('input').eq(5).is(':checked');
	var giturl = social.find('input').eq(6).val();
	var githubsw = social.find('input').eq(7).is(':checked');
	var ycomurl = social.find('input').eq(8).val();
	var ycomsw = social.find('input').eq(9).is(':checked');
	
	var mycv = $('div[name=mycv]');
	var style = mycv.find('select').find('option:selected').eq(0).val();
	var showcv = mycv.find('input[type=checkbox]').eq(0).is(':checked');
	
	AjaxChannel("language", langset);
	AjaxChannel("edu", eduset);
	AjaxChannel("workexp", workexpset);
	AjaxChannel("pp", ppset);
	AjaxChannel("folios", folioset);
	AjaxChannel("award", awardset);
	AjaxChannel("webs", webset);
	AjaxChannel("conference", meetingset);	
	AjaxChannel("programming", pgset);	
	
	
	$.ajax({
		url:"ucomplete",
		type:"POST",
		async:false,
		data:{
			"firstname":firstname,
			"lastname":lastname,
			"gender":gender,
			"birth":birth,
			"country":country,
			"city":city,
			"job":job,
			"about":about,
			"photo":photo,
			"gitname":gitname,
			"gitsw":gitsw,
			"qmuslist":qmuslist,
			"qmusw":qmusw,
			"mapsw":mapsw,
			"pgsw":pgsw,
			"twitterurl":twitterurl,
			"twittersw":twittersw,
			"googleurl":googleurl,
			"googlesw":googlesw,
			"linkinurl":linkinurl,
			"linkinsw":linkinsw,
			"giturl":giturl,
			"githubsw":githubsw,
			"ycomurl":ycomurl,
			"ycomsw":ycomsw,
			"style":style,
			"showcv":showcv/*,
			"codepath":codepath*/
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
	
	
//var filenum = 0;	
var formdata = new FormData();

$('input[name=photo]').each(function(index, element) {
	if(element.files[0] !== undefined)
	{
		//filenum++;
		formdata.append("photos", element.files[0]);	
	}
});

$('input[name=foliopic]').each(function(index, element) {
    if(element.files[0] !== undefined) formdata.append("folios", element.files[0]);
});

$('input[name=awardpic]').each(function(index, element) {
    if(element.files[0] !== undefined) formdata.append("awards", element.files[0]);
});

$.ajax({
	type: "POST",
	enctype: 'multipart/form-data',
	url: "uinform",
	data : formdata,
	dataType: 'JSON',
	cache: false,
	processData: false,
	contentType: false,
	success: function (data) {
		console.log("SUCCESS : ", data);
		window.location = "user";
	},
	error: function (e) {
		console.log("ERROR : ", e);
	}
});

});

function AjaxChannel(domain, jsobject)
{
	$.ajax({
		url:"ucompletejson/" + domain,
		type:"POST",
		async:false,
		data:JSON.stringify(jsobject),
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		success: function(data)
		{
			console.log(domain + " post success!");
		},
		error: function(data)
		{
			console.log(domain + " post failed!");
		}		
	});
}