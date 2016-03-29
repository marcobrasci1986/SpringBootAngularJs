(function (angular) {
    var SecureAdminService = function (Restangular) {

        // set the main route
        var securedAdminItems = Restangular.all('secureAdmin');

        var publicAPI = {
            getList: getList
        };

        function getList() {
            return securedAdminItems.getList();
        }


        return publicAPI;
    };

    SecureAdminService.$inject = ['Restangular'];
    angular.module("myApp.services").factory("SecureAdminService", SecureAdminService);
}(angular));