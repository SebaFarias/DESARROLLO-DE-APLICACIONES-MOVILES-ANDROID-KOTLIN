package com.example.razasperros.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.razasperros.R
import com.example.razasperros.databinding.RazaItemBinding
import com.example.razasperros.model.Raza

class RazaAdapter : RecyclerView.Adapter<RazaAdapter.RazaViewHolder>(){

    private var razasList : List<Raza> = listOf()
    lateinit var listener : OnClickListener

    class RazaViewHolder(itemView : View, listener : OnClickListener) : RecyclerView.ViewHolder( itemView ){

        private val binding = RazaItemBinding.bind( itemView )
        private val listener : OnClickListener = listener

        fun bindData ( raza : Raza)
        {
            binding.lblRazaName.text = raza.name
            itemView.setOnClickListener{ listener.onRazaClick(raza) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazaViewHolder {
        val view = LayoutInflater.from( parent.context ).inflate(R.layout.raza_item, parent, false)
        return RazaViewHolder( view , listener)
    }

    override fun onBindViewHolder(holder: RazaViewHolder, position: Int) {
        holder.bindData(razasList[position])
    }

    override fun getItemCount(): Int {
        return razasList.size
    }
    fun setLista ( newLista : List<Raza>)
    {
        this.razasList = newLista
        notifyDataSetChanged()
    }
    interface OnClickListener{
        fun onRazaClick( raza : Raza)
    }
    fun setClickListener( listener : OnClickListener )
    {
        this.listener = listener
    }
}