akira.constant("Constant", {

	staticUrls : {
		getAuiLogUrl : 'http://' + remoteIp + '/logs/AUI/get',
		getSummaryLogUrl : 'http://' + remoteIp + '/logs/summary/get',
		getGuiLogUrlbyStatus : 'http://' + remoteIp + '/logs/status/get',
		getGuiLogUrlbyResponsetime : 'http://' + remoteIp + '/logs/ResponseTime/get',
		getDistinctUrl : 'http://' + remoteIp + '/logs/distinctUrl',
		autoScaleGroupNameUrl : 'http://' + remoteIp + '/aws/autoscalegroup'
	},
	logMessages : {
		requestFetchError : "Error in fetching Request {0}.",
	},

});