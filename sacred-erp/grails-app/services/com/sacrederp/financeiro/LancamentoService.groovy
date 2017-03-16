package com.sacrederp.financeiro

import com.sacrederp.Departamento
import grails.transaction.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat

@Transactional
class LancamentoService {

    def save(GrailsParameterMap params) {
        def dono = Departamento.get(params.long('depId'))
        def conta = Conta.findOrSaveByDono(dono)
        def lancamento = params.id ? Lancamento.get(params.long('id')) : new Lancamento()
        lancamento.conta = conta
        lancamento.valor = params.decimal('valor')
        lancamento.dataPrevista = params.date('dataPrevista', 'dd/MM/yyyy')
        params.remove('dataPrevista')
        lancamento.properties = params
        if (lancamento.tipo == TipoLancamento.RECEBER) {
            lancamento.valor = lancamento.valor > 0 ? lancamento.valor : -lancamento.valor
        } else if (lancamento.tipo == TipoLancamento.PAGAR) {
            lancamento.valor = lancamento.valor < 0 ? lancamento.valor : -lancamento.valor
        } else {
            throw new RuntimeException('Caso não previsto.')
        }

        lancamento.save(failOnError: true)
    }
}
