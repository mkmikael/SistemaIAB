angular.module('starter')
.factory('loginService', function($http, $httpParamSerializer, URL_SERVER) {
    var _login = function(username, password) {
        var data = {username: username, password: password};
        return $http({
            method: 'POST',
            url: URL_SERVER + '/api/login',
            data: JSON.stringify(data),
            headers: { 'Content-Type': 'application/json' }
            // headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
    };

    var _getInfo = function(username) {
        return $http({
            method: 'GET',
            url: URL_SERVER + '/perfil/infoUser?username=' + username
        });
    };

    return {
        login: _login,
        getInfo: _getInfo
    };
});
