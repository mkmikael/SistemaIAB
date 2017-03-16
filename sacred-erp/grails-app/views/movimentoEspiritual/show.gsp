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
    <div class="content table-responsive table-full-width">
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <td>${mov.id}</td>
            </tr>
            <tr>
                <th>Criado em</th>
                <td>${mov.dateCreated.format('dd/MM/yy HH:mm')}</td>
            </tr>
            <tr>
                <th>Secretário(a)</th>
                <td>${mov.secretario}</td>
            </tr>
            <tr>
                <th>Referência</th>
                <td>${mov.referencia}</td>
            </tr>
            <tr>
                <th>Departamento</th>
                <td>${mov.secretario?.departamento}</td>
            </tr>
            <tr>
                <th>Jovens Matriculados</th>
                <td>${mov.jovensMatriculados}</td>
            </tr>
            <tr>
                <th>Jovens Membros</th>
                <td>${mov.jovensMembros}</td>
            </tr>
            <tr>
                <th>Culto Oficial</th>
                <td>${mov.cultoOficial}</td>
            </tr>
            <tr>
                <th>Culto Livres</th>
                <td>${mov.cultoLivres}</td>
            </tr>
            <tr>
                <th>Culto Domiciliar</th>
                <td>${mov.cultoDomiciliar}</td>
            </tr>
            <tr>
                <th>Culto Treinamento</th>
                <td>${mov.cultoTreinamento}</td>
            </tr>
            <tr>
                <th>Palestras</th>
                <td>${mov.palestras}</td>
            </tr>
            <tr>
                <th>Reunioes Oração Ensaio</th>
                <td>${mov.reunioesOracaoEnsaio}</td>
            </tr>
            <tr>
                <th>Campanha Oração</th>
                <td>${mov.campanhaOracao}</td>
            </tr>
            <tr>
                <th>Consagrações</th>
                <td>${mov.consagracoes}</td>
            </tr>
            <tr>
                <th>Vigílias</th>
                <td>${mov.vigilias}</td>
            </tr>
            <tr>
                <th>Cruzadas</th>
                <td>${mov.cruzadas}</td>
            </tr>
            <tr>
                <th>Evangelismos</th>
                <td>${mov.evangelismos}</td>
            </tr>
            <tr>
                <th>Pessoas Evangelizadas</th>
                <td>${mov.pessoasEvangelizadas}</td>
            </tr>
            <tr>
                <th>Literaturas</th>
                <td>${mov.literaturas}</td>
            </tr>
            <tr>
                <th>Casas Visitas</th>
                <td>${mov.casasVisitas}</td>
            </tr>
            <tr>
                <th>Decisoes</th>
                <td>${mov.decisoes}</td>
            </tr>
            <tr>
                <th>Reconciliacoes</th>
                <td>${mov.reconciliacoes}</td>
            </tr>
            <tr>
                <th>Batismo Espírito Santo</th>
                <td>${mov.batismoEspiritoSanto}</td>
            </tr>
            <tr>
                <th>Curas Divinas</th>
                <td>${mov.curasDivinas}</td>
            </tr>
        </table>
    </div>
</div> <!-- card -->
</body>
</html>