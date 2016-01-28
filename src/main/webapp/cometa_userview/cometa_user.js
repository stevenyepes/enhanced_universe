'use strict';

angular
		.module('app.cometa_user', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/cometa_user', {
				templateUrl : 'cometa_userview/cometa_user.html',
				controller : 'cometaUserCtrl'
			});
		} ])
		.controller(
				'cometaUserCtrl',
				function($scope, $http, cometaService) {

					$scope.cometas = [];
					cometaService.getAll().success(function(data) {

						$scope.cometas = data;
					});
				})
		.service(
				'cometaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/cometa/',

						})
					}

				});
		