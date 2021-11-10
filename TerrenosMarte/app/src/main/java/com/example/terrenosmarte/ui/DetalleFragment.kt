package com.example.terrenosmarte.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.terrenosmarte.R
import com.example.terrenosmarte.databinding.FragmentDetalleBinding
import com.example.terrenosmarte.model.Terrain
import com.example.terrenosmarte.viewModel.MarsViewModel
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class DetalleFragment : Fragment() {

    lateinit private var binding : FragmentDetalleBinding
    lateinit var model : MarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater,container,false)
        var terrainId : Long = arguments?.get("terrain_id") as Long
        var terrain = model.exposeLiveDataFromDatabase().value!!.first { it.id == terrainId }
        with(binding){
            lblPrecio.text = DecimalFormat("$ ###,###,####.##").format(terrain!!.price)
            lblTipo.text = terrain!!.type
            Picasso.get()
                .load(terrain!!.img_src)
                .centerCrop()
                .resize(ivTerrain2.measuredWidth,ivTerrain2.measuredHeight)
                .into(ivTerrain2)
        }
        return binding.root
    }
}