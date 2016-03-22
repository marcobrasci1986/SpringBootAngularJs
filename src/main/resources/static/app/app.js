(function (angular) {

    angular.module("myApp.controllers", []);
    angular.module("myApp.services", []);

    var app = angular.module("myApp", ["myApp.controllers", "myApp.services", "restangular", "ngRoute"]);


    app.config(function ($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl: './app/views/home.html',
            controller: 'HomeController',
            controllerAs: 'controller'
        }).when('/login', {
            templateUrl: './app/views/login.html',
            controller: 'NavigationController',
            controllerAs: 'controller'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    });

    /**
     * Set the default route for all requests
     */
    //app.config(function(RestangularProvider) {
    //    RestangularProvider.setBaseUrl('/springBootAngular');
    //});
}(angular));