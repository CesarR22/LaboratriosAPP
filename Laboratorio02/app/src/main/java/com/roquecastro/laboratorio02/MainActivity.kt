package com.roquecastro.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionCalculate: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding()
        setLIstener()
    }
    private fun binding(){
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text02)
        actionCalculate = findViewById(R.id.action_Calculate)
        bmiTextView = findViewById(R.id.BMI_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)

    }

    private fun setLIstener(){
        actionCalculate.setOnClickListener{

            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (!validateInput(weight, height)){
                return@setOnClickListener
            }

            val bmi = calculateBMI(weight.toFloat(), height.toFloat())
            Log.d("Testing", bmi.toString())
            val bmiTwoDigits = String.format("%.2f",bmi).toFloat()
            displayResult(bmiTwoDigits)

        }
    }

    private fun calculateBMI(weight: Float, height: Float):Float{
        return weight / ((height / 100) * (height /100))
    }

    private fun validateInput(weight: String?, height: String? ):Boolean{

        when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }

            height.isNullOrEmpty() ->{
                Toast.makeText(this, "height is empty", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun displayResult(bmi: Float){

        bmiTextView.text = bmi.toString()
        infoTextView.text = ("Normal range")

        var informationResult = ""
        var color = 0

        when{
            bmi < 18.50 -> {
                informationResult = "Under weight"
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 -> {
                informationResult = "Healthy"
                color = R.color.normal_weight
            }
            bmi in 25.00..29.99 -> {
                informationResult = "Over weight"
                color = R.color.ove_weight
            }
            bmi < 29.99 -> {
                informationResult = "Obese"
                color = R.color.obese
            }
        }
        resultTextView.setTextColor(ContextCompat.getColor(this,color))
        resultTextView.text = informationResult

    }



}