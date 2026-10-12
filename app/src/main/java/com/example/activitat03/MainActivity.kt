package com.example.activitat03

import android.annotation.SuppressLint
import android.content.Intent
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
    var homeSelected: Boolean = false
    var donaSelected: Boolean = false
    lateinit var cardHome: MaterialCardView
    lateinit var cardDona: MaterialCardView
    var alt: Int = 170
    lateinit var slider: Slider
    lateinit var heightValue: TextView
    var pes: Int = 65

    lateinit var weightValue: TextView
    lateinit var lessWeight: Button
    lateinit var moreWeight: Button

    var edat: Int = 19

    lateinit var ageValue: TextView
    lateinit var lessAge: Button
    lateinit var moreAge: Button

    lateinit var calc: Button
    lateinit var err: TextView

    val mainAct = this
    val resAct = ResultActivity::class.java




    @SuppressLint("SetTextI18n")
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

        cardHome = findViewById(R.id.seleccio_home)
        cardDona = findViewById(R.id.seleccio_dona)
        cardHome.setOnClickListener {
            cardHome.setCardBackgroundColor(getColor(R.color.selCard))
            cardDona.setCardBackgroundColor(getColor(R.color.cardBack))
            homeSelected = true
            donaSelected = false
        }
        cardDona.setOnClickListener {
            cardDona.setCardBackgroundColor(getColor(R.color.selCard))
            cardHome.setCardBackgroundColor(getColor(R.color.cardBack))
            homeSelected = false
            donaSelected = true
        }

        //EL SLIDER DE L'ALTURA

        slider = findViewById(R.id.sliderHeight)
        heightValue = findViewById(R.id.heightValue)

        slider.addOnChangeListener { _, value, _ ->
            alt = value.toInt()
            heightValue.text = alt.toString()
        }

        //ELS BOTONS DE PES

        weightValue = findViewById(R.id.weightValue)
        lessWeight = findViewById(R.id.weightLess)
        moreWeight = findViewById(R.id.weightMore)
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

        ageValue = findViewById(R.id.valueAge)
        lessAge = findViewById(R.id.lessAge)
        moreAge = findViewById(R.id.moreAge)

        lessAge.setOnClickListener {
            if(edat > 18) {
                edat--
                ageValue.text = edat.toString()
            }
        }
        moreAge.setOnClickListener {
            edat++
            ageValue.text = edat.toString()
        }
        calc = findViewById(R.id.calculate)
        err = findViewById(R.id.req)
        val intent = Intent(mainAct, resAct)
        calc.setOnClickListener {
            if(homeSelected || donaSelected) {
                err.text = ""
                val altM = alt / 100.0
                val bmi = pes / (altM*altM)
            intent.putExtra("bmi", bmi)
                startActivity(intent)
            } else {
                err.text = "FALTA POSAR EL GÈNERE!"
            }
        }
    }
}