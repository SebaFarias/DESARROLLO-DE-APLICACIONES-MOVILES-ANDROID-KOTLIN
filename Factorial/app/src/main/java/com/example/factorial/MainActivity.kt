package com.example.factorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.factorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var numero = 0
    var resultado = 0
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var hilo = Hilo(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    class Hilo (act: MainActivity):Thread() {
        var numero = act.numero
        var resultado = 1
        override fun run(){
            super.run()
            while(numero > 1){
                resultado = resultado * numero
                numero--
            }
        }
    }

}