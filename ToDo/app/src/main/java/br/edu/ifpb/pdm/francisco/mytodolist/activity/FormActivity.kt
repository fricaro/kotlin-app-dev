package br.edu.ifpb.pdm.francisco.mytodolist.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.edu.ifpb.pdm.francisco.mytodolist.R
import br.edu.ifpb.pdm.francisco.mytodolist.banco.ToDoDAO
import br.edu.ifpb.pdm.francisco.mytodolist.model.ToDo

class FormActivity:  AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var etStatus: EditText
    private lateinit var etPrioridade: EditText
    private lateinit var btSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_activity)

        this.etDescricao = findViewById(R.id.etDescricao)
        this.etPrioridade = findViewById(R.id.etPrioridade)
        this.etStatus = findViewById(R.id.etStatus)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btSalvar.setOnClickListener({ salvar() })
    }

    fun salvar(){
        val intent = Intent()
        val banco = ToDoDAO(this)
        val todo = ToDo(
            this.etDescricao.text.toString(),
            this.etPrioridade.text.toString().toInt(),
            this.etStatus.text.toString()
        )
        banco.inserir(todo)
        intent.putExtra("TODO", todo)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}