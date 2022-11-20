package com.demo.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.persistance.dao.PostDao
import com.demo.persistance.entities.ApiResponse

@Database(entities = [ApiResponse::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getPostDao(): PostDao

}