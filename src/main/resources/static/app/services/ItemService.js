(function (angular) {
    var ItemService = function (Restangular) {

        // set the main route
        var items = Restangular.all('items');

        var publicAPI = {
            getList: getList,
            createItem: createItem
        };

        function getList() {
            return items.getList();
        }

        function createItem(item) {
            return items.post(item);
        }


        return publicAPI;
    };

    ItemService.$inject = ['Restangular'];
    angular.module("myApp.services").factory("ItemService", ItemService);
}(angular));