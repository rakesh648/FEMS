angular.
  module('planNew').
  component('planNew', {
    templateUrl: './femsApp/plan-new/plan-new.template.html',
    controller: ['$routeParams', 
                 '$location',
                 'planListService',
                 'transactionCategoryService',
                 'buildingAreaService',
                 function PlanNewController($routeParams,
                		 						   $location, 
                		 						   planListService, 
                		 						   transactionCategoryService,
                		 						   buildingAreaService
                		 						  ) {	   
    				this.plan = new Object();
    				this.categories = transactionCategoryService .query();
    				this.buildingAreas = buildingAreaService.query(function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
    				
    				function saveNewPlan() {
    					this.saveDisabled = true;
    					planListService.save(this.plan,function(data) {
			        	    $location.path('/plans/'+data.planId);
			        	}, function(error) {
	    				    alert("Unable to connect to server. Please try again later");
	    				});
			        };
			        
			        this.saveNewPlan = saveNewPlan;
			        
			      }
               ]
  });