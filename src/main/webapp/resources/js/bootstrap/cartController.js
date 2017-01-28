MyApp.controller('cartController', function($scope,cartService) {
  $scope.cart = {};
  $scope.cartList=function(){
	  cartService.cartList()
      .then(
      function(d) {
    	  $scope.cart = angular.copy(d);
      },
      function(errResponse){
          console.error('Error while fetching Users');
      }
  );
  }
  
  $scope.editCart=function(){
	  
  }
  
  $scope.newCart=function(){
	  
  }
});
MyApp.factory('cartService',function($http,$q){
	var service={
			cartList:cartList,
			editCart:editCart,
			newCart:newCart
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
	function editCart(list){
		
	}

	function newCart(list){
		
	}
	return service;
});
