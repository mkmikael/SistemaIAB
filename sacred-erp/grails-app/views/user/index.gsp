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
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="content table-responsive table-full-width">
                <table class="table table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Ativo</th>
                    </thead>
                    <tbody>
                    <g:if test="${userList}">
                        <g:each in="${userList}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.enabled}</td>
                            </tr>
                        </g:each>
                    </g:if>
                    <g:else>
                        <tr>
                            <td colspan="3" class="text-center">Sem registros</td>
                        </tr>
                    </g:else>
                    </tbody>
                </table>
            </div>
        </div> <!-- card -->
    </div> <!-- col-md-12 -->
</div><!-- row -->
</body>
</html>