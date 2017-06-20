angular.
  module('summaryDetail').
  component('summaryDetail', {
    templateUrl: './femsApp/summary-detail/summary-detail.template.html',
    controller: ['$routeParams', 'summaryDetailService','$resource',
                 function SummaryDetailController($routeParams, summaryDetailService ,$resource) {	   
			        var self = this;
			        
			        var graphObject = new Object();
	        		graphObject.others = new Object();
	        		graphObject.loan = new Object();
	        		graphObject.saving = new Object();
	        		graphObject.plan = new Object();
	        		
			        var summarySources = summaryDetailService.funds.query({},
			        		function(data) {
		        		
		        		var totalFund =0, totalExpense = 0, totalAvailable = 0;
		        		
		        		var arrayLength = data.length;
		        		for (var i = 0; i < arrayLength; i++) {
		        			
		        			totalFund = totalFund + data[i].fundAmount;
		        			totalExpense = totalExpense + data[i].fundConsumed;
		        			totalAvailable = totalAvailable + data[i].fundRemaining;
		        			if(data[i].source =='LOAN'){
				        		graphObject.loan.fund = data[i].fundAmount;
				        		graphObject.loan.expense = data[i].fundConsumed;
				        		graphObject.loan.available = data[i].fundRemaining;
		        			}
		        			if(data[i].source =='SAVING'){
		        				graphObject.saving.fund = data[i].fundAmount;
				        		graphObject.saving.expense = data[i].fundConsumed;
				        		graphObject.saving.available = data[i].fundRemaining;
		        			}
		        			if(data[i].source =='OTHERS'){
		        				graphObject.others.fund = data[i].fundAmount;
				        		graphObject.others.expense = data[i].fundConsumed;
				        		graphObject.others.available = data[i].fundRemaining;
		        			}
		        		}
		        		
		        		  self.summary.totalFund = totalFund;
		        		  self.summary.totalExpense = totalExpense;
		        		  self.summary.totalAvailable= totalAvailable;
		        		  
		        		  summaryDetailService.plans.query({},
					        		function(data) {
		        			  			var arrayLength = data.length;
		        			  			var total =0;
		        		        		for (var i = 0; i < arrayLength; i++) {
		        		        			total = total +data[i].amount;
		        		        		}
		        		        		self.summary.totalPlan = total;
		        		        		graphObject.plan.amount=total;
		        		        		self.summary.variance =  self.summary.totalFund - self.summary.totalPlan;
		        		        		drawFundSummaryBarGraph(graphObject);
					        		  },
					        		  function(error) {
					    				    alert("Unable to connect to server. Please try again later");    				    
					        		  }											
		        		  
		        		  );
		        		  
		        		 
		        		  
		        		return data;
		        		
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");    				    
    				});
			        
			        
			        this.summary = {totalFund:'',totalExpense:'', totalAvailable:'' };
			        
			        summaryDetailService.contribution.query({},
			        		function(data) {
        			  			var arrayLength = data.length;
        			  			var total =0;
        		        		for (var i = 0; i < arrayLength; i++) {
        		        			total = total +data[i].value;
        		        			
        		        		}
        		        		drawContributionSummaryBarGraph(data);
			        		  },
			        		  function(error) {
			    				    alert("Unable to connect to server. Please try again later");    				    
			        		  }											
        		  
        		  );
			        
    			 }
               ]
  });