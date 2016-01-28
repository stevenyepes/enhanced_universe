'use strict';

angular
		.module('app.galaxia_user', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/galaxia_user', {
				templateUrl : 'galaxia_userview/galaxia_user.html',
				controller : 'galaxiaUserCtrl'
			});
		} ])
		.controller(
				'galaxiaUserCtrl',
				function($scope, $http, $filter, galaxiaService,
						tipoGalaxiaService) {

					$scope.galaxias = [];
					galaxiaService.getAll().success(function(data) {

						$scope.galaxias = data;
					});
				})
		.service(
				'galaxiaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/galaxia/',

						})
					}

				});
		