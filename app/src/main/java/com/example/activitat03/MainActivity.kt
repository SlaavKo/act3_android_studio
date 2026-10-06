package com.example.activitat03

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
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
    lateinit var card_home: MaterialCardView
    lateinit var card_dona: MaterialCardView
    var alt: Int = 72
    lateinit var slider: Slider
    lateinit var heightValue: TextView
    var pes: Int = 170

    lateinit var weightValue: TextView
    lateinit var lessWeight: Button
    lateinit var moreWeight: Button

    var edat: Int = 19

    lateinit var ageValue: TextView
    lateinit var lessAge: Button
    lateinit var moreAge: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //LA PART DE SI ÉS HOME O DONA

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

        //EL SLIDER DE L'ALTURA

        slider = findViewById<Slider>(R.id.sliderHeight)
        heightValue = findViewById<TextView>(R.id.heightValue)

        slider.addOnChangeListener { slider, value, bool ->
            alt = value.toInt()
            heightValue.text = alt.toString()
        }

        //ELS BOTONS DE PES

        weightValue = findViewById<TextView>(R.id.weightValue)
        lessWeight = findViewById<Button>(R.id.weightLess)
        moreWeight = findViewById<Button>(R.id.weightMore)

        lessWeight.setOnClickListener {
            if(pes > 1) {
                pes--
                weightValue.text = pes.toString()
            }
        }

        moreWeight.setOnClickListener {
            pes++
            weightValue.text = pes.toString()
        }

        //ELS BOTONS D'EDAT

        ageValue = findViewById<TextView>(R.id.valueAge)
        lessAge = findViewById<Button>(R.id.lessAge)
        moreAge = findViewById<Button>(R.id.moreAge)

        lessAge.setOnClickListener {
            if(edat > 1) {
                edat--
                ageValue.text = edat.toString()
            }
        }

        moreAge.setOnClickListener {
            edat++
            ageValue.text = edat.toString()
        }




    }


}