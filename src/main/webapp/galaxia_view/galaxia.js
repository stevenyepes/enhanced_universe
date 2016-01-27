'use strict';

angular.module('app.galaxia', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/galaxia', {
    templateUrl: 'galaxia_view/galaxia.html',
    controller: 'galaxiaCtrl'
  });
}])
.controller('galaxiaCtrl', function($scope,$http, $filter,galaxiaService, tipoGalaxiaService) {

	$scope.galaxias = [];
	
	$scope.tipogalaxias = [];
	galaxiaService.getAll().success(function(data) {

		$scope.galaxias = data;
	});
	
	$scope.tipogalaxia = {
			nombre:"x" 
	}
	
	tipoGalaxiaService.getAll().success(function(data) {
		$scope.tipogalaxias = data;
		console.log(data);
	});
	
	
	$scope.showStatus = function(galaxia) {
	    var selected = [];
	    if(galaxia.tipogalaxia) {
	      selected = $filter('filter')($scope.tipogalaxias, {nombre: galaxia.tipogalaxia.nombre});
	      
	    
	    }
	    return selected.length ? selected[0].nombre : 'Not set';
	  };
	  
	  $scope.addUser = function() {
		    $scope.galaxias.push({
		    	nombre : 'nombre',
				tipogalaxia : {
					nombre : null
				},
				ancho : null,
				alto : null,
				profundidad: null,
				diametro: null,
				distanciatierra: null,
				isNew: true
		    });
		  };
	
	  $scope.enviar = function() {
			
		  
		  //var results = [];
		    for (var i = $scope.galaxias.length; i--;) {
		      var galaxia = $scope.galaxias[i];
		      // actually delete user
		      if (galaxia.isDeleted) {
		        $scope.galaxias.splice(i, 1);
		      }
		      // mark as not new 
		      if (galaxia.isNew) {
		        galaxia.isNew = false;
		        // send on server
			      
			      $http({
				        method : 'POST',
				        url : 'http://localhost:8080/enhanced_universe/rest/galaxia/',
				        //headers: headers,
				        data : {
				        	nombre : galaxia.nombre,
							tipogalaxia : {
								nombre : galaxia.tipogalaxia.nombre
							},
							ancho : galaxia.ancho,
							alto : galaxia.alto,
							profundidad: galaxia.profundidad,
							diametro: galaxia.diametro,
							distanciatierra: galaxia.distanciatierra,
				        }
				        	
				        }).success(function() {
				            alert('guardado');
				            
				            //$location.path("/galaxia")
				        });
			        	console.log("aqui ando chaval");
		        
		        
		      }

		     
			 
			 
		    }
	  }
	
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

})
.service('galaxiaService', function($http) {

	this.getAll = function() {

		return $http({

			method : 'GET',
			url : 'http://localhost:8080/enhanced_universe/rest/galaxia/',

		})
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