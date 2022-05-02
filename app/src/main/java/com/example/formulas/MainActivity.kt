package com.example.formulas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formulas.databinding.ActivityMainBinding
import java.util.*

open class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var etMasa: EditText
    private lateinit var etAceleracion: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMasa = findViewById(R.id.etMasa)
        etAceleracion = findViewById(R.id.etAceleracion)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(mBinding.root)

        var lista = resources.getStringArray(R.array.opciones)
        val aaFormulas = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)

        mBinding.spinner.adapter = aaFormulas

        val intent1 = Intent(this, MainActivity2::class.java)
        val intent2 = Intent(this, MainActivity3::class.java)

        mBinding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, lista[p2], Toast.LENGTH_LONG).show()
                if(p0?.getItemAtPosition(p2)?.equals(lista[1]) == true){
                    startActivity(intent1)
                    finish()

                } else if(p0?.getItemAtPosition(p2)?.equals(lista[2]) == true){
                    startActivity(intent2)
                    finish()
                }
                
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }


    @SuppressLint("SetTextI18n")
    fun click(view: View) {
        if(!etMasa.text.toString().isEmpty() and !etAceleracion.text.toString().isEmpty()){
            val masa = etMasa.text.toString().toFloat()
            val aceleracion = etAceleracion.text.toString().toFloat()

            val intent = Intent(this, MainActivity4::class.java)
            val parametros = Bundle()

            parametros.putFloat("masa", masa)
            parametros.putFloat("aceleracion", aceleracion)
            intent.putExtras(parametros)
            startActivity(intent)

        } else if (etMasa.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etMasa.error = getString(R.string.val_req)
            etMasa.requestFocus()
        } else if(etAceleracion.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.ingresa_val), Toast.LENGTH_SHORT).show()
            etAceleracion.error=getString(R.string.val_req)
            etAceleracion.requestFocus()
        }

    }

}
