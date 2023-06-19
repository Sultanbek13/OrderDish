package com.sultandev.core_database.di

import android.content.Context
import androidx.room.Room
import com.sultandev.core_database.AppDatabase
import com.sultandev.core_database.dao.ProductDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object CoreDatabase {
    val module = module {

        fun provideRoomDatabase(ctx: Context): AppDatabase {
            return Room
                .databaseBuilder(ctx, AppDatabase::class.java, "app.db")
                .allowMainThreadQueries()
                .build()
        }

        fun provideDao(database: AppDatabase): ProductDao = database.productDao()

        single { provideRoomDatabase(androidContext()) }

        single { provideDao(get()) }

    }
}