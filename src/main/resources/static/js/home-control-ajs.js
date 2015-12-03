//This is the version used for the HTML home-ajs.html with AngularJS
//This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('ItemCtrl', function ($scope, $http) {

//	changed into something related to items

	$scope.loadItems = function() {
		$http.get("cs480/items/list")
		.success(function(data){
			$scope.items = data;
		});
	}

	$scope.getItem = function() {
		$http.get("cs480/item/" + $scope.userIdToSearch)
		.success(function(data){
			$scope.founduser = data;
		});
	}

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

	$scope.deleteItem = function(itemId) {
		$http.delete("cs480/item/" + itemId)
		.success(function(data){
			$scope.loadItems();
		});
	}
	
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
	
	$scope.getNumofItemsInList = function() {
		var obj = $scope.list; 
		$scope.len = obj.length;
	};
	
	$scope.createGroceryList = function() {
	  for (i=0; i < $scope.list.length; i++) {
		  
	  }
	};	
	
	$scope.findItems = function() {

		var itemsFound = [];
		for (j=0; j<$scope.list.length; j++) {
			for (k=0; k<$scope.storeList.length; k++) {
				for (i=0; i< $scope.items.length ; i++) {
					
					if ($scope.items[i].storeCode.toUpperCase() == $scope.storeList[k].toUpperCase()) {
					   if ($scope.items[i].name.toUpperCase() == $scope.list[j].toUpperCase()) {
					       var itemFound = $scope.items[i];
					       itemsFound.push(itemFound);
					       console.log('item found is ' + $scope.items[i].name);
					   }
					}
				}
			}
		   
		}
		console.log('itemstoreturn ' + itemsFound);
		$scope.itemsToReturn = itemsFound;
	};
	
	$scope.list1 = {title: 'AngularJS - Drag Me'};
	$scope.list2 = {};
});