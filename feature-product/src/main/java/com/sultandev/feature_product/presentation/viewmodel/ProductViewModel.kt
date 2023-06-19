package com.sultandev.feature_product.presentation.viewmodel

import com.sultandev.feature_product.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

internal interface ProductViewModel {

    val allProduct: SharedFlow<List<Product>>

    val message: SharedFlow<String>

    val addBasket: SharedFlow<Unit>

    val allTags: SharedFlow<List<String>>

    fun getProductsByTag(tag: String)

    fun getAllTags()

    fun onAddBasket(product: Product)

}