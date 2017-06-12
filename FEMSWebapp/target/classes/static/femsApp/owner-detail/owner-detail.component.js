angular.
  module('ownerDetail').
  component('ownerDetail', {
    templateUrl: 'owner-detail/owner-detail.template.html',
    controller: ['$routeParams', 'ownerDetailService','$resource',
                 function OwnerDetailController($routeParams, ownerDetailService ,$resource) {	   
			        var self = this;			        
			        this.owner = ownerDetailService.query({ownerId:$routeParams.ownerId},
			        		function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
    			 }
               ]
  });