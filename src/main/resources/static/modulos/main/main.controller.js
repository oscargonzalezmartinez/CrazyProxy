app.controller('MainController', function($scope, $http, $rootScope, $timeout,
		MainService) {

	var socket = new SockJS('/wsstats');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {

		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/stats', function(event) {
			console.debug("WS receive update");
			console.log(event.body);

			$scope.info = angular.fromJson(event.body);
			if ($scope.info.request != 0) {
				var result = parseFloat(
						$scope.info.executionTime / $scope.info.request)
						.toFixed(2);
				if (!isNaN(result)) {
					$scope.mediaEjecucion = result;
				}
			}

			$scope.$apply();

		});//stompClient
	});

	$scope.setErrorThreshold = function() {
		MainService.setErrorThreshold($scope.info.errorThreshold).then(
				function(response) {

				}, function(response) {
					console.debug("setErrorThreshold ko");
				});
	};// setErrorThreshold

	$scope.setDelay = function() {
		MainService.setDelay($scope.info.delay).then(function(response) {
		}, function(response) {
			console.debug("setDelay ko");
		});
	};// setDelay

}// MainController

);