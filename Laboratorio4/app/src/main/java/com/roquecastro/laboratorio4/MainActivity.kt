package com.roquecastro.laboratorio4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var userEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var numberEditText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userEditText = findViewById(R.id.InUSer)
        emailEditText = findViewById(R.id.InEmail)
        numberEditText = findViewById(R.id.InNumber)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val user = userEditText.text.toString()
            val email = emailEditText.text.toString()
            val number = numberEditText.text.toString()

            val intent = Intent(this, CompartirActivity::class.java)

            intent.putExtra("user", user)
            intent.putExtra("email", email)
            intent.putExtra("number", number)

            startActivity(intent)
        }
    }
}

