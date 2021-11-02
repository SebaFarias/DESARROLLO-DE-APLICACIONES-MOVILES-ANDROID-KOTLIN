package com.example.reciclerview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.FormatException;
import android.os.Bundle;
import android.widget.Toast;

import com.example.reciclerview1.databinding.ActivityAgregarProductoBinding;
import com.example.reciclerview1.model.Producto;

import java.util.ArrayList;

public class AgregarProducto extends AppCompatActivity {

    ActivityAgregarProductoBinding binding;
    static ArrayList<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgregarProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAgregar.setOnClickListener( v -> {

            String nombre = binding.txtNombre.getEditText().getText().toString();
            int id = Integer.parseInt(binding.txtId.getEditText().getText().toString());
            int precio = Integer.parseInt(binding.txtPrecio.getEditText().getText().toString());
            Producto p = new Producto();
            boolean correcto = true;
            listaProductos = (ArrayList<Producto>) getIntent().getSerializableExtra(Producto.LIST_TAG);

            binding.txtId.setError(null);
            binding.txtNombre.setError(null);
            binding.txtPrecio.setError(null);

            try{
                p.setId(id);
            }catch (ArithmeticException ex){
                correcto = false;
                binding.txtId.setError(ex.getMessage());
            }try{
                p.setNombre(nombre);
            }catch (FormatException ex){
                correcto = false;
                binding.txtNombre.setError(ex.getMessage());
            }try{
                p.setPrecio(precio);
            }catch (ArithmeticException ex){
                correcto = false;
                binding.txtPrecio.setError(ex.getMessage());
            }
            if (correcto) {
                listaProductos.add(p);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra(Producto.LIST_TAG,listaProductos);
                Toast.makeText(getApplicationContext(),getString(R.string.msg_agregado),Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }

}