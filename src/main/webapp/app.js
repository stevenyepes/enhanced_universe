var app = angular.module('app',[
                                'ngRoute',
                                'ngCookies',
                                'xeditable',
                                'app.galaxia',
                                'app.planeta',
                                'app.asteroide',
                                'app.cometa',
                                'app.satelite',
                                'app.estrella',
                                'app.api',
                                'app.Principal',
                                'app.login']);


app.config([ '$routeProvider', function($routeProvider) {


	$routeProvider.otherwise('/');
} ]);


app.run(function($rootScope, $cookies, $location, editableOptions) {

	editableOptions.theme = 'bs3';
	$rootScope.$on('$routChangeStart', function() {
		if (typeOf($cookies.nombreUsuario) == 'undefined') {

			$location.url('#/login')
		}
	});
});
