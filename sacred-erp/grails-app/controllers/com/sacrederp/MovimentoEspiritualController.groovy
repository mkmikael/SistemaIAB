package com.sacrederp

import com.sacrederp.security.User
import grails.transaction.Transactional
import org.springframework.http.HttpStatus

class MovimentoEspiritualController {

    static allowedMethods = [index: 'GET', save: 'POST']

    def index() {
        if (!params.sort) {
            params.sort = 'dateCreated'
            params.order = 'desc'
        }
        respond MovimentoEspiritual.list(params)
    }

    def view(Integer mes) {
        def ano = Calendar.instance.get(Calendar.YEAR)
        def movimentoEspiritual = MovimentoEspiritual.findByAnoAndMes(ano, mes) ?: new MovimentoEspiritual()
        respond movimentoEspiritual, formats: ['json', 'xml']
    }

    @Transactional
    def save(Integer mes, Integer ano, Long congId) {
        def congregado = Congregado.get(congId)
        def movimentoEspiritual = MovimentoEspiritual.findByAnoAndMesAndSecretario(ano, mes, congregado)
        if (!movimentoEspiritual)
            movimentoEspiritual = new MovimentoEspiritual()
        params.secretario = null
        params.dateCreated = null
        params.lastUpdated = null
        movimentoEspiritual.properties = params
        movimentoEspiritual.secretario = congregado
        movimentoEspiritual.save(failOnError: true)
        request.withFormat {
//            form multipartForm {
//                flash.message = "Salvo com sucesso"
//                redirect histEspiritual
//            }
            '*' { render status: HttpStatus.CREATED }
        }
    } // save

    def show(Long id) {
        def mov = MovimentoEspiritual.get(id)
        if (!mov)
            render view: '/notFound', status: HttpStatus.NOT_FOUND
        [mov: mov]
    }

}
