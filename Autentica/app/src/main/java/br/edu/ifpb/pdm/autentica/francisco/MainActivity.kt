package br.edu.ifpb.pdm.autentica.francisco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etLogin = findViewById<EditText>(R.id.etLogin)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnCancel = findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            etLogin.setText("")
            etPassword.setText("")

            Log.i("APP_AUTENTICA", "User cancelled operation.")
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT)
        }

        val btnOk = findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener {
            if (etLogin.text.toString() == "admin" && etPassword.text.toString() == "1234") {
                Log.i("APP_AUTENTICA", "Login susscessful for ${etLogin.text.toString()}!")
                val intent = Intent(this, LoginSuccessfulActivity::class.java)
                startActivity(intent)
            } else {
                Log.i("APP_AUTENTICA", "Failed to login.")
                Toast.makeText(this, "Wrong login/password.", Toast.LENGTH_SHORT)
            }
        }

    }

}
