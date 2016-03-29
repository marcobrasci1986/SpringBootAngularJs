(function (angular) {
    var SecurityService = function ($http, Restangular) {
        //var securityEndpoint = Restangular.all('logout');
        var securityEndpoint = Restangular.all('customLogout');

        var authenticated = false;
        var roles = [];
        var username = undefined;


        /**
         * Logs the user out
         * @returns {*}
         */
        // customPOST([elem, path, params, headers])
        var logout = function () {
            return securityEndpoint.customPOST({}, "", {}, {});
        };

        var customLogout = function () {
            $http({
                method: 'GET',
                url: '/customLogout'
            }).then(function successCallback(response) {
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
        };

        // customGET(path, [params, headers])
        var authenticate = function (credentials) {
            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.username + ":"
                    + credentials.password)
            } : {};

            return Restangular.all("user").customGET("", {}, headers);

        };


        return {
            authenticated: authenticated,
            authenticate: authenticate,
            logout: logout,
            customLogout: customLogout,
            roles: roles,
            username: username
        }

    };

    SecurityService.$inject = ['$http','Restangular'];
    angular.module("myApp.services").factory("SecurityService", SecurityService);
}(angular));