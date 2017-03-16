angular.module('starter')
.controller('LoginCtrl', function($window, $scope, $state, $ionicLoading, loginService, utilService, financeiroService) {
    if ($window.sessionStorage.user) {
        $state.go('app.dashboard');
    }
    $scope.login = function(loginData) {
        $ionicLoading.show({ template: 'Carregando...' });
        loginService.login(loginData.username,loginData.password)
        .then(function(resp) {
            var user = resp.data;
            utilService.ss.set('user', user);
            loginData.username = '';
            loginData.password = '';
            loginService.getInfo(user.username)
            .then(function(resp) {
                user.perfis = resp.data;
                if (user.perfis.length == 1) {
                    user.perfil = user.perfis[0];
                    utilService.ss.set('user', user);
                    $state.go('app.dashboard');
                } else if (_user.perfis.length > 1) {

                } else {
                    alert('Occoreu um erro ao logar, verifique seu cadastro na secretaria da UMADEB.');
                }
                console.log('Dados login: '+ JSON.stringify(user));
            }, function(resp) {
                alert('Occoreu um erro ao logar, verifique seu cadastro na secretaria da UMADEB.');
            }).finally(function() {
                $ionicLoading.hide();
            });
        }, function(resp) {
            loginData.password = '';
            alert('Login ou senha inválidos.');
            $ionicLoading.hide();
        });
    }; // login

    $scope.enviarLanc = function() {
        financeiroService.save();
    };

});
