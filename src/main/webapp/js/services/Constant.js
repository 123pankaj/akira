akira.constant("Constant", {

	staticUrls : {
		getAuiLogUrl : 'http://' + remoteIp + '/logs/AUI/get',
		getSummaryLogUrl : 'http://' + remoteIp + '/logs/summary/get',
		getGuiLogUrl : 'http://' + remoteIp + '/logs/status/get',
		getDistinctUrl : 'http://' + remoteIp + '/logs/distinctUrl',
		
	},
	logMessages : {
		requestFetchError : "Error in fetching Request {0}.",
	},

});