// Register `phoneList` component, along with its associated controller and template
angular.
  module('ownerNew').
  component('ownerNew', {
    templateUrl: './femsApp/owner-new/owner-new.template.html',
    controller: ['$routeParams', '$location','ownerListService',
                 function OwnerNewController($routeParams,$location, ownerListService ) {	   			          				
    				this.owner = null;
			        
    				function saveNewOwner() {
    					this.saveDisabled = true;
    					ownerListService.save(this.owner,function(data) {
			        	    $location.path('/owners/'+data.owner.id);
			        	}, function(error) {
	    				    alert("Unable to connect to server. Please try again later");
	    				});
			        };
			        this.saveNewOwner = saveNewOwner;
			      }
               ]
  });