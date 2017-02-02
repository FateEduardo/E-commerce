MyApp.controller('userController', function($scope,itemService,$cookieStore) {
	$scope.itemList ={}
	$scope.categories ={}
	$scope.lisItem=function(){
		
		itemService.lisItem()
		.then(
				function(d) {
					
					$scope.itemList = angular.copy(d.items);
					$scope.categories = angular.copy(d.categories);
				
					
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};
	

});

/////
MyApp.factory('itemService',function($http,$q,$window){
	var service={
			lisItem:lisItem
	};
	var URL='http://localhost:8080/academy/user'
		function lisItem(){
		var deferred = $q.defer();
		$http.get(URL+'/listItem')
		.then(
				function (response) {
					deferred.resolve(response.data);

				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
					console.log(errResponse)
				}
		);
		return deferred.promise;
	}

	return service;
});
