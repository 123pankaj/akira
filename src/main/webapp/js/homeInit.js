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
		        controller:'summaryCtrl' 
	      }).when('/logout', {
		        templateUrl: 'ngviews/logout.jsp',
      
		      }).otherwise({
		          redirectTo: '/'
		      });
	  }]);