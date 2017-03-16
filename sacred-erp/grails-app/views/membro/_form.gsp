<%@ page import="com.sacrederp.Sexo" %>
<p class="small">
    * campo obrigatório
</p>

<fieldset>
    <legend>Dados Básicos</legend>
    <div class="row">
        %{--<div class="col-lg-8 col-md-6 col-sm-6">--}%
        %{--</div>--}%
        <div class="col-md-12">
            <div class="form-group">
                <label for="participante.nome" class="control-label">Nome *</label>
                <input id="participante.nome"
                       name="participante.nome"
                       class="form-control border-input"
                       value="${membro.participante?.nome}" required>
            </div>
        </div>

        %{--<div class="col-lg-2 col-md-3 col-sm-3">--}%
        %{--<div class="form-group">--}%
        %{--<label for="participante.dataNascimento" class="control-label">Data de Nascimento</label>--}%
        %{--<g:textField name="participante.dataNascimento"--}%
        %{--class="date form-control border-input"--}%
        %{--value="${membro.participante?.dataNascimento?.format('dd/MM/yyyy')}" />--}%
        %{--</div>--}%
        %{--</div>--}%

        %{--<div class="col-lg-2 col-md-3 col-sm-3">--}%
        %{--<div class="form-group">--}%
        %{--<label for="participante.sexo" class="control-label">Sexo</label>--}%
        %{--<g:select name="participante.sexo"--}%
        %{--class="form-control border-input"--}%
        %{--from="${Sexo.values()}"--}%
        %{--keys="${Sexo.values()*.name()}"--}%
        %{--value="${membro.participante?.sexo}"--}%
        %{--noSelection="['Selecione': '']"/>--}%
        %{--</div>--}%
        %{--</div>--}%
    </div>
</fieldset>

<fieldset>
    <legend>Acesso</legend>
    <input id="user.id" name="user.id" type="hidden" value="${membro.user?.id}">
    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label for="user.username">Login *</label>
                <input id="user.username" name="user.username"
                       class="form-control border-input" value="${membro.user?.username}">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="password">Senha *</label>
                <input id="password" name="user.password" type="password"
                       class="form-control border-input" data-rule-minlength="6" required>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="passConfirm">Confirmar Senha *</label>
                <input id="passConfirm" name="passConfirm" type="password"
                       class="form-control border-input"
                       data-rule-equalto="#password" required>
            </div>
        </div>
    </div>
</fieldset>
