package web.smedim

import com.sacrederp.Congregacao
import com.sacrederp.Congregado
import com.sacrederp.Departamento
import com.sacrederp.Funcao
import com.sacrederp.Membro
import com.sacrederp.Organizacao
import com.sacrederp.Pessoa

class BootStrap {

    def init = { servletContext ->
        initTest()
    }
    def destroy = {
    }

    def initTest() {
        Congregacao.withTransaction { status ->
            if (Organizacao.findByNome('Congregação Boas Novas')) {
                return
            }
            try {
                def congregacao = new Congregacao()
                def org = new Organizacao()
                congregacao.participante = org
                org.nome = "Congregação Boas Novas"
                org.save()
                congregacao.save()

                def dep = new Departamento()
                dep.congregacao = congregacao
                org = new Organizacao()
                org.nome = "Departamento de Jovens da Congregação Boas Novas"
                dep.participante = org
                org.save()
                dep.save()

                def funcao = new Funcao()
                funcao.nome = 'Secretária'
                funcao.save()

                def membro = new Membro()
                def pessoa = new Pessoa()
                pessoa.nome = "Franciane Beltrão"
                pessoa.save()
                membro.participante = pessoa
                membro.save()

                def congregado = new Congregado()
                congregado.congregacao = congregacao
                congregado.membro = membro
                congregado.entrada = new Date()
                congregado.funcao = funcao
                congregado.save()
            } catch (Exception e) {
                status.setRollbackOnly()
            }
        } // withTransaction
    } // initTest

}
