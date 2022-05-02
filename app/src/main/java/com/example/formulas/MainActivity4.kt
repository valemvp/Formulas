package com.example.formulas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity4 : AppCompatActivity() {

    private lateinit var tvResp: TextView
    private lateinit var tvEn1: TextView
    private lateinit var tvEn2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        tvResp = findViewById(R.id.tvResp)
        tvEn1 = findViewById(R.id.tvEn1)
        tvEn2 = findViewById(R.id.tvEn2)

        val bundle = intent.extras
        val masa = bundle?.getFloat("masa")
        val acel = bundle?.getFloat("aceleracion")

        val f = fuerza(masa, acel)

        tvEn1.text = "Para una masa de $masa [kg]"
        tvEn2.text = "con una aceleracion de $acel [m/s]"
        tvResp.text = "El valor de la fuerza es $f [N]"

        //tvEn1.text = String.format(getString(R.string.p_masa), masa)
        //tvEn2.text = String.format(getString(R.string.p_acel),acel)
        //tvResp.text = String.format(getString(R.string.msj_fuerza),f)
    }

    fun fuerza(masa: Float?, aceleracion: Float?): Float? {
        if (masa != null) {
            return masa * aceleracion!!
        }
        return null
    }

}

