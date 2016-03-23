(function (angular) {
    var LoginController = function ($http, $location, $rootScope, SecurityService) {

        var vmLogin = this;

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
                    vmLogin.error = "You are not authorized 401";
                }else{
                    vmLogin.error = "Something went wrong";
                }
                callback && callback(false);
            });

        };

        authenticate();
        vmLogin.credentials = {};

        vmLogin.login = function () {
            authenticate(vmLogin.credentials, function (authenticated) {
                if (authenticated) {
                    console.log("Login succeeded");
                    $location.path("/");

                } else {
                    $location.path("/login");
                    console.log("Login failed");
                }
            });
        };


        vmLogin.logout = function () {
            $http.post('logout', {}).finally(function () {
                $rootScope.authenticated = false;
                $location.path("/");
            });
        };


    };

    LoginController.$inject = ['$http', '$location', '$rootScope', 'SecurityService'];
    angular.module("myApp.controllers").controller("LoginController", LoginController);
}(angular));