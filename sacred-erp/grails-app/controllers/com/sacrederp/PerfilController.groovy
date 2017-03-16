package com.sacrederp

import com.sacrederp.security.User
import grails.converters.JSON

class PerfilController {

    def index() { }

    def infoUser(String username) {
        def user = User.findByUsername(username)
        if (!user)
            throw new RuntimeException('O usuário não foi encontrado.')
        def membro = Membro.findByUser(user)
        if (!membro)
            throw new RuntimeException('O membro não foi encontrado.')
        def congs = Congregado.findAllByMembroAndAtivo(membro, true)
        def list = []
        congs.each { c ->
            def map = [:]
            map.congId = c.id
            map.funcao = c.funcao.nome
            map.depId = c.departamento.id
            list << map
        }
        render(text: list as JSON)
    }

}
