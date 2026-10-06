package com.example.activitat03

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    var home_selected: Boolean = false
    var dona_selected: Boolean = false
    var alt: Int = 72
    lateinit var card_home: MaterialCardView
    lateinit var card_dona: MaterialCardView
    lateinit var slider: Slider
    lateinit var heightValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        card_home = findViewById<MaterialCardView>(R.id.seleccio_home)
        card_dona = findViewById<MaterialCardView>(R.id.seleccio_dona)
        card_home.setOnClickListener {
            card_home.setCardBackgroundColor(getColor(R.color.selCard))
            card_dona.setCardBackgroundColor(getColor(R.color.cardBack))
            home_selected = true
            dona_selected = false
        }
        card_dona.setOnClickListener {
            card_dona.setCardBackgroundColor(getColor(R.color.selCard))
            card_home.setCardBackgroundColor(getColor(R.color.cardBack))
            home_selected = false
            dona_selected = true
        }
        slider = findViewById<Slider>(R.id.heightSlider)
        heightValue = findViewById<TextView>(R.id.heightValue)

        slider.addOnSliderTouchListener { slider, valor, fromUser
            alt = heightValue.toInt()
            heightValue.text = alt.toString()
        }

    }


}