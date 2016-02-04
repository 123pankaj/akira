
//	angular.module( "akira", [ 'tc.chartjs' ])
  akira.controller( "guictrl",[ "$scope", "urlService", function( $scope,urlService ) {
	  $('#searchlist').btsListFilter('#searchinput', {itemChild: 'span'});
	  $scope.distinctUrl=[];
	  
	  $scope.getAndSetSummaryLogs=function(){
<<<<<<< Updated upstream
		
		  urlService.getGUILog($scope.currentUrl).then(function(resultJson) {
		  
=======
		  urlService.getGUILog().then(function(resultJson) {
		
>>>>>>> Stashed changes
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
		  $scope.geturls=function(){
			  urlService.getUrlLog().then(function(resultJson){
			  
			  });
		  
		  
		  
		  
	};
	  
<<<<<<< Updated upstream
	
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
	
	

=======

	
	$scope.getAndSetSummaryLogs();
>>>>>>> Stashed changes
	  

    // Chart.js Data
   /* $scope.data = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label: 'My First dataset',
          fillColor: 'rgba(220,220,220,0.5)',
          strokeColor: 'rgba(220,220,220,0.8)',
          highlightFill: 'rgba(220,220,220,0.75)',
          highlightStroke: 'rgba(220,220,220,1)',
          data: [65, 59, 80, 81, 56, 55, 40]
        },
        {
          label: 'My Second dataset',
          fillColor: 'rgba(151,187,205,0.5)',
          strokeColor: 'rgba(151,187,205,0.8)',
          highlightFill: 'rgba(151,187,205,0.75)',
          highlightStroke: 'rgba(151,187,205,1)',
          data: [28, 48, 40, 19, 86, 27, 90]
        }
      ]
    };
*/
  /*  // Chart.js Options
    $scope.options =  {

      // Sets the chart to be responsive
      responsive: true,

      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
      scaleBeginAtZero : true,

      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines : true,

      //String - Colour of the grid lines
      scaleGridLineColor : "rgba(0,0,0,.05)",

      //Number - Width of the grid lines
      scaleGridLineWidth : 1,

      //Boolean - If there is a stroke on each bar
      barShowStroke : true,

      //Number - Pixel width of the bar stroke
      barStrokeWidth : 2,

      //Number - Spacing between each of the X value sets
      barValueSpacing : 5,

      //Number - Spacing between data sets within X values
      barDatasetSpacing : 1,

      //String - A legend template
      legendTemplate : '<ul class="tc-chart-js-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].fillColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>'
    };
*/
  }]);