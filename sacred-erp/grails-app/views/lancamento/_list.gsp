<%@ page import="com.sacrederp.financeiro.TipoLancamento; com.sacrederp.Departamento" %>

<table class="table table-striped">
    <thead>
    %{--<th>Criado em</th>--}%
    <th>Tipo</th>
    <th>Data Ref.</th>
    <th>Departamento</th>
    <th>Descricao</th>
    <th>Valor</th>
    </thead>
    <tbody>
    <g:if test="${lancamentoList}">
        <g:each in="${lancamentoList}" var="l">
            <tr>
                %{--<td>--}%
                %{--<a href="${createLink(action: 'show', id: l.id)}">--}%
                %{--${l.dateCreated.format('dd/MM/yy HH:mm')}--}%
                %{--</a>--}%
                %{--</td>--}%
                <td>
                    <a href="${createLink(action: 'show', id: l.id)}">
                        <g:if test="${l.tipo == TipoLancamento.RECEBER}">
                            RECEITA
                        </g:if>
                        <g:elseif test="${l.tipo == TipoLancamento.PAGAR}">
                            DESPESA
                        </g:elseif>
                    </a>
                </td>
                <td>${l.dataPrevista.format('dd/MM/yy')}</td>
                <td>${l.conta.dono}</td>
                <td>${l.descricao}</td>
                <td><g:formatNumber number="${l.valor}" type="currency" /> </td>
            </tr>
        </g:each>
    </g:if>
    <g:else>
        <tr>
            <td colspan="6" class="text-center">Sem registros</td>
        </tr>
    </g:else>
    </tbody>
</table>