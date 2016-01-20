
var akira = angular.module('akira', []);
	var remoteIp =location.host;
	
	
	akira.controller("logCtrl",function($scope,$log,urlService){
		$scope.isComponent = false;
			$scope.isLogout = false;
			$scope.isVerify = true;
			$scope.pageNumber=0;
			$scope.pageSize=100;
			$scope.sortByOrder="ASC";
			$scope.sortByAttribute="id";
			
			
			$scope.getAndSet=function(){
				urlService.getAUILog($scope.pageNumber,$scope.pageSize,$scope.sortByOrder,$scope.sortByAttribute).then(function(resultJson) {
					$scope.LogArray = resultJson;
				})
			}
			
			$scope.sortBy=function(attribute){
				if($scope.sortByAttribute==attribute){
					$scope.sortByOrder= ($scope.sortByOrder=="ASC")?"DESC":"ASC"; 
				}
				else{
					$scope.sortByAttribute=attribute;
					$scope.sortByOrder="ASC";			
				}
				$scope.pageNumber=0;
				$scope.getAndSet();
			};
			
			$scope.loadNextLogs = function() {
				$scope.pageNumber = $scope.pageNumber + 1;
				$scope.getAndSet();
				
			};
			$scope.loadPreLogs = function() {
				$scope.pageNumber = $scope.pageNumber - 1;
				$scope.getAndSet();
			};
			
			
			$scope.showDiv = function(id) {
							
				//alert(s==$scope);	
			 	$scope.isComponent = false;
				$scope.isLogout = false;
				$scope.isVerify = false;
				
				if (id == "verify") {
					$scope.isVerify = true;
				}
				else if (id == "component") {
					$scope.isComponent = true;
					 $scope.getAndSet();
			         console.log($scope.LogArray);
				}
				else if(id == "logout") {
				 $scope.isLogout = true;
				      
				}
			};			
	}); 


/*
 
akira.controller("logCtrl", [ "$scope", "$log", "urlService", 
		function($scope, urlService) {

			$scope.isComponent = false;
			$scope.isLogout = false;
			$scope.isVerify = true;
			$scope.pageNumber = 0;

			$scope.loadNextLogs = function() {
				$scope.pageNumber = $scope.pageNumber + 1;
				urlService.getAUILog(pageNumber).then(function(resultJson) {
					$scope.LogArray = resultJson;
				})
			};
			$scope.loadPreLogs = function() {
				$scope.pageNumber = $scope.pageNumber - 1;
				urlService.getAUILog(pageNumber).then(function(resultJson) {
					$scope.LogArray = resultJson;
				})
			};
			
			$scope.showDiv = function(id) {
				$scope.isComponent = false;
				$scope.isLogout = false;
				$scope.isVerify = false;
				if (id == "verify") {
					$scope.isVerify = true;
				}
				if (id == "component") {
					$scope.isComponent = true;
				}
				if (id == "logout") {
					$scope.isLogout = true;
				}

			};

		} ]);*/