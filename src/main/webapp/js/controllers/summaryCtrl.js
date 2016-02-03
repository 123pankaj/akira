akira.controller("summaryCtrl",[ "$scope", "$log", "urlService","$location",
	                             function($scope,$log,urlService,$location){

			$scope.isVerify = true;
			$scope.pageNumber=0;
			$scope.sortByOrder="ASC";
			$scope.sortByAttribute="AverageTimeInMicro";
			$scope.selectedtable="endpoint";
			$scope.pageSizes=[1,25,50,100];
			$scope.week=[];
			$scope.paginationList=[];
			for (var i = 0; i <= 30; i++) {
				var date=new Date();
				date.setDate(date.getDate() - i)
			   $scope.week.push(date.getFullYear()+"-"+("0" + (date.getMonth()+1))+"-"+("0" + date.getDate()).slice(-2));
			
			}
			
			for (var i = 1; i <= 7; i++) {
				$scope.paginationList.push(i);
			}
			
			$scope.date=$scope.week[0];
			$scope.pageSize=$scope.pageSizes[3];
			$scope.getAndSetSummaryLogs=function(){
				  urlService.getSummaryLog($scope.date,$scope.pageNumber,$scope.pageSize,$scope.sortByOrder,$scope.sortByAttribute).then(function(resultJson) {
				  $scope.LogArray = resultJson.list;
				  $scope.totalPage = resultJson.pages;
					
					
					  console.log($scope.totalPage);
				});	  
				  
			};
		
			$scope.byDate=function(){
				$scope.pageNumber=0;
				$scope.getAndSetSummaryLogs();
			};
			$scope.byTable=function(){
			
			if($scope.selectedtable=="logs")
					$location.path('/logs');
				//console.log($location.path);
				//$scope.getAndSetAUILogs();
			};
			
			$scope.changeSize=function(){
				$scope.pageNumber=0;
				$scope.getAndSetSummaryLogs();
				
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
				$scope.getAndSetSummaryLogs();
			};
			
			$scope.loadNextLogs = function() {
				$scope.pageNumber = $scope.pageNumber + 1;
				$scope.getAndSetSummaryLogs();
				
			};
			$scope.loadPreLogs = function() {
				$scope.pageNumber = $scope.pageNumber - 1;
				$scope.getAndSetSummaryLogs();
			};
			$scope.gotoPage = function(id) {
				$scope.pageNumber = $scope.pageNumber + id;
				$scope.getAndSetSummaryLogs();
			};	
			/*
			$scope.visiblePageNumber= function(id) {
				if($scope.pageNumber>=3&&$scope.pageNumber<=$scope.totalPage-3)
					{
					if(id<=4&&id>=-2)
						return true;
					return false;
					}
				else if($scope.pageNumber+id>=0&&$scope.pageNumber+id<$scope.totalPage){
					return true;
				}
				return false;
				
				if($scope.pageNumber<3){
					if(id>=0&&id<=$scope.totalPage)return true;
					return false;
				}
				
				
			};	*/
			
			

			
			$scope.getAndSetSummaryLogs();
			
				
	}]);	
	