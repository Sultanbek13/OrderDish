package com.sultandev.feature_basket.domain.repository

import com.sultandev.core_database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

internal interface BasketRepository {

    fun getAllBasketProduct(): Flow<List<ProductEntity>>

    suspend fun updateProduct(productEntity: ProductEntity)

}