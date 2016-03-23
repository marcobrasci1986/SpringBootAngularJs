(function (angular) {
    var LoginController = function ($http, $rootScope, $location) {

        var vm = this;


        var authenticate = function(credentials, callback) {
            var headers = credentials ? {
                authorization : "Basic "
                + btoa(credentials.username + ":"
                    + credentials.password)
            } : {};

            $http.get('user', {
                headers : headers
            }).success(function(data) {
                if (data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback($rootScope.authenticated);
            }).error(function(error) {
                if(error.status == 401){
                    vm.error = "You are not authorized 401";
                }else{
                    vm.error = "Something went wrong";
                }
                $rootScope.authenticated = false;
                callback && callback(false);
            });

        };

        authenticate();
        vm.credentials = {};

        vm.login = function () {
            authenticate(vm.credentials, function (authenticated) {
                if (authenticated) {
                    console.log("Login succeeded");
                    $location.path("/");
                    $rootScope.authenticated = true;
                } else {
                    $location.path("/login");
                    console.log("Login failed");
                    $rootScope.authenticated = false;
                }
            });
        };


        vm.logout = function () {
            $http.post('logout', {}).finally(function () {
                $rootScope.authenticated = false;
                $location.path("/");
            });
        };

    };

    LoginController.$inject = ['$http', '$rootScope', '$location'];
    angular.module("myApp.controllers").controller("LoginController", LoginController);
}(angular));