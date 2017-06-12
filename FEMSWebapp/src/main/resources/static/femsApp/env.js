
(function (window) {
  window.__env = window.__env || {};
  //window.__env.apiUrl = 'http://10.51.84.76:8200';
  window.__env.apiUrl = 'http://192.168.0.3:8200';
  //window.__env.apiUrl = 'http://localhost:8200';
  
  window.__env.ownerListApiUrl = window.__env.apiUrl+'/owners';
  window.__env.ownerDetailApiUrl = window.__env.apiUrl+'/owners/:ownerId';
  
  window.__env.fundListApiUrl = window.__env.apiUrl+'/funds';
  window.__env.fundDetailApiUrl = window.__env.apiUrl+'/funds/:fundId';
  
  window.__env.transactionListApiUrl = window.__env.apiUrl+'/transactions';
  window.__env.transactionDetailApiUrl = window.__env.apiUrl+'/transactions/:transactionId';
  
  window.__env.fundSourceApiUrl = window.__env.apiUrl+'/funds/sources/';
  window.__env.transactionTypeApiUrl = window.__env.apiUrl+'/transactions/types/';
  window.__env.transactionStatusApiUrl = window.__env.apiUrl+'/transactions/statuses/';
  window.__env.transactionCategoryApiUrl = window.__env.apiUrl+'/transactions/categories/';
  window.__env.buildingAreaApiUrl = window.__env.apiUrl+'/buildingareas/';
  

  // Whether or not to enable debug mode
  // Setting this to false will disable console output
  window.__env.enableDebug = true;
}(this));