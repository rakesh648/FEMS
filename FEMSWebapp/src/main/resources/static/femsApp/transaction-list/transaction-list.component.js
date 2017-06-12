angular.
  module('transactionList').
  component('transactionList', {
    templateUrl: 'transaction-list/transaction-list.template.html',
    controller: ['$routeParams', 'transactionListService','$resource','$location',
                 function TransactionListController($routeParams, transactionListService,$resource ,$location) {	   
			        this.transactions = transactionListService.query({group:$routeParams.group},
			        		function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
			        var self = this;
			        
			        function createNewTransaction() {
			        	$location.path('/transactions/new');
			        };
			        this.createNewTransaction = createNewTransaction;
			        
			        this.orderProp = 'transaction.id';
			      }
               ]
  });