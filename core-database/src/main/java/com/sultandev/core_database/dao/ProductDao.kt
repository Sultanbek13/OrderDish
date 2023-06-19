package com.sultandev.core_database.dao

import androidx.room.*
import com.sultandev.core_database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ProductEntity)

    @Update
    suspend fun update(productEntity: ProductEntity)

    @Query("SELECT * FROM product WHERE count != 0")
    fun getAllBasketProduct(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE id=:id")
    fun getProductById(id: Int): ProductEntity

    @Query("DELETE FROM product")
    suspend fun clearBasket()

}