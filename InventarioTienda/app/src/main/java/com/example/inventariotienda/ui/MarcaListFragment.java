package com.example.inventariotienda.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventariotienda.R;
import com.example.inventariotienda.databinding.FragmentMarcaListBinding;

public class MarcaListFragment extends Fragment {

    FragmentMarcaListBinding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMarcaListBinding.inflate(inflater,container,false);
        return b.getRoot();
    }
}