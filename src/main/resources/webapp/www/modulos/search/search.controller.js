app.controller('SearchController', 
	function ($scope,$http,$rootScope,SearchService) {
	   $scope.search = function(){
		   SearchService.search(searchTerm).then(function (response) {
					$scope.listData = response.data;
					  }, function (response) {
						console.debug("search ko");								  
								//$rootScope.error = response.status + " >> " + response.statusText;
								//$window.alert(response.status + " >> " + response.statusText);
							  });
		  
	   }//search
  
  	   $scope.getDetail = function(id){
		   SearchService.getDetail(id).then(function (response) {
					$scope.detailData = response.data;
					  }, function (response) {
						console.debug("detailData ko");								  
								//$rootScope.error = response.status + " >> " + response.statusText;
								//$window.alert(response.status + " >> " + response.statusText);
							  });
		  
	   }//getDetail
  
	}

);