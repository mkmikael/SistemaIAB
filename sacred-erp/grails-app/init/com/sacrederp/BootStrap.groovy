package com.sacrederp

import com.sacrederp.security.Role
import com.sacrederp.security.User
import com.sacrederp.security.UserRole
import grails.web.servlet.mvc.GrailsParameterMap

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class BootStrap {

    def init = { servletContext ->
        initTest()
        paramsDecimal()
    }
    def destroy = {
    }

    def paramsDecimal() {
        GrailsParameterMap.metaClass.decimal = { String value ->
            def lang = delegate.getRequest().getHeader('Accept-Language') ?: ''
            def locale = Locale.forLanguageTag(lang)
            def df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(locale))
            def v = delegate[value]
            df.parse(v)
        }
    }

    def initTest() {
        Congregacao.withTransaction { status ->
            if (Organizacao.findByNome('Congregação Boas Novas')) {
                return
            }
            try {
                def congregacao = new Congregacao()
                def org = new Organizacao()
                org.nome = "Congregação Boas Novas"
                org.save(flush: true)
                congregacao.participante = org
                congregacao.save(flush: true)

                def dep = new Departamento()
                dep.congregacao = congregacao
                org = new Organizacao()
                org.nome = "Departamento de Jovens da Congregação Boas Novas"
                dep.participante = org
                org.save(flush: true)
                dep.save(flush: true)

                def funcao = new Funcao()
                funcao.nome = 'Secretário(a)'
                funcao.save(flush: true)

                funcao = new Funcao()
                funcao.nome = 'Tesoureiro(a)'
                funcao.save(flush: true)

                def membro = new Membro()
                def pessoa = new Pessoa()
                pessoa.nome = "Franciane Beltrão"
                pessoa.save(flush: true)
                membro.participante = pessoa
                membro.save(flush: true)

                def congregado = new Congregado()
                congregado.departamento = dep
                congregado.membro = membro
                congregado.entrada = new Date()
                congregado.funcao = funcao
                congregado.save(flush: true)

                def user = new User()
                user.username = 'anne'
                user.password = 'anne'
                user.save(flush: true)
                membro.user = user
                membro.save(flush: true)

                def role = Role.findOrSaveByAuthority('ROLE_USER')

                def userRole = new UserRole()
                userRole.user = user
                userRole.role = role
                userRole.save(flush: true)

                user = new User()
                user.username = 'admin'
                user.password = 'admin'
                user.save(flush: true)
//                Role.findOrSaveByAuthority('ROLE_SECRETARIO')
//                Role.findOrSaveByAuthority('ROLE_TESOUREIRO')
                Role.findOrSaveByAuthority('ROLE_USER')
                role = Role.findOrSaveByAuthority('ROLE_ADMIN')

                userRole = new UserRole()
                userRole.user = user
                userRole.role = role
                userRole.save(flush: true)
            } catch (Exception e) {
                status.setRollbackOnly()
                println e
            }
        } // withTransaction
    } // initTest

}
