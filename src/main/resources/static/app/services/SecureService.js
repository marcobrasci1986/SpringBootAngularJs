(function (angular) {
    var SecureService = function (Restangular) {

        // set the main route
        var securedItems = Restangular.all('secure');

        var publicAPI = {
            getList: getList
        };

        function getList() {
            return securedItems.getList();
        }


        return publicAPI;
    };

    SecureService.$inject = ['Restangular'];
    angular.module("myApp.services").factory("SecureService", SecureService);
}(angular));