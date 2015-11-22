//This is the version used for the HTML home-ajs.html with AngularJS
//This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('ItemCtrl', function ($scope, $http) {

//	changed into something related to items


	// works
	$scope.loadItems = function() {
		$http.get("cs480/items/list")
		.success(function(data){
			$scope.items = data;
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
		$scope.new_id = guid();
		$http.post("cs480/item/"  + $scope.new_id + "?storeCode=" + $scope.new_storeCode + "&name=" + $scope.new_name + "&price=" + $scope.new_price)
		.success(function(data){
			$scope.loadItems();
		});
	}

	var count = 0;
	function getId() {
		return ++count;
	}
	
	function guid() {
		function s4() {
			return Math.floor((1 + Math.random()) * 0x10000)
			.toString(16)
			.substring(1);
		}
		return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
		s4() + '-' + s4() + s4() + s4();
	}

	// works
	$scope.deleteItem = function(itemId) {
		$http.delete("cs480/item/" + itemId)
		.success(function(data){
			$scope.loadItems();
		});
	}
	// dont know what it exactly does
	$scope.loadItems();


	// below is related to zip code
	$scope.saveZip = function() {
		$http.post("cs480/zip/" + $scope.zipEntered)
		.success(function(data){
			$scope.zip = data;
		});
	}
	
	var groceryList;
	$scope.completeList = function(list) {
		var array = list.split(",");
		groceryList = array;
		var arrayOfLines = $('list').val().split('\n');
		return arrayOfLines;
	}
	
	$scope.itemFunction = function(item)
	{
	    // Do some tests
		var bool = 0;
		
		for (i = 0; i < $scope.items.length; i++) { 
		    if (groceryList[i]==item){
		    	bool = 1;
		    }
		}
	    return bool; 
	};
	
	var idx = -43;
	$scope.getItemIdx = function(){
		console.log("index is ", idx);
		return idx++;
	}
	
	
});