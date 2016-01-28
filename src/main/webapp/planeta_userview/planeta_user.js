'use strict';

angular
		.module('app.planeta_user', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/planeta_user', {
				templateUrl : 'planeta_userview/planeta_user.html',
				controller : 'planetaUserCtrl'
			});
		} ])
		.controller(
				'planetaUserCtrl',
				function($scope, $http, planetaService) {

					$scope.planetas = [];
					planetaService.getAll().success(function(data) {

						$scope.planetas = data;
					});
				})
		.service(
				'planetaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/planeta/',

						})
					}

				});
		