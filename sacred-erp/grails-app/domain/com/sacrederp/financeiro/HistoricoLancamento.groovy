package com.sacrederp.financeiro

class HistoricoLancamento {

    Date dateCreated
    StatusLancamento oldValue
    StatusLancamento newValue

    static belongsTo = [lancamento: Lancamento]
    static constraints = {
        dateCreated nullable: true
        oldValue    nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    String toString() { "HistoricoLancamento lanc: #$lancamento.id dateCreated: ${dateCreated?.format('dd/MM/yy HH:mm')} oldValue: $oldValue newValue: $newValue" }
}
