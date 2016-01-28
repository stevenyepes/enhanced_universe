'use strict';

angular
		.module('app.satelite', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/satelite', {
				templateUrl : 'satelite_view/satelite.html',
				controller : 'sateliteCtrl'
			});
		} ])
		.controller(
				'sateliteCtrl',
				function($scope, $http, $filter, sateliteService,
						planetaService) {

					$scope.satelites = [];

					$scope.planetas = [];
					sateliteService.getAll().success(function(data) {

						$scope.satelites = data;
					});
					
					$scope.planeta = {
						nombre : "x"
					}

					planetaService.getAll().success(function(data) {
						$scope.planetas = data;
						console.log(data);
					});

					// marcar una galaxia como eliminada
					$scope.eliminarSatelite = function(satelite) {
						var filtered = $filter('filter')($scope.satelites, {
							nombre : satelite.nombre
						});
						console.log(filtered);
						if (filtered.length) {
							filtered[0].isDeleted = true;
						}
					};

					// cancelar los cambios
					$scope.cancel = function() {
						for (var i = $scope.satelites.length; i--;) {
							var satelite = $scope.satelites[i];
							// undelete
							if (satelite.isDeleted) {
								delete satelite.isDeleted;
							}
							// remove new
							if (satelite.isNew) {
								$scope.satelites.splice(i, 1);
							}
						}
						;
					};

					// mostrar los tipos de galaxia
					$scope.showStatus = function(satelite) {
						var selected = [];
						if (satelite.planeta) {
							selected = $filter('filter')($scope.planetas, {
								nombre : satelite.planeta.nombre
							});

						}
						return selected.length ? selected[0].nombre : 'Not set';
					};

					$scope.addSatelite = function() {
						$scope.satelites.push({							  
							    nombre: 'nombre',
							    masa: null,
							    gravedad: null,
							    diametro: null,
							    temperatura: null,
							    periodorotacional: null,
							    periodoorbital: null,
							    planeta: {
							      nombre: null,					       
							      },							  
							    isNew : true
						});
					};

					$scope.enviar = function() {

						// var results = [];
						for (var i = $scope.satelites.length; i--;) {
							var satelite = $scope.satelites[i];
							// actually delete user
							if (satelite.isDeleted) {
								$scope.satelites.splice(i, 1);
								$scope.eliminar(satelite);
							} else {
								// mark as not new
								if (satelite.isNew) {
									satelite.isNew = false;
									// send on server

									$http(
											{
												method : 'POST',
												url : 'http://localhost:8084/enhanced_universe/rest/satelite/',
												// headers: headers,
												data : {
													 	nombre: satelite.nombre ,
													    masa: satelite.masa,
													    gravedad: satelite.gravedad,
													    diametro: satelite.diametro,
													    temperatura: satelite.temperatura,
													    periodorotacional: satelite.periodorotacional,
													    periodoorbital: satelite.periodoorbital,
													    planeta: {
													      nombre: satelite.planeta.nombre,					       
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
												url : 'http://localhost:8084/enhanced_universe/rest/satelite/',
												// headers: headers,
												data : {
													nombre: satelite.nombre ,
												    masa: satelite.masa,
												    gravedad: satelite.gravedad,
												    diametro: satelite.diametro,
												    temperatura: satelite.temperatura,
												    periodorotacional: satelite.periodorotacional,
												    periodoorbital: satelite.periodoorbital,
												    planeta: {
												      nombre: satelite.planeta.nombre,					       
												      },	
												}

											}).success(function() {
										console.log('actualizado')

										// $location.path("/galaxia")
									});
									console.log("aqui ando chaval");
								}
							}
						}

					}

					$scope.eliminar = function(data) {

						$http(
								{
									method : 'DELETE',
									url : 'http://localhost:8084/enhanced_universe/rest/satelite/'
											+ data.nombre,
								}).success(function() {
							alert('Eliminado');
							sateliteService.getAll().success(function(data) {

								$scope.satelites = data;
							});
						});

					}

				})
		.service(
				'sateliteService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8084/enhanced_universe/rest/satelite/',

						})
					}

				})
		.service(
				'planetaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8084/enhanced_universe/rest/planeta/',

						})
					}

				});