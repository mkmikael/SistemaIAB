<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<content tag="title">
    Membros
</content>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="header">
                <a href="${createLink(action: 'create')}">+Cadastrar Membro</a>
            </div>
            <div class="content table-responsive table-full-width">
                <table class="table table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Criado em</th>
                    <th>Nome</th>
                    </thead>
                    <tbody>
                    <g:if test="${membroList}">
                        <g:each in="${membroList}" var="m">
                            <tr>
                                <td>
                                    <a href="${createLink(action: 'show', id: m.id)}">${m.id}</a>
                                </td>
                                <td>${m.dateCreated.format('dd/MM/yyyy HH:mm')}</td>
                                <td>${m.participante.nome}</td>
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
                <g:if test="${membroCount}">
                    <g:paginate total="${membroCount}" params="${params}" />
                </g:if>
            </div>
        </div> <!-- card -->
    </div> <!-- col-md-12 -->
</div><!-- row -->
</body>
</html>