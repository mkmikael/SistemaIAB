package com.sacrederp

class Papel {

    Date dateCreated
    Date lastUpdated

    static belongsTo = [participante: Participante]
    static constraints = {
        dateCreated nullable: true
        lastUpdated nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    String toString() { participante.nome }
}
