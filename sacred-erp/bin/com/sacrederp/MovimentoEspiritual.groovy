package com.sacrederp

class MovimentoEspiritual {

    Date dateCreated
    Date lastUpdated
    Integer mes
    Integer ano

    Integer jovensMatriculados = 0
    Integer jovensMembros = 0
    Integer cultoOficial = 0
    Integer cultoLivres = 0
    Integer cultoDomiciliar = 0
    Integer cultoTreinamento = 0
    Integer palestras = 0
    Integer reunioesOracaoEnsaio = 0
    Integer campanhaOracao = 0
    Integer consagracoes = 0
    Integer vigilias = 0
    Integer cruzadas = 0
    Integer evangelismos = 0
    Integer pessoasEvangelizadas = 0
    Integer literaturas = 0
    Integer casasVisitas = 0
    Integer decisoes = 0
    Integer reconciliacoes = 0
    Integer batismoEspiritoSanto = 0
    Integer curasDivinas = 0

    Departamento departamento
    Congregado tesoureiro

    static constraints = {
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }
}
