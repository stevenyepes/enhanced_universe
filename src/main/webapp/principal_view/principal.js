'use strict';

angular.module('app.Principal', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
	
	$routeProvider.when('/', {
	    templateUrl: 'principal_view/principal.html',
	    controller: 'principalCtrl'
	  });
}])
.controller('principalCtrl', function($scope) {

});