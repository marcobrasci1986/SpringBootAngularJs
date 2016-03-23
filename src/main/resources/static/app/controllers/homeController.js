(function (angular) {
    var HomeController = function ($http) {

        var vm = this;


        $http.get('/resource/').success(function (data) {
            vm.greeting = data;
        })


    };

    HomeController.$inject = ['$http'];
    angular.module("myApp.controllers").controller("HomeController", HomeController);
}(angular));