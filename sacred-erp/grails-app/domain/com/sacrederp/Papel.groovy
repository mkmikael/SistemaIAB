package com.sacrederp

import com.sacrederp.security.User

class Papel {

    Date dateCreated
    Date lastUpdated
    StatusPapel statusPapel = StatusPapel.ATIVO

    static belongsTo = [participante: Participante, user: User]
    static constraints = {
        dateCreated nullable: true
        lastUpdated nullable: true
        user        nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    String toString() { participante.nome }
}
