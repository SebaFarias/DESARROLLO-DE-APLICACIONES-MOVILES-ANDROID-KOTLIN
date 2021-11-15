package com.example.terrenosmarte.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.terrenosmarte.R
import com.example.terrenosmarte.databinding.ListItemBinding
import com.example.terrenosmarte.model.Terrain
import com.squareup.picasso.Picasso

class TerrainAdapter : RecyclerView.Adapter<TerrainAdapter.TerrainViewHolder>() {

    private var lista : ArrayList<Terrain> = ArrayList()
    lateinit var listener : OnClickListener

    class TerrainViewHolder( itemView: View, listener : OnClickListener) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = ListItemBinding.bind( itemView )
        private var listener : OnClickListener = listener

        fun binData( terreno : Terrain )
        {
            Picasso.get()
                .load(terreno.img_src)
                .centerCrop()
                .resize( 150, 150)
                .into(binding.ivTerrain)
            itemView.setOnClickListener{ listener.onTerrainClick( terreno ) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrainViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return TerrainViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: TerrainViewHolder, position: Int) {
        holder.binData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }
    fun setLista( newLista : List<Terrain>)
    {
        lista = newLista as ArrayList<Terrain>
        notifyDataSetChanged()
    }
    fun setClickListener( listener : OnClickListener )
    {
        this.listener = listener
    }
    interface OnClickListener{
        fun onTerrainClick( terreno : Terrain)
    }
}