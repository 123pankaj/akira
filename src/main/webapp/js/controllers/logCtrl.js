
var akira = angular.module('akira', []);
	var remoteIp =location.host;
	akira.config(['$routeProvider', function($routeProvider) {
	    $routeProvider
	    .when('/', {
	        templateUrl: 'ngviews/Verify.jsp'
	      
	      }).when('/logs', {
	        templateUrl: 'ngviews/AllLogs.jsp',
	        controller:'logCtrl'
	      
	      }).when('/logout', {
		        templateUrl: 'ngviews/logout.jsp',
      
		      }).otherwise({
		          redirectTo: '/'
		      });
	  }]);
	akira.controller("logCtrl",[ "$scope", "$log", "urlService",
	                             function($scope,$log,urlService){

			$scope.isVerify = true;
			$scope.pageNumber=0;
			$scope.sortByOrder="ASC";
			$scope.sortByAttribute="id";
			$scope.selectedtable="logs";
			$scope.pageSizes=[10,25,50,100];
			$scope.week=[];

			for (var i = 1; i <= 30; i++) {
				var date=new Date();
				  var month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
				date.setDate(date.getDate() - i)
			   $scope.week.push(date.getFullYear()+"-"+("0" + (date.getMonth())+1).slice(-2)+"-"+("0" + date.getDate()).slice(-2));
			}
			
			$scope.date=$scope.week[0];
			$scope.pageSize=$scope.pageSizes[3];
			$scope.getAndSetAUILogs=function(){
				  
				  urlService.getAUILog($scope.date,$scope.pageNumber,$scope.pageSize,$scope.sortByOrder,$scope.sortByAttribute).then(function(resultJson) {
				  $scope.LogArray = resultJson.list;
				  $scope.totalPage = resultJson.pages;
					
					
				});
			
				  
				  /*
					$log.log("00");
					urlService.getAUILog($scope.date, $scope.pageNumber,$scope.pageSize, $scope.sortByOrder,$scope.sortByAttribute).then(function(resultJson) {
						$log.log("success");
						$log.log(angular.toJson(resultJson));
						$scope.LogArray = resultJson.list;
						$scope.totalPage = resultJson.pages;
					}).error(function(error, status){
						$log.log(angular.toJson(error));
					});*/
				  
				  
				  
				  
				  
			};
			
			

			
			
			$scope.byDate=function(){
				$scope.pageNumber=0;
				$scope.getAndSetAUILogs();
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
				if($scope.pageNumber+id>=0&&$scope.pageNumber+id<$scope.totalPage){
					return true;
				}
				return false;
			};	
			
			
			$scope.onPageClick=function(e,originalEvent,type,page){
				$scope.pageNumber=page;
				$scope.gotoPage(-1);
	        	

            };
			  $scope.options = {
			            currentPage: 1,
			            totalPages: 10,
			            onPageClicked:$scope.onPageClick 
			          
			       
			            
			        }

			  $('#example').bootstrapPaginator($scope.options);
			
			
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