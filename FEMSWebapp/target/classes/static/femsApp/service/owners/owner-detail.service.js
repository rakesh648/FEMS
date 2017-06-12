angular.
  module('ownerDetailService').
  factory('ownerDetailService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource( env.ownerDetailApiUrl, {}, {
                       query: {
                         method: 'GET',
                         isArray: false
                       }
                     });
                   }
               ]);