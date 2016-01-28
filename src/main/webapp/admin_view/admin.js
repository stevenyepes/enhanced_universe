'use strict';

angular.module('app.admin', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/admin', {
		templateUrl : 'admin_view/admin.html',
		controller : 'adminCtrl'
	});
} ])
.controller('adminCtrl',function($scope, $http, $filter, galaxiaService, asteroideService) {

	
	
});
		