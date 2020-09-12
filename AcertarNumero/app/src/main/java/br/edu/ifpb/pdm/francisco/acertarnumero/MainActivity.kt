package br.edu.ifpb.pdm.francisco.acertarnumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var sbChute: SeekBar
    private lateinit var tvMainDivisores: TextView
    private lateinit var tvMainParImpar: TextView
    private lateinit var tvMainQntDivisores: TextView
    private lateinit var tvChute: TextView
    private var numero: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar as variáveis
        this.sbChute = findViewById(R.id.sbChute)
        this.tvMainDivisores = findViewById(R.id.tvMainDivisores)
        this.tvMainParImpar = findViewById(R.id.tvMainParImpar)
        this.tvMainQntDivisores = findViewById(R.id.tvMainQntDivisores)
        this.tvChute = findViewById(R.id.tvChute)
        val btnJogar = findViewById<Button>(R.id.btnJogar)

        //Setar os valores
        setarValores()

        //Setar listeners
        btnJogar.setOnClickListener {
            if (this.sbChute.progress.toString()  == this.numero.toString()) {
                Toast.makeText(this, "VOCÊ ACERTOU!", Toast.LENGTH_SHORT).show()
                setarValores()
            } else {
                Toast.makeText(this, "VOCÊ ERROU! VALOR CORRETO: ${this.numero}", Toast.LENGTH_SHORT).show()
                setarValores()
            }
        }

        this.sbChute!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                tvChute.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })


    }

    override fun onPause() {
        super.onPause()
        setarValores()
    }

    //Criar novo valor pro jogo
    fun setarValores() {
        this.numero = Random.nextInt(1, 100)
        Log.d("APP_ACERTE", "Numero: ${this.numero}!")
        this.tvMainDivisores.text = divisores(this.numero)
        this.tvMainParImpar.text = imparOuPar(this.numero)
        this.tvMainQntDivisores.text = qntDivisores(this.numero)
    }

    //Criar os divisores
    fun divisores(numero: Int): String {
        val res = mutableListOf<Int>()
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach {
            e ->
                if (numero%e == 0) {
                    res += listOf(e)
                }
        }
        return res.joinToString()
    }

    //Definir se número é ímpar ou par
    fun imparOuPar(numero: Int): String {
        if (numero%2 == 0) return "par"
        else return "ímpar"
    }

    //Contar os divisores do número
    fun qntDivisores(numero: Int): String { //Patrocinado pelo google.com
        var limit = numero
        var numberOfDivisors = 0

        if (numero == 1) return "1"

        for (i in 1 until limit) {
            if (numero % i == 0) {
                limit = numero / i
                if (limit != i) {
                    numberOfDivisors++
                }
                numberOfDivisors++
            }
        }

        return numberOfDivisors.toString()
    }

}
