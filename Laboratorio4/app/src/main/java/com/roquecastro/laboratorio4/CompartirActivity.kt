package com.roquecastro.laboratorio4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CompartirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val userTextView = findViewById<TextView>(R.id.nameshare)
        val emailTextView = findViewById<TextView>(R.id.correoshare)
        val numberTextView = findViewById<TextView>(R.id.telefonoshare)



        val user = intent.getStringExtra("user")
        val email = intent.getStringExtra("email")
        val number = intent.getStringExtra("number")


        userTextView.text = "Usuario: $user"
        emailTextView.text = "Email: $email"
        numberTextView.text = "Número: $number"
    }
}
