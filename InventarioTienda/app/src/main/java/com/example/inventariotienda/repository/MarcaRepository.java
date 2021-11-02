package com.example.inventariotienda.repository;

import android.app.Application;

import com.example.inventariotienda.model.Marca;
import com.example.inventariotienda.room.TiendaDB;

import java.util.List;

public class MarcaRepository {

    private TiendaDB tDb;

    public MarcaRepository(Application application)
    {
        this.tDb = TiendaDB.getDatabase(application);
    }
    public void agregar( Marca marca ){ tDb.marcaDao().agregar(marca);}
    public void agregarTodo( Marca... marca ){tDb.marcaDao().agregarTodo(marca);}
    public void eliminar( Marca marca ){ tDb.marcaDao().eliminar(marca);}
    public void modificar( Marca marca ){ tDb.marcaDao().modificar(marca);}
    public List<Marca> listar(){ return tDb.marcaDao().listar();}
    public Marca buscar( int id ) { return  tDb.marcaDao().buscar(id);}
}