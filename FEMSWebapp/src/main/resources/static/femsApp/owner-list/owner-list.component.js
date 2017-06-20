// Register `phoneList` component, along with its associated controller and template
angular.
  module('ownerList').
  component('ownerList', {
    templateUrl: './femsApp/owner-list/owner-list.template.html',
    controller: ['$routeParams', '$location', 'ownerListService',
                 function OwnerListController($routeParams, $location, ownerListService ) {	   
			        
    				this.owners = ownerListService.query(function(data) {
    				    // success handler
    				}, function(error) {
    				    alert("Unable to connect to server. Please try again later");
    				});
			        this.orderProp = 'owner.name';
			        
			        function createNewOwner() {
			        	$location.path('/owners/new');
			        };
			        this.createNewOwner = createNewOwner;
			      }
               ]
  });