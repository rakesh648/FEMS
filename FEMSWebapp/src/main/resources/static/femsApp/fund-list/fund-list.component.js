// Register `phoneList` component, along with its associated controller and template
angular.
  module('fundList').
  component('fundList', {
    templateUrl: 'fund-list/fund-list.template.html',
    controller: ['$routeParams', '$location','fundListService',
                 function FundListController($routeParams,$location, fundListService ) {	   
			        
    				this.funds = fundListService.query(function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
			        this.orderProp = 'fund.availableFrom';
			        
			        function createNewFund() {
			        	$location.path('/funds/new');
			        };
			        this.createNewFund = createNewFund;
			      }
               ]
  });