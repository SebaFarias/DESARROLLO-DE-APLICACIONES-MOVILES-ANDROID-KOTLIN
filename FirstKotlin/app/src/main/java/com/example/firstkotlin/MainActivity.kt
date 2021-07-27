package com.example.firstkotlin

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            var val1 = getValue( et1 )
            var val2 = getValue( et2 )
            if(rb1.isChecked){
                tvResultado.text = "la suma es: ${sumar(val1,val2)}"
            }else if(rb2.isChecked){
                tvResultado.text = "la resta es: ${restar(val1,val2)}"
            }else if(rb3.isChecked){
                tvResultado.text = "la multiplicación es: ${multiplicar(val1,val2)}"
            }else if(rb4.isChecked){
                if(val2 == 0){
                    Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show()
                }else {
                    tvResultado.text = "la división es: ${dividir(val1,val2)}"
                }
            }else{
                Toast.makeText(this, "Selecciona una operacion", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getValue( number : EditText ) : Int{
        return try{
            number.text.toString().toInt()
        }catch( e : NumberFormatException){
            0
        }
    }
    private fun sumar(val1: Int, val2: Int): Int {
        return val1 + val2
    }
    private fun restar( val1:Int, val2:Int): Int {
        return val1 - val2
    }
    private fun multiplicar ( val1: Int , val2: Int ): Int {
        return val1 * val2
    }
    private fun dividir ( val1: Int , val2: Int ): Double {
        return val1.toDouble() / val2
    }
}