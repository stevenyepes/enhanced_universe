'use strict';

angular.module('app.api', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/api', {
    templateUrl: 'api_view/api.html',
    controller: 'apiCtrl'
  });
}])
.controller('apiCtrl', function($scope) {

});
