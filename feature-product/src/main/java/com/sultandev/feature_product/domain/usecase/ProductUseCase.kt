package com.sultandev.feature_product.domain.usecase

import com.sultandev.core_network.di.model.NetworkResponse
import com.sultandev.feature_product.data.model.Product

internal interface ProductUseCase {

    suspend operator fun invoke(product: Product)

    suspend operator fun invoke(tag: String): NetworkResponse<List<Product>>

    suspend fun getTags(): List<String>

}