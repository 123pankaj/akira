
var akira = angular.module('akira', []);
	var remoteIp =location.host;
	akira.config(['$routeProvider', function($routeProvider) {
	    $routeProvider
	    .when('/', {
	        templateUrl: 'ngviews/Verify.jsp'
	      
	      }).when('/logs', {
	        templateUrl: 'ngviews/AllLogs.jsp',
	        controller:'logCtrl'
	      
	      }).when('/summary', {
		        templateUrl: 'ngviews/Summary.jsp',
		        
	      }).when('/logout', {
		        templateUrl: 'ngviews/logout.jsp',
      
		      }).otherwise({
		          redirectTo: '/'
		      });
	  }]);
	akira.controller("logCtrl",[ "$scope", "$log", "urlService","$location",
	                             function($scope,$log,urlService,$location){

			$scope.isVerify = true;
			$scope.pageNumber=0;
			$scope.sortByOrder="ASC";
			$scope.sortByAttribute="id";
			$scope.selectedtable="logs";
			$scope.pageSizes=[1,25,50,100];
			$scope.week=[];
			$scope.paginationList=[];
			for (var i = 1; i <= 30; i++) {
				var date=new Date();
				  var month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
				date.setDate(date.getDate() - i)
			   $scope.week.push(date.getFullYear()+"-"+("0" + (date.getMonth())+1).slice(-2)+"-"+("0" + date.getDate()).slice(-2));
			}
			
			for (var i = 1; i <= 7; i++) {
				$scope.paginationList.push(i);
			}
			
			$scope.date=$scope.week[0];
			$scope.pageSize=$scope.pageSizes[3];
			$scope.getAndSetAUILogs=function(){
				  
				  urlService.getAUILog($scope.date,$scope.pageNumber,$scope.pageSize,$scope.sortByOrder,$scope.sortByAttribute).then(function(resultJson) {
				  $scope.LogArray = resultJson.list;
				  $scope.totalPage = resultJson.pages;
					
					
				});	  
				  
			};
		
			$scope.byDate=function(){
				$scope.pageNumber=0;
				$scope.getAndSetAUILogs();
			};
			$scope.byTable=function(){
			
			if($scope.selectedtable=="endpoint")
					$location.path('/summary');
				//console.log($location.path);
				//$scope.getAndSetAUILogs();
			};
			
			$scope.changeSize=function(){
				$scope.pageNumber=0;
				$scope.getAndSetAUILogs();
				
			};
			
			$scope.table=function(){
				alert($scope.selectedtable);
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
				$scope.getAndSetAUILogs();
			};
			
			$scope.loadNextLogs = function() {
				$scope.pageNumber = $scope.pageNumber + 1;
				$scope.getAndSetAUILogs();
				
			};
			$scope.loadPreLogs = function() {
				$scope.pageNumber = $scope.pageNumber - 1;
				$scope.getAndSetAUILogs();
			};
			$scope.gotoPage = function(id) {
				$scope.pageNumber = $scope.pageNumber + id;
				$scope.getAndSetAUILogs();
			};	
			
			$scope.visiblePageNumber= function(id) {
				if($scope.pageNumber>=3&&$scope.pageNumber<=$scope.totalPage-3)
					{
					if(id<=4&&id>=-2)
						return true;
					return false;
					}
				/*else if($scope.pageNumber+id>=0&&$scope.pageNumber+id<$scope.totalPage){
					return true;
				}
				return false;*/
				
				if($scope.pageNumber<3){
					if(id>=0&&id<=$scope.totalPage)return true;
					return false;
				}
				
				
			};	
			
			

			
			$scope.getAndSetAUILogs();
			
				
	}]);
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