String.prototype.toCamelCase = function(){
	return this.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
};


String.prototype.toCamelCase = function(){
	return this.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
};


function drawFundSummaryBarGraph(sumary){
	
	 var currentWindowHeight = $(window).height();
     var canvas = document.getElementById("myChart");
     var chartHeight = currentWindowHeight - 820;
     if(currentWindowHeight >600){
    	 chartHeight = 100;
     }else{
    	 chartHeight = 300;
     }
     var lineChartParent = document.getElementById('linechartparent')
    // canvas.width = lineChartParent.clientWidth;
     canvas.height = chartHeight;
     
     
	var ctx = document.getElementById("myChart");
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ["Fund", "Expense", "Available"],
	        datasets: [{
	            label: 'Savings',
	            stack : 'stack0',
	            data: [sumary.saving.fund,sumary.saving.expense,sumary.saving.available],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.8)',
	                'rgba(54, 162, 235, 0.8)',
	                'rgba(153, 102, 255, 0.8)'
	            ],
	            borderColor: [
	                'rgba(255,99,132,1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(153, 102, 255, 1)'
	            ],
	            borderWidth: 1
	        },
	        {
	            label: 'Loan',
	            stack : 'stack0',
	            data: [sumary.loan.fund,sumary.loan.expense,sumary.loan.available],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.5)',
	                'rgba(54, 162, 235, 0.5)',
	                'rgba(153, 102, 255, 0.5)'
	            ],
	            borderColor: [
	                'rgba(255,99,132,1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(153, 102, 255, 1)'
	            ],
	            borderWidth: 1
	        },
	        {
	            label: 'Others',
	            stack : 'stack0',
	            data: [sumary.others.fund,sumary.others.expense,sumary.others.available],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(153, 102, 255, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255,99,132,1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(153, 102, 255, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
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