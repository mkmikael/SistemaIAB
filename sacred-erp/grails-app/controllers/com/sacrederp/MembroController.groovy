package com.sacrederp

import com.sacrederp.security.Role
import com.sacrederp.security.User
import com.sacrederp.security.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import org.springframework.http.HttpStatus

class MembroController {

    SpringSecurityService springSecurityService

    def index() {
        if (!params.max)
            params.max = 50
        if (!params.sort) {
            params.sort = 'dateCreated'
            params.order = 'desc'
        }
        def criteria = {
            eq('statusPapel', StatusPapel.ATIVO)
        }
        def membroList = Membro.createCriteria().list(params, criteria)
        def membroCount = Membro.createCriteria().count(criteria)
        [membroList: membroList, congCount: membroCount]
    }

    def show(Long id) {
        def membro = Membro.get(id)
        if (!membro) {
            render uri: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        def congregadoList = Congregado.withCriteria {
            eq('membro', membro)
            eq('ativo', true)
        }
        [membro: membro, congregadoList: congregadoList]
    }

    def create() {
        [membro: new Membro()]
    }

    def edit(Long id) {
        def membro = Membro.get(id)
        if (!membro) {
            render uri: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        [membro: membro]
    }

    @Transactional
    def save() {
        def membro
        def part
        if (params.id) {
            membro = Membro.get(params.long('id'))
            part = membro.participante
        } else {
            membro = new Membro()
            membro.participante = new Pessoa()
            part = membro.participante
        }
        params.participante.dataNascimento = params.date('participante.dataNascimento', 'dd/MM/yyyy')
        part.properties = params.participante
        part.save(failOnError: true)
        membro.save(failOnError: true)

        def user
        if (params.user?.id) {
            user = User.get(params.long('user.id'))
        } else {
            user = new User()
        }
        user.properties = params.user
        user.save(failOnError: true)
        def role = Role.findOrSaveByAuthority('ROLE_USER')
        if (!UserRole.findByUserAndRole(user, role)) {
            user.addToPapeis(membro)
            def userRole = new UserRole()
            userRole.user = user
            userRole.role = role
            userRole.save(failOnError: true)
        }
        redirect action: 'show', id: membro.id
    }

    @Transactional
    def delete(Long id) {
        def membro = Membro.get(id)
        if (!membro) {
            render uri: '/notFound', status: HttpStatus.NOT_FOUND
            return
        }
        membro.statusPapel = StatusPapel.INATIVO
        membro.save()
        redirect(action: 'index')
    }

}
