app.controller('MainController', 
	function ($scope,$http,$rootScope,$timeout,MainService) {
	
    var socket = new SockJS('/wsstats');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        //setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/stats', function (event) {
        	console.debug("WS receive update");
       	 console.log(event.body);
        	 
       	  	$scope.info = angular.fromJson(event.body);
       	  	$scope.$apply();
    	  
        });
    });


	
	               $scope.refreshInfoFromServer = function(data) {
	            	   $scope.info = data;
	               }
	               
	$scope.refreshInfo = function() {
		MainService.getInfo().then(
				function (response) {
						$scope.info = response.data;
						//$scope.info.delay = 33;
						if ($scope.info.request!=0){
							var result = parseFloat($scope.info.executionTime / $scope.info.request).toFixed(2);
							if (!isNaN(result)){
								$scope.mediaEjecucion =  result;
							}
						}
						
					}, function (response) {
						console.debug("search ko");								  
						// $rootScope.error = response.status + " >> " +
						// response.statusText;
						// $window.alert(response.status + " >> " +
						// response.statusText);
					}
				);		
	}
	
	//$scope.refreshInfo();
	
		$scope.setErrorThreshold = function() {
			   MainService.setErrorThreshold($scope.info.errorThreshold).then(function (response) {
							// $scope.detail = response.data;
						
							  }, function (response) {
								  	console.debug("login ko");								  
								// $rootScope.error = response.status + " >> " +
								// response.statusText;
								// $window.alert(response.status + " >> " +
								// response.statusText);
							  }
							  );
		};// setErrorThreshold
		
		   $scope.setDelay = function() {
			   MainService.setDelay($scope.info.delay).then(function (response) {
							// $scope.detail = response.data;
						
							  }, function (response) {
								  	console.debug("login ko");								  
								// $rootScope.error = response.status + " >> " +
								// response.statusText;
								// $window.alert(response.status + " >> " +
								// response.statusText);
							  }
							  );
		};// setErrorThreshold
		
	}// function


);