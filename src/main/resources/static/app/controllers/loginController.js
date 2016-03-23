(function (angular) {
    var LoginController = function ($http, $location, SecurityService) {

        var vmLogin = this;

        vmLogin.SecurityService = SecurityService;


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
                    SecurityService.authenticated = true;
                } else {
                    SecurityService.authenticated = false;
                }
                callback && callback(SecurityService.authenticated);
            }).error(function(error) {
                if(error.status == 401){
                    vmLogin.error = "You are not authorized 401";
                }else{
                    vmLogin.error = "Something went wrong";
                }
                SecurityService.authenticated = false;
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
                SecurityService.authenticated = false;
                $location.path("/");
            });
        };


    };

    LoginController.$inject = ['$http', '$location', 'SecurityService'];
    angular.module("myApp.controllers").controller("LoginController", LoginController);
}(angular));