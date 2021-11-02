package com.example.formulariovalidado.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    final static String emailPattern = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
    private String nombre, apellido, mail;

    public Usuario(String nombre, String apellido, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getEmail(){
        return this.mail;
    }
    public void setNombre(String newNombre){
        this.nombre = newNombre;
    }
    public void setApellido(String newApellido){
        this.apellido = newApellido;
    }
    public void setEmail(String newEmail){
        this.mail = newEmail;
    }
    // Si es válido, devuelve null, si no es válido devuelve un mensaje de error
    public static String isValidName(String name){
        if(name.length()<3){
            return "Minimo 3 caracteres";
        }
        return null;
    }
    // Si es válido, devuelve null, si no es válido devuelve un mensaje de error
    public static String isValidLastname(String lastname){
        if(lastname.length()<2){
            return "Minimo 2 caracteres";
        }
        return null;
    }
    // Si es válido, devuelve null, si no es válido devuelve un mensaje de error
    public static String isValidEmail(String email){
        if(!(email.matches(emailPattern))){
            return "Respete el formato soyuncorreo@dominio.cl";
        }
        return null;
    }
}

