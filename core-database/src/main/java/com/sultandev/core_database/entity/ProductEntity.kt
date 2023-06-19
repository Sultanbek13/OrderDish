package com.sultandev.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val description: String,
    val image_url: String,
    val name: String,
    val price: Int,
    val weight: Int,
    var count: Int = 0
)
