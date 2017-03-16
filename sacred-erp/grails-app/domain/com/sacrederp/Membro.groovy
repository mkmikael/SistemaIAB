package com.sacrederp

class Membro extends Papel {

    static hasMany = [funcoes: Funcao, departamentos: Departamento]
    static belongsTo = [Funcao, Departamento]
    static constraints = {
    }
}
