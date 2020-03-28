requirejs(['jquery', 'browser'], function($, Browser) {

function notCompatible()
{
	var b = Browser.brow;//getBrowser();
	return (b.type == "IE" && b.ver < 11) || (b.type == "Adblock");
}

function preLoad()
{
	if($.support.leadingWhitespace)
	{
		$("html").show();
		if(notCompatible()) $(".unsupported-browser").show();
	}
	else
	{
		alert("Please use browser with higher version.");
	}
}

function LoadQRC()
{
	device.mobile() ? $(".qrCode").hide() : $(".qrCode").show();
	$(".qrCode").hover(function(e) { $("#qr").fadeIn(200); });    
	$(".qrCode").mouseleave(function(e) { $("#qr").fadeOut(200); });
}

function LoadSafeLink() 
{
	if (!document.getElementsByTagName) return;
	var anchors = document.getElementsByTagName("a");
	for (var i = 0 ; i < anchors.length ; i++) 
	{
		var anchor = anchors[i];
		if (anchor.getAttribute("href") && anchor.getAttribute("target") == "_blank") anchor.rel = "nofollow noopener noreferrer";
	}
	
	var frames = document.getElementsByTagName("iframe");
	for (var j = 0 ; j < frames.length ; j++)
	{
		var frame = frames[j];
		frame.sandbox = "allow-same-origin allow-scripts";
	}
}

function LoadToTop()
{
	$(window).scroll(function(){ 
		($('html').scrollTop() + $('body').scrollTop() == 0) ? $('.returnTop').fadeOut(100) : $('.returnTop').fadeIn(100); 
	});
	$('.returnTop').click(function(){ $('html, body').animate({scrollTop: 0}, 200); });	
}

preLoad();
LoadQRC();
LoadToTop();
LoadSafeLink();

});

