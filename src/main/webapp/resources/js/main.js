MyApp=angular.module('MyApp', ['ngCookies']);
//
//MyApp.controller('loginController', function($scope,loginService,$cookieStore) {
//	$scope.username ;
//	$scope.password;
//	
//	$scope.login=function(){
//		loginService.login($scope.username)
//		.then(
//				function(d) {
//					$scope.userList = angular.copy(d);
//
//				},
//				function(errResponse){
//					console.error('Error while fetching Users');
//				}
//		);
//		
//	}
//
//
//
//});
//
///////
//MyApp.factory('loginService',function($http,$q,$window){
//	var service={
//			login:login
//	};
//	var URL='http://localhost:8080/academy/j_spring_security_check'
//
//	
//	function login(username){
//		console.log(username)
//		var deferred = $q.defer();
//		$http.post(URL,username)
//		.then(
//				function (response) {
//					deferred.resolve(response.data);
//
//				},
//				function(errResponse){
//					console.error('Error while fetching Users');
//					deferred.reject(errResponse);
//				}
//		);
//		return deferred.promise;
//	}
//
//	
//	
//	return service;
//});
