var akira = angular.module('akira', ['tc.chartjs','ngRoute']);
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
		        controller:'summaryCtrl' 
	      }).when('/logout', {
		        templateUrl: 'ngviews/logout.jsp',
      
		      }).when ('/gui',{
		    	  templateUrl:'ngviews/gui.jsp',
		    	  controller:'guictrl'
	    	
		      }).otherwise({
		   }).when('/autoScale', {
		        templateUrl: 'ngviews/autoScale.jsp',
		        controller:'awsCtrl'
		   }).when('/autoScale/groupDetail', {
		        templateUrl: 'ngviews/ScaleGroupDetail.jsp',
		   }).otherwise({
		          redirectTo: '/'
		      });
	  }]);
	
