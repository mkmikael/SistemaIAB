<%@ page import="com.sacrederp.Departamento; com.sacrederp.financeiro.TipoLancamento" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="admin" />
    <g:set var="entityName" value="${message(code: 'lancamento.label', default: 'Lancamento')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>

<content tag="title">
    Movimento Financeiro
</content>

<div class="card">
    <div class="header">
        <a href="${createLink(action: 'create')}">+Cadastrar Lançamento</a>
    </div>
    <div class="content">
        <hr>
        <g:form class="form-inline">
            <div class="form-group">
                <label for="mes" class="control-label">Mês de Referência</label>
                <g:select class="form-control" name="mes"
                          from="${meses}" optionKey="index" optionValue="name" value="${mes}" />
            </div>
            <div class="form-group">
                <label for="mes" class="control-label">Ano de Referência</label>
                <g:select class="form-control" name="ano"
                          from="${2000..2030}" value="${ano}" />
            </div>
            <br>
            <br>
            <button type="submit" class="btn btn-primary">Procurar</button>
        </g:form>
        <hr>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="#receitas" aria-controls="receitas" role="tab" data-toggle="tab">
                    Receitas
                </a>
            </li>
            <li role="presentation">
                <a href="#despesas" aria-controls="despesas" role="tab" data-toggle="tab">
                    Despesas
                </a>
            </li>
            <li role="presentation">
                <a href="#resumo" aria-controls="resumo" role="tab" data-toggle="tab">
                    Resumo
                </a>
            </li>
        </ul>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="receitas">
                <g:render template="list" model="[lancamentoList: receitaList, lancamentoCount: receitaCount]" />
            </div>
            <div role="tabpanel" class="tab-pane" id="despesas">
                <g:render template="list" model="[lancamentoList: despesaList, lancamentoCount: despesaCount]" />
            </div>
            <div role="tabpanel" class="tab-pane" id="resumo">
                <g:render template="resumoMensal"
                          model="[receitaSum: receitaSum, despesaSum: despesaSum, saldoAnterior: saldoAnterior]" />
            </div>
        </div>


        <div class="pagination">
            <g:paginate total="${lancamentoCount ?: 0}" />
        </div>
    </div> <!-- content -->
</div> <!-- card -->

</body>
</html>