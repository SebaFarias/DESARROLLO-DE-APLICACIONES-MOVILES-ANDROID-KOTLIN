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

    class TerrainViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = ListItemBinding.bind( itemView )

        fun binData( terreno : Terrain )
        {
            Picasso.get()
                .load(terreno.img_src)
                .centerCrop()
                .resize( 150, 150)
                .into(binding.ivTerrain)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrainViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return TerrainViewHolder(view)
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
}