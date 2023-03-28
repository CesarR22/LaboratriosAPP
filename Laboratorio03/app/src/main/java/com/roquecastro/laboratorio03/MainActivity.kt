package com.roquecastro.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

private lateinit var five_image: ImageView
private lateinit var ten_image: ImageView
private lateinit var quarter_image: ImageView
private lateinit var dollar_image: ImageView
private lateinit var amount_text: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding()
        setListener()
    }

    private fun setListener() {
        var totalAmount = 0.0

        five_image.setOnClickListener {
            totalAmount += 0.05
            amount_text.text = String.format("$%.2f", totalAmount)
        }

        ten_image.setOnClickListener {
            totalAmount += 0.10
            amount_text.text = String.format("$%.2f", totalAmount)
        }

        quarter_image.setOnClickListener {
            totalAmount += 0.25
            amount_text.text = String.format("$%.2f", totalAmount)
        }

        dollar_image.setOnClickListener {
            totalAmount += 1.0
            amount_text.text = String.format("$%.2f", totalAmount)
        }
    }


    private fun binding (){
        five_image = findViewById(R.id.five_image)
        ten_image = findViewById(R.id.ten_image)
        quarter_image = findViewById(R.id.quarteimage)
        dollar_image = findViewById(R.id.dollarimage)
        amount_text = findViewById(R.id.Amount)
    }

}
