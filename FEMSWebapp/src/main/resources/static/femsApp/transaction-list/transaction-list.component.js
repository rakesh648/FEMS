angular.
  module('transactionList').
  component('transactionList', {
    templateUrl: './femsApp/transaction-list/transaction-list.template.html',
    controller: ['$routeParams', 'transactionListService','$resource','$location',
                 function TransactionListController($routeParams, transactionListService,$resource ,$location) {
			    	var url = $location.url();
					if(url.startsWith('/transactions')){
						this.transactions = transactionListService.all.query({},
				        		function(data) {
	    				    // success handler
	    				}, function(error) {
	    				    alert("Unable to connect to server. Please try again later");
	    				});
					}
					else if(url.startsWith('/funds')){
						this.transactions = transactionListService.funds.query({fundId: $routeParams.fundId},
				        		function(data) {
	    				    // success handler
	    				}, function(error) {
	    				    alert("Unable to connect to server. Please try again later");
	    				});
					}
			        
			        var self = this;
			        
			        function createNewTransaction() {
			        	$location.path('/transactions/new');
			        };
			        this.createNewTransaction = createNewTransaction;
			        
			        this.orderProp = 'transaction.transactionDate';
			      }
               ]
  });