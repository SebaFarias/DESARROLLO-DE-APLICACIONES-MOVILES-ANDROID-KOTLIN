package com.example.hilos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var contador: Int = 0
    var estado: Boolean = true
    var pausa: Boolean = false
    private lateinit var binding: ActivityMainBinding
    lateinit var tvNumero: TextView

    override fun onCreate(savedInstanceState: Bundle? ){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var hilo = Hilo(this)
        tvNumero = binding.tvNumero

        binding.btnIniciar.setOnClickListener {
            hilo.start()
        }
        binding.btnPausar.setOnClickListener {
            pausa = true
        }
        binding.btnContinuar.setOnClickListener {
            pausa = false
        }
        binding.btnReiniciar.setOnClickListener {
            contador = 0
        }
        binding.btnEliminar.setOnClickListener {
            estado = false
        }
    }
}

class Hilo(activity:MainActivity):Thread(){
    var act = activity
    override fun run() {
        super.run()
        while( act.estado ){
            while( act.pausa == true ){
                sleep(100)
            }
            sleep(100)
            act.runOnUiThread {
                act.tvNumero.setText("Hilo: " + act.contador)
            }
            act.contador++
        }
    }
}