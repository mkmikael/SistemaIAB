angular.module('starter.controllers', [])

.controller('AppCtrl', function($window, $state, $scope, $ionicModal, $timeout) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  // Form data for the login modal
  $scope.logout = function() {
      console.log('Logout');
      $window.sessionStorage.removeItem('user');
      $state.go('login');
  }; // logout
});
