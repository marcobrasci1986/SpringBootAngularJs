(function (angular) {
    var SecureUserService = function (Restangular) {

        // set the main route
        var securedUserItems = Restangular.all('secureUser');

        var publicAPI = {
            getList: getList
        };

        function getList() {
            return securedUserItems.getList();
        }


        return publicAPI;
    };

    SecureUserService.$inject = ['Restangular'];
    angular.module("myApp.services").factory("SecureUserService", SecureUserService);
}(angular));