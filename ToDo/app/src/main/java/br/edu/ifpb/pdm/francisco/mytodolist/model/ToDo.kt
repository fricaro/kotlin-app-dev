package br.edu.ifpb.pdm.francisco.mytodolist.model

import br.edu.ifpb.pdm.francisco.mytodolist.utils.Status
import java.io.Serializable

class ToDo : Serializable {

    var id: Int
    var descricao: String
    var prioridade: Int
    var status: Status

    constructor(id: Int, descricao: String, prioridade: Int, status: Status ) {
        this.id = id
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = status
    }

    constructor(descricao: String, prioridade: Int, status: Status ) {
        this.id = -1
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = status
    }

    constructor(descricao: String, prioridade: Int, status: String ) {
        this.id = -1
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = toStatus(status)
    }

    private fun toStatus(status: String): Status {
        return when (status) {
            "aberto" -> Status.ABERTO
            "executando" -> Status.EXECUTANDO
            "concluido" -> Status.CONCLUIDO
            else -> Status.ABERTO
        }
    }
}