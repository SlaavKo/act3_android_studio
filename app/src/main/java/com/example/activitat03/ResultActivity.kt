package com.example.activitat03

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    var bmi: Double = 0.0
    lateinit var type: TextView
    lateinit var bmiValue: TextView
    lateinit var recalc: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bmi = intent.getDoubleExtra("bmi", 0.0)
        type = findViewById(R.id.typeText)
        bmiValue = findViewById(R.id.bmiValue)

        bmiValue.text = String.format("%.2f", bmi)

        if(bmi < 18.5) {
            type.text = "UNDERWEIGHT"
            type.setTextColor(getColor(R.color.warning))
        } else if (bmi < 25) {
            type.text = "NORMAL"
            type.setTextColor(getColor(R.color.normal))
        } else if ( bmi < 30) {
            type.text = "OVERWEIGHT"
            type.setTextColor(getColor(R.color.warning))
        } else {
            type.text = "OBESE"
            type.setTextColor(getColor(R.color.danger))
        }

        recalc = findViewById(R.id.recalc)

        recalc.setOnClickListener {
            finish()
        }

    }
}