package com.sacrederp.financeiro

import com.sacrederp.Papel
import grails.databinding.BindingFormat

class Lancamento {

    Date dateCreated
    Date lastUpdated
    Conta conta
    TipoLancamento tipo
    StatusLancamento status = StatusLancamento.BAIXADO
    @BindingFormat('dd/MM/yyyy')
    Date dataPrevista
    BigDecimal valor
    String descricao

    static hasMany = [historicos: HistoricoLancamento]
    static belongsTo = [evento: EventoFinanceiro]
    static constraints = {
        valor scale: 6
        evento nullable: true
        dateCreated nullable: true
        lastUpdated nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
        def hist = new HistoricoLancamento()
        hist.newValue = status
        this.addToHistoricos(hist)
    }

    def beforeUpdate() {
        lastUpdated = new Date()
        if (this.isDirty('status')) {
            def oldValue = this.getPersistentValue('status')
            def newValue = this.status
            def hist = new HistoricoLancamento()
            hist.newValue = newValue
            hist.oldValue = oldValue
            this.addToHistoricos(hist)
            hist.save()
        }
    }

}
