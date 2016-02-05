
//	angular.module( "akira", [ 'tc.chartjs' ])
  akira.controller( "guictrl",[ "$scope", "urlService", function( $scope,urlService ) {
	  $('#searchlist').btsListFilter('#searchinput', {itemChild: 'a'});
	  $scope.distinctUrl=[];
	  
$scope.type="status";
	  $scope.getAndSetSummaryLogsbystatus=function(){
				  urlService.getGUILogbyStatus($scope.currentUrl).then(function(resultJson) {
				$scope.data = {
			      labels: resultJson.dates,
			      datasets: [
			        {
			          label: 'Number of Success',
			          fillColor: 'rgba(200,255,200,0.5)',
			          strokeColor: 'rgba(60,130,60,1)',
			          highlightFill: 'rgba(220,220,220,0.5)',
			          highlightStroke: 'rgba(60,130,60,1)',
			          data: resultJson.numberOfSuccess,
			        },
			        {
			          label: 'Number of Failure',
			          fillColor: 'rgba(255,200,200,0.5)',
			          strokeColor: 'rgba(130,60,60,1)',
			          highlightFill: 'rgba(255,200,200,0.5)',
			          highlightStroke: 'rgba(130,60,60,1)',
			          data:resultJson.numberOfFailure,
			        },
			        {
				          label: 'Number of  Redirects',
				          fillColor: 'rgba(200,200,255,0.5)',
				          strokeColor: 'rgba(60,60,130,1)',
				          highlightFill: 'rgba(200,200,255,0.5)',
				          highlightStroke: 'rgba(60,60,130,1)',
				          data:resultJson.numberOfRedirect,
				        }
				 ]
			    };

		    });	  
		  };
		$scope.getAndSetSummaryLogsbyresponsetime=function(){
	urlService.getGUILogbyResponsetime($scope.currentUrl).then(function(resultJson) {
	    $scope.data = {
		      labels: resultJson.dates,
		      datasets: [
		        {
		            label: 'Average response time in microsecond',
			          fillColor: 'rgba(200,200,200,0.5)',
			          strokeColor: 'rgba(130,130,130,1)',
			          highlightFill: 'rgba(200,200,200,0.5)',
			          highlightStroke: 'rgba(130,130,130,1)',
		          data: resultJson.numberOfResponseTime,
		        },
		       ]
		    };
	});
		};
		
		$scope.bytype=function(){
		if($scope.type=="status")
			$scope.getAndSetSummaryLogsbystatus();
			else
				$scope.getAndSetSummaryLogsbyresponsetime();
	};

	

	  	

	  $scope.getAndSetDisticlUrl=function(){	
		  urlService.getDistinctUrl().then(function(resultJson) {
			  $scope.distinctUrl=resultJson;
			  $scope.currentUrl=$scope.distinctUrl[0];  
				$scope.getAndSetSummaryLogsbystatus();
		  });
		  }
		  $scope.loadUrlData=function(url){
			$scope.currentUrl=url; 
			$scope.bytype();
		  };
	  
	  $scope.getAndSetDisticlUrl();

  }]);

