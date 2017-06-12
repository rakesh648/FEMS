angular.
  module('fundListService').
  factory('fundListService', ['$resource',
                   function($resource) {
                     return $resource(env.fundListApiUrl, {}, {
                       query: {
                         method: 'GET',
                         isArray: true
                       },
                       save: {
                           method: 'POST'
                         }
                     });
                   }
               ]);