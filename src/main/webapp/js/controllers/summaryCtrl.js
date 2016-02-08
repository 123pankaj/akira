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
					
				  $scope.resetPaginator();
				
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
			$scope.loadPage = function(id) {
				$scope.pageNumber = id-1;
				$scope.getAndSetSummaryLogs();
				
		
			};	
			
			$scope.resetPaginator=function(){
				
				 if($scope.pageNumber>3&&$scope.pageNumber<$scope.totalPage-4){
					$scope.pn[0]=$scope.pageNumber-2;
					$scope.pn[1]=$scope.pageNumber-1;
					$scope.pn[2]=$scope.pageNumber-0;
					$scope.pn[3]=$scope.pageNumber+1;
					$scope.pn[4]=$scope.pageNumber+2;
					$scope.pn[5]=$scope.pageNumber+3;
					$scope.pn[6]=$scope.pageNumber+4;
				}
				
				else if($scope.pageNumber<=3){
					$scope.pn=[1,2,3,4,5,6,7];
					
				}	
				
				else{
					$scope.pn[0]=$scope.totalPage-6;
					$scope.pn[1]=$scope.totalPage-5;
					$scope.pn[2]=$scope.totalPage-4;
					$scope.pn[3]=$scope.totalPage-3;
					$scope.pn[4]=$scope.totalPage-2;
					$scope.pn[5]=$scope.totalPage-1;
					$scope.pn[6]=$scope.totalPage;
				
				}
			};
			
			$scope.pageExists=function(id){
				if(id=='<'&&$scope.pageNumber==0)return false;
				if(id=='>'&&$scope.pageNumber>=$scope.totalPage-1)return false;
				else if(id>$scope.totalPage)return false;
				return true;
				
			}
			
			

			
			$scope.getAndSetSummaryLogs();
			
				
	}]);	
	