package com.example.yp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Calculation : AppCompatActivity() {

    lateinit var sum1: TextView
    lateinit var srok1: TextView
    lateinit var textViewResult2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        sum1 = findViewById(R.id.sum2)
        srok1 = findViewById(R.id.srok1)
        textViewResult2 = findViewById(R.id.textViewResult2)

        val rec1=intent.getStringExtra("amount")
        val rec2=intent.getStringExtra("monthInput")
        val rec3=intent.getStringExtra("result")

        sum1.setText(rec1.toString())
        srok1.setText(rec2)
        textViewResult2.setText("Ежемесячный платеж:"+rec3.toString())





    }


    fun back()
    {
        val intent = Intent(this,Bank::class.java)
        startActivity(intent)
    }
}