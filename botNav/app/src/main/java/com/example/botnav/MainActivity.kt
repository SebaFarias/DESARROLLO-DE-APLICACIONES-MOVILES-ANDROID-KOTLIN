package com.example.botnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.botnav.databinding.ActivityMainBinding
import com.example.botnav.ui.AvionFragment
import com.example.botnav.ui.BarcoFragment
import com.example.botnav.ui.BiciFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val avionFragment = AvionFragment()
    val barcoFragment = BarcoFragment()
    val biciFragment = BiciFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(avionFragment)
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
              R.id.menuBarco -> setFragment(barcoFragment)
              R.id.menuBici -> setFragment(biciFragment)
              else -> setFragment(avionFragment)
            }; true
        }
    }
    private fun setFragment (fragment: Fragment) {
        if (fragment !=null){
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container,fragment)
            transaccion.commit()
            Toast.makeText(this, "Cambiar fragment", Toast.LENGTH_SHORT).show()
        }
    }
}