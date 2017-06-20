// Register `phoneList` component, along with its associated controller and template
angular.
  module('fundNew').
  component('fundNew', {
    templateUrl: './femsApp/fund-new/fund-new.template.html',
    controller: ['$routeParams', '$location','ownerListService','fundListService','fundSourceService',
                 function FundNewController($routeParams,$location, ownerListService, fundListService,fundSourceService ) {	   			          				
    				this.fund = new Object();
    				this.fund.fund = new Object();
    				this.fund.fund.availableFrom = new Date();
    				
    				this.owners = ownerListService.query();
    				this.fundSources = fundSourceService.query(function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
    				
    				function saveNewFund() {
    					this.saveDisabled = true;
    					fundListService.save(this.fund,function(data) {
			        	    $location.path('/funds/'+data.fund.id);
			        	}, function(error) {
	    				    alert("Unable to connect to server. Please try again later");
	    				});
			        };
			        this.saveNewFund = saveNewFund;
			      }
               ]
  });