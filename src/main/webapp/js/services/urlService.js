akira.service("urlService", ["$http", "$q","Constant",
    function($http, $q, Constant) {

        var staticUrls= Constant.staticUrls;
        
        window.String.format = function(input) {
            var args = arguments;
            return input.replace(/\{(\d+)\}/g, function(match, capture) {
                return args[1 * capture + 1];
            });
        };

        function getAUILog(pNum,pSize,sOrder,sAttribute) {
            var request = $http.get(staticUrls.getAuiLogUrl,{params:{pN:pNum,pS:pSize,sB:sAttribute,or:sOrder}});
            
           //console.log(request.url);
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