angular.
  module('planList').
  component('planList', {
    templateUrl: './femsApp/plan-list/plan-list.template.html',
    controller: ['$routeParams', 'planListService','$resource','$location',
                 function PlanListController($routeParams, planListService,$resource ,$location) {
					this.plans = planListService.query({},
													        function(data) {
										    				    // success handler
										    				}, 
										    				function(error) {
										    				    alert("Unable to connect to server. Please try again later");
										    				}
										    				);
			        
			        var self = this;
			        
			        function createNewPlan() {
			        	$location.path('/plans/new');
			        };
			        this.createNewPlan = createNewPlan;
			        
			        this.orderProp = 'plan.planId';
			      }
               ]
  });