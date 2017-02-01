
MyApp.controller('adminController',function($scope,itemServie,userService,$cookieStore){

	$scope.itemList={};
	$scope.userList={};
	$scope.item={};
	$scope.user={};

	$scope.lisItem=function(){
		
		itemServie.lisItem()
		.then(
				function(d) {
					
					$scope.itemList = angular.copy(d);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};
	$scope.save=function(id){
		  $cookieStore.put('id',id );
	}
	
	$scope.findItem=function(){

		itemServie.findItem( $cookieStore.get('id'))
		.then(
				function(d) {

					$scope.item = angular.copy(d);
					console.log($scope.item);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};

	
	
	////////////////////////////
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
					if($scope.user.status){
						$scope.user.status="S";
					}else{
						$scope.user.status="N";
					}
					$scope.userRole = angular.copy(d.userRole);
					$scope.listStatus = angular.copy(d.listStatus);
					console.log($scope.listStatus);

				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);

	}

	$scope.save=function(userName){
		$cookieStore.put('userName',userName );

	}

	$scope.editUser=function(){
		$scope.user.status=true;
		userService.editUser($scope.user);
	}

	
	
	

});

MyApp.factory('itemServie',function($http,$q){
	var service={
			lisItem:lisItem,
			findItem:findItem
	};
	
	var URL='http://localhost:8080/academy/admin'
		
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

	function findItem(id){
		var deferred = $q.defer();
		$http.post(URL+'/editItem',id)
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
MyApp.factory('userService',function($http,$q,$window){
	var service={
			userList:userList,
			editUser:editUser,
			newUser:newUser,
			findUser:findUser,
			deleteUser:deleteUser

	};
	var URL='http://localhost:8080/academy/admin/'
		function userList(){
		var deferred = $q.defer();
		$http.get(URL+'/listUser')
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
	

	function editUser(user){
		var deferred = $q.defer();
		$http.post(URL+'/updateUserView',user)
		.then(
				function (response) {
					$window.location.href = URL+'/listUserView';
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
		$http.post(URL+'/editUser',username)
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
