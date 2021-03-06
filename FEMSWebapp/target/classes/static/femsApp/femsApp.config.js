angular.
  module('femsApp').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
      	when('/owners', {
          template: '<owner-list></owner-list>'
        }).
        when('/owners/new', {
            template: '<owner-new></owner-new>'
          }).
        when('/owners/:ownerId', {
            template: '<owner-detail></owner-detail>'
          }).
       
        when('/funds', {
            template: '<fund-list></fund-list>'
        }).
        when('/funds/new', {
            template: '<fund-new></fund-new>'
          }).
        when('/funds/:fundId', {
            template: '<fund-detail></fund-detail>'
        }).
        when('/transactions', {
              template: '<transaction-list></transaction-list>'
         }).
         when('/transactions/new', {
             template: '<transaction-new></transaction-new>'
           }).
        when('/transactions/:transactionId', {
             template: '<transaction-detail></transaction-detail>'
        }).
        otherwise('',{
        	template: '<phone-list></phone-list>'
        });
      
    }
  ]);