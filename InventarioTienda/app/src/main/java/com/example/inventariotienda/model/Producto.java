package com.example.inventariotienda.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "producto_table",
        foreignKeys = @ForeignKey(entity = Marca.class,
                parentColumns = "id",
                childColumns = "marca_fk",
                onDelete = CASCADE))
public class Producto {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "marca_fk",index = true)
    private int marca;
    @ColumnInfo(name = "precio")
    private int precio;

    public Producto(int id, String nombre, int marca, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }
    @Ignore
    public Producto(String nombre, int marca, int precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}