package com.example.terrenosmarte.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.terrenosmarte.dao.TerrainDAO
import com.example.terrenosmarte.model.Terrain

private const val DATA_BASE_NAME = "mars_db"

@Database( entities = [Terrain::class], version= 1 )
public abstract class MarsDB : RoomDatabase()
{
    abstract fun getTerrainDao() : TerrainDAO

    companion object
    {
        @Volatile
        private var INSTANCE : MarsDB? = null

        fun getDatabase( context : Context) : MarsDB
        {
            val tempInstance = INSTANCE
            if ( tempInstance != null ){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder( context, MarsDB::class.java,DATA_BASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}