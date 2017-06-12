angular.
  module('transactionDetailService').
  factory('transactionDetailService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.transactionDetailApiUrl, {}, {
                       query: {
                         method: 'GET',
                         isArray: false
                       }
                     });
                   }
               ]);