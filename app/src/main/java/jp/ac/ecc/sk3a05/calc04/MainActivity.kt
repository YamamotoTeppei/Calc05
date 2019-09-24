package jp.ac.ecc.sk3a05.calc04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calc.*

class MainActivity : AppCompatActivity() {

    internal var mCalculater = Calculate()
    var calcflg = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        textView1.setText("0")

        setView(R.id.button0)  //「0」
        setView(R.id.button00)  //「00」
        setView(R.id.button1)  //「1」
        setView(R.id.button2)  //「2」
        setView(R.id.button3)  //「3」
        setView(R.id.button4)  //「4」
        setView(R.id.button5)  //「5」
        setView(R.id.button6)  //「6」
        setView(R.id.button7)  //「7」
        setView(R.id.button8)  //「8」
        setView(R.id.button9)  //「9」
        opView(R.id.buttonadd)  //「+」
        opView(R.id.buttonsub)  //「-」
        opView(R.id.buttonmul)  //「*」
        opView(R.id.buttondiv)  //「/」
        opView(R.id.buttonmod)  //「MOD」

        //「CLR」
        val buttonclr : Button = findViewById(R.id.buttonclr)
        buttonclr.setOnClickListener {
            mCalculater.reset()
            calcflg = true
            textView1.setText("0")
        }

        //「=」
        val buttonequal : Button = findViewById(R.id.buttonequal)
        buttonequal.setOnClickListener { v ->
            val btn = v as Button
            val input = btn.text.toString()
            val textvalue = textView1.text.toString()
            mCalculater.putInput(textvalue)
            textView1.text = mCalculater.putInput(input)
        }

    }

    fun setView(buttonID : Int) {
        val button : Button = findViewById(buttonID)
        button.setOnClickListener { v ->

            val btn = v as Button
            val input = btn.text.toString()
            val textvalue = textView1.text.toString()

            if (textvalue.length < 12) {    //12桁まで
                if (textvalue == "0" || calcflg) {  //0または
                    textView1.setText(input)
                    calcflg = false
                } else {
                    textView1.setText(textvalue + input)
                }
            }
        }
    }
    fun opView(buttonID: Int) {
        val button : Button = findViewById(buttonID)
        button.setOnClickListener { v ->
            val btn = v as Button
            val input = btn.text.toString()
            val textvalue = textView1.text.toString()

            mCalculater.putInput(textvalue)
            mCalculater.putInput(input)
            calcflg = true
        }
    }
}
