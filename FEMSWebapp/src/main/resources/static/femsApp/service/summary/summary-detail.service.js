angular.
  module('summaryDetailService').
  factory('summaryDetailService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
					  return {
				     	 funds: $resource(env.fundSummaryDetailServiceUrl, {}, {
				     	        query: { method: 'GET', isArray: true }
				     	      }),
				 	      plans: $resource(env.planSummaryDetailServiceUrl, {}, {
				 	          query: { method: 'GET', isArray: true }
				 	        }),
				 	      contribution: $resource(env.contributionSummaryDetailServiceUrl, {}, {
				 	          query: { method: 'GET', isArray: true }
				 	        })
				     	 }
                   }
               ]);