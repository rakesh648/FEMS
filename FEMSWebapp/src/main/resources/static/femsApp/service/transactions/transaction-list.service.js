angular.
  module('transactionListService').
  factory('transactionListService', ['$resource','$routeParams','$location',
                   function($resource,$routeParams,$location) {
                     return {
                    	 all: $resource(env.transactionListApiUrl, {}, {
                    	        query: { method: 'GET', isArray: true }
                    	      }),
                    	 newTransaction: $resource(env.transactionListApiUrl, {}, {
                      	        save: { method: 'POST'}
                      	      }),
                	      funds: $resource(env.fundTransactionApiUrl, {}, {
                	          query: { method: 'GET', isArray: true }
                	        }),
                    	 }
                     }
               ]);