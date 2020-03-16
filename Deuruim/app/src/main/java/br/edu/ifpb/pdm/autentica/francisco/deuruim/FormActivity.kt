package br.edu.ifpb.pdm.autentica.francisco.deuruim

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var sbNota: SeekBar
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var btFoto: Button
    private lateinit var ivFoto: ImageView
    private lateinit var tvForm: TextView
    private var imagem: Bitmap? = null

    val CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.sbNota = findViewById(R.id.sbFormNota)
        this.tvForm = findViewById(R.id.tvFormProgress)
        this.sbNota!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                tvForm.setText("Nota: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })


        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener({ salvar() })
        this.btCancelar.setOnClickListener({
            finish()
        })

        this.ivFoto = findViewById(R.id.ivFormFoto)
        this.btFoto = findViewById(R.id.btFormFoto)
        this.btFoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == CAMERA){
                imagem = data?.extras?.get("data") as Bitmap
                this.ivFormFoto.setImageBitmap(imagem)
            }
        }
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbNota.progress


        val evento = Evento(descricao, nota, imagem)

        val intent = Intent()
        intent.putExtra("EVENTO", evento)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}