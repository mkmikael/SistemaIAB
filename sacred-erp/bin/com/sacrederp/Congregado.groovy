package com.sacrederp

class Congregado {

    Date dateCreated
    Date lastUpdated
    Funcao funcao
    Membro membro
    Congregacao congregacao
    Date entrada
    Date saida

    static constraints = {
        saida        nullable: true
        dateCreated  nullable: true
        lastUpdated  nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}
