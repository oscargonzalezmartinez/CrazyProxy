//var app = angular.module('App',['ngRoute','pascalprecht.translate']);
var app = angular.module('App',['ngRoute','ui.bootstrap']);

app.config(
	function($routeProvider){
		$routeProvider
				.when('/main',	{
					templateUrl : 'modulos/main/main.view.html',
					controller : 'MainController'
								}
				)	
				.when('/',	{
					templateUrl : 'modulos/main/main.view.html',
					controller : 'MainController'					
						}
				).otherwise({ redirectTo: '/main' });

});










