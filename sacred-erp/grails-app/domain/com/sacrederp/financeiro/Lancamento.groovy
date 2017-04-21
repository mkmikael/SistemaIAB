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
    Integer mes
    Integer ano

    static hasMany = [historicos: HistoricoLancamento]
    static belongsTo = [evento: EventoFinanceiro]
    static constraints = {
        valor scale: 6
        evento nullable: true
        dateCreated nullable: true
        lastUpdated nullable: true
    }

    void setDataPrevista(Date dataPrevista) {
        def cal = Calendar.instance
        cal.time = dataPrevista
        mes = cal.get(Calendar.MONTH) + 1
        ano = cal.get(Calendar.YEAR)
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

    static List<Lancamento> listReceitas(Map params = [:]) {
        Lancamento.createCriteria().list(params) {
            eq('tipo', TipoLancamento.RECEBER)
            if (params.mes)
                eq('mes', params.mes as Integer)
        }
    }

    static List<Lancamento> listDespesas(Map params = [:]) {
        Lancamento.createCriteria().list(params) {
            eq('tipo', TipoLancamento.PAGAR)
            if (params.mes)
                eq('mes', params.mes as Integer)
        }
    }

    static BigDecimal getSaldoAnterior(Integer mes, Integer ano) {
        Lancamento.createCriteria().get {
            projections {
                sum('valor')
            }
            'in'('tipo', TipoLancamento.RECEBER, TipoLancamento.PAGAR)
            le('ano', ano)
            lt('mes', mes)
        } ?: 0
    }

}
