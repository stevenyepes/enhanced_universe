'use strict';

angular
		.module('app.cometa', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/cometa', {
				templateUrl : 'cometa_view/cometa.html',
				controller : 'cometaCtrl'
			});
		} ])
		.controller(
				'cometaCtrl',
				function($scope, $http, $filter, cometaService,
						galaxiaService) {

					$scope.cometas = [];

					$scope.galaxias = [];
					cometaService.getAll().success(function(data) {

						$scope.cometas = data;
					});

					$scope.galaxia = {
						nombre : "x"
					}

					galaxiaService.getAll().success(function(data) {
						$scope.galaxias = data;
						console.log(data);
					});

					// marcar una galaxia como eliminada
					$scope.eliminarCometa = function(cometa) {
						var filtered = $filter('filter')($scope.cometas, {
							nombre : cometa.nombre
						});
						console.log(filtered);
						if (filtered.length) {
							filtered[0].isDeleted = true;
						}
					};

					// cancelar los cambios
					$scope.cancel = function() {
						for (var i = $scope.cometas.length; i--;) {
							var cometa = $scope.cometas[i];
							// undelete
							if (cometa.isDeleted) {
								delete cometa.isDeleted;
							}
							// remove new
							if (cometa.isNew) {
								$scope.cometas.splice(i, 1);
							}
						}
						;
					};

					// mostrar los tipos de galaxia
					$scope.showStatus = function(cometa) {
						var selected = [];
						if (cometa.galaxia) {
							selected = $filter('filter')($scope.galaxias, {
								nombre : cometa.galaxia.nombre
							});

						}
						return selected.length ? selected[0].nombre : 'Not set';
					};

					$scope.addCometa = function() {
						$scope.cometas.push({								    
							    nombre: 'nombre',
							    diametro: null,
							    periodoorbital: null,
							    ultimoperihelio: null,
							    galaxia: {							     
							      nombre: null						        
							      },						  
							    isNew : true
						});
					};

					$scope.enviar = function() {

						// var results = [];
						for (var i = $scope.cometas.length; i--;) {
							var cometa = $scope.cometas[i];
							// actually delete user
							if (cometa.isDeleted) {
								$scope.cometas.splice(i, 1);
								$scope.eliminar(cometa);
							} else {
								// mark as not new
								if (cometa.isNew) {
									cometa.isNew = false;
									// send on server

									$http(
											{
												method : 'POST',
												url : 'http://localhost:8084/enhanced_universe/rest/cometa/',
												// headers: headers,
												data : {
													 	nombre: cometa.nombre,
													    diametro: cometa.diametro,
													    periodoorbital: cometa.periodoorbital,
													    ultimoperihelio: cometa.ultimoperihelio,
													    galaxia: {							     
													      nombre: cometa.galaxia.nombre						        
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
												url : 'http://localhost:8084/enhanced_universe/rest/cometa/',
												// headers: headers,
												data : {
													nombre: cometa.nombre,
												    diametro: cometa.diametro,
												    periodoorbital: cometa.periodoorbital,
												    ultimoperihelio: cometa.ultimoperihelio,
												    galaxia: {							     
												      nombre: cometa.galaxia.nombre						        
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
									url : 'http://localhost:8084/enhanced_universe/rest/cometa/'
											+ data.nombre,
								}).success(function() {
							alert('Eliminado');
							cometaService.getAll().success(function(data) {

								$scope.cometas = data;
							});
						});

					}

				})
		.service(
				'cometaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8084/enhanced_universe/rest/cometa/',

						})
					}

				})
		.service(
				'galaxiaService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8084/enhanced_universe/rest/galaxia/',

						})
					}

				});