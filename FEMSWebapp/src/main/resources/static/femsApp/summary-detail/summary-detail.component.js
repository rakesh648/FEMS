angular.
  module('summaryDetail').
  component('summaryDetail', {
    templateUrl: 'summary-detail/summary-detail.template.html',
    controller: ['$routeParams', 'summaryDetailService','$resource',
                 function SummaryDetailController($routeParams, summaryDetailService ,$resource) {	   
			        var self = this;
			        
			        var summarySources = summaryDetailService.query({},
			        		function(data) {

				        var graphObject = new Object();
		        		graphObject.others = new Object();
		        		
		        		var totalFund =0, totalExpense = 0, totalAvailable = 0;
		        		
		        		var arrayLength = data.length;
		        		for (var i = 0; i < arrayLength; i++) {
		        			
		        			totalFund = totalFund + data[i].fundAmount;
		        			totalExpense = totalExpense + data[i].fundConsumed;
		        			totalAvailable = totalAvailable + data[i].fundRemaining;
		        			
		        			if(data[i].source =='LOAN'){
		        				graphObject.loan = new Object();
				        		graphObject.loan.fund = data[i].fundAmount;
				        		graphObject.loan.expense = data[i].fundConsumed;
				        		graphObject.loan.available = data[i].fundRemaining;
		        			}
		        			if(data[i].source =='SAVING'){
		        				graphObject.saving = new Object();
		        				graphObject.saving.fund = data[i].fundAmount;
				        		graphObject.saving.expense = data[i].fundConsumed;
				        		graphObject.saving.available = data[i].fundRemaining;
		        			}
		        			if(data[i].source =='OTHERS'){
		        				graphObject.others = new Object();
		        				graphObject.others.fund = data[i].fundAmount;
				        		graphObject.others.expense = data[i].fundConsumed;
				        		graphObject.others.available = data[i].fundRemaining;
		        			}
		        		}
		        		
		        		  self.summary.totalFund = totalFund;
		        		  self.summary.totalExpense = totalExpense;
		        		  self.summary.totalAvailable= totalAvailable;
		        		  
		        		  drawFundSummaryBarGraph(graphObject);
		        		return data;
		        		
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");    				    
    				});
			        
			        this.summary = {totalFund:'',totalExpense:'', totalAvailable:'' };
    			 }
               ]
  });