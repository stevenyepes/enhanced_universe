'use strict';

angular
		.module('app.asteroide_user', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/asteroide_user', {
				templateUrl : 'asteroide_userview/asteroide_user.html',
				controller : 'asteroideUserCtrl'
			});
		} ])
		.controller(
				'asteroideUserCtrl',
				function($scope, $http, asteroideService) {

					$scope.asteroides = [];
					asteroideService.getAll().success(function(data) {

						$scope.asteroides = data;
					});
				})
		.service(
				'asteroideService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/asteroide/',

						})
					}

				});
		