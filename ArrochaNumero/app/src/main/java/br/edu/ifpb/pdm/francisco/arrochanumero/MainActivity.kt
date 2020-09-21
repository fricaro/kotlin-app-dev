package br.edu.ifpb.pdm.francisco.arrochanumero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var etChute: EditText
    private lateinit var tvMainIntervaloSuperior: TextView
    private lateinit var tvMainIntervaloInferior: TextView
    private var limiteSuperior: Int = 100
    private var limiteInferior: Int = 1
    private var numero: Int = Random.nextInt(limiteInferior, limiteSuperior)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar as variáveis
        this.etChute = findViewById(R.id.etChute)
        this.tvMainIntervaloSuperior = findViewById(R.id.tvMainIntervaloSuperior)
        this.tvMainIntervaloSuperior.text = limiteSuperior.toString()
        this.tvMainIntervaloInferior = findViewById(R.id.tvMainIntervaloInferior)
        this.tvMainIntervaloInferior.text = limiteInferior.toString()
        val btnJogar = findViewById<Button>(R.id.btnJogar)

        //Setar listeners
        btnJogar.setOnClickListener {
            if (this.numero + 1 == this.limiteSuperior && this.numero - 1 == this.limiteInferior) {
                val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
                val msg = "VENCEU INFILIZ"
                intent.putExtra("MENSAGEM", msg)
                startActivityForResult(intent, 1)
            } else if (this.etChute.text.toString().toInt()  == this.numero) {
                val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
                val msg = "PERDESSE VISSE"
                intent.putExtra("MENSAGEM", msg)
                startActivityForResult(intent, 2)
            } else if (this.etChute.text.toString().toInt()  == this.limiteInferior){
                val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
                val msg = "PERDESSE VISSE"
                intent.putExtra("MENSAGEM", msg)
                startActivityForResult(intent, 2)
            } else if (this.etChute.text.toString().toInt()  == this.limiteSuperior) {
                val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
                val msg = "PERDESSE VISSE"
                intent.putExtra("MENSAGEM", msg)
                startActivityForResult(intent, 2)
            } else if (this.etChute.text.toString().toInt() > this.numero && this.etChute.text.toString().toInt() < this.limiteSuperior) {
                this.setarValores(this.etChute.text.toString().toInt(), this.limiteInferior)
            } else if (this.etChute.text.toString().toInt() < this.numero && this.etChute.text.toString().toInt() > this.limiteInferior) {
                this.setarValores(this.limiteSuperior, this.etChute.text.toString().toInt())
            } else {
                Toast.makeText(this, "NÚMERO INVÁLIDO," +
                        "UTILIZAR NÚMEROS DENTRO DO INTERVALO!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setarValores(sup: Int, inf: Int) {
        this.limiteSuperior = sup
        this.tvMainIntervaloSuperior.text = limiteSuperior.toString()
        this.limiteInferior = inf
        this.tvMainIntervaloInferior.text = limiteInferior.toString()
        Log.d("APP_ARROCHA", "Numero: ${this.numero}!")
    }

}
