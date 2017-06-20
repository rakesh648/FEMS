String.prototype.toCamelCase = function(){
	return this.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
};


String.prototype.toCamelCase = function(){
	return this.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
};


function drawFundSummaryBarGraph(sumary){
	
	 var currentWindowHeight = $(window).height();
     var canvas = document.getElementById("myChart");
     var chartHeight = currentWindowHeight - 85;
     if(currentWindowHeight >600){
    	 chartHeight = 100;
     }else{
    	 chartHeight = 300;
     }
     var lineChartParent = document.getElementById('linechartparent')
    // canvas.width = lineChartParent.clientWidth;
     canvas.height = chartHeight;
     
     var planStackOpacity = 0.9;
     var savingStackOpacity = 0.7;
     var loanStackOpacity = 0.5;
     var otherStackOpacity = 0.3;
     var borderOpacity = 1;
     
     var planStackBG =  '33, 130, 5';
     var savingStackBG =  '255, 99, 132';
     var loanStackBG =  '54, 162, 235';
     var otherStackBG =  '153, 102, 255';
     
	var ctx = document.getElementById("myChart");
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ["Plan", "Fund", "Expense", "Available"],
	        datasets: [

	    	           {
	    	            label: 'Plan',
	    	            stack : 'stack1',
	    	            data: [sumary.plan.amount,0,0,0],
	    	            backgroundColor: [
	    	                'rgba('+planStackBG+','+planStackOpacity+')',
	    	                'rgba('+savingStackBG+','+planStackOpacity+')',
	    	                'rgba('+loanStackBG+','+planStackOpacity+')',
	    	                'rgba('+otherStackBG+','+planStackOpacity+')',
	    	            ],
	    	            borderColor: [
							'rgba('+planStackBG+','+borderOpacity+')',
							'rgba('+savingStackBG+','+borderOpacity+')',
							'rgba('+loanStackBG+','+borderOpacity+')',
							'rgba('+otherStackBG+','+borderOpacity+')'
	    	            ],
	    	            borderWidth: 1
	    	        },
	           {
	            label: 'Savings',
	            stack : 'stack1',
	            data: [0,sumary.saving.fund,sumary.saving.expense,sumary.saving.available],
	            backgroundColor: [
	                              'rgba('+planStackBG+','+savingStackOpacity+')',
	                              'rgba('+savingStackBG+','+savingStackOpacity+')',
	  	    	                  'rgba('+loanStackBG+','+savingStackOpacity+')',
	  	    	                  'rgba('+otherStackBG+','+savingStackOpacity+')',
	            ],
	            borderColor: [
								'rgba('+planStackBG+','+borderOpacity+')',
								'rgba('+savingStackBG+','+borderOpacity+')',
								'rgba('+loanStackBG+','+borderOpacity+')',
								'rgba('+otherStackBG+','+borderOpacity+')'
	            ],
	            borderWidth: 1
	        },
	        {
	            label: 'Loan',
	            stack : 'stack1',
	            data: [0,sumary.loan.fund,sumary.loan.expense,sumary.loan.available],
	            backgroundColor: [
						'rgba('+planStackBG+','+loanStackOpacity+')',
						'rgba('+savingStackBG+','+loanStackOpacity+')',
						'rgba('+loanStackBG+','+loanStackOpacity+')',
						'rgba('+otherStackBG+','+loanStackOpacity+')',
	            ],
	            borderColor: [
							'rgba('+planStackBG+','+borderOpacity+')',
							'rgba('+savingStackBG+','+borderOpacity+')',
							'rgba('+loanStackBG+','+borderOpacity+')',
							'rgba('+otherStackBG+','+borderOpacity+')'
	            ],
	            borderWidth: 1
	        },
	        {
	            label: 'Others',
	            stack : 'stack1',
	            data: [0,sumary.others.fund,sumary.others.expense,sumary.others.available],
	            backgroundColor: [
						'rgba('+planStackBG+','+otherStackOpacity+')',
						'rgba('+savingStackBG+','+otherStackOpacity+')',
						'rgba('+loanStackBG+','+otherStackOpacity+')',
						'rgba('+otherStackBG+','+otherStackOpacity+')',
	            ],
	            borderColor: [
						'rgba('+planStackBG+','+borderOpacity+')',
						'rgba('+savingStackBG+','+borderOpacity+')',
						'rgba('+loanStackBG+','+borderOpacity+')',
						'rgba('+otherStackBG+','+borderOpacity+')'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	    	legend :{
            	display:false
            },
	    	 title: {
	                display: true,
	                text: 'Status Summary'
	            },
	        scales: {
	        	xAxes: [{
	                stacked: true
	            }],
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
}

function getContributionDescription(key){
	if(key=='LOAN'){
		return "Amount";
	}
	if(key=='GIFT'){
		return "Gift Amount ";
	}
	if(key=='INV_REM'){
		return "Remaining";
	}
	if(key=='INV_DONE'){
		return "Contribution";
	}
}

function getContributionBGColor(key, groupName){
	
	if(key=='LOAN'){
		return '33, 130, 5';
	}
	if(key=='GIFT'){
		return '33, 130, 5';
	}
	if(groupName=='Rakesh/Sowmya'){
		return '255, 99, 132';
	}
	return '153, 102, 255';
	
}

function getContributionOpacity(key){
	if(key=='LOAN'){
		return 0.8;
	}
	if(key=='GIFT'){
		return 0.5;
	}
	if(key=='INV_REM'){
		return 0.5;
	}
	if(key=='INV_DONE'){
		return 0.8;
	}
}

function drawContributionSummaryBarGraph(summary){
	
	var currentWindowHeight = $(window).height();
    var canvas = document.getElementById("contributionChart");
    var chartHeight = currentWindowHeight - 85;
    if(currentWindowHeight >600){
   	 chartHeight = 100;
    }else{
   	 chartHeight = $(window).width();
    }
    canvas.height = chartHeight;
    
    var length = summary.length;
    var valueArray =[];
    var labelArray =[];
    var bgColorArray =[];
    var borderArray =[];
    for(i=0;i<length;i++){
    	valueArray[i] = summary[i].value;
    	labelArray[i] = summary[i].groupName+'-'+getContributionDescription(summary[i].key);
    	bgColorArray[i] = 'rgba('+getContributionBGColor(summary[i].key,summary[i].groupName)+','+getContributionOpacity(summary[i].key)+')'
    	borderArray[i]= bgColorArray[i];
    };
    
	var ctx = document.getElementById("contributionChart");
	var myDoughnutChart = new Chart(ctx, {
	    type: 'doughnut',
	    data: {
	    	    datasets: [{
	    	        data: valueArray,
	    	        backgroundColor: bgColorArray,
		            borderColor: borderArray
	    	    }],
	    	   
	    	    // These labels appear in the legend and in the tooltips when hovering different arcs
	    	    labels: labelArray
	    	},
	    	options: {
	            title: {
	                display: true,
	                text: 'Contribution Summary'
	            },
	            layout: {
	                padding: {
	                    left: 0,
	                    right: 0,
	                    top: 50,
	                    bottom: 0
	                	}
	                },
	            legend :{
	            	position:'top',
	            	fullWidth:true
	            }
	        }
	});
}