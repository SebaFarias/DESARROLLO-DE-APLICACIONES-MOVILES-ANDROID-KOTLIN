package com.example.terrenosmarte.adapter

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
    private lateinit var listener : OnClickListener

    class TerrainViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val binding = ListItemBinding.bind( itemView )
        fun binData( terreno : Terrain )
        {
            Picasso.get()
                .load(terreno.img_src)
                .into(binding.ivTerrain)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrainViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent)
        return TerrainViewHolder( view )
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
    interface OnClickListener{
        fun onClick( terreno : Terrain )
    }
    fun setListener( listener : OnClickListener ){
        this.listener = listener
    }
}