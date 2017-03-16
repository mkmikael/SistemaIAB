package com.sacrederp

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import org.springframework.http.HttpStatus

@Transactional(readOnly = true)
class CongregadoController {

    static allowedMethods = [save: 'POST', delete: 'DELETE']
    SpringSecurityService springSecurityService

    @Transactional
    def save() {
        def congregado = new Congregado()
        congregado.properties = params
        def dep = congregado.departamento
        def func = congregado.funcao
        def mem = congregado.membro
        def result = [:]
        if (Congregado.findByDepartamentoAndFuncaoAndMembroAndAtivo(dep, func, mem, true)) {
            result.status = 'error'
            result.msg = "O membro ja esta no $dep com a funçao de $func"
        } else {
            congregado.entrada = new Date()
            congregado.save(failOnError: true)
            def congregadoList = Congregado.withCriteria {
                eq('membro', congregado.membro)
                eq('ativo', true)
            }
            result.status = 'success'
            result.html = g.render(template: '/congregado/list', model: [congregadoList: congregadoList])
        }
        render text: result as JSON, contentType: 'application/json'
    }

    @Transactional
    def delete(Long id) {
        def congregado = Congregado.get(id)
        if (!congregado) {
            render view: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        congregado.ativo = false
        congregado.saida = new Date()
        congregado.save()
        def result = [msg: 'O acesso foi removido com sucesso.']
        def congregadoList = Congregado.withCriteria {
            eq('membro', congregado.membro)
            eq('ativo', true)
        }
        result.status = 'success'
        result.html = g.render(template: '/congregado/list', model: [congregadoList: congregadoList])
        render text: result as JSON, contentType: 'application/json', status: HttpStatus.OK
    }

}
