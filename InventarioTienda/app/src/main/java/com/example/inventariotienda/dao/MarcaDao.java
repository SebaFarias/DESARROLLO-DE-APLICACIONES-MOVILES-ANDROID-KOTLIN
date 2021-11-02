package com.example.inventariotienda.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.inventariotienda.model.Marca;

import java.util.List;

@Dao
public interface MarcaDao {

    @Insert
    void agregar(Marca marca);

    @Insert
    void agregarTodo(Marca... marca);

    @Delete
    void eliminar(Marca marca);

    @Update
    void modificar(Marca marca);

    @Query("select id,descripcion from marca_table")
    List<Marca> listar();

    @Query("select id,descripcion from marca_table where id = :id")
    Marca buscar(int id);
}