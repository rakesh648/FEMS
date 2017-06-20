angular.
  module('planListService').
  factory('planListService', ['$resource','$routeParams','$location',
                   function($resource,$routeParams,$location) {
                     return $resource(env.planListApiUrl, {}, {
                    	        query: { method: 'GET', isArray: true },
                    	        save: { method: 'POST'}
                    	      })
                    	 
                     }
               ]);