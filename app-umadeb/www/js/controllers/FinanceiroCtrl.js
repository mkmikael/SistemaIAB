angular.module('starter.controllers')
.controller('FinanceiroCtrl', function($window, $scope, $ionicLoading, $filter, $state, $stateParams, financeiroService, utilService) {
    $scope.now = new Date();
    $scope.data = new Date();

    $scope.changeDate = function(qtd) {
        var data = $scope.data;
        $scope.data = moment(data).add(qtd, 'month').toDate()
        $scope.loadLancs();
    };

    $scope.loadLanc = function() {
        var id = $stateParams.id;
        $scope.id = id;
        var tipo = $stateParams.type
        $scope.type = tipo;
        if (id) {
            $ionicLoading.show({ template: 'Carregando...' });
            financeiroService.get(id)
            .then(function(resp) {
                var data = resp.data;
                data.dataPrevista = $filter('date')(data.dataPrevista, 'dd/MM/yyyy');
                if (tipo == 'PAGAR') {
                    data.valor = -data.valor;
                }
                data.valor = $filter('number')(data.valor, 2);
                $scope.lanc = resp.data;
                $scope.lanc.tipo = tipo;
            }, function(resp) {
                alert('Ocorreu um erro inesperado! Contate o suporte de TI da UMADEB.');
            }).finally(function() {
                $ionicLoading.hide();
            });
        } else {
            $scope.lanc = { dataPrevista: $filter('date')(new Date(), 'dd/MM/yyyy'), tipo: tipo  }
        }
    };

    $scope.loadLancs = function() {
        var data = utilService.ss.get('data');
        if (data) {
            $scope.data = moment(data, 'DD/MM/YYYY').toDate()
            utilService.ss.cls('data');
        }
        var mes = $scope.data.getMonth() + 1;
        var ano = $scope.data.getYear() + 1900;
        $ionicLoading.show({ template: 'Carregando...' });
        financeiroService.list(mes, ano)
        .then(function(resp) {
            var data = resp.data;
            $scope.width = $window.innerWidth;
            $scope.height = $window.innerHeight;
            $scope.lancs = data.lancs;
            $scope.soma = data.soma;
            $scope.total = data.total;
        }, function(resp) {
            alert('Ocorreu um erro inesperado! Contate o suporte de TI da UMADEB.');
        }).finally(function() {
            $ionicLoading.hide();
        });
    };

    $scope.delete = function(id) {
        $ionicLoading.show({ template: 'Carregando...' });
        financeiroService.delete(id)
        .then(function(resp) {
            $state.go('app.financeiroList');
        }, function(resp) {
            alert('Ocorreu um erro inesperado! Contate o suporte de TI da UMADEB.');
        }).finally(function() {
            $ionicLoading.hide();
        });
    };

    $scope.save = function(lanc) {
        console.log('Save lançamento');
        var type = $scope.type;
        var id = $stateParams.id;
        if (id) {
            lanc.id = id;
        }
        financeiroService.save(lanc, type)
        .then(function(resp) {
            $state.go('app.financeiroList');
            utilService.ss.set('data', lanc.dataPrevista);
        }, function(resp) {
            alert('Ocorreu um erro inesperado! Contate o suporte de TI da UMADEB.');
        });
    }; // save

});
