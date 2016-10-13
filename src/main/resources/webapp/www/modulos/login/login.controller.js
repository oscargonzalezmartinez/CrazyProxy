app.controller('LoginController', 
function ($scope,$rootScope,$location,LoginService) {
	   $scope.user = {id:null,password:null};
	   $rootScope.authenticated = false;
	   $scope.formKeyDown = function(event){
		   if (event.which == 13){
			   $scope.login();
		   }
	   }
	   
	   $scope.login = function() {
			LoginService.login($scope.user).then(function (response) {
							//	$scope.detail = response.data;
console.debug("login ok");
var user = response.data;
if (user.ok){
	$rootScope.authenticated = true;
	 $location.path("main"); 
}
							  }, function (response) {
console.debug("login ko");								  
								//$rootScope.error = response.status + " >> " + response.statusText;
								//$window.alert(response.status + " >> " + response.statusText);
							  });
		};//login
	}//function

);