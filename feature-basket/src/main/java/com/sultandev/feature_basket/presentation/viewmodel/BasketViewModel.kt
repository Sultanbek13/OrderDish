package com.sultandev.feature_basket.presentation.viewmodel

import com.sultandev.core_database.entity.ProductEntity
import kotlinx.coroutines.flow.SharedFlow

internal interface BasketViewModel {

    val allBasketProduct: SharedFlow<List<ProductEntity>>

    val message: SharedFlow<String>

    fun getAllBasketProduct()

    fun updateProduct(productEntity: ProductEntity)

}