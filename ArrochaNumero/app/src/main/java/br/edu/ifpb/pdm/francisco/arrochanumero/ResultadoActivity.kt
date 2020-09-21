package br.edu.ifpb.pdm.francisco.arrochanumero

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var tvResultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado_activity)
        this.tvResultado = findViewById(R.id.tvResultado)
        this.tvResultado.text = intent.getStringExtra("MENSAGEM")
    }
}