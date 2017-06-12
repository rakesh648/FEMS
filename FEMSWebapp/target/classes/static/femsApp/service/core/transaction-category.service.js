angular.
  module('transactionCategoryService').
  factory('transactionCategoryService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.transactionCategoryApiUrl , {}, {
                       query: {
                         method: 'GET',
                         //params: {group: $routeParams.group},
                         isArray: true                         
                       }
                     });
                   }
               ]);