// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('UserCtrl', function ($scope, $http) {

//	changed into something related to items
	
	var id = polling_func();
	  function polling_func()
	  {
		  var d = new Date();
		  var n = d.getTime();
	      return n;
	  }
	
	  var counter = 0;
	// works
  $scope.loadUsers = function() {
	  $http.get("cs480/items/list")
	  	.success(function(data){
	  		$scope.users = data;
	  	});
  }
  // works
  $scope.getItem = function() {
	  $http.get("cs480/item/" + $scope.userIdToSearch)
	  	.success(function(data){
	  		$scope.founduser = data;
	  	});
  }
  
  // works
  $scope.addItem = function() {
//	  $http.post("cs480/item/" + $scope.new_id + "?storeCode=" + $scope.new_storeCode + "&name=" + $scope.new_name + "&price=" + $scope.new_price)
	  $http.post("cs480/item/"  + $scope.new_id + "?storeCode=" + $scope.new_storeCode + "&name=" + $scope.new_name + "&price=" + $scope.new_price)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }
  
  // works
  $scope.deleteItem = function(itemId) {
	  $http.delete("cs480/item/" + itemId)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }
  // dont know what it exactly does
  $scope.loadUsers();
  
  
  // below is related to zip code
  $scope.saveZip = function() {
	  $http.post("cs480/zip/" + $scope.zipEntered)
	  	.success(function(data){
	  		$scope.zip = data;
	  	});
  }
  
  
  
//  polling_func();
 
  
});