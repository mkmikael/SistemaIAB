<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<content tag="title">
    Cadastrar Congregação
</content>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="header">
                <a href="${createLink(action: 'index')}">Voltar às congregações</a>
            </div>
            <div class="content">
                <g:form action="save">
                    <g:render template="form" model="[cong: cong]" />
                    <button type="submit" class="btn btn-info btn-fill btn-wd">Cadastrar</button>
                </g:form>
            </div>
        </div> <!-- card -->
    </div> <!-- col-md-12 -->
</div><!-- row -->
</body>
</html>