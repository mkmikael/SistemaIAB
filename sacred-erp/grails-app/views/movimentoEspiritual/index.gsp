<%@ page import="com.sacrederp.MovimentoEspiritual" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<content tag="title">
    Movimento Espiritual
</content>

<div class="card">
    <div class="content">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#recebidos" aria-controls="recebidos" role="tab" data-toggle="tab">Recebidos</a></li>
            <li role="presentation"><a href="#geral" aria-controls="geral" role="tab" data-toggle="tab">Geral</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="recebidos">
                <table class="table table-striped">
                    <thead>
                    <th>Criado em</th>
                    <th>Departamento</th>
                    <th>Secretário(a)</th>
                    <th>Referência</th>
                    </thead>
                    <tbody>
                    <g:if test="${movimentoEspiritualList}">
                        <g:each in="${movimentoEspiritualList}" var="mv">
                            <tr>
                                <td>
                                    <g:link controller="movimentoEspiritual" action="show" id="${mv.id}">
                                        ${mv.dateCreated.format('dd/MM/yyyy HH:mm')}
                                    </g:link>
                                </td>
                                <td>${mv.secretario.departamento}</td>
                                <td>${mv.secretario}</td>
                                <td>${mv.referencia}</td>
                            </tr>
                        </g:each>
                    </g:if>
                    <g:else>
                        <tr>
                            <td colspan="4" class="text-center">Sem registros</td>
                        </tr>
                    </g:else>
                    </tbody>
                </table>
            </div>
            <div role="tabpanel" class="tab-pane" id="geral">
                <h3>Relatório Geral</h3>
                <table class="table table-striped">
                    <tbody>
                        <g:each in="${MovimentoEspiritual.totalGeral()}" var="total">
                            <tr>
                                <th>${total.key}</th>
                                <td><g:formatNumber number="${total.value ?: 0}" /></td>
                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </div>
        </div> <!-- tab-content -->
    </div> <!-- content -->
</div> <!-- card -->
</body>
</html>