MyApp.controller('cartController', function($scope,cartService,$cookieStore) {
  $scope.cart = {};
  $scope.cartList = {};
  $scope.cartStatus={};
  $scope.shipTos={};
  $scope.date=new Date();
  $scope.cartList=function(){
	  cartService.cartList()
	  .then(
			  function(d) {
				  $scope.cartList = angular.copy(d);
			  },
			  function(errResponse){
				  console.error('Error while fetching Users');
			  }
	  );
  }
  $scope.saveCartId=function(id){
	  $cookieStore.put('id',id );
  }
  
  $scope.findCart=function(){
	  	
		cartService.findCart( $cookieStore.get('id'))
		.then(
				function(d) {
					$scope.cart = angular.copy(d.cart);
					$scope.cart.cartDetails.cartAmount=0;
					//console.log($scope.cart)
					$scope.cartStatus = angular.copy(d.cartStatus);
					//console.log($scope.cartStatus)
					$scope.shipTos = angular.copy(d.shipTos);
					//console.log($scope.shipTos)

				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);

	}
  $scope.dataCart=function(){
	  cartService.dataCart( )
		.then(
				function(d) {
					
					
					$scope.cartStatus = angular.copy(d.cartStatus);
					
					$scope.shipTos = angular.copy(d.shipTos);
					
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	}
  $scope.newCart=function(){
	  $scope.cart.audit.createDate=new Date();
	  $scope.cart.audit.updateDate=new Date();
	  cartService.newCart($scope.cart)
	}

	$scope.deleteCart=function(id){
		cartService.deleteCart(id)
	}
});
MyApp.factory('cartService',function($http,$q,$window){
	var service={
			cartList:cartList,
			editCart:editCart,
			newCart:newCart,
			findCart:findCart,
			dataCart:dataCart,
			deleteCart:deleteCart
			
	};
	var URL='http://localhost:8080/jpaproject/Cart'
	function cartList(){
		var deferred = $q.defer();
        $http.get(URL+'/List')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	function newCart(cart){
		var deferred = $q.defer();
		$http.post(URL+'/add',cart)
		.then(
				function (response) {
					console.log(response);
					$window.location.href = URL+'/ListView';
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	
	function editCart(cart){
		var deferred = $q.defer();
		console.log(cart)
		$http.post(URL+'/update',cart)
		.then(
				function (response) {
					console.log(response);
					$window.location.href = URL+'/ListView';
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	
	
	
	function dataCart(){
		var deferred = $q.defer();
		$http.get(URL+'/data')
		.then(
				function (response) {
					deferred.resolve(response.data);

				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	
	function deleteCart(id){
		var deferred = $q.defer();
		$http.post(URL+'/delete',id)
		.then(
				function (response) {
					console.log(response);
					$window.location.href = URL+'/ListView';
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	
	
	

	
	function findCart(id){
		var deferred = $q.defer();
		$http.post(URL+'/edit',id)
		.then(
				function (response) {
					deferred.resolve(response.data);

				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	return service;
});
