package com.example.inventariotienda.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "marca_table")
public class Marca {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "descripcion")
    @NonNull

    private String descripcion;
    public Marca(int id, String descripcion)  {
        this.id = id;
        setDescripcion(descripcion);
    }
    @Ignore
    public Marca(String descripcion) {
        setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}



