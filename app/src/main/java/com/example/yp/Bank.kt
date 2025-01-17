package com.example.yp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Bank : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)
    }

    fun next(view: View) {
        val text1=findViewById<EditText>(R.id.login).text
        val text2=findViewById<EditText>(R.id.password).text

        if (!text1.isEmpty()||!text2.isEmpty())
        {
            if (text1.toString()!="ects"||text2.toString()!="ects2024")
            {
                Toast.makeText(this,"Логин или пароль были введены не правильно", Toast.LENGTH_LONG).show()
            }
            else{ val intent = Intent(this,Credit::class.java)
                startActivity(intent)}
        }
        else{ Toast.makeText(this,"Заполните поля", Toast.LENGTH_LONG).show()}

    }
}