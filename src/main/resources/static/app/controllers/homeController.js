(function (angular) {
    var HomeController = function () {

        var vm = this;

        setup();


        function setup() {
            console.log('HomeController');
        }


    };

    HomeController.$inject = [];
    angular.module("myApp.controllers").controller("HomeController", HomeController);
}(angular));