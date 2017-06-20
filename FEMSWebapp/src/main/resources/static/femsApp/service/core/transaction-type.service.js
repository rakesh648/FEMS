angular.
  module('transactionTypeService').
  factory('transactionTypeService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.transactionTypeApiUrl , {}, {
                       query: {
                         method: 'GET',
                         isArray: true                         
                       }
                     });
                   }
               ]);