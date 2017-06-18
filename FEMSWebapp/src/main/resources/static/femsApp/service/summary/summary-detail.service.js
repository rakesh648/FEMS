angular.
  module('summaryDetailService').
  factory('summaryDetailService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.summaryDetailServiceUrl , {}, {
                       query: {
                         method: 'GET',
                         isArray: true                         
                       }
                     });
                   }
               ]);