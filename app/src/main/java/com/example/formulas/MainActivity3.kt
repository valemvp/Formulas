package com.example.formulas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {

    private lateinit var etDistancia: EditText
    private lateinit var etTiempoR: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        etDistancia = findViewById(R.id.etDistancia)
        etTiempoR = findViewById(R.id.etTiempoR)
    }

    @SuppressLint("SetTextI18n")
    fun click(view: View) {
        if(!etDistancia.text.toString().isEmpty() and !etTiempoR.text.toString().isEmpty()){
            val distancia = etDistancia.text.toString().toFloat()
            val tiempo = etTiempoR.text.toString().toFloat()

            val intent = Intent(this, MainActivity4::class.java)
            val parametros = Bundle()

            parametros.putFloat("dist", distancia)
            parametros.putFloat("tiempo", tiempo)
            intent.putExtras(parametros)
            startActivity(intent)

        } else if (etDistancia.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etDistancia.error = getString(R.string.val_req)
            etDistancia.requestFocus()

        } else if(etTiempoR.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etTiempoR.error=getString(R.string.val_req)
            etTiempoR.requestFocus()
        } else if(etTiempoR.text.toString() == "0"){
            Toast.makeText(this, getString(R.string.val_noA), Toast.LENGTH_SHORT).show()
            etTiempoR.error = getString(R.string.val_err)
            etTiempoR.requestFocus()
        }

    }
}