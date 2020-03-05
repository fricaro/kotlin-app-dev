package br.edu.ifpb.pdm.autentica.francisco.diversos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import android.app.Activity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST = 100
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.imageView = this.findViewById<ImageView>(R.id.imageView1)
        val photoButton = this.findViewById<Button>(R.id.button1)
        photoButton.setOnClickListener {
            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            val photo = data!!.extras!!.get("data") as Bitmap?
            imageView?.setImageBitmap(photo)
        }
    }
}
