package com.example.factorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.factorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var numero = 0
    lateinit var resultado : TextView
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
        resultado = tvResultado
            btnCalcular.setOnClickListener {
                numero = et1.text.toString().toInt()
                var hilo = Hilo(this@MainActivity)
            }
        }

    }

    class Hilo (act: MainActivity):Thread() {
        var numero = act.numero
        var textView = act.resultado
        var resultado = 1
        override fun run(){
            super.run()
            while(numero > 1){
                resultado = resultado * numero
                numero--
                textView.setText("Resultado: ${resultado}")
            }
        }
    }

}