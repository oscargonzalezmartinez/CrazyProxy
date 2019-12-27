app.service("MainService", function($http) {

	this.getInfo = function() {
		return $http({
			method : 'GET',
			url : '/info/'
		});
	}//getInfo

	this.setErrorThreshold = function(errorTH) {
		return $http({
			method : 'POST',
			url : '/settings/errorTH/' + errorTH
		});
	}//setErrorThreshold

	this.setDelay = function(delay) {
		return $http({
			method : 'POST',
			url : '/settings/delay/' + delay
		});
	}//setDelay

}//MainService

);