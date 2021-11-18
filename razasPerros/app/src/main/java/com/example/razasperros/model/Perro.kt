package com.example.razasperros.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "tabla_perros")
data class Perro(
    @PrimaryKey( autoGenerate = false )
    val img_src : String,
    val raza : String,
    val fav : Boolean,
)