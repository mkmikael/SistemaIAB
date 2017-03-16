// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers'])

.constant("URL_SERVER", "http://192.168.100.3:8080")

.factory('authInterceptor', function ($rootScope, $window, $q) {
    return {
        request: function (config) {
            config.headers = config.headers || {};
            var user = $window.sessionStorage.user
            if (user) {
                user = JSON.parse(user);
                if (user)
                config.headers.Authorization = user.token_type + ' ' + user.access_token;
            }
            return config;
        },
        'responseError': function(rejection) {
            // do something on error
            if (rejection.status == '401') {
                $window.sessionStorage.user = null;
                window.location = '/#/login';
            }
            // console.log(JSON.stringify(rejection));
            // if (canRecover(rejection)) {
                // return responseOrNewPromise
            // }
            return $q.reject(rejection);
        }
    };
})
.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
})
.run(function($ionicPlatform) {
    $ionicPlatform.ready(function() {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)
        if (window.cordova && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            cordova.plugins.Keyboard.disableScroll(true);

        }
        if (window.StatusBar) {
            // org.apache.cordova.statusbar required
            StatusBar.styleDefault();
        }
    });
})

.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider

    .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'templates/menu.html',
        controller: 'AppCtrl'
    })

    .state('app.movEspiritualList', {
        url: '/movEspiritual/list',
        views: {
            'menuContent': {
                templateUrl: 'templates/movEspiritual/list.html',
                controller: 'MovEspiritualCtrl'
            }
        }
    })

    .state('app.movEspiritualForm', {
        url: '/movEspiritual/form',
        views: {
            'menuContent': {
                templateUrl: 'templates/movEspiritual/form.html',
                controller: 'MovEspiritualCtrl'
            }
        }
    })

    .state('app.financeiroEdit', {
        url: '/financeiro/edit/:id?:type',
        views: {
            'menuContent': {
                templateUrl: 'templates/financeiro/form.html',
                controller: 'FinanceiroCtrl'
            }
        }
    })

    .state('app.financeiroList', {
        url: '/financeiro/list',
        views: {
            'menuContent': {
                templateUrl: 'templates/financeiro/list.html',
                controller: 'FinanceiroCtrl'
            }
        }
    })

    .state('app.financeiroShow', {
        url: '/financeiro/show/:id?:type',
        views: {
            'menuContent': {
                templateUrl: 'templates/financeiro/show.html',
                controller: 'FinanceiroCtrl'
            }
        }
    })

    .state('app.financeiroForm', {
        url: '/financeiro/form/:type',
        views: {
            'menuContent': {
                templateUrl: 'templates/financeiro/form.html',
                controller: 'FinanceiroCtrl'
            }
        }
    })

    .state('app.dashboard', {
        url: '/dashboard',
        views: {
            'menuContent': {
                templateUrl: 'templates/dashboard.html',
                controller: 'LoginCtrl'
            }
        }
    })

    .state('login', {
        url: '/login',
        templateUrl: 'templates/login.html',
        controller: 'LoginCtrl'

    })
    ;
    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/login');
});
