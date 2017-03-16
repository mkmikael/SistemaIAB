package com.sacrederp

class Participante {

    Date dateCreated
    Date lastUpdated
    String nome
    String nomeFantasia
    String doc

    static hasMany = [papeis: Papel, telefones: Telefone, enderecos: Endereco]
    static constraints = {
        nomeFantasia nullable: true
        doc          nullable: true
        dateCreated  nullable: true
        lastUpdated  nullable: true
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    String toString() { nome }

}
