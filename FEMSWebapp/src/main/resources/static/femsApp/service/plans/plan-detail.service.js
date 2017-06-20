angular.
  module('planDetailService').
  factory('planDetailService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.planDetailApiUrl, {}, {
                       query: {
                         method: 'GET',
                         isArray: false
                       }
                     });
                   }
               ]);