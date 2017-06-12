angular.
  module('ownerListService').
  factory('ownerListService', ['$resource',
                   function($resource) {
                     return $resource(env.ownerListApiUrl, {}, {
                       query: {
                         method: 'GET',
                         isArray: true
                       },
                       save : {
                           method: 'POST'
                       }
                     });
                   }
               ]);