<%@ page import="com.sacrederp.Funcao; com.sacrederp.Departamento" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <asset:javascript src="scripts/membro.js" />
</head>
<body>
<content tag="title">
    Membro
</content>
<input type="hidden" id="id" name="id" value="${membro.id}">

<div class="card">
    <div class="header">
        <a href="${createLink(action: 'index')}">Voltar aos membros</a>
    </div>
    <div class="content">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#dados" aria-controls="dados" role="tab" data-toggle="tab">Dados Gerais</a></li>
            <li role="presentation"><a href="#acesso" aria-controls="acesso" role="tab" data-toggle="tab">Acesso</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="dados">
                <table class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <td>${membro.id}</td>
                    </tr>
                    <tr>
                        <th>Criado em</th>
                        <td>${membro.dateCreated.format('dd/MM/yy HH:mm')}</td>
                    </tr>
                    <tr>
                        <th>Modificado em</th>
                        <td>${membro.lastUpdated.format('dd/MM/yy HH:mm')}</td>
                    </tr>
                    <tr>
                        <th>Nome</th>
                        <td>${membro.participante.nome}</td>
                    </tr>
                    <g:if test="${membro.participante.dataNascimento}">
                        <tr>
                            <th>Data de Nascimento</th>
                            <td>${membro.participante.dataNascimento.format('dd/MM/yyyy')}</td>
                        </tr>
                    </g:if>
                    <g:if test="${membro.participante.sexo}">
                        <tr>
                            <th>Sexo</th>
                            <td>${membro.participante.sexo}</td>
                        </tr>
                    </g:if>
                    <tr>
                        <th>Login</th>
                        <td>${membro.user.username}</td>
                    </tr>
                </table>
            </div>
            <div role="tabpanel" class="tab-pane" id="acesso">
                <br>
                <p>
                    <button class="btn btn-default" data-toggle="modal" data-target="#modalAcesso">+Add</button>
                </p>

                <div id="acessos">
                    <g:render template="/congregado/list" model="[congregadoList: congregadoList]" />
                </div>
            </div>
        </div> <!-- tab-content -->
        <g:form action="delete" id="${membro.id}"
                method="DELETE"
                style="display: inline-block;">
            <button type="submit" onclick="return confirm('Você tem certeza?')" class="btn btn-danger btn-fill btn-wd">Deletar</button>
        </g:form>
        <a href="${createLink(action: 'edit', id: membro.id)}" class="btn btn-default btn-fill btn-wd">Editar</a>
    </div> <!-- content -->
</div> <!-- card -->

<content tag="modal">
    <div id="modalAcesso" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Add Acesso</h4>
                </div>
                <g:form>
                    <div class="modal-body">
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="departamento.id">Departamento</label>
                                <br>
                                <g:select name="departamento.id" class="select2"
                                          style="width: 100%"
                                          from="${Departamento.list().sort { it.participante.nome } }"
                                          optionKey="id"
                                          optionValue="${{ it.participante.nome }}"
                                          noSelection="['': 'Selecione']" required="" />
                            </div>
                        </div> <!-- row -->

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="funcao.id">Função</label>
                                <g:select name="funcao.id" class="form-control border-input"
                                          from="${Funcao.list(sort: 'nome')}"
                                          optionKey="id"
                                          optionValue="nome"
                                          noSelection="['': '']" required="" />
                            </div>
                        </div> <!-- row -->
                    </div> <!-- modal-body -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button id="saveAcesso" type="button" class="btn btn-primary">Salvar</button>
                    </div>
                </g:form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</content>
</body>
</html>