package br.edu.ifpb.pdm.francisco.mytodolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import br.edu.ifpb.pdm.francisco.mytodolist.activity.FormActivity
import br.edu.ifpb.pdm.francisco.mytodolist.model.ToDo
import java.io.Serializable
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var todos: ArrayList<Serializable> = criarTodos();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: View = findViewById(R.id.fabMain)
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            val FORM = 1
            startActivityForResult(intent, FORM)
        }

        val lista = findViewById<View>(R.id.lvMain) as ListView
        val adapter = ArrayAdapter<Serializable>(this, android.R.layout.simple_list_item_1, todos)
        lista.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            val todo = data!!.getSerializableExtra("TODO")
            val lista = findViewById<View>(R.id.lvMain) as ListView
            this.todos.add(todo)
            val adapter = ArrayAdapter<Serializable>(this, android.R.layout.simple_list_item_1, todos)
            lista.setAdapter(adapter)
        }
    }

    private fun criarTodos(): ArrayList<Serializable> {
        return ArrayList()
    }
}
