package com.sacrederp

class Congregado {

    Date dateCreated
    Date lastUpdated
    Funcao funcao
    Membro membro
    Departamento departamento
    Date entrada
    Date saida
    Boolean ativo = true

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

    String toString() {
        membro
    }

}
