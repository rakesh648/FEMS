angular.
  module('buildingAreaService').
  factory('buildingAreaService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.buildingAreaApiUrl , {}, {
                       query: {
                         method: 'GET',
                         //params: {group: $routeParams.group},
                         isArray: true                         
                       }
                     });
                   }
               ]);