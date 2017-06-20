angular.
  module('transactionStatusService').
  factory('transactionStatusService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.transactionStatusApiUrl , {}, {
                       query: {
                         method: 'GET',
                         isArray: true                         
                       }
                     });
                   }
               ]);