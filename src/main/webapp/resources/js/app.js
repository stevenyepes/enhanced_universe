var app = angular.module('app',[
                                'ngRoute',
                                'ngCookies']);

app.config(['$routeProvider',function($routeProvider){
	
	$routeProvider.when('/', {
		
		templateUrl : 'templates/login.html',
		controller: 'contLogin'
	});
	
	$routeProvider.when('/galaxia', {
		
		templateUrl : 'templates/galaxias.html',
		controller: 'galaxiaCtrl'
	});
}]);

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
		log(data);
	});
	
	
	

});

app.service('usuario',function($http) {
	
	this.validar = function(user,pwd) {
		
		return $http({
			
			method: 'GET',
			url: 'http://localhost:8080/enhanced_universe/rest/administrador/'+user+'/' + pwd,
			
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
	
