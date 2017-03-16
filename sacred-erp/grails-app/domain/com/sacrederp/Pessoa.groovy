package com.sacrederp

class Pessoa extends Participante {

    Date dataNascimento
    Sexo sexo

    static constraints = {
        dataNascimento nullable: true
        sexo nullable: true
    }
}
