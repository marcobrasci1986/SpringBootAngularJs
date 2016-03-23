(function (angular) {
    var SecurityService = function () {
        var credentials = {};
        var authenticated = false;



        return {
            credentials : credentials,
            authenticated : authenticated
        }

    };

    SecurityService.$inject = [];
    angular.module("myApp.services").factory("SecurityService", SecurityService);
}(angular));