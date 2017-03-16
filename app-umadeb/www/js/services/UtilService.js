angular.module('starter')
.factory('utilService', function($http, $window, $httpParamSerializer, URL_SERVER) {
    var _ls = {
        get: function(key) {
            if ($window.localStorage[key]) {
                return JSON.parse($window.localStorage[key]);
            } else {
                return null;
            }
        },
        set: function(key, value) {
            $window.localStorage[key] = JSON.stringify(value);
        },
        cls: function(key) {
            $window.localStorage.removeItem(key);
        }
    }

    var _ss = {
        get: function(key) {
            if ($window.sessionStorage[key]) {
                return JSON.parse($window.sessionStorage[key]);
            } else {
                return null;
            }
        },
        set: function(key, value) {
            $window.sessionStorage[key] = JSON.stringify(value);
        },
        cls: function(key) {
            $window.sessionStorage.removeItem(key);
        }
    }

    return {
        ls: _ls,
        ss: _ss
    };
});
