app.service("LoginService", function($http){
			
			this.login = function(user){
								return $http({
										method: 'POST',
										data:user,
										url: '/api/login'
										});
			}//getRecords
			
			this.getDetail = function(id){
								return $http({
										method: 'GET',
										url: 'http://localhost:9000/get/'+id
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