
	akira.controller("logCtrl",[ "$scope", "$log", "urlService","$location",
	                             function($scope,$log,urlService,$location){

			$scope.isVerify = true;
			$scope.pageNumber=0;
			$scope.sortByOrder="ASC";
			$scope.sortByAttribute="id";
			$scope.selectedtable="logs";
			$scope.pageSizes=[1,25,50,100];
			$scope.pn=[1,2,3,4,5,6,7];
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
			$scope.loadPage = function(id) {
				$scope.pageNumber = id-1;
				//alert(id);
				$scope.getAndSetAUILogs();
				if($scope.pageNumber>3){
					$scope.pn[0]=$scope.pageNumber-2;
					$scope.pn[1]=$scope.pageNumber-1;
					$scope.pn[2]=$scope.pageNumber-0;
					$scope.pn[3]=$scope.pageNumber+1;
					$scope.pn[4]=$scope.pageNumber+2;
					$scope.pn[5]=$scope.pageNumber+3;
					$scope.pn[6]=$scope.pageNumber+4;
					
				}
			};	
			
			

			
			$scope.getAndSetAUILogs();
			
				
	}]);

	
	