'use strict';

angular
		.module('app.satelite_user', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/satelite_user', {
				templateUrl : 'satelite_userview/satelite_user.html',
				controller : 'sateliteUserCtrl'
			});
		} ])
		.controller(
				'sateliteUserCtrl',
				function($scope, $http, sateliteService) {

					$scope.satelites = [];
					sateliteService.getAll().success(function(data) {

						$scope.satelites = data;
					});
				})
		.service(
				'sateliteService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/satelite/',

						})
					}

				});
		