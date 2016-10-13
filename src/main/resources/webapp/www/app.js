//var app = angular.module('App',['ngRoute','pascalprecht.translate']);
var app = angular.module('App',['ngRoute','ui.bootstrap']);

app.config(
	function($routeProvider){
		$routeProvider
			.when('/login',	{
					templateUrl : 'modulos/login/login.view.html',
					controller : 'LoginController'
								}
				)
				.when('/main',	{
					templateUrl : 'modulos/main/main.view.html',
					controller : 'MainController'
								}
				)	
				.when('/',	{
//					templateUrl : 'modulos/login/login.view.html',
//					controller : 'LoginController'
					templateUrl : 'modulos/main/main.view.html',
					controller : 'MainController'					
						}
				).when('/search',	{
					templateUrl : 'modulos/search/search.view.html',
					controller : 'SearchController'
					
						}
				).otherwise({ redirectTo: '/main' });

});




				/*
			
	*/
app.filter('esPar',function(){
	return function(input){
		return (input % 2 == 0)?input:null;
	}
	
});

app.filter('ocultarPass',function(){
	return function(input){
		return input.substr(0,3)+input.substr(3).replace(/./g,"*");
	}
	
});







