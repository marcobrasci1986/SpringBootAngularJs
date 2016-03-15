(function (angular) {
    var ItemController = function (ItemService) {

        var vm = this;

        setup();


        function setup() {
            ItemService.getList().then(function (data) {
                vm.items = data ? data : [];
            }, function (error) {
                console.log('Error: ' + error);
            });
        }


        vm.addItem = function (description) {
            var newItem = {
                description: description,
                checked: false
            };

            ItemService.createItem(newItem).then(function () {
                console.log('Insert complete. Refreshing list');
                vm.getList();
            }, function (error) {
                console.log('Error: ' + error);
            });
        };

        vm.updateItem = function (item) {
            console.log('Update item');
        };

        vm.deleteItem = function (item) {
            console.log('Update item');
        };

        //$scope.addItem = function(description) {
        //  new Item({
        //    description: description,
        //    checked: false
        //  }).$save(function(item) {
        //    $scope.items.push(item);
        //  });
        //  $scope.newItem = "";
        //};

        //$scope.updateItem = function(item) {
        //  item.$update();
        //};

        //$scope.deleteItem = function(item) {
        //  item.$remove(function() {
        //    $scope.items.splice($scope.items.indexOf(item), 1);
        //  });
        //};
    };

    ItemController.$inject = ['ItemService'];
    angular.module("myApp.controllers").controller("ItemController", ItemController);
}(angular));