package com.example.reciclerview1.model;

import android.nfc.FormatException;

import java.io.Serializable;

public class Producto implements Serializable {

    public static final String LIST_TAG = "lista_productos";
    public static final String PRODUCT_TAG = "producto";
    private int id, precio;
    private String nombre;

    public Producto(){

    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setId(int id) throws ArithmeticException{
        if( id < 0){
            throw new ArithmeticException("No puede ingresar un valor negativo.");
        }
        this.id = id;
    }
    public void setNombre(String nombre)throws FormatException{
        if( nombre.length() < 3){
            throw new FormatException("Mínimo 3 caracteres");
        }
        this.nombre = nombre;
    }
    public void setPrecio(int precio) throws ArithmeticException{
        if( precio < 0){
            throw new ArithmeticException("No puede ingresar un valor negativo.");
        }
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
    public int precioConIva(){
        return Math.round(precio*1.19f);
    }
}
