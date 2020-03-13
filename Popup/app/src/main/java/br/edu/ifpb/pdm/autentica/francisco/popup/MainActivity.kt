package br.edu.ifpb.pdm.autentica.francisco.popup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import android.widget.RadioButton
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {


    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Mensagem
        findViewById<Button>(R.id.btMensagem).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Mensagem")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Que bom")
                .setPositiveButton("Ok") { dialog, i ->
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Hum") { dialog, i ->
                    Toast.makeText(this, "Hum", Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        //Input
        findViewById<Button>(R.id.btInput).setOnClickListener {
            this.view = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("Input")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Digitar")
                .setView(this.view)
                .setPositiveButton("Ok") { dialog, i ->
                    val msg = (this.view as EditText).text.toString()
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        //Data
        findViewById<Button>(R.id.btData).setOnClickListener {
            this.view = DatePicker(this)
            AlertDialog.Builder(this)
                .setTitle("Data picker")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Escolher data")
                .setView(this.view)
                .setPositiveButton("Ok") { dialog, i ->
                    val dp = this.view as DatePicker
                    val msg = "${dp.dayOfMonth}/${dp.month + 1}/${dp.year}"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        //Hora
        findViewById<Button>(R.id.btHora).setOnClickListener {
            this.view = TimePicker(this)
            (this.view as TimePicker).setIs24HourView(true)
            AlertDialog.Builder(this)
                .setTitle("Hora picker")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Escolher hora")
                .setView(this.view)
                .setPositiveButton("Ok") { dialog, i ->
                    val hp = this.view as TimePicker
                    var msg = ""
                    if (Build.VERSION.SDK_INT < 23) {
                        val msg = "${hp.currentHour}:${hp.currentMinute}"
                    }
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        //Faixa
        findViewById<Button>(R.id.btFaixa).setOnClickListener {
            this.view = SeekBar(this)
            (this.view as SeekBar).setMax(100)
            AlertDialog.Builder(this)
                .setTitle("Seekbar")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Escolher um valor de 0 a 100")
                .setView(this.view)
                .setPositiveButton("Ok") { dialog, i ->
                    val msg = (this.view as SeekBar).progress.toString()
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        //Escolha
        findViewById<Button>(R.id.btEscolha).setOnClickListener {
            this.view = Switch(this)
            AlertDialog.Builder(this)
                .setTitle("Escolha")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Escolha")
                .setView(this.view)
                .setPositiveButton("Ok") { dialog, i ->
                    val msg = (this.view as Switch).isChecked.toString()
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        //Unico
        findViewById<Button>(R.id.btUnico).setOnClickListener {
            val janela = AlertDialog.Builder(this)
            var msg = ""

            //Create the view
            this.view = RadioGroup(this)
            val radioButton1: RadioButton = RadioButton(this)
            radioButton1.setText("1")
            val radioButton2: RadioButton = RadioButton(this)
            radioButton2.setText("2")
            val radioButton3: RadioButton = RadioButton(this)
            radioButton3.setText("3")
            val radioButton4: RadioButton = RadioButton(this)
            radioButton4.setText("4")
            (this.view as RadioGroup).addView(radioButton1)
            (this.view as RadioGroup).addView(radioButton2)
            (this.view as RadioGroup).addView(radioButton3)
            (this.view as RadioGroup).addView(radioButton4)

            //Config
            janela.setTitle("Unico")
            janela.setIcon(R.mipmap.ic_launcher)
            janela.setMessage("Escolha um numero")
            janela.setView(this.view)

            //EventListener
            (this.view as RadioGroup).setOnCheckedChangeListener { group, checkedId ->
                Toast.makeText(this, "HUHUHUHU", Toast.LENGTH_LONG)
                val childCount = group.childCount
                for (x in 0 until childCount) {
                    val btn = group.getChildAt(x) as RadioButton
                    if (btn.id == checkedId) {
                        Toast.makeText(this, btn.text.toString(), Toast.LENGTH_LONG)
                        msg = btn.text.toString()
                    }
                }
            }

            //Buttons
            janela.setPositiveButton("Ok"){ dialog, which ->
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }

            janela.setNegativeButton("Cancelar"){ dialog, which ->
                Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
            }

            janela.create().show()

        }

        //Varios
        findViewById<Button>(R.id.btVarios).setOnClickListener {
            val janela = AlertDialog.Builder(this)
            var msgs = ""

            //Create the view
            this.view = LinearLayout(this)
            val cBox1: CheckBox = CheckBox(this)
            cBox1.setText("1")
            val cBox2: CheckBox = CheckBox(this)
            cBox2.setText("2")
            val cBox3: CheckBox = CheckBox(this)
            cBox3.setText("3")
            val cBox4: CheckBox = CheckBox(this)
            cBox4.setText("4")
            (this.view as LinearLayout).addView(cBox1)
            (this.view as LinearLayout).addView(cBox2)
            (this.view as LinearLayout).addView(cBox3)
            (this.view as LinearLayout).addView(cBox4)

            //Config
            janela.setTitle("Varios")
            janela.setIcon(R.mipmap.ic_launcher)
            janela.setMessage("Escolha numeros")
            janela.setView(this.view)

            //Buttons
            janela.setPositiveButton("Ok"){ dialog, which ->
                if (cBox1.isChecked) msgs += "1 "
                if (cBox2.isChecked) msgs += "2 "
                if (cBox3.isChecked) msgs += "3 "
                if (cBox4.isChecked) msgs += "4 "
                Toast.makeText(this, msgs, Toast.LENGTH_SHORT).show()
            }

            janela.setNegativeButton("Cancelar"){ dialog, which ->
                Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
            }

            janela.create().show()
        }
    }
}
