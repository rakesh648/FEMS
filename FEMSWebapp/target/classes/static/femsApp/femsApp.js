var env = {};

// Import variables if present (from env.js)
if(window){  
  Object.assign(env, window.__env);
}
var isMobile = typeof(ionic)!=='undefined' && (ionic.Platform.is("ios") || ionic.Platform.is("android"));
/*if(isMobile) {
    dependencies.push('ionic');
}*/
var femsApp = angular.module('femsApp', [
                                         'menuList',
                                         'ownerList',                                         
                                         'ownerListService',
                                         'ownerDetail',                                         
                                         'ownerDetailService',
                                         'ownerNew',
                                         'fundList',                                         
                                         'fundListService',
                                         'fundDetail',                                         
                                         'fundDetailService',
                                         'fundNew',
                                         'transactionList',                                         
                                         'transactionListService',
                                         'transactionDetail',                               
                                         'transactionDetailService',
                                         'transactionNew',
                                         'fundSourceService',
                                         'transactionTypeService',
                                         'transactionStatusService',
                                         'transactionCategoryService',
                                         'buildingAreaService',
                                         'ngRoute',
                                         'ngResource'
                                         ]);

femsApp.constant('__env', env);

if(isMobile) {
   ngModule.run(function ($ionicPlatform) {
       $ionicPlatform.ready(function() {
       // Anything native should go here, like StatusBar.styleLightContent()
       if (window.StatusBar) {
          // org.apache.cordova.statusbar required
          StatusBar.styleDefault();
       }
    });
})
}