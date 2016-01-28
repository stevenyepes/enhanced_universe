'use strict';

angular
		.module('app.estrella_user', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/estrella_user', {
				templateUrl : 'estrella_userview/estrella_user.html',
				controller : 'estrellaUserCtrl'
			});
		} ])
		.controller(
				'estrellaUserCtrl',
				function($scope, $http, estrellaService) {

					$scope.estrellas = [];
					estrellaService.getAll().success(function(data) {

						$scope.estrellas = data;
					});
				})
		.service(
				'estrellaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/estrella/',

						})
					}

				});
		