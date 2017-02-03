MyApp.controller('userController', function($scope,itemService,$cookieStore) {
	$scope.itemList ={}
	$scope.categories ={}
	$scope.cost=0;
	$scope.cart={};
	$scope.itemOrder={};
	$scope.items=null;

	$scope.item={}
	
	$scope.listItem=function(){
		console.log("as")
		itemService.listItem()
		.then(
				function(d) {
					$scope.itemList = angular.copy(d);
					console.log($scope.itemList)
				//	$scope.categories = angular.copy(d.categories);


				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};
	$scope.listOrder=function(){
		itemService.listOrder()
		.then(
				function(d) {
					$scope.itemOrder = angular.copy(d.orders);
					$scope.cart=angular.copy(d.cart);
				//	$scope.categories = angular.copy(d.categories);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};
	$scope.addItemOrder=function(item,quantity){
		
		$scope.itemOrder={'id':null,'cart':null,'quantity':quantity,'item':item,}
		console.log($scope.itemOrder)
		itemService.addItemOrder($scope.itemOrder)
		.then(
				function(d) {
					$scope.items=d;
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
					console.log($scope.itemList)
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
					console.log($scope.itemList)
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
			listItem:listItem,
			shoesFilter:shoesFilter,
			sweaterFilter:sweaterFilter,
			orderList:orderList,
			addItemOrder:addItemOrder
	};
	var URL='http://localhost:8080/academy/user'
		function listItem(){
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

	function orderList(){
		var deferred = $q.defer();
		$http.get(URL+'/listCart')
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
	
	function addItemOrder(itemOrder){
		var deferred = $q.defer();
		$http.post(URL+'/addOrder',itemOrder)
		.then(
				function (response) {
					if(angular.isNumber(response.data)){
						deferred.resolve(response.data);
					}else{
						$window.location.href = 'http://localhost:8080/academy/login';
					}
					

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
			
				if(item!=null && item[0]!=null  ){
					   if(item[0].price>price){
					    	 return item;
					     }
				}else{
					
					return item;
				}
			  
		}
});

