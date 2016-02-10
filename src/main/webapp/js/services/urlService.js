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
						var request = $http.get(staticUrls.getAuiLogUrl, {
							params : {
								pN : pNum,
								pS : pSize,
								sB : sAttribute,
								or : sOrder,
								date : date
							}
						});
						return (request.then(handleSuccess, handleError));
					}

					function getGUILogbyStatus(url) {
						var request = $http.get(
								staticUrls.getGuiLogUrlbyStatus, {
									params : {
										url : url,

									}
								});

						// console.log("-"+staticUrls.getGuiLogUrl+" "+date+"
						// "+pNum+" "+pSize+" "+sOrder+" "+sAttribute);
						return (request.then(handleSuccess, handleError));
					}
					function getGUILogbyResponsetime(url) {
						var request = $http.get(
								staticUrls.getGuiLogUrlbyResponsetime, {
									params : {
										url : url,

									}
								});

						// console.log("-"+staticUrls.getGuiLogUrl+" "+date+"
						// "+pNum+" "+pSize+" "+sOrder+" "+sAttribute);
						return (request.then(handleSuccess, handleError));
					}

					function getSummaryLog(date, pNum, pSize, sOrder,
							sAttribute) {
						var request = $http.get(staticUrls.getSummaryLogUrl, {
							params : {
								pN : pNum,
								pS : pSize,
								sB : sAttribute,
								or : sOrder,
								date : date
							}
						});

						console.log("-" + staticUrls.getAuiLogUrl + " " + date
								+ " " + pNum + " " + pSize + " " + sOrder + " "
								+ sAttribute);
						return (request.then(handleSuccess, handleError));
					}

					function getDistinctUrl() {
						var request = $http.get(staticUrls.getDistinctUrl);

						return (request.then(handleSuccess, handleError));
					}

					// Aws info call
					function getAutoScaleGroupNames() {
						var request = $http.get(
								staticUrls.autoScaleGroupNameUrl, {});
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

					return ({
						getAUILog : getAUILog,
						getSummaryLog : getSummaryLog,
						getGUILogbyStatus : getGUILogbyStatus,
						getGUILogbyResponsetime : getGUILogbyResponsetime,
						getDistinctUrl : getDistinctUrl,
						getAutoScaleGroupNames : getAutoScaleGroupNames,
					});
				} ]);