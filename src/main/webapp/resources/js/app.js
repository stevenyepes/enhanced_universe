var app = angular.module('app',[
                                'ngRoute',
                                'ngCookies']);

app.config(['$routeProvider',function($routeProvider){
	
	$routeProvider.when('/', {
		
		templateUrl : 'templates/principal.html',
		controller: 'principalCtrl'
	});
	
	$routeProvider.when('/login', {
		
		templateUrl : 'templates/login.html',
		controller: 'contLogin'
	});
	
	$routeProvider.when('/galaxia', {
		
		templateUrl : 'templates/galaxias.html',
		controller: 'galaxiaCtrl'
	});
	
	$routeProvider.when('/agregarGalaxia', {
		
		templateUrl : 'templates/agregarGalaxia.html',
		controller: 'agregarGalaxiaCtrl'
	});
	
	$routeProvider.otherwise('/');
}]);

app.controller('principalCtrl', function($scope){
	

});


app.controller('contLogin', function($scope, usuario){
	
	$scope.validar= function(){
		
		usuario.validar($scope.nombreUsuario,
				$scope.contrasena)
				.success(function(data){
					
					if(data != '') {
						alert(data);
					}else {
						
						alert('valido');
					}
					
					
				})
	}

});
    
app.controller('galaxiaCtrl', function($scope, galaxia){
	
	$scope.galaxias = [];
	galaxia.getAll().success(function(data){
		
		$scope.galaxias = data;
	});
	
	
	

});

app.controller('agregarGalaxiaCtrl', function($scope, $http, tipoGalaxiaService){
	
	$scope.tipoGalaxias = [];
	tipoGalaxiaService.getAll().success(function(data) {
		
		$scope.tipoGalaxias = data;
		
	}) ;
	
	/*$http({
		
		method: 'POST',
		url: 'http://localhost:8080/enhanced_universe/rest/galaxia/',
		data: {
			
			nombre: "andromeda V",
		    tipogalaxia: {
		      id: 1,
		      nombre: "espiral"
		    },
		    alto: 847769,
		    ancho: 46,
		    profundidad: 457646,
		    diametro: 123456,
		    distanciatierra: 5847564645
		}
		
	}).success(function(data){
		
		
	});*/
		
	
	
	
	

});

app.service('usuario',function($http) {
	
	this.validar = function(user,pwd) {

		
		return $http({
			
			method: 'POST',
			url: 'http://localhost:8080/enhanced_universe/rest/administrador/login',
			data: {
				login : user,
				contrasena : pwd
			}
			
		})
	}
	
	
});

app.service('galaxia',function($http) {
	
	this.getAll = function() {
		
		return $http({
			
			method: 'GET',
			url: 'http://localhost:8080/enhanced_universe/rest/galaxia/',
			
		})
	}
	
	
});


app.service('tipoGalaxiaService',function($http) {
	
	this.getAll = function() {
		
		return $http({
			
			method: 'GET',
			url: 'http://localhost:8080/enhanced_universe/rest/tipogalaxia/',
			
		})
	}
	
	
});
	
