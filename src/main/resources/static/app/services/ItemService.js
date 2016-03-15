(function (angular) {
    var ItemService = function (Restangular) {

        // set the main route
        var items = Restangular.all('items');

        var publicAPI = {
            getList: getList,
            createItem: createItem,
            findById: findById
        };

        function getList() {
            return items.getList();
        }

        function createItem(item) {
            return items.post(item);
        }

        function findById() {
            return Restangular.one('items', 1).get();
        }


        return publicAPI;
    };

    ItemService.$inject = ['Restangular'];
    angular.module("myApp.services").factory("ItemService", ItemService);
}(angular));