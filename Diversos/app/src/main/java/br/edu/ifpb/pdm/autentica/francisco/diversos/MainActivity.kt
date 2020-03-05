package br.edu.ifpb.pdm.autentica.francisco.diversos


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnHtml).setOnClickListener {
            html()
        }

        findViewById<Button>(R.id.btnDiscar).setOnClickListener {
            discar()
        }

        findViewById<Button>(R.id.btnLigar).setOnClickListener {
            ligar()
        }

        findViewById<Button>(R.id.btnCompartilhar).setOnClickListener {
            compartilhar()
        }

        findViewById<Button>(R.id.btnEmail).setOnClickListener {
            email()
        }

        findViewById<Button>(R.id.btnPonto).setOnClickListener {
            ponto()
        }

        findViewById<Button>(R.id.btnRota).setOnClickListener {
            rota()
        }

        findViewById<Button>(R.id.btnSms).setOnClickListener {
            sms()
        }

        findViewById<Button>(R.id.btnYoutube).setOnClickListener {
            youtube()
        }

        findViewById<Button>(R.id.btnFoto).setOnClickListener {
            foto()
        }

    }

    fun html() {
        val uri = Uri.parse("http://www.ifpb.edu.br")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun discar() {
        val uri = Uri.parse("tel:36121392")

        val intent = Intent(Intent.ACTION_DIAL, uri)

        startActivity(intent)
    }


    fun ligar() {
        val uri = Uri.parse("tel:36121392")

        val intent = Intent(Intent.ACTION_CALL, uri)

        val call = Manifest.permission.CALL_PHONE

        val granted = PackageManager.PERMISSION_GRANTED

        if (ContextCompat.checkSelfPermission(this, call) == granted) {
            startActivity(intent)
        }
    }

    fun compartilhar() {
        val intent = Intent(Intent.ACTION_SEND)

        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,

            "Texto para compartilhar")

        // intent.setPackage("com.whatsapp")

        if (intent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(intent, "Compartilhar"))
        }
    }

    fun email() {
        val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")

        val intent = Intent(Intent.ACTION_SENDTO, uri)

        intent.putExtra(Intent.EXTRA_SUBJECT,

            "Assunto")

        intent.putExtra(Intent.EXTRA_TEXT,

            "Texto")

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun ponto() {
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun rota() {
        val origem =

            "-7.1356496,-34.8760932"

        val destino =

            "-7.1181836,-34.8730402"

        val url = "http://maps.google.com/maps"

        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun sms() {
        val uri = Uri.parse("sms:36121392")

        val intent = Intent(Intent.ACTION_SENDTO, uri)

        intent.putExtra("sms_body"
            ,
            "Mensagem")

        startActivity(intent)
    }

    fun youtube() {
        val uri = Uri.parse("vnd.youtube://dglqGGyWbVo")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun foto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        startActivity(intent)
    }

}
