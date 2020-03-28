requirejs(['jquery'], function($) {

function toPercent(point)
{
    var str = Number(point * 100).toFixed(1);
    str += "%";
    return str;
}

function porp(x, y){ return (x.frequency < y.frequency) ? 1 : -1; }


function loadSkillset(lang, freq)
{
	var newItem = '<div class="item"><h3 class="level-title">' + lang;
	newItem += '<span class="level-label">' + freq + '</span></h3>';
	newItem += '<div class="level-bar"><div class="level-bar-inner">';
	newItem += '</div></div></div>';
	
	return newItem;
}

function LoadLevelBar()
{
	var jurl = domain + "/api/skillset/index.php"; 
	
	//$.ajaxSettings.async = false;
	$.getJSON(jurl, function (data) 
	{
		data.sort(porp);
		var skillset = $('.skillset');
		$.each(data, function(i, item)
		{
			var freq = toPercent(item.frequency);
			skillset.append(loadSkillset(item.language, freq));
			skillset.find('.level-bar-inner').eq(i).animate({ width: freq }, 800);
		})
		
	});
	
}

LoadLevelBar(); 

});