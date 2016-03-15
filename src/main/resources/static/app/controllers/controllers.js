(function(angular) {
  var AppController = function($scope, ItemService) {
    
    ItemService.getList().then(function (data) {
      $scope.items = data ? data : [];
    }, function (error) {
      console.log('Error: ' + error);
    })
    
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
  
  AppController.$inject = ['$scope', 'ItemService'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));