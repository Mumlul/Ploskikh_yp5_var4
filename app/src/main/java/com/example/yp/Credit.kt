package com.example.yp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Credit : AppCompatActivity() {
    lateinit var text:TextView
    lateinit var seekBar: SeekBar
    lateinit var date:EditText
     var count:Int=0
         var text1:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)
        seekBar = findViewById<SeekBar>(R.id.seekBar)
        date=findViewById(R.id.date)
        text=findViewById(R.id.kk)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                count=seekBar.progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                text.setText(count.toString())
            }
        })
    }

    fun calculation(view: View) {
        val amount=seekBar.progress
        val monthInput=date.text.toString()

        if (monthInput.isEmpty())
        {
            Toast.makeText(this,"Введите срок кредита в месяцах", Toast.LENGTH_LONG).show()
            return
        }
        else if(monthInput.toInt()<=0){
            Toast.makeText(this,"Месяц должен быть положительным числом", Toast.LENGTH_LONG).show()
            return
        }
        val result: Double
        val ss : Int = monthInput.toInt()

        result = when {

            ss<=12 ->
            { amount/ss+(amount*0.059) }
            ss<=24 ->
            {(amount/12+(amount*0.059))+amount/ss+(amount-12*(amount/ss+(amount*0.059)))*0.051}


            else ->
            {(amount/12+(amount*0.059))+amount/ss+(amount-12*(amount/ss+(amount*0.059)))*0.042}
        }

        findViewById<TextView>(R.id.answ).text=String.format("ежемесячный платеж = %.2f тысяч",result/1000);

        Toast.makeText(this,"ежемесячный платеж = ${result/1000} тысяч",Toast.LENGTH_LONG).show()


        val intent = Intent(this,Calculation::class.java).putExtra("result",result/1000).putExtra("amount",amount).putExtra("monthInput",monthInput)
        startActivity(intent)
    }

    fun back(view: View) {
        val intent = Intent(this,Bank::class.java)
        startActivity(intent)
    }
}