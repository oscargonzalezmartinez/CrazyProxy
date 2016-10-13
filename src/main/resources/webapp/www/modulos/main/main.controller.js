app.controller('MainController', 
	function ($scope,$http,$rootScope,$timeout,MainService) {
		
	var ws = new WebSocket("ws://localhost:8080/events/stats");

	ws.onmessage = function (event) {
	  console.log(event.data);
	  $scope.info = angular.fromJson(event.data);
	  $scope.$apply();
	 // $scope.info.delay = 155;
	//  $scope.refreshInfoFromServer(angular.fromJson(event.data));
	//  $scope.refreshInfo();
	}

	             ws.onopen = function()
	               {
	                  // Web Socket is connected, send data using send()
	                  ws.send("Message to send");
	                  console.log("Message is sent...");
	               };
					
					
	               ws.onclose = function()
	               { 
	                  // websocket is closed.
	                  console.log("Connection is closed..."); 
	               };

//			    var poll = function() {
//			        $timeout(function() {
//			        	$scope.refreshInfo();
//			        			poll();
//			        			}, 10000);
//			    };     
//			   poll();
	
	               $scope.refreshInfoFromServer = function(data) {
	            	   $scope.info = data;
	               }
	$scope.refreshInfo = function() {
		MainService.getInfo().then(
				function (response) {
						$scope.info = response.data;
						$scope.info.delay = 33;
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