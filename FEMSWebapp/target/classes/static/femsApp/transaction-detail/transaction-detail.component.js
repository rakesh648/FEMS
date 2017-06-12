angular.
  module('transactionDetail').
  component('transactionDetail', {
    templateUrl: 'transaction-detail/transaction-detail.template.html',
    controller: ['$routeParams', 'transactionDetailService','$resource',
                 function TransactionDetailController($routeParams, transactionDetailService ,$resource) {	   
			        var self = this;			        
    				this.transaction = transactionDetailService.query({transactionId:$routeParams.transactionId},
				    						function(data) {
					    				    // success handler
						    				}, function(error) {
						    				    alert("Unable to connect to server. Please try again later");
						    				});
    			 }
               ]
  });