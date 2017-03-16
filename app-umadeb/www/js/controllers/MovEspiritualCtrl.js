angular.module('starter.controllers')
.controller('MovEspiritualCtrl', function($scope, $ionicLoading, $state, $stateParams, movEspService) {
    $scope.data = new Date();

    $scope.changeDate = function(qtd) {
        var data = $scope.data;
        $scope.data = moment(data).add(qtd, 'month').toDate()
        $scope.loadMov();
    };

    $scope.create = function(mes) {
        $state.go('app.movEspiritualForm', { mes: mes });
    };

    $scope.loadMov = function() {
        var mes = $scope.data.getMonth() + 1;
        var ano = $scope.data.getYear() + 1900;
        $ionicLoading.show({ template: 'Carregando...' });
        movEspService.get(mes, ano)
        .then(function(req) {
            $scope.mov = req.data;
            $scope.mov.ano = ano;
            $scope.mov.mes = mes;
        }, function(resp) {
            alert('Erro ao comunicar com servidor, tente mais tarde.');
        }).finally(function() {
            $ionicLoading.hide();
        });
    };

    $scope.save = function(mov) {
        $ionicLoading.show({ template: 'Enviando para UMADEB...' });
        movEspService.save(mov)
        .then(function(req) {
            alert('Enviado com sucesso! Deus te abençoe!');
        }, function() {
            alert('Erro ao comunicar com servidor, tente mais tarde.');
        }).finally(function() {
            $ionicLoading.hide();
            // $state.go('app.movEspiritualList');
        });
    };
});
