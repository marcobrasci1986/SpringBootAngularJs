(function (angular) {
    var HomeController = function ($http, SecurityService) {

        var vm = this;
        vm.SecurityService = SecurityService;

        $http.get('/resource/').success(function (data) {
            vm.greeting = data;
        })


    };

    HomeController.$inject = ['$http', 'SecurityService'];
    angular.module("myApp.controllers").controller("HomeController", HomeController);
}(angular));