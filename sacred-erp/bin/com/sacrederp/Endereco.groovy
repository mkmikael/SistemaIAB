package com.sacrederp

class Endereco {

    TipoEndereco tipo = TipoEndereco.OUTRO
    String logradouro
    String numero
    String complemento
    String bairro
    Cidade cidade

    static belongsTo = [participante: Participante]
    static constraints = {
        complemento nullable: true
        numero      nullable: true
    }
}
