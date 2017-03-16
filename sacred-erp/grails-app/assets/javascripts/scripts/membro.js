/**
 * Created by mikael on 3/5/17.
 */

var congService = {
    save: function() {
        if ($('#modalAcesso form').valid()) {
            var data = {};
            data['departamento.id'] = $("*[name='departamento.id']").val();
            data['funcao.id'] = $("*[name='funcao.id']").val();
            data['membro.id'] = $("#id").val();
            $.ajax({
                url: baseUrl + 'congregado/save',
                method: 'POST',
                data: data
            }).done(function(data) {
                if (data.status == 'error') {
                    swal('Oops... Ocorreu um erro!', data.msg, 'error');
                } else if (data.status == 'success') {
                    $('#modalAcesso').modal('hide');
                    $('#acessos').html(data.html);
                    $('*[data-delete]').click(function () {
                        var self = $(this);
                        congService.delete(self.data('delete'));
                    }); // #saveAcesso
                }
            }).fail(function() {
                erroInesperado();
            });
        }
    },
    delete: function(id) {
        swal({
            title: 'Voce tem certeza?',
            text: "Voce tem certeza que deseja remover o acesso!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim, delete!',
            cancelButtonText: 'Cancelar',
            customClass: 'animated tada',
            animation: false
        }).then(function () {
            $.ajax({
                url: baseUrl + 'congregado/delete/' + id,
                method: 'DELETE'
            }).done(function(data) {
                swal('Deletado!', data.msg, 'success');
                $('#acessos').html(data.html);
                $('*[data-delete]').click(function () {
                    var self = $(this);
                    congService.delete(self.data('delete'));
                }); // #saveAcesso
            }).fail(function() {
                erroInesperado();
            });
        });
    } // delete
};

$(function() {
    $('#saveAcesso').click(function () {
        congService.save();
    }); // #saveAcesso

    $('*[data-delete]').click(function () {
        var self = $(this);
        congService.delete(self.data('delete'));
    }); // #saveAcesso
});