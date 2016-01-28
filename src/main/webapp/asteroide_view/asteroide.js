'use strict';

angular
		.module('app.asteroide', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/asteroide', {
				templateUrl : 'asteroide_view/asteroide.html',
				controller : 'asteroideCtrl'
			});
		} ])
		.controller(
				'asteroideCtrl',
				function($scope, $http, $filter, galaxiaService,
						asteroideService) {

					$scope.asteroides = [];

					$scope.galaxias = [];
					asteroideService.getAll().success(function(data) {

						$scope.asteroides = data;
					});

					$scope.galaxia = {
						nombre : "x"
					}

					galaxiaService.getAll().success(function(data) {
						$scope.galaxias = data;
						console.log(data);
					});

					// marcar una galaxia como eliminada
					$scope.eliminarAsteroide = function(asteroide) {
						var filtered = $filter('filter')($scope.asteroides, {
							nombre : asteroide.nombre
						});
						console.log(filtered);
						if (filtered.length) {
							filtered[0].isDeleted = true;
						}
					};

					// cancelar los cambios
					$scope.cancel = function() {
						for (var i = $scope.asteroides.length; i--;) {
							var asteroide = $scope.asteroides[i];
							// undelete
							if (asteroide.isDeleted) {
								delete asteroide.isDeleted;
							}
							// remove new
							if (asteroide.isNew) {
								$scope.asteroides.splice(i, 1);
							}
						}
						;
					};

					// mostrar los tipos de galaxia
					$scope.showStatus = function(asteroide) {
						var selected = [];
						if (asteroide.galaxia) {
							selected = $filter('filter')($scope.galaxias, {
								nombre : asteroide.galaxia.nombre
							});

						}
						return selected.length ? selected[0].nombre : 'Not set';
					};

					$scope.addAsteroide = function() {
						$scope.asteroides.push({
							nombre : 'nombre',
							diametro : null,
							peligroso : null,
							galaxia : {
								nombre : null
							},
							isNew : true
						});
					};

					$scope.enviar = function() {

						// var results = [];
						for (var i = $scope.asteroides.length; i--;) {
							var asteroide = $scope.asteroides[i];
							// actually delete user
							if (asteroide.isDeleted) {
								$scope.asteroides.splice(i, 1);
								$scope.eliminar(asteroide);
							} else {
								// mark as not new
								if (asteroide.isNew) {
									asteroide.isNew = false;
									// send on server

									$http(
											{
												method : 'POST',
												url : 'http://localhost:8080/enhanced_universe/rest/asteroide/',
												// headers: headers,
												data : {
													nombre : asteroide.nombre,
													diametro : asteroide.diametro,
													peligroso : asteroide.peligroso,
													galaxia : {
														nombre : asteroide.galaxia.nombre
													},
												}

											}).success(function() {
										alert('guardado');

										// $location.path("/galaxia")
									});

								} else {
									// send on server

									$http(
											{
												method : 'PUT',
												url : 'http://localhost:8080/enhanced_universe/rest/asteroide/',
												// headers: headers,
												data : {
													nombre : asteroide.nombre,
													diametro : asteroide.diametro,
													peligroso : asteroide.peligroso,
													galaxia : {
														nombre : asteroide.galaxia.nombre
													},
												}

											}).success(function() {
										console.log('actualizado')

										// $location.path("/galaxia")
									});
								}
							}

						}

						$scope.eliminar = function(data) {

							$http(
									{
										method : 'DELETE',
										url : 'http://localhost:8080/enhanced_universe/rest/asteroide/'
												+ data.nombre,
									}).success(
									function() {
										alert('Eliminado');
										asteroideService.getAll().success(
												function(data) {

													$scope.asteroides = data;
												});
									});

						}
					}
<<<<<<< HEAD
					
				}

=======
>>>>>>> 24f0d4f22ba4be29d97cdd1712d950c41f71de45
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