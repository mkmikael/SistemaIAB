<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<content tag="title">
    Editar Membro
</content>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="header">
                <a href="${createLink(action: 'show', id: membro.id)}">Voltar ao membro</a>
            </div>
            <div class="content">
                <g:form action="save">
                    <input type="hidden" id="id" name="id" value="${membro.id}">
                    <g:render template="form" model="[membro: membro]" />
                    <button type="submit" class="btn btn-info btn-fill btn-wd">Editar</button>
                </g:form>
            </div>
        </div> <!-- card -->
    </div> <!-- col-md-12 -->
</div><!-- row -->
</body>
</html>