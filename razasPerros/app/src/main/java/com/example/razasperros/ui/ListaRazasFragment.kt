package com.example.razasperros.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.razasperros.R
import com.example.razasperros.adapter.RazaAdapter
import com.example.razasperros.databinding.FragmentListaRazasBinding
import com.example.razasperros.model.Raza
import com.example.razasperros.viewmodel.PerroViewModel
import com.example.razasperros.viewmodel.PerroViewModelFactory

class ListaRazasFragment : Fragment() {

    lateinit var binding : FragmentListaRazasBinding
    lateinit var model : PerroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaRazasBinding.inflate( inflater, container, false)
        //model = ViewModelProvider( this,ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(PerroViewModel::class.java)
        model = PerroViewModelFactory( requireActivity().application ).create(PerroViewModel::class.java)
        model.fetchRazasFromServer()

        val adapter = RazaAdapter()

        with( binding ) {

            rvRazas.layoutManager = LinearLayoutManager( context )
            rvRazas.adapter = adapter
            model.exposeRazasFromDB().value?.let { adapter.setLista(it) }

            adapter.setClickListener( object : RazaAdapter.OnClickListener {
                override fun onRazaClick( raza: Raza ) {
                    model.fetchPerrosByRaza( raza.name )
                    var bundle = Bundle()
                    bundle.putString("raza_name", raza.name)
                    Navigation
                        .findNavController( requireActivity() , R.id.fragHost )
                        .navigate(R.id.action_listaRazasFragment_to_listaPerrosFragment)
                }
            })
        }
        model.exposeRazasFromDB().observe( viewLifecycleOwner, {
            try{
                adapter.setLista(it)
                Log.d("RVRazas",it[1].name)
            }catch( err : Exception )
            {
                Toast.makeText(context,"Ha ocurrido un error", Toast.LENGTH_LONG).show()
                Log.e("RAZAS_FRAGMENT",err.message ?: "No hay mensaje de error")
            }
        })

        return binding.root
    }
}