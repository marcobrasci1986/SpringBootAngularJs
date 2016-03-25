(function (angular) {
    var SecurityService = function (Restangular) {
        var securityEndpoint = Restangular.all('logout');

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
            roles: roles,
            username: username
        }

    };

    SecurityService.$inject = ['Restangular'];
    angular.module("myApp.services").factory("SecurityService", SecurityService);
}(angular));