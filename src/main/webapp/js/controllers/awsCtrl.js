akira.controller("awsCtrl",[ "$scope", "$log", "urlService",
	                             function($scope,$log,urlService){
			  
			 urlService.getAutoScaleGroupNames().then(function(resultJson) {
			  $scope.ScaleGroup = resultJson.groups;
			});	 
			 
			 $scope.getGropuDetail=function(groupName){
					$scope.pageNumber=0;
					$scope.getAndSetAUILogs();
					
				};
	}]);