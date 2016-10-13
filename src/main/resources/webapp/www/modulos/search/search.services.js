app.service("SearchService", function($http){
			
			this.search = function(searchTerm){
								return $http({
										method: 'POST',
										data:searchTerm,
										url: '/api/search'
										});
			}//getRecords
			
			this.getDetail = function(id){
								return $http({
										method: 'GET',
										url: 'http://localhost:9000/api/get/'+id
										});
			}//getDetail
			
			this.buy = function(id){
								return $http({
										method: 'GET',
										url: 'http://localhost:9000/buy/'+id
										});
			}//getDetail
			
		}//myHttpServices


);	