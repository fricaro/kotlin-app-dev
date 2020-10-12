package br.edu.ifpb.pdm.francisco.mytodolist.banco

import android.content.ContentValues
import android.content.Context
import br.edu.ifpb.pdm.francisco.mytodolist.utils.Status
import br.edu.ifpb.pdm.francisco.mytodolist.model.ToDo

class ToDoDAO {

    var banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    fun inserir(toDo: ToDo) {
        val cv = ContentValues()
        cv.put("descricao", toDo.descricao)
        cv.put("prioridade", toDo.prioridade)
        cv.put("status", getStatus(toDo.status))
        this.banco.writableDatabase.insert("todo", null, cv)
    }

    fun editar(toDo: ToDo) {
        val cv = ContentValues()
        val where = "id = ?"
        val wherep = arrayOf(toDo.id.toString())
        cv.put("descricao", toDo.descricao)
        cv.put("prioridade", toDo.prioridade)
        cv.put("status", getStatus(toDo.status))
        this.banco.writableDatabase.update("todo", cv, where, wherep)

    }

    fun remover(id: Int) {
        val where = "id = ?"
        val wherep = arrayOf(id.toString())
        this.banco.writableDatabase.delete("todo", where, wherep)
    }

    fun getAllToDo(): ArrayList<ToDo> {
        val lista = ArrayList<ToDo>()
        val colunas = arrayOf("id", "descricao", "prioridade", "status")
        val c = this.banco.readableDatabase.query("todo", colunas, null, null, null, null, null)
        if (c.count > 0) {
            c.moveToFirst()
            do {
                val id = c.getInt(0)
                val descricao = c.getString(1)
                val prioridade = c.getInt(2)
                val status = c.getString(3)
                lista.add(
                    ToDo(
                        id,
                        descricao,
                        prioridade,
                        getStatus(status)
                    )
                )
            } while(c.moveToNext())
        }
        return lista
    }

    fun getToDo(id: Int): ToDo? {
        val colunas = arrayOf("id", "descricao", "prioridade", "status")
        val c = this.banco.readableDatabase.query("todo", colunas, null, null, null, null, null)
        if (c.count > 0) {
            c.moveToFirst()
            do {
                if (id == c.getInt(0)) {
                    val id2 = c.getInt(0)
                    val descricao = c.getString(1)
                    val prioridade = c.getInt(2)
                    val status = c.getString(3)
                    return ToDo(
                        id2,
                        descricao,
                        prioridade,
                        getStatus(status)
                    )
                }
            } while(c.moveToNext())
        }
        return null
    }

    private fun getStatus(status: Status): String {
        return when (status) {
            Status.ABERTO -> "aberto"
            Status.EXECUTANDO -> "executando"
            Status.CONCLUIDO -> "concluido"
        }
    }

    private fun getStatus(status: String): Status {
        return when (status) {
            "aberto" -> Status.ABERTO
            "executando" -> Status.EXECUTANDO
            "concluido" -> Status.CONCLUIDO
            else -> Status.ABERTO
        }
    }
}