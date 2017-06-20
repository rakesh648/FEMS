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
        when('/funds/:fundId/transactions', {
        	template: '<transaction-list></transaction-list>'
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
        
        when('/plans', {
            template: '<plan-list></plan-list>'
        }).
        when('/plans/new', {
           template: '<plan-new></plan-new>'
        }).
        when('/plans/:planId', {
           template: '<plan-detail></plan-detail>'
        }).
        when('/summary', {
	          template: '<summary-detail></summary-detail>'	      
       }).
        otherwise('/summary', {
	          template: '<summary-detail></summary-detail>'	      
        });
      
    }
  ]);