requirejs(['jquery'], function($) {
	
function loadCodingMusic(sid, sname, singer)
{
	var ul = $('.list-unstyled').eq(2);
	var lnk = "https://y.qq.com/n/yqq/song/" + sid + "_num.html";
	var li = '<li><i class="fa fa-headphones"></i> <a href="' + lnk;
	li += '" target="_blank">' + sname + ' - ' + singer + '</a></li>';
	ul.append(li);
}

function postSonglist()
{
	var jurl = domain + "/api/qmusic/index.php"; 
	
	//$.ajaxSettings.async = false;
	$.getJSON(jurl, function (data) 
	{
		$.each(data, function(i, item)
		{
			loadCodingMusic(item.songid, item.songname, item.artist);
		})
		
	});
}

postSonglist();
	
});

