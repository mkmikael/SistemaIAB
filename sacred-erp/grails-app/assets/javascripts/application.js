// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-1.10.2
//= require /jquery-validate/jquery.validate.min
//= require /jquery-validate/date-pt_BR
//= require /jquery-validate/messages_pt_BR
//= require jquery.mask.min
//= require jquery.maskMoney.min
//= require bootstrap
//= require bootstrap-checkbox-radio
//= require bootstrap-notify
//= require datepicker/bootstrap-datepicker.min
//= require datepicker/bootstrap-datepicker.pt-BR.min
//= require sweetalert2.min
//= require select2/select2.min
//= require select2/pt-BR
//= require chartist.min
//= require paper-dashboard
//= require demo
//= require_self

$.fn.modal.Constructor.prototype.enforceFocus = function() {};
var baseUrl;

function erroInesperado() {
    swal('Oops... Ocorreu um erro inesperado!', 'Por favor, contate o suporte!', 'error')
}


$(function () {
    baseUrl = $('#baseUrl').val();
    $('.select2').select2({ language: 'pt-BR' });
    $('.datepicker').datepicker({
        format: 'dd/mm/yyyy',
        language: 'pt-BR'
    });
    $('form').validate();
    $('.date').mask('00/00/0000', { placeholder: '00/00/0000' });
    $('.time').mask('00:00:00');
    $('.date_time').mask('00/00/0000 00:00:00');
    $('.cep').mask('00000-000');
    $('.phone').mask('00000-0000');
    $('.phone_with_ddd').mask('(00) 00000-0000');
    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
    // $('.money').mask('000.000.000.000.000,00', {reverse: true});
    $('.money').mask("#.##0,00", {reverse: true});
    // $('.money').maskMoney({ allowZero: true, allowNegative: true, decimal: ',', thousands: '.' });
});