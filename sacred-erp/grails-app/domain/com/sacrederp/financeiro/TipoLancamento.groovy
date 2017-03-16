package com.sacrederp.financeiro

/**
 * Created by mikael on 14/02/17.
 */
enum TipoLancamento {
    PAGAR('DESPESA'), RECEBER('RECEITA'), TAXA_DEPARTAMENTO('TAXA DEPARTAMENTO'), OFERTA('OFERTA'), DIZIMO('DÍZIMO')

    String nome

    TipoLancamento(String nome) {
        this.nome = nome
    }

    static List<TipoLancamento> toList() {
        [PAGAR, RECEBER]
    }

    String toString() {
        nome
    }
}
