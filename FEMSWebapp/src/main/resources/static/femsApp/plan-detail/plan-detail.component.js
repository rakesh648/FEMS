angular.
  module('planDetail').
  component('planDetail', {
    templateUrl: './femsApp/plan-detail/plan-detail.template.html',
    controller: ['$routeParams', 'planDetailService','$resource',
                 function PlanDetailController($routeParams, planDetailService ,$resource) {	   
			        var self = this;			        
    				this.plan = planDetailService.query({planId:$routeParams.planId},
				    						function(data) {
					    				    // success handler
						    				}, function(error) {
						    				    alert("Unable to connect to server. Please try again later");
						    				});
    			 }
               ]
  });