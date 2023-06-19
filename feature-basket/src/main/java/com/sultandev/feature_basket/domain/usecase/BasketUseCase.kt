package com.sultandev.feature_basket.domain.usecase

import com.sultandev.core_database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

internal interface BasketUseCase {

    operator fun invoke(): Flow<List<ProductEntity>>

    suspend fun invoke(productEntity: ProductEntity)

}