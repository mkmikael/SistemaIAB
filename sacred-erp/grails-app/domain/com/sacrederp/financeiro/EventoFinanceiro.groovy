package com.sacrederp.financeiro

class EventoFinanceiro {

    Date dateCreated
    Date lastUpdated
    BigDecimal valor

    static hasMany = [lancamentos: Lancamento]
    static constraints = {
        dateCreated nullable: true
        lastUpdated nullable: true
        valor       nullable: false, scale: 6
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}
