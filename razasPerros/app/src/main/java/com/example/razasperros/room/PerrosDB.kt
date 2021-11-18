package com.example.razasperros.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.razasperros.dao.RazaDao
import com.example.razasperros.model.Perro
import com.example.razasperros.model.Raza

private const val DATA_BASE_NAME = "perros_db"

@Database( entities = [ Raza::class, Perro::class ], version = 1)
public abstract class PerrosDB : RoomDatabase() {

    abstract fun razaDao(): RazaDao

    companion object
    {
        @Volatile
        private var INSTANCE : PerrosDB? = null
        fun getDatabase( context : Context ) : PerrosDB
        {
            val tempInstance = INSTANCE
            if ( tempInstance != null ) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder( context, PerrosDB::class.java, DATA_BASE_NAME).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}