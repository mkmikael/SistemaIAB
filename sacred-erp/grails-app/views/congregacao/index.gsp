<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<content tag="title">
    Congregações
</content>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="header">
                <a href="${createLink(action: 'create')}">+Cadastrar Congregação</a>
            </div>
            <div class="content table-responsive table-full-width">
                <table class="table table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Criado em</th>
                    <th>Descrição</th>
                    </thead>
                    <tbody>
                    <g:if test="${congList}">
                        <g:each in="${congList}" var="c">
                            <tr>
                                <td>
                                    <a href="${createLink(action: 'show', id: c.id)}">${c.id}</a>
                                </td>
                                <td>${c.dateCreated.format('dd/MM/yyyy HH:mm')}</td>
                                <td>${c.participante.nome}</td>
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
                <g:if test="${congCount}">
                    <g:paginate total="${congCount}" params="${params}" />
                </g:if>
            </div>
        </div> <!-- card -->
    </div> <!-- col-md-12 -->
</div><!-- row -->
</body>
</html>