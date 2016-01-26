'use strict';

angular.module('app.addGalaxia', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/addGalaxia', {
    templateUrl: 'add_galaxia_view/addGalaxia.html',
    controller: 'addGalaxiaCtrl'
  });
}])

.controller('addGalaxiaCtrl', function($scope, $http,$location,tipoGalaxiaService){
	
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
	        }).success(function() {
	            alert('guardado');
	            $location.path("/galaxia")
	        });
	}
		
	
	
	
	

})
.service('tipoGalaxiaService',function($http) {
	
	this.getAll = function() {
		
		return $http({
			
			method: 'GET',
			url: 'http://localhost:8080/enhanced_universe/rest/tipogalaxia/',
			
		})
	}
	
	
});
