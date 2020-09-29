package br.edu.ifpb.pdm.francisco.truecolorslollipop

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import br.edu.ifpb.pdm.francisco.truecolorslollipop.Activity.FormActivity
import br.edu.ifpb.pdm.francisco.truecolorslollipop.Adapter.CorAdapter
import br.edu.ifpb.pdm.francisco.truecolorslollipop.Model.Cor
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var cores: ArrayList<Cor> = todosAsCores()
    val FORM = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: View = findViewById(R.id.fabMain)
        fab.setOnClickListener(OnClickBotao())


        // PREGUIÇA DE REFATORAR POIS FOME
        val lista = findViewById<View>(R.id.lvMain) as ListView
        val adapter = CorAdapter(cores, this)
        lista.setAdapter(adapter)

        lista.setOnItemClickListener { parent, view, position, id ->
            cores.removeAt(position)
            lista.adapter = CorAdapter(cores, this)
        }
    }

    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            startActivityForResult(intent, FORM)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            val cor = data!!.getParcelableExtra<Cor>("COR")
            val lista = findViewById<View>(R.id.lvMain) as ListView
            this.cores.add(cor)
            val adapter = CorAdapter(cores, this)
            lista.setAdapter(adapter)
        }
    }

    private fun todosAsCores(): ArrayList<Cor> {
        return ArrayList(
            Arrays.asList(
                Cor("ff0000"),
                Cor("e895aa"),
                Cor("001e3d")
            )
        )
    }
}
