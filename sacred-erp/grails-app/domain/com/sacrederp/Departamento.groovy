package com.sacrederp

class Departamento extends Papel {

    Departamento centralizador

    static hasMany = [membros: Membro]
    static belongsTo = [congregacao: Congregacao]
    static constraints = {
    }
}
