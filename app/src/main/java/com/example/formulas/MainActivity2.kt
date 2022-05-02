package com.example.formulas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private lateinit var etVelI: EditText
    private lateinit var etVelF: EditText
    private lateinit var etTiempoA: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        etVelI = findViewById(R.id.etVelI)
        etVelF = findViewById(R.id.etVelF)
        etTiempoA = findViewById(R.id.etTiempoA)

    }

    @SuppressLint("SetTextI18n")
    fun click(view: View) {
        if(!etVelI.text.toString().isEmpty() and !etVelF.text.toString().isEmpty()
            and !etTiempoA.text.toString().isEmpty()){
            val velI = etVelI.text.toString().toFloat()
            val velF = etVelF.text.toString().toFloat()
            val tiempo = etTiempoA.text.toString().toFloat()

            val intent = Intent(this, MainActivity5::class.java)
            val parametros = Bundle()

            parametros.putFloat("velI", velI)
            parametros.putFloat("velF", velF)
            parametros.getFloat("tiempo", tiempo)
            intent.putExtras(parametros)
            startActivity(intent)

        } else if (etVelI.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etVelI.error = getString(R.string.val_req)
            etVelI.requestFocus()
        } else if(etVelF.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etVelF.error=getString(R.string.val_req)
            etVelF.requestFocus()
        } else if(etTiempoA.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etTiempoA.error=getString(R.string.val_req)
            etTiempoA.requestFocus()
        } else if(etTiempoA.text.toString() == "0"){
            Toast.makeText(this, getString(R.string.val_noA), Toast.LENGTH_SHORT).show()
            etTiempoA.error = getString(R.string.val_err)
            etTiempoA.requestFocus()
        }

    }
}