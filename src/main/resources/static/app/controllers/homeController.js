(function (angular) {
    var HomeController = function ($http, SecurityService) {

        var vm = this;
        vm.SecurityService = SecurityService;

        vm.test = {
            name: 'marco'
        };

        var test2 = vm.test;

        console.log(vm.test);
        console.log(test2);

        //vm.test.name = "changed";
        test2.name = "changed2";

        console.log(vm.test);
        console.log(test2);

        $http.get('/resource/').success(function (data) {
            vm.greeting = data;
        })


    };

    HomeController.$inject = ['$http', 'SecurityService'];
    angular.module("myApp.controllers").controller("HomeController", HomeController);
}(angular));