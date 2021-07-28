package com.example.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var hours      : Int     = 0
    private var minutes    : Int     = 0
    private var seconds    : Int     = 0
    private var hundredths : Int     = 0
    private var running    : Boolean = false

    private lateinit var binding  : ActivityMainBinding
    private lateinit var tvTiempo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvTiempo = binding.tvTiempo

        val hilo = Hilo(this)
        hilo.start()

        binding.btnIniciar.setOnClickListener{
            running = true
        }
        binding.btnPausar.setOnClickListener {
            running = false
        }
        binding.btnResetear.setOnClickListener{
            hours      = 0
            minutes    = 0
            seconds    = 0
            hundredths = 0
        }
    }
    private fun formatTime() : String{
        checkMax()
        val hh = toPrettyTime(hours)
        val mm = toPrettyTime(minutes)
        val ss = toPrettyTime(seconds)
        val cc = toPrettyTime(hundredths)
        val formated = "$hh:$mm:$ss:$cc"
        Log.d("Hola",formated)
        return formated
    }
    private fun toPrettyTime(value : Int) : String {
        return if(value < 10){
            "0$value"
        }else{
            value.toString()
        }
    }
    private fun checkMax() {
        checkHundreths()
        checkSeconds()
        checkMinutes()
    }
    private fun checkHundreths () {
        if(hundredths > 99){
            hundredths = 0
            seconds ++
        }
    }
    private fun checkSeconds () {
        if(seconds > 59){
            seconds = 0
            minutes ++
        }
    }
    private fun checkMinutes () {
        if(minutes > 59){
            minutes = 0
            hours ++
        }
    }
    class Hilo( activity : MainActivity ) : Thread() {
        private var act = activity
        override fun run () {
            super.run()
            Log.d("Debug","started")
            while (act.running){
                Log.d("Working","yeah, rigth")
                sleep(100)
                act.hundredths++
                val time = act.formatTime()
                act.runOnUiThread {
                    act.tvTiempo.text = time
                }
            }
        }

    }
}