package com.gilbertocampos.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var sumResult: TextView
    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var quarter: ImageView
    private lateinit var oneDollar: ImageView
    private var amountOfMoney = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        listeners()
    }

    private fun bind() {
        sumResult = findViewById(R.id.tv_sum_result)
        fiveCents = findViewById(R.id.iv_five_cents)
        tenCents = findViewById(R.id.iv_ten_cents)
        quarter = findViewById(R.id.iv_quarter_cents)
        oneDollar = findViewById(R.id.iv_one_dollar)

    }

    private fun listeners() {
        fiveCents.setOnClickListener { addMoney(0.05f) }
        tenCents.setOnClickListener { addMoney(0.10f) }
        quarter.setOnClickListener { addMoney(0.25f) }
        oneDollar.setOnClickListener { addMoney(1.00f) }
    }

    private fun addMoney(money: Float) {
        amountOfMoney += money
        val df = DecimalFormat("#.###")
        df.roundingMode = RoundingMode.CEILING
        sumResult.text = df.format(amountOfMoney)
    }


}