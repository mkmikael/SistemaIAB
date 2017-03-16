<%@ page import="com.sacrederp.financeiro.TipoLancamento; com.sacrederp.Departamento" %>

<p class="small">
    * campo obrigatório
</p>

<g:hiddenField name="id" value="${lancamento?.id}" />
<fieldset>
    <legend></legend>
    <g:if test="${lancamento?.conta?.dono}">
        <g:hiddenField name="depId" value="${lancamento.conta.dono.id}" />
        <p>
            ${lancamento.conta.dono}
        </p>
    </g:if>
    <g:else>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="depId">Departamento *</label>
                    <g:select name="depId" class="select2 form-control border-input"
                              style="width: 100%"
                              from="${Departamento.list().sort { it.participante.nome } }"
                              optionKey="id"
                              optionValue="${{ it.participante.nome }}"
                              noSelection="['': 'Selecione']" required="" />

                    <label id="depId-error" class="error" for="depId" hidden>Este campo é requerido.</label>
                </div>
            </div>
        </div> <!-- row -->
    </g:else>

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label class="control-label" for="tipo">Tipo *</label>
                <g:select name="tipo" class="form-control border-input"
                          from="${TipoLancamento.toList()}"
                          keys="${TipoLancamento.toList()*.name()}"
                          noSelection="['': 'Selecione']" value="${lancamento?.tipo}" required="" />
            </div>
        </div>
    </div> <!-- row -->

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label class="control-label" for="dataPrevista">Data de Referência *</label>
                <g:set var="dataPrevista" value="${lancamento?.dataPrevista ?: new Date()}" />
                <g:textField class="date form-control border-input"
                             name="dataPrevista"
                             value="${dataPrevista?.format('dd/MM/yyyy')}" required="" />
            </div>
        </div>
    </div> <!-- row -->

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label class="control-label" for="valor">Valor *</label>
                <g:textField class="form-control border-input money" name="valor"
                             value="${lancamento?.valor?.setScale(2)}" required="" />
            </div>
        </div>
    </div> <!-- row -->

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label class="control-label" for="descricao">Descrição *</label>
                <g:textField class="form-control border-input" name="descricao"
                             value="${lancamento?.descricao}" required="" />
            </div>
        </div>
    </div> <!-- row -->
</fieldset>