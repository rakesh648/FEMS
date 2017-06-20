angular.
  module('menuList').
  component('menuList', {
    templateUrl: './femsApp/core/menu/menu-list.template.html',
    controller: 
                 function MenuListController() {
    				this.modules = [
									{
										name: 'Summary',
										desc: 'Sammary Management',
									    link: '/summary',
									    order: 1
									},
			    	               /* {
			    	                  name: 'Members',
			    	                  desc: 'Member Management',
			    	                  link: '/owners',
			    	                  order: 1
			    	                }, */
			    	               {
			    	                	name: 'Funds',
			    	                	desc: 'Funds Management',
			    	                    link: '/funds',
			    	                    order: 2
			    	                }, {
			    	                	name: 'Expense',
			    	                	desc: 'Expense Management',
			    	                    link: '/transactions',
			    	                    order: 3
			    	                },
			    	                {
			    	                	name: 'Plans',
			    	                	desc: 'Plan Management',
			    	                    link: '/plans',
			    	                    order: 4
			    	                }
			    	                
			    	              ];
			
			        this.orderProp = 'order';
			      }
  
  });