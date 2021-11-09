package com.example.terrenosmarte.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "terrain_table")
data class Terrain(
   @PrimaryKey
    val id: Long,
    val img_src: String,
    val price: Int,
    val type: String
)