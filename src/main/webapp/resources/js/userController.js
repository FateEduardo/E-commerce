MyApp.controller('userController', function($scope,userService,$cookieStore) {
	$scope.userList = {};
	$scope.user = {};
	$scope.userRole = {};
	$scope.listStatus = {};

	$scope.userList=function(){
	
		userService.userList()
		.then(
				function(d) {
					$scope.userList = angular.copy(d);

				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	}
	$scope.findUser=function(){

		userService.findUser( $cookieStore.get('userName'))
		.then(
				function(d) {
					$scope.user = angular.copy(d.users);
					$scope.user.password='';
					$scope.userRole = angular.copy(d.userRole);
					$scope.listStatus = angular.copy(d.listStatus);

				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);

	}

	$scope.saveUserName=function(userName){
		$cookieStore.put('userName',userName );

	}

	$scope.editUser=function(){
		userService.editUser($scope.user);
	}

	$scope.dataUser=function(){
		userService.dataUser( )
		.then(
				function(d) {
					$scope.userRole = angular.copy(d.userRole);
					$scope.listStatus = angular.copy(d.listStatus);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	}
	
	$scope.findUserRepeat=function(){
		
		userService.findUserRepeat($scope.name)
		.then(
				function(d) {
					$scope.userList = angular.copy(d);
					console.log($scope.userList)
				},
				function(errResponse){
					console.error('Error while fetching Users');
					alert("Error 409")
				}
		);
	}

	$scope.newUser=function(){
		userService.newUser($scope.user)
	}

	$scope.deleteUser=function(username){
		userService.deleteUser(username)
	}

});

/////
MyApp.factory('userService',function($http,$q,$window){
	var service={
			userList:userList,
			editUser:editUser,
			newUser:newUser,
			findUser:findUser,
			dataUser:dataUser,
			deleteUser:deleteUser,
			findUserRepeat:findUserRepeat

	};
	var URL='http://localhost:8080/jpaproject/User'
		function userList(){
		var deferred = $q.defer();
		$http.get(URL+'/List')
		.then(
				function (response) {
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error(errResponse);
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	
	
	function findUserRepeat(name){
		console.log(name)
		var deferred = $q.defer();
		$http.post(URL+'/find',name)
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

	function editUser(user){
		var deferred = $q.defer();
		$http.post(URL+'/update',user)
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

	function findUser(username){
		var deferred = $q.defer();
		$http.post(URL+'/edit',username)
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

	function dataUser(){
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


	function deleteUser(username){
		var deferred = $q.defer();
		$http.post(URL+'/delete',username)
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

	function newUser(user){
		var deferred = $q.defer();
		$http.post(URL+'/add',user)
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
	return service;
});
