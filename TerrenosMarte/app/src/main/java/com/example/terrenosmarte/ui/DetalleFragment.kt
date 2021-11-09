package com.example.terrenosmarte.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.terrenosmarte.R
import com.example.terrenosmarte.databinding.FragmentDetalleBinding

class DetalleFragment : Fragment() {

    lateinit private var binding : FragmentDetalleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater,container,false)
        return binding.root
    }

}