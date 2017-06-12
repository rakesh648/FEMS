angular.
  module('transactionListService').
  factory('transactionListService', ['$resource','$routeParams',
                   function($resource,$routeParams) {
                     return $resource(env.transactionListApiUrl, {}, {
                       query: {
                         method: 'GET',
                         params: {group: $routeParams.group},
                         isArray: true
                       },
                     save: {
                         method: 'POST'
                       }
                     });
                   }
               ]);