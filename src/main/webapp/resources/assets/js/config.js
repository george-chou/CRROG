var domain = "http://localhost";

var isEn = !(document.location.href.indexOf("-cn.html") > -1);

requirejs.config({
	baseUrl: '../resources/assets/js',
	paths: {
		'jquery':   'jquery-1.11.2.min',
		'device':   'current-device.min',
		'browser':  'browser',
		'mustache': 'mustache.min',
		'github': 	(isEn ? 'github-activity-0.1.1.min' : 'github-activity-0.1.1-cn.min'),	
		'core':		'core',		
		'maps':     'maps',
		'worldlow': 'worldLow',
		'animated': 'animated'
	},
	shim: {
		'browser': {
			deps: ['device'],
			exports: 'Browser'
		},
		'mustache': {
			deps: [],
			exports: 'Mustache'
		},
		'github': {
			deps: ['mustache'],
			exports: 'GitHubActivity'
		},
		'core': {
			deps: ['jquery'],
			exports: 'am4core'
		},
		'maps': {
			deps: ['core'],
			exports: "_"
		},
		'worldlow': {
			deps: ['core'],
			exports: "_"
		},
		'animated': {
			deps: ['core'],
			exports: "_"
		}			
	},
	waitSeconds: 0
});

requirejs(['github'], function(GitHubActivity) {
	
	GitHubActivity.feed({ username: "george-chou", selector: "#ghfeed" });
	
});	