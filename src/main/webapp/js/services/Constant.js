akira.constant("Constant", {

	staticUrls : {
		getAuiLogUrl : 'http://' + remoteIp + '/logs/AUI/get',
		getSummaryLogUrl : 'http://' + remoteIp + '/logs/summary/get',
<<<<<<< Updated upstream
		getGuiLogUrl : 'http://' + remoteIp + '/logs/status/get',
		getDistinctUrl : 'http://' + remoteIp + '/logs/distinctUrl',
=======
<<<<<<< HEAD
		getGuiLogUrlbyStatus : 'http://' + remoteIp + '/logs/status/get',
		getGuiLogUrlbyResponsetime : 'http://' + remoteIp + '/logs/ResponseTime/get',

		getDistinctUrl : 'http://' + remoteIp + '/logs/distinctUrl',
	
=======
		getGuiLogUrl : 'http://' + remoteIp + '/logs/status/get',
		getDistinctUrl : 'http://' + remoteIp + '/logs/distinctUrl',
>>>>>>> 94475972f17eb574b6ebc4b93f28ef91c97462b6
>>>>>>> Stashed changes

		
	},
	logMessages : {
		requestFetchError : "Error in fetching Request {0}.",
	},

});