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
        <g:form>
            <div class="form-group">
                <label for="mes" class="control-label">Mês de Referência</label>
                <g:select class="form-control" name="mes"
                          from="${meses}" optionKey="index" optionValue="name" value="${mes}" />
            </div>
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
                <table class="table">
                    <tr>
                        <th>Receita Total</th>
                        <td><g:formatNumber type="currency" number="${receitaSum}"/></td>
                    </tr>
                    <tr>
                        <th>Despesa Total</th>
                        <td><g:formatNumber type="currency" number="${despesaSum}"/></td>
                    </tr>
                    <tr>
                        <th>Subtotal</th>
                        <td><g:formatNumber type="currency" number="${receitaSum + despesaSum}"/></td>
                    </tr>
                    <tr>
                        <th>Saldo Mês Anterior</th>
                        <td><g:formatNumber type="currency" number="${saldoAnterior}"/></td>
                    </tr>
                    <tr>
                        <th>Saldo em Caixa</th>
                        <td><g:formatNumber type="currency" number="${receitaSum + despesaSum + saldoAnterior}"/></td>
                    </tr>
                </table>
            </div>
        </div>


        <div class="pagination">
            <g:paginate total="${lancamentoCount ?: 0}" />
        </div>
    </div> <!-- content -->
</div> <!-- card -->

</body>
</html>