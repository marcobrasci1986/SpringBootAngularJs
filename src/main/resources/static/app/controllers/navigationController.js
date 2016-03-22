(function (angular) {
    var NavigationController = function () {

        var vm = this;

        setup();


        function setup() {
            console.log('NavigationController');
        }


    };

    NavigationController.$inject = [];
    angular.module("myApp.controllers").controller("NavigationController", NavigationController);
}(angular));