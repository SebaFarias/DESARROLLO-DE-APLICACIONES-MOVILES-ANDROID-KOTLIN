package com.example.terrenosmarte.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "terrain_table")
data class Terrain (
   @PrimaryKey  val id: Long,
    val img_src: String,
    val price: Int,
    val type: String
)