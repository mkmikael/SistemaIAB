<%@ page import="com.sacrederp.financeiro.TipoLancamento; com.sacrederp.Departamento" %>

<table class="table">
    <tr>
        <th>Receita Total Mês</th>
        <td><g:formatNumber type="currency" number="${receitaSum}"/></td>
    </tr>
    <tr>
        <th>Despesa Total Mês</th>
        <td><g:formatNumber type="currency" number="${despesaSum}"/></td>
    </tr>
    <tr>
        <th>Total Mês</th>
        <td><g:formatNumber type="currency" number="${receitaSum + despesaSum}"/></td>
    </tr>
    <tr>
        <th>Saldo Anterior</th>
        <td><g:formatNumber type="currency" number="${saldoAnterior}"/></td>
    </tr>
    <tr>
        <th>Saldo em Caixa</th>
        <td><g:formatNumber type="currency" number="${receitaSum + despesaSum + saldoAnterior}"/></td>
    </tr>
</table>