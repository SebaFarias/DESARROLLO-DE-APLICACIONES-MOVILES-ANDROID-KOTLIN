package com.example.formulariovalidado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.formulariovalidado.databinding.ActivityResumenDatos2Binding;
import com.example.formulariovalidado.model.Usuario;

public class ResumenDatos extends AppCompatActivity {

    private ActivityResumenDatos2Binding binding;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResumenDatos2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        user = (Usuario) getIntent().getSerializableExtra("user");
        binding.lblNombre.setText(user.getNombre() + " " + user.getApellido());
        binding.lblMail.setText(user.getEmail());
    }
}