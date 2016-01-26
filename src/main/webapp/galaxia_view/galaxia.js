'use strict';

angular.module('app.galaxia', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/galaxia', {
    templateUrl: 'galaxia_view/galaxia.html',
    controller: 'galaxiaCtrl'
  });
}])
.controller('galaxiaCtrl', function($scope,$http, galaxiaService) {

	$scope.galaxias = [];
	galaxiaService.getAll().success(function(data) {

		$scope.galaxias = data;
	});
	
	$scope.eliminar = function(data){
		
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/enhanced_universe/rest/galaxia/' + data.nombre ,
		}).success(function() {
            alert('Eliminado');
            galaxiaService.getAll().success(function(data) {

        		$scope.galaxias = data;
        	});
        });
		
	}

}).service('galaxiaService', function($http) {

	this.getAll = function() {

		return $http({

			method : 'GET',
			url : 'http://localhost:8080/enhanced_universe/rest/galaxia/',

		})
	}

});