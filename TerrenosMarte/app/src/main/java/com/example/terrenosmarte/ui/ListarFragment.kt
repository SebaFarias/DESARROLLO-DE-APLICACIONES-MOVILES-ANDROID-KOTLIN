package com.example.terrenosmarte.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.terrenosmarte.R
import com.example.terrenosmarte.adapter.TerrainAdapter
import com.example.terrenosmarte.databinding.FragmentListarBinding
import com.example.terrenosmarte.model.Terrain
import com.example.terrenosmarte.viewModel.MarsViewModel
import com.example.terrenosmarte.viewModel.MarsViewModelFactory

class ListarFragment : Fragment() {

    lateinit var binding : FragmentListarBinding
    lateinit var model : MarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListarBinding.inflate(inflater, container, false)
       // model = ViewModelProvider(this).get(MarsViewModel::class.java)
        // model = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(MarsViewModel::class.java)
        model = MarsViewModelFactory(requireActivity().application).create(MarsViewModel::class.java)
        model.getDataFromServer()

        val adapter = TerrainAdapter()
        with( binding ){
            rvLista.layoutManager = GridLayoutManager(context,2)
            rvLista.adapter = adapter
            /*adapter.setListener( object : TerrainAdapter.OnClickListener {
                override fun onClick(terreno: Terrain) {
                    var bundle = Bundle()
                    bundle.putLong("terrain_id", terreno.id)
                    Navigation
                        .findNavController(container!!.rootView)
                        .navigate(R.id.action_listarFragment_to_detalleFragment, bundle)
                }
            })*/
        }
        model.terrainList.observe( viewLifecycleOwner,{
            try{
                adapter.setLista(it)
            }catch( err : Exception ){
                Toast.makeText(context,"Ha ocurrido un error",Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

}