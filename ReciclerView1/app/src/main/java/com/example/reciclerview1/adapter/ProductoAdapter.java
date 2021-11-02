package com.example.reciclerview1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reciclerview1.R;
import com.example.reciclerview1.databinding.ItemLayoutBinding;
import com.example.reciclerview1.model.Producto;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>{

    private ArrayList<Producto> listaProductos;

    public ProductoAdapter(ArrayList<Producto> lista){
        this.listaProductos = lista;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ProductoViewHolder holder, int position) {
        holder.bindData(listaProductos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }


    class ProductoViewHolder extends RecyclerView.ViewHolder{

        ItemLayoutBinding binding;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayoutBinding.bind(itemView);
        }
        public void bindData(Producto pro){
            DecimalFormat formatea = new DecimalFormat("###,###.##");
            binding.lblNombre.setText(pro.getNombre());
            binding.lblPrecio.setText("$"+formatea.format(pro.precioConIva()));
        }
    }
}
