package com.sacrederp

/**
 * Created by mikael on 14/02/17.
 */
class Funcao {

    String nome

    static hasMany = [membros: Membro]
    static constraints = {
    }

    String toString() { nome }
}
