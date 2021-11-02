package com.example.inventariotienda.repository;

import android.app.Application;

import com.example.inventariotienda.model.Producto;
import com.example.inventariotienda.room.TiendaDB;

import java.util.List;

public class ProductoRepository {

    private TiendaDB tdb;

    public ProductoRepository( Application application )
    {
        this.tdb = TiendaDB.getDatabase(application);
    }
    public void agregar(Producto producto ){ tdb.productoDao().agregar(producto);}
    public void agregarTodos(Producto... producto ){ tdb.productoDao().insertarTodos(producto);}
    public void modificar(Producto producto ){ tdb.productoDao().modificar(producto);}
    public void eliminar( Producto producto ){ tdb.productoDao().eliminar(producto);}
    public List<Producto> listar(){ return tdb.productoDao().listar();}
    public Producto buscar( int id ){ return tdb.productoDao().buscar( id );}
}
