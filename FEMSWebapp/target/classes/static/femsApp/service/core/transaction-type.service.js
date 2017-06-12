angular.
  module('transactionTypeService').
  factory('transactionTypeService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.transactionTypeApiUrl , {}, {
                       query: {
                         method: 'GET',
                         params: {group: $routeParams.group},
                         isArray: true                         
                       }
                     });
                   }
               ]);