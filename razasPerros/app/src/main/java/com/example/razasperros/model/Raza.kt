package com.example.razasperros.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
data class Raza(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val message: Object,
    val status: String
)