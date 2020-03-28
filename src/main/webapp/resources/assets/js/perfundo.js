requirejs(['jquery'], function($) {
/*
function ShowCer(img, caption)
{
	var imglnk = domain + "/api/award/cer/" + img;
	$('.perfundo__image').css("background-image","url(" + imglnk + ")"); 
	$('.perfundo__caption').text(caption);
}
*/
function ShowCer(img, caption, id)
{
	var imglnk = "../img/" + img + "/awards/" + id;
	$('.perfundo__image').css("background-image","url(" + imglnk + ")"); 
	$('.perfundo__caption').text(caption);
}

function workExp()
{
	var workexp = $('.experience').eq(0).find('.perfundo__link');
	var hls = workexp.eq(0);
	var dy = workexp.eq(1);
	
	var hlsCaption = isEn ? "Working Certificate from Beijing HollySys Co., Ltd." : "北京和利时系统工程有限公司工作证明";
	var dyCaption = isEn ? "Working Certificate from Liaoning Dongye Industry Co.,Ltd." : "辽宁东野环保产业开发有限公司工作证明";
	
	hls.click(function(e) {
        ShowCer("hls.jpg", hlsCaption);
    });
	
	dy.click(function(e) {
        ShowCer("dy.jpg", dyCaption);
    });	
}

function toDate(date)
{
	var basic = date.toString();
	basic = basic.substr(0, basic.length - 3);
	return basic.replace("-", ".");
}

function up(x, y)
{
	var date1 = new Date(x.date);
	var date2 = new Date(y.date);
	
	return (date1.getTime() < date2.getTime()) ? 1 : -1;
}

function loadCers(title, place, date, lnk, photo, descript)
{
	var institute = place;
	
	if(lnk !== null)
	{
		institute = '<a href="' + lnk;
		institute += '" target="_blank" rel="nofollow noopener noreferrer" style="color: inherit !important;">';
		institute += place + '</a>';
	}
	
	var divitem = '<div class="item"><h3 class="title"><i class="fa fa-certificate"></i> ';
	divitem += '<a class="perfundo__link" href="#perfundo-single2">' + title + '</a></h3>';
	divitem += '<h4 class="university">' + institute + '<span class="year"> (' + toDate(date) + ')</span></h4></div>';
	
	return divitem;
}

function getCers()
{
	var jurl = '../cvload/award';
	//$.ajaxSettings.async = false;	
	$.ajax({
  		url: jurl,//domain + "/api/award/index.php",
  		data: {"lg":(isEn?"en":"cn")},  
  		dataType: "json",
  		success: function(data){
			
			data.sort(up);
			var condiv = $('.education').eq(1).find('.content').eq(0);
			
			$.each(data, function(i, item)
			{
				
				var divitem = loadCers(item.title, item.institution, item.date, item.url);
				condiv.append(divitem);
				condiv.find('.perfundo__link').eq(i).click(function(e) {
					ShowCer(item.image, item.description, i + 1);
				});
				/*
				var divitem;
				
				if(isEn)
				{
					divitem = loadCers(item.title, item.place, item.date, item.link);
					condiv.append(divitem);
					condiv.find('.perfundo__link').eq(i).click(function(e) {
						ShowCer(item.photo, item.descript);
					});
				}
				else
				{
					divitem = loadCers(item.titlezh, item.placezh, item.date, item.linkzh);
					condiv.append(divitem);
					condiv.find('.perfundo__link').eq(i).click(function(e) {
						ShowCer(item.photo, item.descriptzh);
					});
				}
				*/
			})
		}
	});		
}

workExp();
getCers();

});