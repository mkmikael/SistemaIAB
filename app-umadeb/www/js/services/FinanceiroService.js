angular.module('starter')
.factory('financeiroService', function($http, $window, $httpParamSerializer, utilService, URL_SERVER) {
    var _get = function(id) {
        return $http({
            method: 'GET',
            url: URL_SERVER + '/lancamento/show/' + id
        });
    };

    var _list = function(mes, ano) {
        var user = utilService.ss.get('user');
        var depId = user.perfil.depId;
        return $http({
            method: 'GET',
            url: URL_SERVER + '/lancamento/lancsByDepartamento?depId=' + depId + '&mes=' + mes + '&ano=' + ano
        });
    }; // loadLancs

    var _delete = function(id) {
        return $http({
            method: 'DELETE',
            url: URL_SERVER + '/lancamento/delete/' + id
        });
    };

    var _save = function(lanc, type) {
        var user = utilService.ss.get('user');
        lanc.depId = user.perfil.depId;
        lanc.valor = lanc.valor.replace(',', '.');
        return $http({
            method: 'POST',
            data: $httpParamSerializer(lanc),
            url: URL_SERVER + '/lancamento/save',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
    }; // save

    return {
        save: _save,
        delete: _delete,
        list: _list,
        get: _get
    };
});
