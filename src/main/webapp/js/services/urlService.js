akira.service("urlService",
		[
				"$http",
				"$q",
				"$log",
				"Constant",
				function($http, $q, $log, Constant) {
					var staticUrls = Constant.staticUrls;
					window.String.format = function(input) {
						var args = arguments;
						return input.replace(/\{(\d+)\}/g, function(match,
								capture) {
							return args[1 * capture + 1];
						});
					};

					function getAUILog(date, pNum, pSize, sOrder, sAttribute) {
						var request=$http.get(staticUrls.getAuiLogUrl, {
							params : {
								pN : pNum,
								pS : pSize,
								sB : sAttribute,
								or : sOrder,
								date : date
							}
						});
						
						console.log("-"+staticUrls.getAuiLogUrl+" "+date+" "+pNum+" "+pSize+" "+sOrder+" "+sAttribute);
						return (request.then(handleSuccess, handleError));
					}

					function handleError(response) {
						if (!angular.isObject(response.data)
								|| !response.data.message) {
							return ($q.reject("An unknown error occurred."));
						}
					}

					function handleSuccess(response) {
						console.log("--");
						return (response.data);
					}

					function getSummaryLog(date, pNum, pSize, sOrder, sAttribute) {
						var request=$http.get(staticUrls.getSummaryLogUrl, {
							params : {
								pN : pNum,
								pS : pSize,
								sB : sAttribute,
								or : sOrder,
								date : date
							}
						});
						
						console.log("-"+staticUrls.getAuiLogUrl+" "+date+" "+pNum+" "+pSize+" "+sOrder+" "+sAttribute);
						return (request.then(handleSuccess, handleError));
					}	
					
					
					
					
					return ({
						getAUILog : getAUILog,
						getSummaryLog : getSummaryLog,
					});

				} ]);