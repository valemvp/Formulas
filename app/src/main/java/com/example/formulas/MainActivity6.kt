package com.example.formulas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {

    private lateinit var tvResp: TextView
    private lateinit var tvEn1: TextView
    private lateinit var tvEn2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        tvResp = findViewById(R.id.tvResp)
        tvEn1 = findViewById(R.id.tvEn1)
        tvEn2 = findViewById(R.id.tvEn2)

        val bundle = intent.extras
        val dist = bundle?.getFloat("masa")
        val t = bundle?.getFloat("aceleracion")

        val v = rapidez(dist, t)

        //tvEn1.text = "Para una masa de $masa [kg]"
        //tvEn2.text = "con una aceleracion de $acel [m/s]"
        //tvResp.text = "El valor de la fuerza es $f [N]"

        tvEn1.text = getString(R.string.p_dis,dist)
        tvEn2.text = getString(R.string.p_tiempo,t)
        tvResp.text = getString(R.string.msj_rapidez,v)
    }

    fun rapidez(distancia: Float?, tiempo: Float?): Float? {
        if (tiempo != null) {
            if (distancia != null) {
                return distancia/tiempo
            }
        }
        return null
    }
}