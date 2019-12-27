app.service("MainService", function($http){
			
			this.getInfo = function(){
								return $http({
										method: 'GET',
										url: '/info/'
										});
			}//getRecords
			
			this.getDetail = function(id){
								return $http({
										method: 'GET',
										url: 'http://localhost:9000/get/'+id
										});
			}//getDetail
			
			this.setErrorThreshold = function(errorTH){
								return $http({
										method: 'POST',
										url: '/settings/errorTH/'+errorTH
										});
			}//setErrorThreshold
			
			this.setDelay = function(delay){
				return $http({
						method: 'POST',
						url: '/settings/delay/'+delay
						});
}//setErrorThreshold
			
		}//myHttpServices


);	