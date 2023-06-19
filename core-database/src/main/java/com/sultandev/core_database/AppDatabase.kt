package com.sultandev.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sultandev.core_database.dao.ProductDao
import com.sultandev.core_database.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}