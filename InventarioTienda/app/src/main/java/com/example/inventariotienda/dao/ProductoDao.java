package com.example.inventariotienda.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.inventariotienda.model.Producto;

import java.util.List;

@Dao
public interface ProductoDao {

    @Insert
    void agregar( Producto producto );

    @Insert
    void insertarTodos( Producto...producto );

    @Delete
    void eliminar( Producto producto );

    @Update
    void modificar( Producto producto );

    @Query("select id, nombre, marca_fk, precio from producto_table")
    List<Producto> listar();

    @Query("select id, nombre, marca_fk, precio from producto_table where id= :id")
    Producto buscar( int id );

}
