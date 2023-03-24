package com.gilbertocampos.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var weight: EditText
    private lateinit var height: EditText
    private lateinit var calculate: Button
    private lateinit var healthResult: TextView
    private lateinit var bmiHealthResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        calculate.setOnClickListener {
            calculateBMI()
            healthResult.text = calculateBMI().toString()
        }
    }

    private fun bind() {
        weight = findViewById(R.id.weight_editText)
        height = findViewById(R.id.height_editText)
        calculate = findViewById(R.id.btn_calc_bmi)
        healthResult = findViewById(R.id.bmi_result)
        bmiHealthResult = findViewById(R.id.bmi_health_result)
    }

    private fun calculateBMI(): Float {
        val userWeight = weight.text.toString().toFloat()
        val userHeight = height.text.toString().toFloat()
        return (userWeight) / (userHeight * userHeight) * 10000
    }
}