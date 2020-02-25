package br.edu.ifpb.pdm.expobre.francsco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var tvNumeros : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvNumeros = findViewById(R.id.tvNumbers)

        val btnClick = findViewById(R.id.btn_click_me) as Button
        btnClick.setOnClickListener {
            this.tvNumeros.text = MegaSena.getInstance().joinToString(" ")
        }
    }
}
