package br.edu.ifpb.pdm.francisco.rgb

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    private lateinit var receiver : BloqueioReceiverRGB
    private lateinit var filter : IntentFilter
    private lateinit var tvMainR : TextView
    private lateinit var tvMainG : TextView
    private lateinit var tvMainB : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvMainR = findViewById(R.id.tvMainR)
        this.tvMainG = findViewById(R.id.tvMainG)
        this.tvMainB = findViewById(R.id.tvMainB)
        this.receiver = BloqueioReceiverRGB()
        this.filter = IntentFilter()
        this.filter.addAction(Intent.ACTION_SCREEN_OFF)

        val i = this.getIntent()
        val url = i.getClipData()
        val title = i.getStringExtra(Intent.EXTRA_TITLE)
        val text = i.getStringExtra(Intent.EXTRA_TEXT)

        if (url != null) {
            this.tvMainR.text = url.toString()
            this.tvMainR.setTextColor(Color.parseColor("#FF0000"))
            this.tvMainG.text = title
            this.tvMainG.setTextColor(Color.parseColor("#30CE10"))
            this.tvMainB.text = text
            this.tvMainB.setTextColor(Color.parseColor("#2020Ef"))


        } else {
            this.tvMainR.text = "R"
            this.tvMainR.setTextColor(Color.parseColor("#FF0000"))
            this.tvMainG.text = "G"
            this.tvMainG.setTextColor(Color.parseColor("#30CE10"))
            this.tvMainB.text = "B"
            this.tvMainB.setTextColor(Color.parseColor("#2020Ef"))
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(this.receiver, this.filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(this.receiver)
    }

    inner class BloqueioReceiverRGB: BloqueioReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            this@MainActivity.tvMainR.text = "R"
            this@MainActivity.tvMainR.setTextColor(Color.parseColor("#FF0000"))
            this@MainActivity.tvMainG.text = "G"
            this@MainActivity.tvMainG.setTextColor(Color.parseColor("#30CE10"))
            this@MainActivity.tvMainB.text = "B"
            this@MainActivity.tvMainB.setTextColor(Color.parseColor("#2020Ef"))
        }
    }

}
