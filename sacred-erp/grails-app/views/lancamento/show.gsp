<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="admin" />
    <g:set var="entityName" value="${message(code: 'lancamento.label', default: 'Lancamento')}" />
    <title>Movimento Espiritual</title>
</head>
<body>
<content tag="title">
    Movimento Financeiro
</content>
<div class="card">
    <div class="header">
        <a href="${createLink(action: 'index')}">Voltar aos lançamentos</a>
    </div>
    <div class="content table-responsive table-full-width">
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <td>${lancamento.id}</td>
            </tr>
            <tr>
                <th>Criado em</th>
                <td>${lancamento.dateCreated.format('dd/MM/yy HH:mm')}</td>
            </tr>
            <tr>
                <th>Modificado em</th>
                <td>${lancamento.lastUpdated.format('dd/MM/yy HH:mm')}</td>
            </tr>
            <tr>
                <th>Congregação</th>
                <td>${lancamento.conta.dono}</td>
            </tr>
            <tr>
                <th>Tipo</th>
                <td>${lancamento.tipo}</td>
            </tr>
            <tr>
                <th>Data de Referência</th>
                <td>${lancamento.dataPrevista.format('dd/MM/yy')}</td>
            </tr>
            <tr>
                <th>Valor</th>
                <td><g:formatNumber number="${lancamento.valor}" type="currency" /></td>
            </tr>
        </table>

        <g:form style="display: inline-block" resource="${this.lancamento}" method="DELETE">
            <input class="btn btn-danger btn-fill btn-wd" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
        </g:form>
        <g:link action="edit" class="btn btn-default btn-fill btn-wd" resource="${this.lancamento}">Editar</g:link>
    </div>
</div> <!-- card -->
</body>
</html>
