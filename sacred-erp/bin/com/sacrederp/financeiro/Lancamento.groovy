package com.sacrederp.financeiro

class Lancamento {

    Date dateCreated
    Date lastUpdated
    Conta conta
    TipoLancamento tipo
    Date dataOriginal
    Date dataPrevista
    Date dataEfetivacao
    StatusLancamento status = StatusLancamento.ABERTO
    BigDecimal valor

    static belongsTo = [evento: EventoFinanceiro]
    static constraints = {
        valor scale: 6
        evento nullable: true
        dateCreated nullable: true
        lastUpdated nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }
}
