package com.sacrederp

class Cidade {

    Estado estado
    String nome

    static constraints = {
    }

    String toString() { "$nome - $estado.uf" }
}
