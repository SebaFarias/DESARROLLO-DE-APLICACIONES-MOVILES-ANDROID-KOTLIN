package com.example.terrenosmarte.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.terrenosmarte.R
import com.example.terrenosmarte.databinding.FragmentDetalleBinding
import com.example.terrenosmarte.model.Terrain
import com.example.terrenosmarte.viewModel.MarsViewModel
import com.example.terrenosmarte.viewModel.MarsViewModelFactory
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.text.DecimalFormat

class DetalleFragment : Fragment() {

    lateinit private var binding : FragmentDetalleBinding
    lateinit var model : MarsViewModel
    lateinit var terrain : Terrain

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater,container,false)
        model = MarsViewModelFactory(requireActivity().application).create(MarsViewModel::class.java)
        model.setTerrainById(requireArguments().getLong("terrain_id"))
        model.terrain.observe( viewLifecycleOwner, {
            try{
                bindData( it )
            }catch ( err : Exception){
                Log.e( "terrain", err.message ?: err.toString())
            }
        })
        return binding.root
    }

    fun bindData( terrain : Terrain) {
        with( binding ){
            Picasso.get()
                .load( terrain.img_src )
                .centerCrop()
                .resize( ivTerrain2.measuredWidth, ivTerrain2.measuredHeight )
                .into( ivTerrain2 )
            lblPrecio.text = DecimalFormat("$ ###,###,###.##").format(terrain.price) ?: "$ 0"
            lblTipo.text = terrain.type.uppercase()
        }
    }
}