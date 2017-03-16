<table class="table table-striped">
    <thead>
    <th>Departamento</th>
    <th>Funçao</th>
    </thead>
    <tbody>
    <g:if test="${congregadoList}">
        <g:each in="${congregadoList}" var="cong">
            <tr>
                <td>${cong.departamento}</td>
                <td>${cong.funcao}</td>
                <td>
                    <a href="#" data-delete="${cong.id}">Remover</a>
                </td>
            </tr>
        </g:each>
    </g:if>
    <g:else>
        <tr>
            <td class="text-center" colspan="2">Sem registros</td>
        </tr>
    </g:else>
    </tbody>
</table>