package com.example.formulas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {

    private lateinit var tvResp: TextView
    private lateinit var tvEn1: TextView
    private lateinit var tvEn2: TextView
    private lateinit var tvEn3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        tvResp = findViewById(R.id.tvResp)
        tvEn1 = findViewById(R.id.tvEn1)
        tvEn2 = findViewById(R.id.tvEn2)
        tvEn3 = findViewById(R.id.tvEn3)

        val bundle = intent.extras
        val vel1 = 15.5
        val velF = 10.2
        val t = 5

        val a = aceleracion(vel1,velF,t)

        tvEn1.text = "A una velocidad inicial de $vel1 [m/s],"
        tvEn2.text = "una velocidad final de $velF [m/s]"
        tvEn2.text = "en un tiempo de $t [s]"
        tvResp.text = "El valor de la aceleración es $a [m/s^2]"

        //tvEn1.text = getString(R.string.p_masa,masa)
        //tvEn2.text = getString(R.string.p_acel,acel)
        //tvResp.text = getString(R.string.msj_fuerza,f)
    }

    private fun aceleracion(vel1: Double, velF: Double, t: Int?): Double? {
        if (t != null) {
            return (vel1 - velF!!)/ t
        }
        return null
    }


}