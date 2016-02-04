akira.constant("Constant", {

	staticUrls : {
		getAuiLogUrl : 'http://' + remoteIp + '/logs/AUI/get',
		getSummaryLogUrl : 'http://' + remoteIp + '/logs/summary/get',
		getGuiLogUrl : 'http://' + remoteIp + '/logs/status/get',
<<<<<<< Updated upstream
		getDistinctUrl : 'http://' + remoteIp + '/logs/distinctUrl',
=======
		getUrl:'http://' + remoteIp + '/logs/distinctUrl',
>>>>>>> Stashed changes
		
	},
	logMessages : {
		requestFetchError : "Error in fetching Request {0}.",
	},

});