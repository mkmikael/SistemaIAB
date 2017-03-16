<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<content tag="title">
    Congregação
</content>
<div class="card">
    <div class="header">
        <a href="${createLink(action: 'index')}">Voltar às congregações</a>
    </div>
    <div class="content table-responsive table-full-width">
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <td>${cong.id}</td>
            </tr>
            <tr>
                <th>Criado em</th>
                <td>${cong.dateCreated.format('dd/MM/yy HH:mm')}</td>
            </tr>
            <tr>
                <th>Modificado em</th>
                <td>${cong.lastUpdated.format('dd/MM/yy HH:mm')}</td>
            </tr>
            <tr>
                <th>Nome da Congregação</th>
                <td>${cong.participante.nome}</td>
            </tr>
        </table>

        <g:form action="delete" id="${cong.id}"
                method="DELETE"
                style="display: inline-block;">
            <button type="submit" onclick="return confirm('Você tem certeza?')" class="btn btn-danger btn-fill btn-wd">Deletar</button>
        </g:form>
        <a href="${createLink(action: 'edit', id: cong.id)}" class="btn btn-default btn-fill btn-wd">Editar</a>
    </div>
</div> <!-- card -->
</body>
</html>