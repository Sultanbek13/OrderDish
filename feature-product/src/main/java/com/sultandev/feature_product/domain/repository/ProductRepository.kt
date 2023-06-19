package com.sultandev.feature_product.domain.repository

import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.data.model.Products
import retrofit2.Response

internal interface ProductRepository {

    suspend fun getAllProducts(): Response<Products>

    suspend fun getProductsByTag(tag: String): Response<List<Product>>

    suspend fun addBasket(product: Product)

    suspend fun getAllTags(): Set<String>

}