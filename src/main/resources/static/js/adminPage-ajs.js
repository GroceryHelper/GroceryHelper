// adminPage support, Using AngularJS
var cs480App2 = angular.module('cs480App2', []);

cs480App2.controller('AdminPageCtrl', function ($scope, $http) {
	
	 $scope.loadUsers = function() {
		  $http.get("cs480/items/list")
		  	.success(function(data){
		  		$scope.users = data;
		  	});
	  }


  $scope.addItem = function() {
	  $http.post("cs480/item/" + $scope.new_id + "?storeCode=" + $scope.new_storeCode + "&name=" + $scope.new_name + "&price=" + $scope.new_price)
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
  // dont know what it exactly does
  $scope.loadUsers();
  
});