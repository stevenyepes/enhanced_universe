'use strict';

angular.module('app.login', [ 'ngRoute' , 'ngCookies'])

.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/login', {
				templateUrl : 'login_view/login.html',
				controller : 'loginCtrl'
			});
		} ])
		
.controller('loginCtrl', function($scope, $http, $cookies,$location, validacionService) {
	
	$scope.validar = function() {

		validacionService.validar($scope.nombreUsuario, $scope.contrasena).success(
				function(data) {

					if (data.validado) {
						$cookies.usuario = $scope.nombreUsuario;
						$location.path('/admin')
					} else {

						alert('usuario invalido');
					}

				})
	}
	
})
.service('validacionService',function($http, $cookies) {

					this.validar = function(user, pwd) {

						$cookies.nombreUsuario = user;

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/administrador/login/'+
							user+'/'+pwd,
							

						})
					}

				});;