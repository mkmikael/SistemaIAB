package com.sacrederp

class Telefone {

    String ddd
    String numero
    String ramal

    static belongsTo = [participante: Participante]
    static constraints = {
        ramal nullable: true
    }

    String toString() {
        "($ddd) $numero"
    }
}
