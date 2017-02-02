
MyApp.controller('adminController',function($scope,itemService,userService,$cookieStore){

	$scope.itemList={};
	$scope.userList={};
	$scope.categories={};
	$scope.userRole={};
	$scope.listStatus={};
	$scope.item={};
	$scope.user={};
	$scope.categoryItem;
	$scope.role
	$scope.lisItem=function(){
		
		itemService.lisItem()
		.then(
				function(d) {
					
					$scope.itemList = angular.copy(d.items);
					$scope.categories = angular.copy(d.categories);
					console.log(d.cat);
					
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};
	$scope.saveItem=function(id){
		  $cookieStore.put('id',id );
	}
	
	$scope.findItem=function(){
		itemService.findItem( $cookieStore.get('id'))
		.then(
				function(d) {

					$scope.item = angular.copy(d.item);
					$scope.categories=angular.copy(d.categories);
					
					
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	};

	
	$scope.filterCategory=function(category){
		itemService.filterCategory(category)
		.then(
				function(d) {
								
					$scope.itemList = angular.copy(d.items);
					$scope.categories = angular.copy(d.categories);
					
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	}
	
	$scope.editItem=function(){

		itemService.editItem($scope.item)
		itemService.editCategory($scope.item,$scope.categoryItem);
	}
	$scope.deleteItem=function(id){
		itemService.deleteItem(id);
	}
	$scope.newItem=function(){
		console.log($scope.item);
		itemService.newItem($scope.item)
	}
	$scope.dataItem=function(){
		itemService.dataItem( )
		.then(
				function(d) {
					$scope.categories = angular.copy(d);
					
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	}
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
					console.log($scope.user)
					if($scope.user.status){
						$scope.user.status="S";
					}else{
						$scope.user.status="N";
					}
					$scope.userRole = angular.copy(d.userRole);
					$scope.listStatus = angular.copy(d.listStatus);
				

				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);

	}

	$scope.saveUser=function(userName){
		$cookieStore.put('userName',userName );

	}

	$scope.editUser=function(){
		$scope.user.status=true;
		userService.editUser($scope.user);
	}
	$scope.dataUser=function(){
		userService.dataUser( )
		.then(
				function(d) {
					$scope.user=angular.copy(d.user);
					console.log($scope.user)
					$scope.userRole = angular.copy(d.userRole);
					$scope.listStatus = angular.copy(d.listStatus);
				},
				function(errResponse){
					console.error('Error while fetching Users');
				}
		);
	}
	$scope.newUser=function(){
		if($scope.user.status){
			$scope.user.status="S";
		}else{
			$scope.user.status="N";
		}
		userService.newUser($scope.user)
	}

	$scope.deleteUser=function(username){
		userService.deleteUser(username)
	}
	
	
	

});

MyApp.factory('itemService',function($http,$q,$window){
	var service={
			lisItem:lisItem,
			findItem:findItem,
			filterCategory:filterCategory,
			editItem:editItem,
			newItem:newItem,
			deleteItem:deleteItem,
			editCategory:editCategory,
			dataItem:dataItem
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
	function deleteItem(id){
		var deferred = $q.defer();
		$http.post(URL+'/deleteItem',id)
		.then(
				function (response) {
					$window.location.href = URL+'/listItemView';

				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
					console.log(errResponse)
				}
		);
		return deferred.promise;
	}

	function filterCategory(category) {
		console.log(category)
		var deferred = $q.defer();
		$http.post(URL+'/category',category)
		.then(
				function (response) {
					deferred.resolve(response.data);
					console.log(response.data)

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
	function newItem(item){
		var deferred = $q.defer();
		$http.post(URL+'/newItem',item)
		.then(
				function (response) {
					$window.location.href = URL+'/listItemView';
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	
	function dataItem(){
		var deferred = $q.defer();
		$http.get(URL+'/dataItem')
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

	function editItem(item){
		var deferred = $q.defer();
		$http.post(URL+'/updateItemView',item)
		.then(
				function (response) {
					console.log("Sussefull")
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
	function editCategory(item,categoryItem){
		
		var categoryItems={'id':{'item':item,'id':categoryItem}}
		
		console.log(categoryItems)
		var deferred = $q.defer();
		$http.post(URL+'/updateCategory',categoryItems)
		.then(
				function (response) {
					$window.location.href = URL+'/listItemView';
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
MyApp.factory('userService',function($http,$q,$window){
	var service={
			userList:userList,
			editUser:editUser,
			newUser:newUser,
			findUser:findUser,
			dataUser:dataUser,
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
		$http.post(URL+'/deleteUser',username)
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
	function dataUser(){
		var deferred = $q.defer();
		$http.get(URL+'dataUser')
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
	function newUser(user){
		var deferred = $q.defer();
		$http.post(URL+'newUser',user)
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
	return service;
});
