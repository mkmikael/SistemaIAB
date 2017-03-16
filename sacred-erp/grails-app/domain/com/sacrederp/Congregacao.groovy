package com.sacrederp

class Congregacao extends Papel {

    static hasMany = [departamentos: Departamento]
    static constraints = {
    }
}
