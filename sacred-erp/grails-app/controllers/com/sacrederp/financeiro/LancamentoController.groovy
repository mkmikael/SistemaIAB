package com.sacrederp.financeiro

import com.sacrederp.Departamento
import grails.converters.JSON

import java.text.DecimalFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LancamentoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    LancamentoService lancamentoService

    def lancsByDepartamento(Long depId, Integer mes, Integer ano) {
        def dep = Departamento.get(depId)
        if (!dep)
            throw new RuntimeException('O departamento não foi encontrado.')

        def result = [:]
        def p = [depId: depId, mes: mes, ano: ano, status: StatusLancamento.CANCELADO]
        result.lancs = Lancamento.executeQuery("""
select new map(
    l.id as id,
    l.dataPrevista as dataPrevista,
    l.status as status,
    l.tipo as tipo,
    l.valor as valor,
    l.descricao as descricao
)
    from Lancamento l
where
    month(l.dataPrevista) = :mes
    and year(l.dataPrevista) = :ano
    and l.conta.dono.id = :depId
    and l.status != :status
order by l.dataPrevista desc""", p)

        p = [mes: mes, status: StatusLancamento.CANCELADO]
        result.soma = Lancamento.executeQuery("""
select sum(l.valor)
    from Lancamento l
where
    l.status != :status
    and month(l.dataPrevista) <= :mes""", p)
        result.soma = result.soma[0]

        p.remove('mes')
        result.total = Lancamento.executeQuery("""
select sum(l.valor)
    from Lancamento l
where
    l.status != :status""", p)
        result.total = result.total[0]
        render text: result as JSON
    } // lancsByDepartamento

    def index(Integer max) {
        def meses = []
        meses << [index: 1 , name: 'Janeiro']
        meses << [index: 2 , name: 'Fevereiro']
        meses << [index: 3 , name: 'Março']
        meses << [index: 4 , name: 'Abril']
        meses << [index: 5 , name: 'Maio']
        meses << [index: 6 , name: 'Junho']
        meses << [index: 7 , name: 'Julho']
        meses << [index: 8 , name: 'Agosto']
        meses << [index: 9 , name: 'Setembro']
        meses << [index: 10 , name: 'Outrubro']
        meses << [index: 11 , name: 'Novembro']
        meses << [index: 12 , name: 'Dezembro']
        params.max = Math.min(max ?: 10, 100)
        def cal = Calendar.instance
        if (!params.mes) {
            params.mes = cal.get(Calendar.MONTH) + 1
            params.ano = cal.get(Calendar.YEAR)
        }
        def saldoAnterior = Lancamento.createCriteria().get {
            projections {
                sum('valor')
            }
            'in'('tipo', TipoLancamento.RECEBER, TipoLancamento.PAGAR)
            sqlRestriction "extract(month from data_prevista) < ? and extract(year from data_prevista) <= ?", [params.mes, params.ano]
        } ?: 0

        def receitasCriteria = {
            eq('tipo', TipoLancamento.RECEBER)
            sqlRestriction "extract(month from data_prevista) = ?", [params.mes]
        }
        def receitaList = Lancamento.createCriteria().list(params, receitasCriteria)
        def receitaCount = Lancamento.createCriteria().count(receitasCriteria)
        def receitaSum = receitaList.sum { it.valor } ?: 0

        def despesasCriteria = {
            eq('tipo', TipoLancamento.PAGAR)
            sqlRestriction "extract(month from data_prevista) = ?", [params.mes]
        }
        def despesaList = Lancamento.createCriteria().list(params, despesasCriteria)
        def despesaCount = Lancamento.createCriteria().count(despesasCriteria)
        def despesaSum = despesaList.sum { it.valor } ?: 0
        [receitaList: receitaList, receitaCount: receitaCount, despesaSum: despesaSum,
         despesaList: despesaList, despesaCount: despesaCount, receitaSum: receitaSum,
         saldoAnterior: saldoAnterior, meses: meses] + params
    }

    def show(Lancamento lancamento) {
        def accept = request.getHeader('Accept')
        if (accept.contains('text/html')) {
            [lancamento: lancamento]
        } else {
            def map = [:]
            map.tipo = lancamento.tipo.name()
            map.descricao = lancamento.descricao
            map.dataPrevista = lancamento.dataPrevista
            map.valor = lancamento.valor
            map.id = lancamento.id
            render map as JSON
        }
    }

    def create() {
        respond new Lancamento(params)
    }

    @Transactional
    def save() {
        def lancamento = lancamentoService.save(params)

        if (lancamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lancamento.errors, view:'create'
            return
        }

        redirect lancamento
    }

    def edit(Lancamento lancamento) {
        respond lancamento
    }

    @Transactional
    def update(Lancamento lancamento) {
        if (lancamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (lancamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lancamento.errors, view:'edit'
            return
        }

        lancamento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lancamento.label', default: 'Lancamento'), lancamento.id])
                redirect lancamento
            }
            '*'{ respond lancamento, [status: OK] }
        }
    }

    @Transactional
    def delete(Lancamento lancamento) {

        if (lancamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        lancamento.status = StatusLancamento.CANCELADO
        lancamento.save()

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lancamento.label', default: 'Lancamento'), lancamento.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lancamento.label', default: 'Lancamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
