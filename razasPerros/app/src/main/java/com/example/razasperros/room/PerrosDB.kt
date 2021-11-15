package com.example.razasperros.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.razasperros.dao.RazaDao
import com.example.razasperros.model.Raza


@Database( entities = [Raza::class], version = 1)
public abstract class PerrosDB : RoomDatabase() {

    lateinit private var instance : PerrosDB
    abstract fun razaDao(): RazaDao

    @Synchronized
    open fun getDB(context: Context): PerrosDB {
        if (instance == null) {
            instance = Room.databaseBuilder( context, PerrosDB::class.java, "ejemplo_db" ).build()
        }
        return instance
    }

}