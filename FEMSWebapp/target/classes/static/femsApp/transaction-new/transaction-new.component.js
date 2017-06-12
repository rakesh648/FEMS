angular.
  module('transactionNew').
  component('transactionNew', {
    templateUrl: 'transaction-new/transaction-new.template.html',
    controller: ['$routeParams', 
                 '$location',
                 'transactionListService',
                 'fundListService',
                 'transactionTypeService',
                 'transactionStatusService',
                 'transactionCategoryService',
                 'buildingAreaService',
                 function TransactionNewController($routeParams,
                		 						   $location, 
                		 						   transactionListService, 
                		 						   fundListService,
                		 						   transactionTypeService,
                		 						   transactionStatusService,
                		 						   transactionCategoryService,
                		 						   buildingAreaService
                		 						  ) {	   
    				this.transaction = new Object();
    				this.transaction.transactionType ='CHEQUE';
    				this.transaction.transactionDate= new Date();
    				this.transaction.chequeDate= new Date();
    				this.transaction.deductedOn= new Date();
    				this.transaction.status= 'INITITATED';
    				this.transactionTypes = transactionTypeService.query({group:$routeParams.group});
    				this.transactionStatuses = transactionStatusService.query({group:$routeParams.group});
    				this.transactionCategories = transactionCategoryService.query();
    				this.buildingAreas = buildingAreaService.query(function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
    				this.funds = fundListService.query();
    				
    				function saveNewTransaction() {
    					this.saveDisabled = true;
    					transactionListService.save(this.transaction,function(data) {
			        	    $location.path('/transactions/'+data.transactionId);
			        	}, function(error) {
	    				    alert("Unable to connect to server. Please try again later");
	    				});
			        };
			        
			        this.saveNewTransaction = saveNewTransaction;
			        
			        function isBankDisabled(){
			        	if(this.transaction == null){
			        		return false;
			        	}
			        	if(this.transaction.transactionType == 'CASH'){
			        		this.transaction.bank = "";
			        		return true;
			        	}
			        	return false;
			        }
			        this.isBankDisabled = isBankDisabled;
			        
			        function isChequeFieldsDisabled(){
			        	if(this.transaction == null){
			        		return false;
			        	}
			        	if( this.transaction.transactionType != 'CHEQUE'){
			        		this.transaction.chequeDate = "";
				        	this.transaction.chequeNumber = "";
				        	this.transaction.chequeTo = "";
			        		return true;
			        	}
			        	
			        	return false;
			        }
			        this.isChequeFieldsDisabled = isChequeFieldsDisabled;
			        
			        function isDeductedOnFieldsDisabled(){
			        	if(this.transaction == null){
			        		return false;
			        	}
			        	if(this.transaction.transactionType == 'CASH'){
			        		this.transaction.deductedOn = "";
			        		return true;
			        	}
			        	return false;
			        }
			        this.isDeductedOnFieldsDisabled = isDeductedOnFieldsDisabled;
			      }
               ]
  });