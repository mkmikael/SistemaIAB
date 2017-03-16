package com.sacrederp

import grails.transaction.Transactional
import org.springframework.http.HttpStatus

class MovimentoEspiritualController {

    static allowedMethods = [index: 'GET', save: 'POST']

    def index() {
        respond MovimentoEspiritual.list(params), formats: ['json', 'xml']
    }

    def view(Integer mes) {
        def ano = Calendar.instance.get(Calendar.MONTH)
        def movimentoEspiritual = MovimentoEspiritual.findByAnoAndMes(ano, mes) ?: new MovimentoEspiritual()
        respond movimentoEspiritual, formats: ['json', 'xml']
    }

    @Transactional
    def save(Integer mes) {
        def ano = Calendar.instance.get(Calendar.MONTH)
        def movimentoEspiritual = MovimentoEspiritual.findByAnoAndMes(ano, mes)
        if (!movimentoEspiritual)
            movimentoEspiritual = new MovimentoEspiritual()
        movimentoEspiritual.properties = params
        movimentoEspiritual.ano = ano
        movimentoEspiritual.save(failOnError: true)
        request.withFormat {
//            form multipartForm {
//                flash.message = "Salvo com sucesso"
//                redirect histEspiritual
//            }
            '*' { render status: HttpStatus.CREATED }
        }
    }

}
