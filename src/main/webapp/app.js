var app = angular.module('app',[
                                'ngRoute',
                                'ngCookies',
                                'app.addGalaxia',
                                'app.galaxia' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {

		templateUrl : 'templates/principal.html',
		controller : 'principalCtrl'
	});

	$routeProvider.when('/login', {

		templateUrl : 'templates/login.html',
		controller : 'contLogin'
	});

	$routeProvider.otherwise('/');
} ]);

app.controller('principalCtrl', function($scope) {

});

app.controller('contLogin', function($scope, usuario) {

	$scope.validar = function() {

		usuario.validar($scope.nombreUsuario, $scope.contrasena).success(
				function(data) {

					if (data != '') {
						alert(data);
					} else {

						alert('valido');
					}

				})
	}

});



app.service('usuario',function($http, $cookies) {

					this.validar = function(user, pwd) {

						$cookies.nombreUsuario = user;

						return $http({

							method : 'GET',
							url : 'http://localhost:8080/enhanced_universe/rest/administrador/login',
							params : {
								login : user,
								contrasena : pwd
							}

						})
					}

				});

app.service('galaxia', function($http) {

	this.getAll = function() {

		return $http({

			method : 'GET',
			url : 'http://localhost:8080/enhanced_universe/rest/galaxia/',

		})
	}

});

app.run(function($rootScope, $cookies, $location) {

	$rootScope.$on('$routChangeStart', function() {
		if (typeOf($cookies.nombreUsuario) == 'undefined') {

			$location.url('#/login')
		}
	});
});
