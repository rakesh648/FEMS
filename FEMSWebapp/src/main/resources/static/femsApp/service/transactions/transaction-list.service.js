angular.
  module('transactionListService').
  factory('transactionListService', ['$resource','$routeParams','$location',
                   function($resource,$routeParams,$location) {
                     return {
                    	 all: $resource(env.transactionListApiUrl, {}, {
                    	        query: { method: 'GET', isArray: true }
                    	      }),
                	      funds: $resource(env.fundTransactionApiUrl, {}, {
                	          query: { method: 'GET', isArray: true }
                	        })
                    	 }
                     }
               ]);