package br.edu.ifpb.pdm.autentica.francisco.imagens

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var btCamera : Button
    private lateinit var btArquivo : Button
    private lateinit var btDownload : Button
    private lateinit var ivImagem : ImageView


    val CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btCamera = findViewById(R.id.btCamera)
        this.btArquivo = findViewById(R.id.btArquivo)
        this.btDownload = findViewById(R.id.btDownload)
        this.ivImagem = findViewById(R.id.ivImagem)


        this.btCamera.setOnClickListener{ camera() }
        this.btArquivo.setOnClickListener{ xml() }
        this.btDownload.setOnClickListener{ download() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == CAMERA){
                val imagem = data?.extras?.get("data") as Bitmap
                this.ivImagem.setImageBitmap(imagem)
            }
        }
    }

    fun camera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }

    fun xml(){
        this.ivImagem.setImageResource(R.drawable.super_mario)
    }

    fun downloadDaImagem(url: String?) : Bitmap{
        URL(url).openStream().use {
            val imagem = BitmapFactory.decodeStream(it)
            return imagem
        }
    }

    fun createSmHandler(formato: String?) {
        val handler = Handler()
        val url = "http://www.valeria.eti.br/sm/sm_${formato}.png"
        Thread {
            val imagem = this.downloadDaImagem(url)

            handler.post{
                this.ivImagem.setImageBitmap(imagem)
            }
        }.start()
    }

    fun download(){
        var selection: String? = null
        val resolutions = resources.getStringArray(R.array.sm_resolution)
        AlertDialog.Builder(this)
            .setTitle("Escolha um tamanho.")
            .setSingleChoiceItems(resolutions,0) { dialogInterface, which ->
                selection = resolutions[which]

            }
            .setPositiveButton("Ok") { dialog, i ->
                createSmHandler(selection)
            }
            .create()
            .show()


    }
}