MyApp.controller('userController', function($scope,itemService,$cookieStore) {
	$scope.itemList ={}
	$scope.categories ={}
	$scope.lisItem=function(){
	$scope.cost={};
		itemService.lisItem()
		.then(
				function(d) {

					$scope.itemList = angular.copy(d);
				//	$scope.categories = angular.copy(d.categories);


				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};

	$scope.shoesFilter=function(){

		itemService.shoesFilter()
		.then(
				function(d) {
					$scope.itemList = angular.copy(d);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};
	$scope.sweaterFilter=function(){

		itemService.sweaterFilter()
		.then(
				function(d) {
					$scope.itemList = angular.copy(d);
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
			lisItem:lisItem,
			shoesFilter:shoesFilter,
			sweaterFilter:sweaterFilter
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
	function shoesFilter(){
		var deferred = $q.defer();
		$http.get(URL+'/shoes')
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

	function sweaterFilter(){
		var deferred = $q.defer();
		$http.get(URL+'/sweater')
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

MyApp.filter("price",function(){
		return function(item,price){
			
				if(item!=null && item[0]!=null ){
					   if(item[0].price>price){
					    	 return item;
					     }
				}else{
					
					return item;
				}
			  
		}
});