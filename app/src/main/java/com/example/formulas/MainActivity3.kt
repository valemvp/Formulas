package com.example.formulas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.example.formulas.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var etDistancia: EditText
    private lateinit var etTiempoR: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        etDistancia = findViewById(R.id.etDistancia)
        etTiempoR = findViewById(R.id.etTiempoR)

        /*mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(mBinding.root)

        var lista = resources.getStringArray(R.array.opciones)
        val aaFormulas = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)

        mBinding.spinner.adapter = aaFormulas

        val intent1 = Intent(this, MainActivity::class.java)
        val intent2 = Intent(this, MainActivity2::class.java)

        mBinding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity3, lista[p2], Toast.LENGTH_LONG).show()
                if(p0?.getItemAtPosition(p2)?.equals(lista[0]) == true){
                    startActivity(intent1)
                    //finish()

                } else if(p0?.getItemAtPosition(p2)?.equals(lista[1]) == true){
                    startActivity(intent2)
                    //finish()
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }*/
    }

    @SuppressLint("SetTextI18n")
    fun click(view: View) {
        if(!etDistancia.text.toString().isEmpty() and !etTiempoR.text.toString().isEmpty()){
            val distancia = etDistancia.text.toString().toFloat()
            val tiempo = etTiempoR.text.toString().toFloat()

            val intent = Intent(this, MainActivity6::class.java)
            val parametros = Bundle()

            parametros.putFloat("dist", distancia)
            parametros.putFloat("tiempo", tiempo)
            intent.putExtras(parametros)
            startActivity(intent)

        } else if(etTiempoR.text.toString() == "0"){
            Toast.makeText(this, getString(R.string.val_noA), Toast.LENGTH_SHORT).show()
            etTiempoR.error = getString(R.string.val_err)
            etTiempoR.requestFocus()
        } else if (etDistancia.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etDistancia.error = getString(R.string.val_req)
            etDistancia.requestFocus()

        }  else if(etTiempoR.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etTiempoR.error=getString(R.string.val_req)
            etTiempoR.requestFocus()
        }

    }
}