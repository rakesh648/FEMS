angular.
  module('fundDetailService').
  factory('fundDetailService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.fundDetailApiUrl , {}, {
                       query: {
                         method: 'GET',
                         isArray: false
                       }
                     });
                   }
               ]);