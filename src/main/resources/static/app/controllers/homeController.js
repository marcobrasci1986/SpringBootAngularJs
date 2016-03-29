(function (angular) {
    var HomeController = function ($http, SecurityService, SecureAdminService, SecureUserService) {

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
        });


        vm.getSecuredAdminResource = function () {
            SecureAdminService.getList().then(function (data) {
                console.log(data);
            }, function (error) {
                console.log('error: ' + error);
            });
        };

        vm.getSecuredUserResource = function () {
            SecureUserService.getList().then(function (data) {
                console.log(data);
            }, function (error) {
                console.log('error: ' + error);
            });
        };





    };

    HomeController.$inject = ['$http', 'SecurityService', 'SecureAdminService', 'SecureUserService'];
    angular.module("myApp.controllers").controller("HomeController", HomeController);
}(angular));