package com.example.dummylistingapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dummylistingapp.model.Item

@Database(
    entities = [Item::class],
    version = 1
)

abstract class ItemDatabase : RoomDatabase() {

    abstract fun getItemDao(): ItemDao

    //Build Room Database
    companion object {
        @Volatile
        private var instance: ItemDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ItemDatabase::class.java,
            "itemdatabase"
        ).build()
    }
}