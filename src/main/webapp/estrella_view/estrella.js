'use strict';

angular
		.module('app.estrella', [ 'ngRoute' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/estrella', {
				templateUrl : 'estrella_view/estrella.html',
				controller : 'estrellaCtrl'
			});
		} ])
		.controller(
				'estrellaCtrl',
				function($scope, $http, $filter, estrellaService,
						galaxiaService, tipoEspectralService) {

					$scope.estrellas = [];

					$scope.galaxias = [];
					
					$scope.tiposespectrales = [];
					
					
					estrellaService.getAll().success(function(data) {

						$scope.estrellas = data;
					});					
					

					$scope.galaxia = {
						nombre : "x"
					}
					
					$scope.tipoespectral = {
							nombre : "x"
						}

					galaxiaService.getAll().success(function(data) {
						$scope.galaxias = data;
						console.log(data);
					});
					
					tipoEspectralService.getAll().success(function(data) {
						$scope.tiposespectrales = data;
						console.log(data);
					});


					// marcar una galaxia como eliminada
					$scope.eliminarEstrella = function(estrella) {
						var filtered = $filter('filter')($scope.estrellas, {
							nombre : estrella.nombre
						});
						console.log(filtered);
						if (filtered.length) {
							filtered[0].isDeleted = true;
						}
					};

					// cancelar los cambios
					$scope.cancel = function() {
						for (var i = $scope.estrellas.length; i--;) {
							var estrella = $scope.estrellas[i];
							// undelete
							if (estrella.isDeleted) {
								delete galaxia.isDeleted;
							}
							// remove new
							if (estrella.isNew) {
								$scope.estrellas.splice(i, 1);
							}
						}
						;
					};

					// mostrar los tipos de galaxia
					$scope.showStatus = function(estrella) {
						var selected = [];
						if (estrella.galaxia) {
							selected = $filter('filter')($scope.galaxias, {
								nombre : estrella.galaxia.nombre
							});

						}
						return selected.length ? selected[0].nombre : 'Not set';
					};
					
					$scope.showStatus2 = function(estrella) {
						var selected = [];
						if (estrella.tipoespectral) {
							selected = $filter('filter')($scope.tiposespectrales, {
								clasificacion : estrella.tipoespectral.clasificacion
							});

						}
						return selected.length ? selected[0].clasificacion : 'Not set';
					};

					$scope.addEstrella = function() {
						$scope.estrellas.push({								    
							    nombre: 'nombre',
							    tipoespectral: {
							      clasificacion: null							      
							    },
							    temperatura: null,
							    clase: null,
							    masa: null,
							    diametro: null,
							    galaxia: {							      
							      nombre: null						       
							      },						  
							    isNew : true
						});
					};

					$scope.enviar = function() {

						// var results = [];
						for (var i = $scope.estrellas.length; i--;) {
							var estrella = $scope.estrellas[i];
							// actually delete user
							if (estrella.isDeleted) {
								$scope.estrellas.splice(i, 1);
								$scope.eliminar(estrella);
							} else {
								// mark as not new
								if (estrella.isNew) {
									estrella.isNew = false;
									// send on server

									$http(
											{
												method : 'POST',
												url : 'http://localhost:8080/enhanced_universe/rest/estrella/',
												// headers: headers,
												data : {
													nombre: estrella.nombre,
												    tipoespectral: {
												      clasificacion: estrella.tipoespectral.clasificacion							      
												    },
												    temperatura: estrella.temperatura,
												    clase: estrella.clase,
												    masa: estrella.masa,
												    diametro: estrella.diametro,
												    galaxia: {							      
												      nombre: estrella.galaxia.nombre						       
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
												url : 'http://localhost:8080/enhanced_universe/rest/estrella/',
												// headers: headers,
												data : {
													nombre: estrella.nombre,
												    tipoespectral: {
												      clasificacion: estrella.tipoespectral.clasificacion							      
												    },
												    temperatura: estrella.temperatura,
												    clase: estrella.clase,
												    masa: estrella.masa,
												    diametro: estrella.diametro,
												    galaxia: {							      
												      nombre: estrella.galaxia.nombre						       
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
									url : 'http://localhost:8080/enhanced_universe/rest/estrella/'
											+ data.nombre,
								}).success(function() {
							alert('Eliminado');
							estrellaService.getAll().success(function(data) {

								$scope.estrellas = data;
							});
						});

					}

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

				})
		.service(
				'tipoEspectralService',
				function($http) {

					this.getAll = function() {

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/tipoespectral/',

						})
					}

				});