package br.edu.ifpb.pdm.francisco.truecolorslollipop.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifpb.pdm.francisco.truecolorslollipop.Model.Cor
import br.edu.ifpb.pdm.francisco.truecolorslollipop.R


class FormActivity : AppCompatActivity() {
    private lateinit var etCor: EditText
    private lateinit var btSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etCor = findViewById(R.id.etFormCor)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btSalvar.setOnClickListener({ salvar() })
    }

    fun salvar(){
        val intent = Intent()
        intent.putExtra("COR", Cor(this.etCor.text.toString()))
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}