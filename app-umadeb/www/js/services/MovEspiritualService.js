angular.module('starter')
.factory('movEspService', function($http, $window, $httpParamSerializer, utilService, URL_SERVER) {

    var _get = function(mes, ano) {
        var user = utilService.ss.get('user');
        return $http({
            method: 'GET',
            url: URL_SERVER + '/movimentoEspiritual/view?format=json&mes=' + mes + '&ano=' + ano + '&congId=' + user.perfil.congId
        });
    };

    var _save = function(movEsp) {
        var user = utilService.ss.get('user');
        movEsp.congId = user.perfil.congId;
        return $http({
            method: 'POST',
            url: URL_SERVER + '/movimentoEspiritual/save',
            data: $httpParamSerializer(movEsp),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
    };

    return {
        get: _get,
        save:  _save
    };
});
