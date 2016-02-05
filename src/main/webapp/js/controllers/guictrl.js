
//	angular.module( "akira", [ 'tc.chartjs' ])
  akira.controller( "guictrl",[ "$scope", "urlService", function( $scope,urlService ) {
	  $('#searchlist').btsListFilter('#searchinput', {itemChild: 'a'});
	  $scope.distinctUrl=[];
	  
	  $scope.getAndSetSummaryLogs=function(){

		
		  urlService.getGUILog($scope.currentUrl).then(function(resultJson) {
		  $scope.data = {
			      labels: resultJson.dates,
			      datasets: [
			        {
			          label: 'Number of Success',
			          fillColor: 'rgba(220,220,220,0.5)',
			          strokeColor: 'rgba(220,220,220,0.8)',
			          highlightFill: 'rgba(220,220,220,0.75)',
			          highlightStroke: 'rgba(220,220,220,1)',
			          data: resultJson.numberOfSuccess,
			        },
			        {
			          label: 'Number of Failure',
			          fillColor: 'rgba(151,187,205,0.5)',
			          strokeColor: 'rgba(151,187,205,0.8)',
			          highlightFill: 'rgba(151,187,205,0.75)',
			          highlightStroke: 'rgba(151,187,205,1)',
			          data:resultJson.numberOfFailure,
			        },
			        {
				          label: 'Number of  Redirects',
				          fillColor: 'rgba(151,187,205,0.5)',
				          strokeColor: 'rgba(151,187,205,0.8)',
				          highlightFill: 'rgba(151,187,205,0.75)',
				          highlightStroke: 'rgba(151,187,205,1)',
				          data:resultJson.numberOfRedirect,
				        },
				        
			      ]
			    };
		  });	  
	  }

	  	
	  $scope.getAndSetDisticlUrl=function(){
			
		  urlService.getDistinctUrl().then(function(resultJson) {
			  $scope.distinctUrl=resultJson;
			  $scope.currentUrl=$scope.distinctUrl[0];  
				$scope.getAndSetSummaryLogs();
		  });
		  }
		  
	 $scope.loadUrlData=function(url){
		 $scope.currentUrl=url;
		 console.log($scope.currentUrl);
		 $scope.getAndSetSummaryLogs();
	 }
	  
	  $scope.getAndSetDisticlUrl();
	


	
	

	  


  }]);