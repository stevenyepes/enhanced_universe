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
	
	
	
	$scope.enviar = function() {
		
	
	 $http({
	        method : 'POST',
	        url : 'http://localhost:8080/enhanced_universe/rest/galaxia/',
	        //headers: headers,
	        data :{
	        	nombre : $scope.nombre,
				tipogalaxia : {
					nombre : $scope.tipogalaxia
				},
				ancho : $scope.ancho,
				alto : $scope.alto,
				profundidad: $scope.profundidad,
				diametro: $scope.diametro,
				distanciatierra: $scope.distanciatierra,

	           }
	        }).success(function(data) {
	            alert('guardado')
	        });
	}
		
	
	
	
	

});

app.service('usuario',function($http, $cookies) {
	
	this.validar = function(user,pwd) {

		$cookies.nombreUsuario = user;
		
		return $http({
			
			method: 'GET',
			url: 'http://localhost:8080/enhanced_universe/rest/administrador/login',
			params: {
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

app.run(function($rootScope, $cookies, $location){
	
	$rootScope.$on('$routChangeStart', function(){
		if(typeOf($cookies.nombreUsuario) == 'undefined'){
			
			$location.url('#/login')
		}
	});
});


