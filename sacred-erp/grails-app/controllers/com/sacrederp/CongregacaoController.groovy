package com.sacrederp

import grails.transaction.Transactional
import org.springframework.http.HttpStatus

@Transactional(readOnly = true)
class CongregacaoController {

    static allowedMethods = [delete: 'DELETE', save: 'POST']

    def index() {
        if (!params.max)
            params.max = 50
        if (!params.sort) {
            params.sort = 'dateCreated'
            params.order = 'desc'
        }
        def congList = Congregacao.list(params)
        def congCount = Congregacao.count()
        [congList: congList, congCount: congCount]
    }

    def show(Long id) {
        def cong = Congregacao.get(id)
        if (!cong) {
            render uri: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        [cong: cong]
    }

    def create() {
        [cong: new Congregacao()]
    }

    def edit(Long id) {
        def cong = Congregacao.get(id)
        if (!cong) {
            render uri: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        [cong: cong]
    }

    @Transactional
    def save() {
        def cong
        def part
        if (params.id) {
            cong = Congregacao.get(params.long('id'))
            part = cong.participante
        } else {
            cong = new Congregacao()
            cong.participante = new Organizacao()
            part = cong.participante
        }
        part.nome = params.nome
        part.save(failOnError: true)
        cong.save(failOnError: true)
        redirect action: 'show', id: cong.id
    }

    @Transactional
    def delete(Long id) {
        def cong = Congregacao.get(id)
        if (!cong) {
            render uri: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        cong.delete(flush: true)
        redirect(action: 'index')
    }

}
