
(function (window) {
  window.__env = window.__env || {};
  window.__env.apiUrl = 'http://192.168.0.5:8020';
  //window.__env.apiUrl = 'https://femsproddb.appspot.com';
  
  window.__env.ownerListApiUrl = window.__env.apiUrl+'/owners';
  window.__env.ownerDetailApiUrl = window.__env.apiUrl+'/owners/:ownerId';
  
  window.__env.fundListApiUrl = window.__env.apiUrl+'/funds';
  window.__env.fundDetailApiUrl = window.__env.apiUrl+'/funds/:fundId';
  window.__env.fundTransactionApiUrl = window.__env.apiUrl+'/funds/:fundId/transactions';
  
  window.__env.transactionListApiUrl = window.__env.apiUrl+'/transactions';
  window.__env.transactionDetailApiUrl = window.__env.apiUrl+'/transactions/:transactionId';
  
  window.__env.planListApiUrl = window.__env.apiUrl+'/plans';
  window.__env.planDetailApiUrl = window.__env.apiUrl+'/plans/:planId';
  
  window.__env.fundSourceApiUrl = window.__env.apiUrl+'/funds/sources/';
  window.__env.transactionTypeApiUrl = window.__env.apiUrl+'/transactions/types/';
  window.__env.transactionStatusApiUrl = window.__env.apiUrl+'/transactions/statuses/';
  window.__env.transactionCategoryApiUrl = window.__env.apiUrl+'/transactions/categories/';
  window.__env.buildingAreaApiUrl = window.__env.apiUrl+'/buildingareas/';
  
  window.__env.fundSummaryDetailServiceUrl = window.__env.apiUrl+'/funds/summary/';
  window.__env.planSummaryDetailServiceUrl = window.__env.apiUrl+'/plans/summary/';
  window.__env.contributionSummaryDetailServiceUrl = window.__env.apiUrl+'/summary/contribution'
  

  // Whether or not to enable debug mode
  // Setting this to false will disable console output
  window.__env.enableDebug = true;
}(this));