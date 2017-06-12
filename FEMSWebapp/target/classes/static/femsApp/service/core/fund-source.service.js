angular.
  module('fundSourceService').
  factory('fundSourceService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.fundSourceApiUrl , {}, {
                       query: {
                         method: 'GET',
                         isArray: true
                       }
                     });
                   }
               ]);