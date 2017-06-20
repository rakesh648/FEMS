// Register `phoneList` component, along with its associated controller and template
angular.
  module('fundDetail').
  component('fundDetail', {
    templateUrl: './femsApp/fund-detail/fund-detail.template.html',
    controller: ['$routeParams', 'fundDetailService',
                 function FundDetailController($routeParams, fundDetailService ) {	   
    				this.fund = fundDetailService.query({fundId:$routeParams.fundId},function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
			      }
               ]
  });