package com.sultandev.feature_product.domain.usecase.impl

import com.sultandev.core_network.di.model.NetworkResponse
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.domain.repository.ProductRepository
import com.sultandev.feature_product.domain.usecase.ProductUseCase

internal class ProductUseCaseImpl(private val productRepository: ProductRepository) :
    ProductUseCase {

    override suspend fun invoke(product: Product) {
        productRepository.addBasket(product = product)
    }

    override suspend fun invoke(tag: String): NetworkResponse<List<Product>> {
        val productResponse = productRepository.getProductsByTag(tag)
        return NetworkResponse(
            isSuccess = productResponse.isSuccessful,
            data = productResponse.body() ?: listOf(),
            error = productResponse.message()
        )
    }

    override suspend fun getTags(): List<String> {
        val result = productRepository.getAllTags()
        return result.toList()
    }
}