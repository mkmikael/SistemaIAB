package com.sacrederp

import org.hibernate.criterion.CriteriaSpecification

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

    Congregado secretario

    static constraints = {
    }

    def getReferencia() {
        sprintf("%02d", mes) + '/' + ano
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    static Map totalGeral() {
        MovimentoEspiritual.createCriteria().get {
            projections {
                sum('jovensMatriculados', 'Jovens Matriculados')
                sum('jovensMembros', 'Jovens Membros')
                sum('cultoOficial', 'Culto Oficial')
                sum('cultoLivres', 'Culto Livres')
                sum('cultoDomiciliar', 'Culto Domicíliar')
                sum('cultoTreinamento', 'Culto Treinamento')
                sum('palestras', 'Palestras')
                sum('reunioesOracaoEnsaio', 'Reuniões Oração Ensaio')
                sum('campanhaOracao', 'Campanha Oração')
                sum('consagracoes', 'Consagrações')
                sum('vigilias', 'Vigílias')
                sum('cruzadas', 'Cruzadas')
                sum('evangelismos', 'Evangelismos')
                sum('pessoasEvangelizadas', 'Pessoas Evangelizadas')
                sum('literaturas', 'Literaturas')
                sum('casasVisitas', 'Casas Visitas')
                sum('decisoes', 'Decisões')
                sum('reconciliacoes', 'Reconciliações')
                sum('batismoEspiritoSanto', 'Batismo no Espirito Santo')
                sum('curasDivinas', 'Curas Divínas')
            }
            resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
        }
    }
}
