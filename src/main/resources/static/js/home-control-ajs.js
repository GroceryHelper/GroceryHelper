// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('UserCtrl', function ($scope, $http) {

//	changed into something related to items
	
  $scope.loadUsers = function() {
	  $http.get("cs480/items/list")
	  	.success(function(data){
	  		$scope.users = data;
	  	});
  }

  $scope.getItem = function() {
	  $http.get("cs480/item/" + $scope.userIdToSearch)
	  	.success(function(data){
	  		$scope.founduser = data;
	  	});
  }

  $scope.addItem = function() {
	  $http.post("cs480/item/" + $scope.new_id + "?name=" + $scope.new_name + "&price=" + $scope.new_price)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }

  $scope.deleteItem = function(userId) {
	  $http.delete("cs480/item/" + userId)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }
  
  $scope.loadUsers();
  
});