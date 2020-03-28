requirejs(['jquery', 'browser', 'core', 'maps', 'worldlow', 'animated'], function($, Browser, am4core, _, _, _){

function vInfo(country, city, browser, os, iso, mark)
{
	this.country = country;
	this.city = city; 
	this.browser = browser;
	this.os = os;
	this.iso = iso;
	this.mark = mark;
}

function mInfo(latitude, longitude, IP, current)
{
	this.zoomLevel = 5;
	this.scale = 0.5;
	this.title = IP;
	this.latitude = latitude;
	this.longitude = longitude;
	if(latitude == -90 && longitude == 0) 
	{
		this.url = undefined;
	}
	else
	{
		this.url = 'https://www.google.com/maps/place/' + latitude + ',' + longitude;
	}
	this.current = current;
}

function up(x, y)
{
	var date1 = new Date(x.datetime);
	var date2 = new Date(y.datetime);
	
	return (date1.getTime() < date2.getTime()) ? 1 : -1;
}

function getCoord(cip, num)
{
	var count = 0;
	
	var rec = {
		markers : new Array(),
		recent : new Array(num),
		num : 0
	}

	var b = Browser.brow;//getBrowser();
	var os = Browser.osys;//getOS();
	
	$.ajaxSettings.async = false;	
	$.ajax({
  		url: domain + "/api/visitormap/index.php",
  		data: {"ip":cip,"b":b.no,"bv":b.ver,"os":os.no,"osv":os.ver,"lg":(isEn?"en":"cn")},  
  		dataType: "json",
  		success: function(data){
			data.sort(up);
			$.each(data, function(i, item)
			{
				if(cip == item.IP)
				{
					var country = isEn ? item.country : item.countryzh;
					var city = isEn ? item.city : item.cityzh;
					rec.markers[0] = new mInfo(item.Latitude, item.Longitude, item.IP, true); 
					rec.recent[0] = new vInfo(country, city, item.Browser, item.OS, item.isocode, [item.Latitude, item.Longitude]);
				}
				else
				{
					count++;
					rec.markers[count] = new mInfo(item.Latitude, item.Longitude, item.IP, false); 
					if(count < num) 
					{
						var country = isEn ? item.country : item.countryzh;
						var city = isEn ? item.city : item.cityzh;
						rec.recent[count] = new vInfo(country, city, item.Browser, item.OS, item.isocode, [item.Latitude, item.Longitude]);		
					}
				}
			})
		}
	});	
	
	rec.num = count;
	return rec;
}

function DrawMap(mks)
{
am4core.ready(function() { 
// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

// Create map instance
var chart = am4core.create("chartdiv", am4maps.MapChart);

// Set map definition
chart.geodata = am4geodata_worldLow;

// Set projection
chart.projection = new am4maps.projections.Miller();

// Create map polygon series
var polygonSeries = chart.series.push(new am4maps.MapPolygonSeries());

// Exclude Antartica
polygonSeries.exclude = ["AQ"];

// Make map load polygon (like country names) data from GeoJSON
polygonSeries.useGeodata = true;

// Configure series
var polygonTemplate = polygonSeries.mapPolygons.template;
polygonTemplate.tooltipText = "{name}";
polygonTemplate.fill = chart.colors.getIndex(0).lighten(0.5);

// Create hover state and set alternative fill color
var hs = polygonTemplate.states.create("hover");
hs.properties.fill = chart.colors.getIndex(0);

// Add image series
var imageSeries = chart.series.push(new am4maps.MapImageSeries());
imageSeries.mapImages.template.propertyFields.longitude = "longitude";
imageSeries.mapImages.template.propertyFields.latitude = "latitude";
imageSeries.data = mks;

chart.events.on( "mappositionchanged", updateCustomMarkers );

// this function will take current images on the map and create HTML elements for them
function updateCustomMarkers( event ) {
  
  // go through all of the images
  imageSeries.mapImages.each(function(image) {
    // check if it has corresponding HTML element
    if (!image.dummyData || !image.dummyData.externalElement) {
      // create onex
      image.dummyData = {
        externalElement: createCustomMarker(image)
      };
    }

    // reposition the element accoridng to coordinates
    var xy = chart.geoPointToSVG( { longitude: image.longitude, latitude: image.latitude } );
    image.dummyData.externalElement.style.top = xy.y + 'px';
    image.dummyData.externalElement.style.left = xy.x + 'px';
  });

}

function hideTips()
{
	$('#chartdiv span').fadeOut(300);
	$('.map-marker').css('z-index', '9');
}

function toGPS(latitude, longitude)
{
	var sn = '';
	if(latitude > 0) sn = 'N';
	if(latitude < 0) sn = 'S';
	
	var ew = '';
	if(longitude > 0) ew = 'E';
	if(longitude < 0) ew = 'W';
	
	return '(' + Math.abs(latitude) + '°' + sn + ', ' + Math.abs(longitude) + '°' + ew + ')';
}

// this function creates and returns a new marker element
function createCustomMarker( image ) {
  
  var chart = image.dataItem.component.chart;

  // create holder
  var holder = document.createElement( 'div' );
  holder.className = 'map-marker';
  //holder.title = image.dataItem.dataContext.title;
  holder.style.position = 'absolute';
  
  // create dot
  if(image.dataItem.dataContext.current)
  {
	  var dot = document.createElement( 'div' );
	  dot.className = 'dot';
	  holder.appendChild( dot );
  }
  
  var pulse = document.createElement( 'div' );
  pulse.className = 'pulse';
  pulse.title = image.dataItem.dataContext.title;
  holder.appendChild( pulse );
  
  var htip = document.createElement( 'span' );
  htip.className = 'marker-tip';
  
  var lip = document.createElement( 'text' );
  lip.innerHTML = image.dataItem.dataContext.title;
  htip.innerHTML = "";
  htip.append(lip);
	  
  if ( undefined !== image.dataItem.dataContext.url ) 
  {	  
	  var aip = document.createElement( 'a' );
	  aip.href = image.dataItem.dataContext.url;
	  aip.target = '_blank';
	  aip.rel = 'nofollow noopener noreferrer';
	  aip.innerHTML = toGPS(image.dataItem.dataContext.latitude, image.dataItem.dataContext.longitude);	  
	  htip.append(aip);
  }
  else
  {
	  lip.append(isEn ? '(Unknown regions)' : '(未知区域)');
  }
  
  pulse.onclick = function() {
	  hideTips();
	  holder.style.zIndex = 99;
	  htip.style.display = 'block';
  }
  
  lip.onclick = function() { hideTips(); }
  
  holder.className += ' map-clickable';
  holder.appendChild( htip );
  
  // append the marker to the map container
  chart.svgContainer.htmlElement.appendChild( holder );

  return holder;
}

});

}

function LoadVisitors(recent, count)
{
	var vList = $(".vl");
	var num = recent.length;
	var vf = isEn ? 'Visitor from' : '访客来自';
	
	for(var i = 0 ; i < num ; i++)
	{
		var reci = recent[i];
		var vl = '<tr><td><span class="flag-icon flag-icon-' + reci.iso;
		
		if(reci.iso == 'others')
		{
			vl += '"></span>' + vf + ' <i class="fa fa-map-marker">';
			vl += reci.city + ', ' + reci.country + '</i></td>';
		}
		else
		{ 
			vl += '"></span>' + vf + ' <a href="https://www.google.com/maps/place/' + reci.mark;
			vl += '" target="_blank" rel="nofollow noopener noreferrer"><i class="fa fa-map-marker">';
			vl += reci.city + ', ' + reci.country + '</i></a></td>';
		}
		
		vl += '<td><span class="icon_os icon_' + Browser.toBroICO(reci.browser);
		vl += '"></span>' + Browser.toBroName(reci.browser) + '</td>';
		vl += '<td><span class="icon_os icon_' + Browser.toSysICO(reci.os);
		vl += '"></span>' + Browser.toSysName(reci.os) + '</td>';
		vList.append(vl);		
	}
	
	$(".tbhead").find("span").text(count);
}

function LoadMap()
{
	$.getScript("https://pv.sohu.com/cityjson?ie=utf-8", function(){
		
		var rec = getCoord(returnCitySN.cip, 3);
		DrawMap(rec.markers);
		LoadVisitors(rec.recent, rec.num); 
		
	});	
}

LoadMap();

});