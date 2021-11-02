package com.example.reciclerview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.reciclerview1.databinding.ActivityResumenProductoBinding;
import com.example.reciclerview1.model.Producto;

public class ResumenProducto extends AppCompatActivity {

    ActivityResumenProductoBinding binding;
    Producto p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResumenProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        p = (Producto) getIntent().getSerializableExtra(Producto.PRODUCT_TAG);

    }
}