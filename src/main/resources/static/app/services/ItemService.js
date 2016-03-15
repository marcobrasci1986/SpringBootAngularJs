(function(angular) {
  var ItemService = function(Restangular) {

      var items = Restangular.all('items');

    var publicAPI = {
        getList : getList,
        createItem : createItem
    };

    function getList (){
        return items.getList();
    }

      function createItem(item){
          items.post();
      }



    return publicAPI;
  };

    ItemService.$inject = ['Restangular'];
  angular.module("myApp.services").factory("ItemService", ItemService);
}(angular));