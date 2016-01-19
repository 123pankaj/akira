akira.service("urlService", ["$http", "$q","Constant",
    function($http, $q, Constant) {

        var staticUrls= Constant.staticUrls;
        
        window.String.format = function(input) {
            var args = arguments;
            return input.replace(/\{(\d+)\}/g, function(match, capture) {
                return args[1 * capture + 1];
            });
        };

        function getAUILog(pNumber) {
            var request = $http({
                method: "get",
                url: String.format(staticUrls.getAuiLogUrl, pNumber),
                
            });
            return (request.then(handleSuccess, handleError));
        }
        

        function handleError(response) {
            if (!angular.isObject(response.data) || !response.data.message) {
                return ($q.reject("An unknown error occurred."));
            }
            return ($q.reject(response.data.message));
        }

        function handleSuccess(response) {
            return (response.data);
        }
        
        return ({
        	getAUILog: getAUILog,
        });

    }
]);