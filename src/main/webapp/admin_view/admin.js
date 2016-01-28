'use strict';

angular.module('app.admin', [ 'ngRoute', 'ngCookies'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/admin', {
		templateUrl : 'admin_view/admin.html',
		controller : 'adminCtrl'
	});
} ])
.controller('adminCtrl',function($scope, $http, $filter,$cookies, $location) {

	$scope.usuario = '';
	if (!($cookies.nombreUsuario)) {
		console.log("cambie")

		$location.path('/login')
	}else {
		
		$scope.usuario = $cookies.nombreUsuario
	}
	
	
	
});
		