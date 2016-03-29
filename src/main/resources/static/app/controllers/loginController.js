(function (angular) {
    var LoginController = function ($http, $location, SecurityService) {

        var vmLogin = this;

        vmLogin.SecurityService = SecurityService;

        authenticate();

        vmLogin.credentials = {};

        function authenticate() {
            SecurityService.authenticate(vmLogin.credentials).then(function (data) {
                if (data.name) {
                    console.log("Login succeeded");
                    SecurityService.authenticated = true;
                    SecurityService.username = data.name;
                    SecurityService.roles = data.authorities;
                    //$location.path("/");
                } else {
                    console.log("Login failed");
                    SecurityService.authenticated = false;
                    console.log("User is not logged in");
                }

            }, function (error) {

                vmLogin.error = "Login ot successfull";
                console.log("User is not logged in");
            });
        };

        vmLogin.login = function () {
            authenticate();
        };


        vmLogin.logout = function () {

            SecurityService.logout().then(function () {
                console.log('logout success');
            }, function (error) {
                console.log('error logout');
            }).finally(function () {
                SecurityService.authenticated = false;
                $location.path("/");
            });

        };

        vmLogin.customLogout  = function () {
            console.log('Custom logout');
            SecurityService.customLogout();

            SecurityService.authenticated = false;
            $location.path("/");
        }


    };

    LoginController.$inject = ['$http', '$location', 'SecurityService'];
    angular.module("myApp.controllers").controller("LoginController", LoginController);
}(angular));