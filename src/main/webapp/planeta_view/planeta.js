'use strict';

angular
		.module('app.planeta', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/planeta', {
				templateUrl : 'planeta_view/planeta.html',
				controller : 'planetaCtrl'
			});
		} ])
		.controller(
				'planetaCtrl',
				function($scope, $http, $filter, galaxiaService,
						planetaService) {

					$scope.planetas = [];

					$scope.galaxias = [];
					planetaService.getAll().success(function(data) {

						$scope.planetas = data;
					});

					$scope.galaxia = {
						nombre : "x"
					}

					galaxiaService.getAll().success(function(data) {
						$scope.galaxias = data;
						console.log(data);
					});

					// marcar una galaxia como eliminada
					$scope.eliminarPlaneta = function(planeta) {
						var filtered = $filter('filter')($scope.planetas, {
							nombre : planeta.nombre
						});
						console.log(filtered);
						if (filtered.length) {
							filtered[0].isDeleted = true;
						}
					};

					// cancelar los cambios
					$scope.cancel = function() {
						for (var i = $scope.planetas.length; i--;) {
							var planeta = $scope.planetas[i];
							// undelete
							if (planeta.isDeleted) {
								delete planeta.isDeleted;
							}
							// remove new
							if (planeta.isNew) {
								$scope.planetas.splice(i, 1);
							}
						}
						;
					};

					// mostrar los tipos de galaxia
					$scope.showStatus = function(planeta) {
						var selected = [];
						if (planeta.galaxia) {
							selected = $filter('filter')($scope.galaxias, {
								nombre : planeta.galaxia.nombre
							});

						}
						return selected.length ? selected[0].nombre : 'Not set';
					};

					$scope.addPlaneta = function() {
						$scope.planetas.push({							
							    nombre: 'nombre',
							    masa: null,
							    gravedad: null,
							    diametro: null,
							    temperatura: null,
							    periodorotacional: null,
							    periodoorbital: null,
							    distanciatierra: null,
							    galaxia: {							      
							      nombre: null						        
							      },							  
							    isNew : true
						});
					};

					$scope.enviar = function() {

						// var results = [];
						for (var i = $scope.planetas.length; i--;) {
							var planeta = $scope.planetas[i];
							// actually delete user
							if (planeta.isDeleted) {
								$scope.planetas.splice(i, 1);
								$scope.eliminar(planeta);
							} else {
								// mark as not new
								if (planeta.isNew) {
									planeta.isNew = false;
									// send on server

									$http(
											{
												method : 'POST',
												url : 'http://localhost:8080/enhanced_universe/rest/planeta/',
												// headers: headers,
												data : {
													nombre: planeta.nombre,
												    masa: planeta.masa,
												    gravedad: planeta.gravedad,
												    diametro: planeta.diametro,
												    temperatura: planeta.temperatura,
												    periodorotacional: planeta.periodorotacional,
												    periodoorbital: planeta.periodoorbital,
												    distanciatierra: planeta.distanaciatierra,
												    galaxia: {							      
												      nombre: planeta.galaxia.nombre						        
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
												url : 'http://localhost:8080/enhanced_universe/rest/planeta/',
												// headers: headers,
												data : {
													nombre: planeta.nombre,
												    masa: planeta.masa,
												    gravedad: planeta.gravedad,
												    diametro: planeta.diametro,
												    temperatura: planeta.temperatura,
												    periodorotacional: planeta.periodorotacional,
												    periodoorbital: planeta.periodoorbital,
												    distanciatierra: planeta.distanaciatierra,
												    galaxia: {							      
												      nombre: planeta.galaxia.nombre						        
												      },	
												}

											}).success(function() {
										console.log('actualizado')

										// $location.path("/galaxia")
									});									
								}
							}
						}

					}

					$scope.eliminar = function(data) {

						$http(
								{
									method : 'DELETE',
									url : 'http://localhost:8080/enhanced_universe/rest/planeta/'
											+ data.nombre,
								}).success(function() {
							alert('Eliminado');
							planetaService.getAll().success(function(data) {

								$scope.planetas = data;
							});
						});

					}

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