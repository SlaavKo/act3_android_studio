package com.example.activitat03

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import android.view.View

class MainActivity : AppCompatActivity() {
    var home_selected: Boolean = false
    var dona_selected: Boolean = false
    var card_home: MaterialCardView=findViewById<MaterialCardView>(R.id.seleccio_home)
    var card_dona: MaterialCardView=findViewById<MaterialCardView>(R.id.seleccio_dona)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        card_home.setOnClickListener {
            card_home.setCardBackgroundColor(Color.BLUE)
            home_selected = true
            dona_selected = false
        }

        card_dona.setOnClickListener( ::card_click)

    }
    fun card_click(it: View):Unit {
        card_dona.setCardBackgroundColor(Color.RED)
        card_home.setCardBackgroundColor(Color.WHITE)
        home_selected = false

    }
}