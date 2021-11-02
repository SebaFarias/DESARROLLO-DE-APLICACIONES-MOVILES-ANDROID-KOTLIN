package com.example.inventariotienda.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.inventariotienda.dao.MarcaDao;
import com.example.inventariotienda.dao.ProductoDao;
import com.example.inventariotienda.model.Marca;
import com.example.inventariotienda.model.Producto;

@Database(entities = {Producto.class, Marca.class},version = 1)
public abstract class TiendaDB extends RoomDatabase {

    private static TiendaDB instance;
    public abstract MarcaDao marcaDao();
    public abstract ProductoDao productoDao();
    public static synchronized TiendaDB getDatabase(Context context){
        if( instance == null )
        {
            instance = Room.databaseBuilder(context,TiendaDB.class,"tienda_db").build();
        }
        return instance;
    }

}

