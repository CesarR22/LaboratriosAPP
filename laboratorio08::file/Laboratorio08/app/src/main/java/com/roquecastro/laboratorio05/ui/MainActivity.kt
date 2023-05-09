package com.roquecastro.laboratorio05.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roquecastro.laboratorio05.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || super.onSupportNavigateUp()
    }

}