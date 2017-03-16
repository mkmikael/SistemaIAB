package com.sacrederp

class Departamento extends Papel {

    static hasMany = [membros: Membro]
    static belongsTo = [congregacao: Congregacao]
    static constraints = {
    }
}
