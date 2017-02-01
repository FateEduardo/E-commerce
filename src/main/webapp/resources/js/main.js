MyApp=angular.module('MyApp', ['ngCookies']);

MyApp.controller('loginController',function($scope,loginService,$cookieStore){

	$scope.user=null;

	$scope.login=function(){
		
		loginService.login()
		.then(
				function(d) {
					
					$scope.user = angular.copy(d);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	

	};

});

MyApp.factory('loginService',function($http,$q){
	var service={
			login:login
	};
	
	var URL='http://localhost:8080/academy'
		function login(){
	
		var deferred = $q.defer();
		$http.get(URL+'/userName')
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
