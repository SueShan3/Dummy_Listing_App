package com.example.dummylistingapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dummylistingapp.model.Item

@Dao
interface ItemDao {

    //Insert item to database
    @Insert
    suspend fun addItem(item: Item)

    //Query to fetch all the items from the database
    @Query("SELECT * FROM item ORDER BY id DESC")
    suspend fun getAllItems(): List<Item>

    //Update item to database
    @Update
    suspend fun updateItem(item: Item)
}