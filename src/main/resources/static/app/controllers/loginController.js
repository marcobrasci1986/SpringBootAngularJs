(function (angular) {
    var LoginController = function () {

        var controller = this;

        setup();


        function setup() {
            console.log('LoginController');
        }

        controller.login = function () {
            console.log("Login");
        }



    };

    LoginController.$inject = [];
    angular.module("myApp.controllers").controller("LoginController", LoginController);
}(angular));