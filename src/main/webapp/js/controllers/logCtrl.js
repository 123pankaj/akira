akira.controller("logCtrl", [ "$scope", "$log", "urlService", 
		function($scope, urlService) {

			$scope.isComponent = false;
			$scope.isLogout = false;
			$scope.isVerify = true;
			$scope.curentPage = 0;

			$scope.loadNextLogs = function() {
				$scope.curentPage = $scope.curentPage + 1;
				urlService.getAUILog(curentPage).then(function(resultJson) {
					$scope.LogArray = resultJson;
				})
			};
			$scope.loadPreLogs = function() {
				$scope.curentPage = $scope.curentPage - 1;
				urlService.getAUILog(curentPage).then(function(resultJson) {
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

		} ]);